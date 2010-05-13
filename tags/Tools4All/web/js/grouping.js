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
    var article='Just4Article';
    var pt;
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
    var checkColumn = new Ext.grid.CheckColumn({
        header: 'Active',
        dataIndex: 'available',
        width: 5
    });

    function storeAtrsUpdate(id){
        //alert("Need");
        storeAtrsProxy.setUrl("Attribute.exml?ptId="+id);
    //storeAtrs.load();
    }

    var comboOwner = new Ext.form.ComboBox({
        store: storeAtrs,
        displayField:'atr',
        valueField: 'atr',
        typeAhead: true,
        mode: 'local',
        forceSelection: true,
        triggerAction: 'all',
        //emptyText:'Выберите автора...',
        editable: false,
        style: {
            margin: '0px'
        },
        width:200,
        listeners: {
            beforequery : function test(){
                if(article!=grid.getSelectionModel().selection.record.data.article){
                    pt = grid.getSelectionModel().selection.record.data.pt;
                    storeAtrsProxy.setUrl("Service.exml?request=attributes/productType="+pt);
                    article=grid.getSelectionModel().selection.record.data.article;
                    storeAtrs.clearData();
                    storeAtrs.load();
                }
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
        url: 'Service.exml?request=outputData',
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
            }, {
                name:'unit',
                mapping:'Unit'
            }, {
                name:'available',
                mapping:'Available',
                type: 'bool'
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
            dataIndex: 'article'
            
        },
        {
            header: "Product Type",
            width: 15,
            sortable: true,
            editable: true,
            dataIndex: 'pt'
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
        },

        {
            header: "Unit",
            width: 10,
            sortable: true,
            dataIndex: 'unit',
            editor: new fm.TextField({
                allowBlank: false
            })
        },checkColumn
        ]
    });

    var grid = new xg.EditorGridPanel({
        store: storePtsAlt,
        id:'iii',
        cm:cm,
        plugins: checkColumn,
        clicksToEdit: 2,
        view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        frame:true,
        //        width: 1000,
        height: 800,
        collapsible: true,
        // collapsed: true,
        animCollapse: true,
        columnLines:true,
        title: 'Grouping Example',
        renderTo: document.body,
        tbar: [{
            text: 'Add Plant',
            handler : function(){
                // access the Record constructor through the grid's store
                //                var Plant = grid.getStore().getAt(0).get("attribute");
                //                alert(Plant);
                //
                var data="";
                //                Ext.each(grid.getStore().getModifiedRecords(), function(record){
                //                    data.push(record.data);
                //                });
                grid.getStore().each(
                    function(record){
                        data+=record.data.id+
                        "$$$"+
                        record.data.article+
                        "$$$"+
                        record.data.pt+
                        "$$$"+
                        record.data.attribute+
                        "$$$"+
                        record.data.value+
                        "$$$"+
                        record.data.unit+
                        "$$$"+
                        record.data.available+
                        "|||";
                    }
                    )

                Ajax.updateDownloadData(data, function(data) {
                    dwr.engine.openInDownload(data);
                });
            //                Ext.Msg.show({
            //
            //                    msg: data,
            //                    buttons: Ext.MessageBox.OK,
            //                    width: 600,
            //                    icon: Ext.MessageBox.INFO
            //                });
            //                var p = new Plant({
            //                    common: 'New Plant 1',
            //                    light: 'Mostly Shade',
            //                    price: 0,
            //                    availDate: (new Date()).clearTime(),
            //                    indoor: false
            //                });
            //                grid.stopEditing();
            //                store.insert(0, p);
            //                grid.startEditing(0, 0);
            }
        }]

    });
    storePtsAlt.load();
//storeAtrsUpdate(12);
    
});

