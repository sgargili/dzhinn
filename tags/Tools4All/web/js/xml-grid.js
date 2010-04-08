/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*!
 * Ext JS Library 3.1.1
 * Copyright(c) 2006-2010 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
var store = new Ext.data.Store({
    url: 'data/Owners.xml',

    // the return will be XML, so lets set up a reader
    reader: new Ext.data.XmlReader({
        record: 'Owner',
        id: 'Id'
    }, [
    {
        name: 'owner',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var combo = new Ext.form.ComboBox({
    store: store,
    displayField:'owner',
    valueField: 'id',
    typeAhead: true,
    mode: 'local',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите автора...',
    width:200
//renderTo:'example-grid'
});
Ext.onReady(function(){
    combo.render('example-grid');
    store.load();

    combo.on('change', function(n){
        alert(combo.value);
    })
});