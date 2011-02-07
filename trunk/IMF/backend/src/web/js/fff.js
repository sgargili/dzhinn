var mask = new Ext.LoadMask(Ext.getBody(), {
    msg:"Пожалуйста, подождите..."
});

var unitsOfMeasureReader = new Ext.data.JsonReader({
    root: 'unitsOfMeasureResponse.unitsOfMeasureDtos',
    totalProperty: 'unitsOfMeasureResponse.totalRowsCount',
    idProperty: 'id',
    fields: [
        'id',
        'name',
        'comment',
        'defaultValue',
        'ratio',
        'prefix'
    ]
});

//Хранилище данных для единиц измерения...
var unitsOfMeasureStore = new Ext.data.Store({
    reader: unitsOfMeasureReader,
    proxy: new Ext.data.HttpProxy({
        url: 'rest/unitsOfMeasure.json',
        method: 'GET'
    })
});

//Панель представления таблицы данных...
var unitsOfMeasureGrid = new Ext.grid.GridPanel({
    store: unitsOfMeasureStore,
    region: 'center',
    loadMask: mask,
    //Модель представления строк данных в таблице...
    sm: new Ext.grid.RowSelectionModel({
        //Убираем возможность множественного выбора строк в таблице...
        singleSelect:true
    }),
    //МОдель представления стобцов..
    columns: [
        new Ext.grid.RowNumberer(),
        {
            header: "Unit",
            dataIndex: 'name',
            sortable: true
        },
        {
            header: "Comment",
            dataIndex: 'comment',
            sortable: true,
            align: 'left'
        },
        {
            header: "Prefix",
            dataIndex: 'prefix',
            sortable: true,
            align: 'left'
        },
        {
            header: "Ratio",
            dataIndex: 'ratio',
            sortable: true,
            align: 'left'
        },
        {
            header: "Default",
            dataIndex: 'defaultValue',
            sortable: true,
            align: 'left'
        }
    ],
    //Конфигурация представления таблицы...
    viewConfig: {
        //Растягиваем столбцы по ширине окна...
        forceFit: true/*,
         enableRowBody: true,
         showPreview: false*/
    },
    //Верхний тулбар...
    tbar:[
        {
            text:'Добавить',
            tooltip:'Добавить новую единицу измерения',
            iconCls:'add',
            handler: function () {
//                winUnitsGroupAddForm.show();
            }
        },
        '-',
        {
            text:'Изменить',
            tooltip:'Настроить данные единицы измерения',
            iconCls:'option',
            handler: function () {
//                if (unitsGroupGrid.getSelectionModel().getSelections().length != 0) {
//                    unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateName").setValue(unitsGroupGrid.getSelectionModel().getSelections()[0].get('name'));
//                    unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateComment").setValue(unitsGroupGrid.getSelectionModel().getSelections()[0].get('comment'));
//                    unitsGroupId = unitsGroupGrid.getSelectionModel().getSelections()[0].get('id');
//                    winUnitsGroupUpdateForm.show();
//                }
            }
        },
        '-',
        {
            text:'Удалить',
            tooltip:'Удалить единицу измерения',
            iconCls:'remove',
            handler: function () {
//                if (unitsGroupGrid.getSelectionModel().getSelections().length != 0) {
//                    unitsGroupId = unitsGroupGrid.getSelectionModel().getSelections()[0].get('id');
//                    Ext.Msg.confirm('Подтверждение',
//                            'Вы уверены, что хотите удалить единицу измерения?',
//                                   function(btn, text) {
//                                       if (btn == 'yes') {
//                                           var unitsGroup = new UnitsGroup();
//                                           unitsGroup.setId(unitsGroupId);
//                                           action4UnitsGroup('delete', unitsGroup);
//                                       }
//                                   });
//                }
            }
        }
    ],
    //Вяжем листнеры...
    listeners: {
        //Обрабатываем двойное нажатие на строку...
        rowdblclick: function (grid, rowIndex, e) {
//            unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateName").setValue(unitsGroupGrid.getStore().getAt(rowIndex).get('name'));
//            unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateComment").setValue(unitsGroupGrid.getStore().getAt(rowIndex).get('comment'));
//            unitsGroupId = unitsGroupGrid.getStore().getAt(rowIndex).get('id');
//            winUnitsGroupUpdateForm.show();
        }
    }
    //Убираем лишние обрамление...
//    bodyStyle: 'border:0px;'
});


Ext.onReady(function() {
    var Tree = Ext.tree;
    var detailsText = '<i>Select a book to see more information...</i>';

    /*var tpl = new Ext.Template(
     '<h2 class="title">{title}</h2>',
     '<p><b>Published</b>: {published}</p>',
     '<p><b>Synopsis</b>: {innerText}</p>',
     '<p><a href="{url}" target="_blank">Purchase from Amazon</a></p>'
     );
     tpl.compile();*/

    new Ext.Panel({
        title: 'Reading List',
        renderTo: 'tree',
        layout: 'border',
        width: 740,
        height: 480,
        items: [
            {
                xtype: 'treepanel',
                id: 'tree-panel',
                region: 'west',
                autoScroll: true,
                rootVisible: true,
                width: 200,
                bodyStyle: 'border-top:0px; border-bottom:0px',
                split: true,
                root: {
                    nodeType: 'async',
                    text: 'Units Group',
                    draggable: false,
                    expanded: true,
                    id: 'root'
                },
                loader: new Tree.JsonTreeLoader({
                    dataUrl:'rest/unitsGroupTree.json',
                    nodeParameter:'unitsGroupTreeNodeList',
                    requestMethod: 'GET',
                    rootNode: 'unitsGroupTreeResponse.nodes'
                }),
                listeners: {
                    'render': function(tp) {
                        tp.getSelectionModel().on('selectionchange', function(tree, node) {
//                            var el = Ext.getCmp('details-panel').body;
                            if (node && node.leaf) {
                                unitsOfMeasureStore.load({
                                    params: {
                                        id: node.id
                                    }
                                });
                                /*tpl.overwrite(el, node.attributes);
                                 } else {
                                 el.update(detailsText);
                                 */
//                                alert(node.id);
                            }
                        })
                    }
                }
            },
            unitsOfMeasureGrid
            /*,
             {
             region: 'center',
             title: 'Book Details',
             id: 'details-panel',
             autoScroll: true,
             collapsible: true,
             split: true,
             //                margins: '0 2 2 2',
             //                cmargins: '2 2 2 2',
             //                height: 220,
             html: detailsText
             }*/
        ]
    });
});