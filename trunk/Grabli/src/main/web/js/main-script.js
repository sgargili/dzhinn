/**
 *
 * User: Andrey Popov
 * Date: 14.10.2010
 * Time: 17:26:30
 */

//Дополнение для загрузки файлов...
Ext.ux.Report = Ext.extend(Ext.Component, {
    autoEl: {tag: 'iframe', cls: 'x-hidden', src: Ext.SSL_SECURE_URL},
    load: function(config) {
        this.getEl().dom.src = config.url + (config.params ? '?' + Ext.urlEncode(config.params) : '');
    }
});

Ext.reg('ux.report', Ext.ux.Report);
//Конец дополнения

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
                Ext.getCmp('ip').setDisabled(false);
                Ext.getCmp('port').setDisabled(false);
            } else {
                Ext.getCmp('ip').setDisabled(true);
                Ext.getCmp('port').setDisabled(true);
            }
        }
    }
});

var statusData = [
    ['1', 'Описания Nix'],
    ['2', 'Картинки Nix'],
    ['3', 'Описания Fcenter'],
    ['4', 'Картинки Fcenter'],
    ['5', 'Описания Orion'],
    ['6', 'Картинки Orion']
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
            if (statusCombo.getValue() == '2'
                    || statusCombo.getValue() == '4'
                    || statusCombo.getValue() == '6') {
                Ext.getCmp('picPath').setDisabled(false);
            } else {
                Ext.getCmp('picPath').setDisabled(true);
            }
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
        {
            id: 'report',
            xtype: 'ux.report'
        },
        statusCombo,
        {
            fieldLabel: 'Путь для картинок',
            name: 'picPath',
            regex: /\/$/,
            regexText: 'В конце пути должен стоять слеш "/"...',
            id:'picPath',
            disabled: true,
            value: 'C:/tempPic4Shop/'
        },
        proxyCombo,
        {
            fieldLabel: 'IP прокси',
            name: 'ip',
            regex: /^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/,
            regexText: 'Не верный формат IP...',
            id:'ip',
            disabled: true,
            value: '127.0.0.1'
        },
        {
            fieldLabel: 'Порт прокси',
            name: 'port',
            regex: /^\d{1,5}$/,
            maxLength: 5,
            id:'port',
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
                            processId: statusCombo.getValue()
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
            text: 'Запустить процесс',
            handler: function () {
                if (proxyCombo.isValid() && statusCombo.isValid()) {
                    Ext.Msg.show({
                        title: 'Выполненно!',
                        msg: 'Процесс запущен...',
                        buttons: Ext.MessageBox.OK,
                        width: 400,
                        icon: Ext.MessageBox.INFO
                    });
                    Ext.Ajax.request({
                        url: 'rest/process.html',
                        params: {
                            processId: statusCombo.getValue(),
                            picPath: Ext.getCmp('picPath').getValue(),
                            useProxy: proxyCombo.getValue(),
                            ip: Ext.getCmp('ip').getValue(),
                            port: Ext.getCmp('port').getValue()
                        },
                        method: 'POST',
                        success: function (response, opts) {
                            Ext.Msg.show({
                                title: 'Выполненно!',
                                msg: response.responseText,
                                buttons: Ext.MessageBox.OK,
                                width: 400,
                                icon: Ext.MessageBox.INFO
                            });
                        },
                        failure: function (response, opts) {
                        }
                    });
                }
            }
        },
        {
            text: 'Загрузить данные',
            handler: function () {
                if (statusCombo.isValid()) {
                    if (statusCombo.getValue() == '3' ||
                            statusCombo.getValue() == '4') {
                        Ext.getCmp('report').load({
                            url: 'rest/csv.html',
                            params: {
                                shopId: '2'
                            }
                        });
                    } else {
                        Ext.getCmp('report').load({
                            url: 'rest/csv.html',
                            params: {
                                shopId: '1'
                            }
                        });
                    }
                }
            }
        }
    ]
});

grabliForm.render(Ext.getBody());
Ext.QuickTips.init();
