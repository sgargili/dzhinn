// Переменная для айдишника единицы измерения, служит для работы функционала во время удаления и обновления данных...
var unitsGroupId;

//Ридер данных коллекции единиц измерения...
var unitsGroupReader = new Ext.data.JsonReader({
    root: 'unitsGroupResponse.unitsGroupDtos',
    totalProperty: 'unitsGroupResponse.totalRowsCount',
    idProperty: 'id',
    fields: [
        'id',
        'name',
        'comment'
    ]
});

//Хранилище данных для единиц измерения...
var unitsGroupStore = new Ext.data.Store({
    reader: unitsGroupReader,
    proxy: new Ext.data.HttpProxy({
        url: 'rest/unitsGroup.json',
        method: 'GET'
    }),
    //Алиасы параметров пейджинга, указывать обязательно, ибо не будет работать пейджинг..
    paramNames: {
        start : 'firstResult',
        limit : 'maxResult'
    }
});

//Комбобокс для функционала пейджинга, указывает количество строк в таблице...
var comboPerPageUnitsGroup = new Ext.form.ComboBox({
    name : 'perpage',
    width: 60,
    store: new Ext.data.ArrayStore({
        fields: ['id'],
        //Возможные варианты количества строк в таблице....
        data  : [
            ['10'],
            ['25'],
            ['50']
        ]
    }),
    mode : 'local',
    //Значение количества строк по-умолчанию...
    value: '25',
    listWidth     : 40,
    triggerAction : 'all',
    displayField  : 'id',
    valueField    : 'id',
    //Убираем возможность правки данных, пусть юзер только указанные выше использует...
    editable      : false,
    forceSelection: true
});

 // Пейджинговый тулбар...
var bbarUnitsGroup = new Ext.PagingToolbar({
    pageSize: 25,
    store: unitsGroupStore,
    displayInfo: true,
    firstText: 'Первая страница',
    prevText: 'Предыдущая страница',
    nextText : 'Следующая страница',
    lastText : 'Последняя страница',
    refreshText : 'Обновить',
    displayMsg: 'Показ строк {0} - {1} из {2}',
    emptyMsg: "Нет строк для отображения...",
    beforePageText: 'Страница',
    afterPageText: 'из {0}',
    /*baseParams : {
        sortOrder: 'asc',
        sortColumn: 'id'
    },*/
    items   :    [
        '-',
        'Строк: ',
        comboPerPageUnitsGroup
    ]
});


//Обработка события пейджингового комбобокса... При выборе перезагружаем таблицу.
comboPerPageUnitsGroup.on('select', function(combo, record) {
    bbarUnitsGroup.pageSize = parseInt(record.get('id'), 10);
    bbarUnitsGroup.doLoad(bbarUnitsGroup.cursor);
}, this);

//Маска загрузки данных таблицы...
var mask = new Ext.LoadMask(Ext.getBody(), {
    msg:"Пожалуйста, подождите..."
});

//Панель представления таблицы данных...
var unitsGroupGrid = new Ext.grid.GridPanel({
    store: unitsGroupStore,
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
            header: "Единица измерения",
            dataIndex: 'name',
            sortable: true
        },
        {
            header: "Комментарий",
            dataIndex: 'comment',
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
    //Нижний тулбар...
    bbar:  bbarUnitsGroup,
    //Верхний тулбар...
    tbar:[
        {
            text:'Добавить',
            tooltip:'Добавить новую единицу измерения',
            iconCls:'add',
            handler: function () {
                winUnitsGroupAddForm.show();
            }
        },
        '-',
        {
            text:'Изменить',
            tooltip:'Настроить данные единицы измерения',
            iconCls:'option',
            handler: function () {
                if (unitsGroupGrid.getSelectionModel().getSelections().length != 0) {
                    unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateName").setValue(unitsGroupGrid.getSelectionModel().getSelections()[0].get('name'));
                    unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateComment").setValue(unitsGroupGrid.getSelectionModel().getSelections()[0].get('comment'));
                    unitsGroupId = unitsGroupGrid.getSelectionModel().getSelections()[0].get('id');
                    winUnitsGroupUpdateForm.show();
                }
            }
        },
        '-',
        {
            text:'Удалить',
            tooltip:'Удалить единицу измерения',
            iconCls:'remove',
            handler: function () {
                if (unitsGroupGrid.getSelectionModel().getSelections().length != 0) {
                    unitsGroupId = unitsGroupGrid.getSelectionModel().getSelections()[0].get('id');
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
    //Вяжем листнеры...
    listeners: {
        //Обрабатываем двойное нажатие на строку...
        rowdblclick: function (grid, rowIndex, e) {
            unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateName").setValue(unitsGroupGrid.getStore().getAt(rowIndex).get('name'));
            unitsGroupUpdateForm.getForm().findField("unitsGroupUpdateComment").setValue(unitsGroupGrid.getStore().getAt(rowIndex).get('comment'));
            unitsGroupId = unitsGroupGrid.getStore().getAt(rowIndex).get('id');
            winUnitsGroupUpdateForm.show();
        }
    },
    //Убираем лишние обрамление...
    bodyStyle: 'border:0px;'
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
                unitsGroupStore.reload();
            },
            failure: function (response, opts) {
                unitsGroupStore.reload();
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

