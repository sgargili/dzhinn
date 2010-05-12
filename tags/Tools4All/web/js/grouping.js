/*!
 * Ext JS Library 3.2.1
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){

    Ext.QuickTips.init();

    var xg = Ext.grid;
    var fm = Ext.form;

    var storeAtrsProxy = new Ext.data.HttpProxy({
        url:    'some url',
        method: 'GET'
    })


    var storeAtrs = new Ext.data.Store({
        proxy: storeAtrsProxy,
        reader: new Ext.data.XmlReader({
            record: 'Attribute',
            id: 'Id'
        }, [
        {
            name: 'atr',
            mapping: 'Name'
        }, {
            name:'id',
            mapping:'Id'
        }
        ])
    });

    function storeAtrsUpdate(id){
        //alert("Need");
        storeAtrsProxy.setUrl("Attribute.exml?ptId="+id);
        //storeAtrs.load();
    }

    var comboOwner = new Ext.form.ComboBox({
        store: storeAtrs,
        displayField:'atr',
        valueField: 'id',
        typeAhead: true,
        mode: 'remote',
        forceSelection: true,
        triggerAction: 'all',
        //emptyText:'Выберите автора...',
        editable: false,
        style: {
            margin: '0px'
        },
        width:200,
        listeners: {
            beforequery : function(){
                //storeAtrs.clearData();
                alert(grid.getSelectionModel().getColumnCount());
                //storeAtrsUpdate(Ext.get("ids").getValue());
            }
        }
    });
//beforequery
    var storePtsAlt = new Ext.data.GroupingStore({
        //url: 'data/Owners.xml',
        sortInfo:{
            field: 'article',
            direction: "ASC"
        },
        groupField:'article',
        url: 'test.xml',
        reader: new Ext.data.XmlReader({
            record: 'Article',
            id: 'Id',
            fields:[
            {
                name: 'id',
                mapping: 'Id'
            },{
                name: 'article',
                mapping: 'Name'
            }, {
                name:'pt',
                mapping:'PT',
                type: 'string'
            }, {
                name:'attribute',
                mapping:'Attribute'
            }, {
                name:'value',
                mapping:'Value'
            }
            ]
        })
    });

    var cm = new Ext.grid.ColumnModel({
        // specify any defaults for each column
        defaults: {
            sortable: true // columns are not sortable by default,
        },
        columns: [
        {
            //id:'article',
            header: "Article",
            width: 10,
            sortable: true,
            dataIndex: 'article',
            editor: new fm.TextField({
                allowBlank: false
            })
        },{
            id:'ids',
            header: "Id",
            width: 3,
            sortable: true,
            dataIndex: 'id'
        },

        {
            header: "Product Type",
            width: 15,
            sortable: true,
            editable: true,
            dataIndex: 'pt',
            editor: new fm.TextField({
                allowBlank: false
            })
        },

        {
            header: "Attribute",
            width: 20,
            sortable: true,
            dataIndex: 'attribute',
            editor: comboOwner
        },

        {
            header: "Value",
            width: 60,
            sortable: true,
            dataIndex: 'value',
            editor: new fm.TextField({
                allowBlank: false
            })
        }
        ]
    });

    var grid = new xg.EditorGridPanel({
        store: storePtsAlt,
        cm:cm,
        clicksToEdit: 2,
        view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        frame:true,
        //        width: 1000,
        height: 800,
        collapsible: true,
        animCollapse: true,
        title: 'Grouping Example',
        renderTo: document.body
    });
    storePtsAlt.load();
    //storeAtrsUpdate(12);
});
