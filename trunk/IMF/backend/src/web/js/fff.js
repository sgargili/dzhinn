var unitsGroupId;

Ext.onReady(function() {
    var mask = new Ext.LoadMask('tree', {
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
        id: 'storee',
        store: unitsOfMeasureStore,
        region: 'center',
        loadMask: true,
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


//Ext.onReady(function() {
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
                tbar:[
                    {
                        text:'',
                        tooltip:'Добавить новую единицу измерения',
                        iconCls:'add',
                        handler: function () {
                            winUnitsGroupAddForm.show();
                        }
                    },
                    '-',
                    {
                        text:'',
                        tooltip:'Настроить данные единицы измерения',
                        iconCls:'option',
                        handler: function () {
//                            alert(Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode().text);
                            if (Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode() != null) {
                                unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateName").setValue(Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode().text);
//                                unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateComment").setValue(Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode().comment);
                                unitsGroupId = Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode().id;
                                winUnitsGroupUpdateForm.show();
                            }
                        }
                    },
                    '-',
                    {
                        text:'',
                        tooltip:'Удалить единицу измерения',
                        iconCls:'remove',
                        handler: function () {
                            if (Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode() != null) {
                                unitsGroupId = Ext.getCmp('tree-panel').getSelectionModel().getSelectedNode().id;
                                Ext.Msg.confirm('Подтверждение',
                                        'Вы уверены, что хотите удалить единицу измерения?',
                                               function(btn, text) {
                                                   if (btn == 'yes') {
                                                       var unitsGroup = new UnitsGroup();
                                                       unitsGroup.setId(unitsGroupId);
                                                       action4UnitsGroup('delete', unitsGroup);
                                                   }
                                               });
                            }
                        }
                    }
                ],
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
        ]
    });

    //Ajax вызовы для работы с данными таблицы...
    function action4UnitsGroup(action, unitsGroup) {
        if (action == 'add' || action == 'update' || action == 'delete') {
            Ext.Ajax.request({
                url: 'rest/' + action + 'UnitsGroup',
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                //Суем в тело запроса Json-объект...
                params: Ext.encode(unitsGroup),
                method: 'POST',
                success: function (response, opts) {
                    Ext.getCmp('tree-panel').getRootNode().reload();
                },
                failure: function (response, opts) {
                    Ext.getCmp('tree-panel').getRootNode().reload();
                }
            });
        }
    }

//Форма добавления единицы измерения...
    var unitsGroupAddForm = new Ext.FormPanel({
        labelWidth: 75,
        url:'rest/addUnitsGroup',
        frame:true,
        bodyStyle:'padding:0px; border: 0px',
        width: 350,
        defaults: {
            width: 230
        },
        defaultType: 'textfield',

        items: [
            {
                id:'unitsGroupAddName',
                fieldLabel: 'Имя',
                name: 'name',
                allowBlank:false
            },
            {
                id:'unitsGroupAddComment',
                fieldLabel: 'Комметарий',
                name: 'comment'
            }
        ],
        buttons: [
            {
                text: 'Сохранить',
                handler: function () {
                    var form = unitsGroupAddForm.getForm();
                    if (form.isValid()) {
                        //Собираем данные в DTO-объект который потом отправим серверу в Json виде...
                        var unitsGroup = new UnitsGroup();
                        unitsGroup.setName(form.findField("unitsGroupAddName").getValue());
                        unitsGroup.setComment(form.findField("unitsGroupAddComment").getValue());
                        action4UnitsGroup('add', unitsGroup);
                        unitsGroupAddForm.getForm().reset();
                        winUnitsGroupAddForm.hide();
                    }
                }
            },
            {
                text: 'Отменить',
                handler: function () {
                    unitsGroupAddForm.getForm().reset();
                    winUnitsGroupAddForm.hide();
                }
            }
        ]
    });

//Окно добавления единицы измерения...
    var winUnitsGroupAddForm = new Ext.Window({
        layout: 'fit',
        showAnimDuration: 0.2,
        hideAnimDuration: 0.2,
        title: 'Добавить единицу измерения',
        width: 400,
        height: 150,
        closeAction: 'hide',
        plain: true,
        items: unitsGroupAddForm
    });


    //Форма обновления единицы измерения...
    var unitsGroupUpdateForm = new Ext.FormPanel({
        labelWidth: 75,
        url:'rest/updateUnitsGroup',
        frame:true,
        bodyStyle:'padding:0px; border: 0px',
        width: 350,
        defaults: {
            width: 230
        },
        defaultType: 'textfield',
        items: [
            {
                id:'unitsGroupUpdateName',
                fieldLabel: 'Имя',
                name: 'name',
                allowBlank:false
            },
            {
                id:'unitsGroupUpdateComment',
                fieldLabel: 'Комметарий',
                name: 'comment'
            }
        ],
        buttons: [
            {
                text: 'Сохранить',
                handler: function () {
                    var form = unitsGroupUpdateForm.getForm();
                    if (form.isValid()) {
                        //Собираем данные в DTO-объект который потом отправим серверу в Json виде...
                        var unitsGroup = new UnitsGroup();
                        unitsGroup.setId(unitsGroupId);
                        unitsGroup.setName(form.findField("unitsGroupUpdateName").getValue());
                        unitsGroup.setComment(form.findField("unitsGroupUpdateComment").getValue());
                        action4UnitsGroup('update', unitsGroup);
                        unitsGroupUpdateForm.getForm().reset();
                        winUnitsGroupUpdateForm.hide();
                    }
                }
            },
            {
                text: 'Отменить',
                handler: function () {
                    unitsGroupUpdateForm.getForm().reset();
                    winUnitsGroupUpdateForm.hide();
                }
            }
        ]
    });

    //Окно обновления единицы измерения...
    var winUnitsGroupUpdateForm = new Ext.Window({
        layout: 'fit',
        showAnimDuration: 0.2,
        hideAnimDuration: 0.2,
        title: 'Изменить единицу измерения',
        width: 400,
        height: 150,
        closeAction: 'hide',
        plain: true,
        items: unitsGroupUpdateForm
    });
});