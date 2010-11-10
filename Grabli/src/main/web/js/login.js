/**
 *
 * User: Andrey Popov
 * Date: 14.10.2010
 * Time: 17:26:30
 */

var proxyData = [
    ['true', 'Да'],
    ['false', 'Нет']
];

var proxyStore = new Ext.data.ArrayStore({
    fields: ['id', 'value'],
    data : proxyData
});

var proxyCombo = new Ext.form.ComboBox({
    store: proxyStore,
    fieldLabel: 'Использовать Proxy',
    name: 'useProxy',
    displayField: 'value',
    valueField: 'id',
    maxLength: 3,
    typeAhead: false,
    mode: 'local',
    triggerAction: 'all',
    emptyText: 'Да, Нет?...',
    selectOnFocus: true,
    allowBlank: false,
    disabled: true,
    blankText: 'Нужно выбрать...',
    listeners: {
        'select': function() {
            if (proxyCombo.getValue() == 'true') {
                Ext.getCmp('proxyIp').setDisabled(false);
                Ext.getCmp('proxyPort').setDisabled(false);
            } else {
                Ext.getCmp('proxyIp').setDisabled(true);
                Ext.getCmp('proxyPort').setDisabled(true);
            }
        }
    }
});

var statusData = [
    ['fcDesc', 'Описания Fcenter'],
    ['fcPics', 'Картинки Fcenter'],
    ['nixDesc', 'Описания Nix'],
    ['nixPics', 'Картинки Nix']
];

var statusStore = new Ext.data.ArrayStore({
    fields: ['id', 'value'],
    data : statusData
});

var statusCombo = new Ext.form.ComboBox({
    store: statusStore,
    fieldLabel: 'Метод',
    name: 'method',
    displayField: 'value',
    valueField: 'id',
    maxLength: 30,
    typeAhead: false,
    mode: 'local',
    triggerAction: 'all',
    emptyText: 'Веберите метод',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Нужно выбрать...',
    listeners: {
        'select': function() {
            proxyCombo.setDisabled(false);
        }
    }
});


var grabliForm = new Ext.FormPanel({
    labelWidth: 120,
    frame:true,
    title: 'Запуск процессов грабилки',
    bodyStyle:'padding:5px 5px 0',
    width: 500,
    defaults: {
        width: 200
    },
    style: {
        padding: '10px'
    },
    defaultType: 'textfield',

    items: [
        statusCombo,
        proxyCombo,
        {
            fieldLabel: 'Proxy IP',
            name: 'proxyIp',
            regex: /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/,
            id:'proxyIp',
            disabled: true,
            value: '127.0.0.1'
        },
        {
            fieldLabel: 'Proxy Port',
            name: 'proxyPort',
            regex: /^\d{1,5}$/,
            maxLength: 5,
            id:'proxyPort',
            disabled: true,
            value: '8118'
        }

    ],
    buttons: [
        {
            text: 'Проверить статус',
            handler: function () {
                if (statusCombo.isValid()) {
                    Ext.Ajax.request({
                        url: 'rest/status.html',
                        params: {
                            process: statusCombo.getValue()
                        },
                        method: 'POST',
                        success: function (response, opts) {
                            Ext.Msg.show({
                                title: 'Выполненно!',
                                msg: 'Статус процесса: ' + response.responseText,
                                buttons: Ext.MessageBox.OK,
                                width: 400,
                                icon: Ext.MessageBox.INFO
                            });
                        },
                        failure: function (response, opts) {
                            Ext.Msg.show({
                                title: 'Выполненно!',
                                msg: 'Ошибка... Что-то упало... См. тут: ' + response.responseText,
                                buttons: Ext.MessageBox.OK,
                                width: 400,
                                icon: Ext.MessageBox.INFO
                            });
                        }
                    });
                }
            }
        },
        {
            text: 'Запустить',
            handler: function () {
                if (proxyCombo.isValid() && statusCombo.isValid()) {
                    Ext.Ajax.request({
                        url: 'rest/process.html',
                        params: {
                            process: statusCombo.getValue(),
                            useProxy: proxyCombo.getValue(),
                            proxyIp: Ext.getCmp('proxyIp').getValue(),
                            proxyPort: Ext.getCmp('proxyPort').getValue()
                        },
                        method: 'POST',
                        success: function (response, opts) {
                            Ext.Msg.show({
                                title: 'Выполненно!',
                                msg: 'Процесс грабилки описаний для Fcenter запущен.' + response.responseText,
                                buttons: Ext.MessageBox.OK,
                                width: 400,
                                icon: Ext.MessageBox.INFO
                            });
                        },
                        failure: function (response, opts) {
                            Ext.Msg.show({
                                title: 'Выполненно!',
                                msg: 'Ошибка... Что-то упало... См. тут: ' + response.responseText,
                                buttons: Ext.MessageBox.OK,
                                width: 400,
                                icon: Ext.MessageBox.INFO
                            });
                        }
                    });
                }
            }
        }
    ]
});

grabliForm.render(Ext.getBody());
