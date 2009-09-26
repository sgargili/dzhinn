/* Copyright 2008 You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at:
 http://developer.sun.com/berkeley_license.html
 $Id: component.js,v 1.0 2008/04/15 19:39:59 gmurray71 Exp $
*/

dojo.require("dijit.form.ComboBox");
dojo.require("dojo.data.ItemFileWriteStore");

jmaki.namespace("jmaki.widgets.dojo.dijit.combobox");

jmaki.widgets.dojo.dijit.combobox.Widget = function(wargs) {
    
    var _widget = this;
    _widget.container = document.getElementById(wargs.uuid);

    var selected = "";
    var data;
    var _d = {};
    //new format if using the data store need to provide followin properties
    _d.identifier = "id";
    _d.label = "label";
    var publish = "/dojo/dijit/combobox";
    var subscribe = ["/dojo/dijit/combobox", "/combobox"];
    
    if (wargs.publish ) {
	    publish = wargs.publish;
    }
     
    if (wargs.subscribe){
        if (typeof wargs.subscribe == "string") {
            subscribe = [];
            subscribe.push(wargs.subscribe);
        } else {
            subscribe = wargs.subscribe;
        }
    }
    
    var vmappings = {};
    var counter = 0;
    
    function genKey(){
        return wargs.uuid + "_item_" + counter++;
    }

    function modelConverter(data) {
        var model = [];

        for (var i=0; i < data.length; i++) {
            var _val = data[i].value;
            var _label = data[i].label;
            // if only a value is specified make the label equal to the value
            if (!_val && _label) _val = _label;
            if (_val && !_label) _label = _val;
            if (!data[i].value && data[i].label) {
                _val = data[i].label;
            }      
            
            var _name = _val;
            var key =  data[i].id;
            if (!key) key = genKey();
            if (data[i].selected &&  data[i].selected == true) {
                   _widget.selected = _label;
            }   
            vmappings[_val] = { label : _name, id : key, action : data[i].action, value: _val};
            model.push({id : key, label : _label, val : _val});
        }
        return model;
    };

    /**
     *  Remove an item from the completion fields.
     *
     * @param o - The targetId of the item to remove or an object containing a
                  message.targetId property like:
                  { messsage : {targetId : 'foo'}}
     *
     */
    this.removeItem = function(o) {
        var targetId;
        if (o.message) o = o.message;
        if (o.targetId)targetId = o.targetId;
        else targetId = o;
        
        var target = _widget.store._getItemByIdentity(targetId);
        
        if (target) {
            _widget.store.deleteItem(target);      
        }
        // sync with the local model
        var _vm = _getValueMapping(targetId);
        if (_vm) {
            delete vmappings[_vm.value];           
        } 
    };
    
    this.clear = function(){
        for (var i in vmappings) {
            var targetId = vmappings[i].id;
            if (targetId) {            
                delete vmappings[targetId];
                var item = _widget.store._getItemByIdentity(targetId);
                _widget.store.deleteItem(item);
            }
        }
        _widget.store.save();
        _widget.wrapper.setValue("");
        vmappings = {};
    };
    
    /**
     * Called after the widget has loaded. The model must be set before this is 
     * function called.
     *
     */
    this.init = function() {
         _d.items  = _widget.model;      
        _widget.store = new dojo.data.ItemFileWriteStore({ data :_d});
        // force the store to load immediately
        _widget.store._forceLoad();

        _widget.wrapper = new dijit.form.ComboBox({searchAttr:"label",
                                            autocomplete:true,
                                            value: _widget.selected,
                                            store: _widget.store}, _widget.container);
        var _body = document.body;
        // add tundra to the body.
        // TODO : Add other Dojo themes        
        if (_body) {
            if (!/tundra/i.test(_body.className)){
                _body.className += " tundra";
            }
        }

       
    };
    
    /**
     *  Set the value of the text field regardless of whether the value is 
     *  in the list or not. Generally using select is a better solution.
     *
     * @param o - The value to add or an object containing a
                  message.value property like:
                  { messsage : {value : 'some text'}}
     *
     */
    this.setValue = function(o) {
        var _value;
        if (o.message) o = o.message;
        else _value = o;
        if (_value.value) value = _value.value;
        _widget.wrapper.setValue(_value);
    };

    /**
     * Returns the currently selected value
     */
    this.getValue = function() {
        return _widget.wrapper.getValue();
    };
    
    function _getValueMapping(targetId) {
        for (var i in vmappings) {
            if (vmappings[i].id == targetId) {
                return vmappings[i];
            }
        }
        return null;
    }
    
    /**
     *  Select an item from the list. The Label of the item will be
     *  set as the value of the text field.
     *
     * @param o - The targetId to select or an object containing a
                  message.targetId property like:
                  { messsage : {targetId : 'foo'}}
     *
     */
    this.select = function(e){
        var targetId;
        var _target;
        if (e.message)e = e.message;
        if (e.value)e = e.value;

        if (e.action && e.action.targetId) {
           targetId = e.action.targetId;
        } else {
           targetId = e.targetId;
        }
        var _val = _getValueMapping(targetId);
        if (_val) {
            processActions(publish, _val, _val.targetId, 'onSelect', _val);
            var _item = _widget.store._getItemByIdentity(targetId);        
            _widget.wrapper.setValue(_item.label);   
        }
    };
    
    /**
     *  Add an item from the list.
     *
     * @param o - An item like:
                  { id : 'foo', label : 'My label', value : 'v1'}
                  or an object containg a message.value property
                  which is used as the value like:
                  { messsage : {value :  { id : 'foo', label : 'My label', value : 'v1'}}}
     *
     */
    this.addItem = function(e) {
        var _item;
        if (e.message && e.message.value) _item = e.message.value;
        else _item = e;
        var nid;
        if (typeof _item.id != 'undefined') nid= _item.id;
        else nid = genId();
        _item.nid = nid;
        var _mixins = { item : _item,
                        label : _item.label,
                        id :nid,
                        nid : nid};
                    
        if (_item.action) _mixins.action = _item.action;

        var _ai = _widget.store.newItem(_mixins, {});
        vmappings[nid] = _ai;
        return _ai;
    };

    /**
     * Clears the list and set the values to the list provided.
     *
     * @param o - An array of items like:
                  [
                  { id : 'foo', label : 'My label', value : 'v1'},
                  { id : 'bar', label : 'My label 2', value : 'v2'}
                  ]
                  or an object containg a message.value property
                  which is used as the value like:
                  { messsage : {value : [ values ]}}
     *
     */
    this.setValues = function(e){
        _widget.clear();
        var _values;
        if (e.message && e.message.value) _values = e.message.value;
        else _values = e;
        var _selected;
        // clear out the selected value so we can reselect
        _widget.selected = undefined;
        
        if (_values) {
           var _v = modelConverter(_values);
           for (var i=0;_v && i < _v.length; i++){
               _widget.addItem(_v[i]);
           }

           if (_widget.selected &&
                vmappings[_widget.selected]) {
                _widget.wrapper.setValue(vmappings[_widget.selected].label);
           }
        }
    }; 
    
    function clone(t) {
       var obj = {};
       for (var i in t) {
            obj[i] = t[i];
       }
       return obj;
    }    
    
    function processActions(_publish, _t, _pid, _type, _value) {
        if (_t) {
            var _topic = _publish;
            var _m = {widgetId : wargs.uuid, type : _type, targetId : _pid};
            if (typeof _value != "undefined") _m.value = _value;
            var action = _t.action;
            if (!action) _topic = _topic + "/" + _type;
            if (action && action instanceof Array) {
              for (var _a=0; _a < action.length; _a++) {
                  var payload = clone(_m);
                  if (action[_a].topic) payload.topic = action[_a].topic;
                  else payload.topic = publish;
                  if (action[_a].message) payload.message = action[_a].message;
                  jmaki.publish(payload.topic,payload);
              }
            } else {
              if (action && action.topic) {
                  _topic = _m.topic = action.topic;
              }
              if (action && action.message) _m.message = action.message;                
              jmaki.publish(_topic,_m);
            } 
        }
    }    
    
    function doSubscribe(topic, handler) {
        var i = jmaki.subscribe(topic, handler);
        _widget.subs.push(i);
    }
    
    this.destroy = function() {
        for (var i=0; _widget.subs && i < _widget.subs.length; i++) {
            jmaki.unsubscribe(_widget.subs[i]);
        }
    };

    this.postLoad = function() {
        _widget.subs = [];       
        for (var _i=0; _i < subscribe.length; _i++) {
            doSubscribe(subscribe[_i]  + "/select", _widget.select);
            doSubscribe(subscribe[_i]  + "/clear", _widget.clear);
            doSubscribe(subscribe[_i]  + "/remove", _widget.removeItem);
            doSubscribe(subscribe[_i]  + "/addItem", _widget.addItem);
            doSubscribe(subscribe[_i]  + "/setValues", _widget.setValues);
        }
              
        if (wargs.value && wargs.value instanceof Array){ 
            _widget.model = modelConverter(wargs.value);
            _widget.init(); 
        } else if (wargs.service) {
            jmaki.doAjax(
              { url: wargs.service, 
                callback: function(req) {
                    if (req.responseText == "") {
                        _widget.container.innerHTML = "No data provided by: " + wargs.service;
                        return;
                    }
                    var _in = eval('(' + req.responseText + ')');
                    //new format if using the data store need to provide followin properties
                    _widget.model = modelConverter(_in);
                    _widget.init();
                },
                onerror : function (message) {
                    _widget.container.innerHTML = "Failed to load data: " + message;
                }
              }
            );
        }
    };
	
    this.onChange = function(value){
        jmaki.publish(publish + "/onChange", {id:wargs.uuid, value: value.target.item});
    };

    dojo.connect(this.wrapper, "_selectOption", _widget, "onChange");
};