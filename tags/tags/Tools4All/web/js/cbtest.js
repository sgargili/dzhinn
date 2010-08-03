/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Ext.ns('Ext.ux.form');
//Ext.ux.form.GroupingComboBox = Ext.extend(Ext.form.ComboBox, {
//    initComponent : function(){
//        if(this.transform){
//            this.allowDomMove = false;
//            var s = Ext.getDom(this.transform);
//            if(!this.hiddenName){
//                this.hiddenName = s.name;
//            }
//            if(!this.store){
//                this.mode = 'local';
//                var d = [], opts = s.options;
//                for(var i = 0, len = opts.length;i < len; i++){
//                    var o = opts[i];
//                    var value = (Ext.isIE ? o.getAttributeNode('value').specified : o.hasAttribute('value')) ? o.value : o.text;
//                    if(o.selected) {
//                        this.value = value;
//                    }
//                    var optgrp = o.parentNode, group = optgrp.tagName.toLowerCase() == 'optgroup' ? optgrp.label : false;
//                    d.push([value, o.text, group]);
//                }
//                this.store = new Ext.data.SimpleStore({
//                    'id': 0,
//                    fields: ['value', 'text', 'group'],
//                    data : d
//                });
//                this.valueField = 'value';
//                this.displayField = 'text';
//                this.groupField = 'group';
//            }
//            s.name = Ext.id();
//            if(!this.lazyRender){
//                this.target = true;
//                this.el = Ext.DomHelper.insertBefore(s, this.autoCreate || this.defaultAutoCreate);
//                Ext.removeNode(s);
//                this.render(this.el.parentNode);
//            }else{
//                Ext.removeNode(s);
//            }
//        }
//        delete this.transform;
//        Ext.ux.form.GroupingComboBox.superclass.initComponent.call(this);
//    },
//    initList : function(){
//        if(!this.list && !this.tpl){
//            this.tpl = '<tpl for=".">' +
//            '<tpl if="values.' + this.groupField + ' && (xindex == 1 || parent[xindex - 2].' + this.groupField + ' != values.' + this.groupField + ')">' +
//            '<div class="x-combo-list-group">{' + this.groupField + '}</div>' +
//            '</tpl>' +
//            '<div class="x-combo-list-item">' +
//            '<tpl if="values.' + this.groupField + '">&nbsp;</tpl>' +
//            '{' + this.displayField + '}</div>' +
//            '</tpl>';
//        }
//        Ext.ux.form.GroupingComboBox.superclass.initList.call(this);
//    }
//});


Ext.onReady(function(){
    Ext.QuickTips.init();
    var storeLanguages = new Ext.data.Store({
        url: 'data/Languages.xml',
        reader: new Ext.data.XmlReader({
            record: 'Language',
            id: 'Value'
        }, [
        {
            name: 'lang',
            mapping: 'Name'
        }, {
            name:'value',
            mapping:'Value'
        }, {
            name:'groupe',
            mapping:'Groupe'
        }
        ])
    });
    var eee = new Ext.form.ComboBox({
        store: storeLanguages,
        displayField:'lang',
        valueField: 'value',
        typeAhead: true,
        mode: 'remote',
        forceSelection: true,
        triggerAction: 'all',
        emptyText:'Select a state...',
        selectOnFocus:true,
        applyTo: 'www'
    });
//    var comboPT = new Ext.form.ComboBox({
//        store: storeLanguages,
//        hideLabel: true,
//        displayField:'lang',
//        valueField: 'value',
//        typeAhead: true,
//        mode: 'local',
//        forceSelection: true,
//        triggerAction: 'all',
//        emptyText:'Выберите PT...',
//        editable: false,
//        style: {
//            margin: '0px'
//        },
//        width:200,
//        applyTo:'www',
//        tpl: new Ext.XTemplate(
//            '<tpl for=".">',
//            '<tpl if="this.groupe != values.groupe">',
//            '<tpl exec="this.groupe = values.groupe"></tpl>',
//            '<h1>{group}</h1>',
//            '</tpl>',
//            '<div class="x-combo-list-item">{value}</div>',
//            '</tpl>'
//            )
//    //    listeners: {
//    //        'select': function(){
//    //            storeAtrsProxy.setUrl("Attribute.exml?ptId=" + comboOwner2.getValue());
//    //            storeAtrs.clearData();
//    //            storeAtrs.load();
//    //        }
//    //    }
//    });

//    new Ext.form.ComboBox({
//        store: storeLanguages,
////            new Ext.data.SimpleStore({
////            id: 0,
////            fields: ['value', 'text', 'group'],
////            data: [
////            [1, 'Item 1a', 'Group 1'],
////            [2, 'Item 1b', 'Group 1'],
////            [3, 'Item 1c', 'Group 1'],
////            [4, 'Item 2a', 'Group 2'],
////            [5, 'Item 2b', 'Group 2'],
////            [6, 'Item 3a', 'Group 3'],
////            [7, 'Item 3b', 'Group 3']
////            ]
////        }),
//        mode: 'local',
//        displayField: 'lang',
//        valueField: 'value',
//        ////        editable: true,
//              triggerAction: 'all',
//        width: 120,
//        //        tpl: new Ext.XTemplate(
//        //            '<tpl for=".">',
//        //            '<tpl if="this.group != values.group">',
//        //            '<tpl exec="this.group = values.group"></tpl>',
//        //            '<h1>{group}</h1>',
//        //            '</tpl>',
//        //            '<div class="x-combo-list-item">{text}</div>',
//        //            '</tpl>'
//        //            ),
//        applyTo:'www'
//    });
});