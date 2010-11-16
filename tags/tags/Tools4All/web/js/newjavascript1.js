var FileUploadField = Ext.form.FileUploadField = Ext.extend(Ext.form.TextField, { buttonText: 'Browse...', buttonOnly: false, buttonOffset: 3, readOnly: true, autoSize: Ext.emptyFn, initComponent: function(){ FileUploadField.superclass.initComponent.call(this); this.addEvents( 'fileselected' ); }, onRender : function(ct, position){ FileUploadField.superclass.onRender.call(this, ct, position); this.wrap = this.el.wrap({cls:'x-form-field-wrap x-form-file-wrap'}); this.el.addClass('x-form-file-text'); this.el.dom.removeAttribute('name'); this.createFileInput(); var btnCfg = Ext.applyIf(this.buttonCfg || {}, { text: this.buttonText }); this.button = new Ext.Button(Ext.apply(btnCfg, { renderTo: this.wrap, cls: 'x-form-file-btn' + (btnCfg.iconCls ? ' x-btn-icon' : '') })); if(this.buttonOnly){ this.el.hide(); this.wrap.setWidth(this.button.getEl().getWidth()); } this.addFileListener(); }, getName : function(){ return this.rendered && this.fileInput.dom.name ? this.fileInput.dom.name : (this.hiddenName || ''); }, getFileInputId: function(){ return this.id+'-file'; }, onResize : function(w, h){ FileUploadField.superclass.onResize.call(this, w, h); this.wrap.setWidth(w); if(!this.buttonOnly){ var w = this.wrap.getWidth() - this.button.getEl().getWidth() - this.buttonOffset; this.el.setWidth(w); } }, preFocus : Ext.emptyFn, getResizeEl : function(){ return this.wrap; }, getPositionEl : function(){ return this.wrap; }, alignErrorIcon : function(){ this.errorIcon.alignTo(this.wrap, 'tl-tr', [2, 0]); }, createFileInput : function() { this.fileInput = this.wrap.createChild({ id: this.getFileInputId(), name: this.name || this.getId(), cls: 'x-form-file', tag: 'input', type: 'file', size: 1 }); if(this.disabled) { this.fileInput.dom.disabled = true; } }, addFileListener : function() { this.fileInput.on({ 'change': function(){ var v = this.fileInput.dom.value; this.setValue(v); this.fireEvent('fileselected', this, v); }, 'mouseover' : function() {this.button.addClass(['x-btn-over', 'x-btn-focus']) }, 'mouseout' : function() { this.button.removeClass(['x-btn-over', 'x-btn-focus','x-btn-click']) }, 'mousedown' : function() { this.button.addClass('x-btn-click') }, 'mouseup' : function() { this.button.removeClass(['x-btn-over', 'x-btn-focus', 'x-btn-click']) }, scope : this }); }, reset : function(){ Ext.destroy(this.fileInput);  this.createFileInput(); this.addFileListener();  FileUploadField.superclass.reset.call(this); }, onDestroy : function(){ if(this.fileInput){ Ext.destroy(this.fileInput); } if(this.button) { this.button.destroy(); } FileUploadField.superclass.onDestroy.call(this); }, onEnable: function() { FileUploadField.superclass.onEnable.call(this); this.fileInput.dom.disabled = false; this.button.enable(); }, onDisable: function() { FileUploadField.superclass.onEnable.call(this); this.fileInput.dom.disabled = true; this.button.disable(); } }); Ext.reg('fileuploadfield', FileUploadField);