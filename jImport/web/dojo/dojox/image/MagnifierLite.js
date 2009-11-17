dojo.provide("dojox.image.MagnifierLite");
dojo.experimental("dojox.image.MagnifierLite");
dojo.require("dijit._Widget");
dojo.declare("dojox.image.MagnifierLite", dijit._Widget,
	{
	glassSize: 180,
	scale: 6,
	postCreate: function(){
		this.inherited(arguments);
		
		// images are hard to make into workable templates, so just add outer overlay
		// and skip using dijit._Templated		
		this._adjustScale();
		this._createGlass();
		
		this.connect(this.domNode,"onmouseenter","_showGlass");
		this.connect(this.glassNode,"onmousemove","_placeGlass");
		this.connect(this.img,"onmouseout","_hideGlass");

		// when position of domNode changes, _adjustScale needs to run.
		// window.resize isn't it always, FIXME:
		this.connect(window,"onresize","_adjustScale");
		
	},

	_createGlass: function(){
		// summary: make img and glassNode elements as children of the body

		var node = this.glassNode = dojo.doc.createElement('div');
		this.surfaceNode = node.appendChild(dojo.doc.createElement('div'));
		dojo.addClass(node,"glassNode");
		dojo.body().appendChild(node);
		dojo.style(node,{
			height: this.glassSize + "px",
			width: this.glassSize + "px"
		});
		
		this.img = dojo.clone(this.domNode);
		node.appendChild(this.img);
		// float the image around inside the .glassNode 
		dojo.style(this.img, {
			position: "relative",
			top: 0,
			left: 0,
			width: this._zoomSize.w + "px",
			height: this._zoomSize.h + "px"
		});

	},
	
	_adjustScale: function(){
		// summary: update the calculations should this.scale change

		this.offset = dojo.coords(this.domNode, true);
		this._imageSize = { w: this.offset.w, h:this.offset.h };
		this._zoomSize = {
			w: this._imageSize.w * this.scale,
			h: this._imageSize.h * this.scale
		};
	},
	
	_showGlass: function(e){
		// summary: show the overlay
		this._placeGlass(e);
		dojo.style(this.glassNode, {
			visibility: "visible",
			display:""
		});			
		
	},
	
	_hideGlass: function(e){
		// summary: hide the overlay
		dojo.style(this.glassNode, {
			visibility: "hidden",
			display:"none"
		});
	},
	
	_placeGlass: function(e){
		// summary: position the overlay centered under the cursor

		this._setImage(e);
		var sub = Math.floor(this.glassSize / 2);
		dojo.style(this.glassNode,{ 
			top: Math.floor(e.pageY - sub) + "px", 
			left:Math.floor(e.pageX - sub) + "px"
		});
		
	},

	_setImage: function(e){
		// summary: set the image's offset in the clipping window relative to the mouse position

		var xOff = (e.pageX - this.offset.l) / this.offset.w;
		var yOff = (e.pageY - this.offset.t) / this.offset.h;
		var x = (this._zoomSize.w * xOff * -1) + (this.glassSize * xOff);
		var y = (this._zoomSize.h * yOff * -1) + (this.glassSize * yOff);
		dojo.style(this.img, {
			top: y + "px",
			left: x + "px"
		});

	},
	
	destroy: function(finalize){
		dojo.destroy(this.glassNode);
		this.inherited(arguments);
	}

});