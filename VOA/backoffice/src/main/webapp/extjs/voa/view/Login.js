Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'extjs/core/ext',
        'Voa': 'extjs/voa'
    }
});

Ext.require([
    'Ext.form.action.StandardSubmit',
    'Ext.layout.container.Fit',
    'Ext.window.MessageBox',
    'Voa.util.Message'
]);

Ext.onReady(function() {
    if (location.search.substring(1) == 'login_error=1') {
        var message = new Message(3000);
        message.show('Ошибка!', 'Введены неверные пользовательские данные!');
    }

    var loginForm = Ext.create('Ext.form.Panel', {
        url:'j_spring_security_check',
        frame:true,
        preventHeader : true,
        standardSubmit:true,
        title: 'Вход в систему',
        width: 450,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 130
        },
        defaultType: 'textfield',
        defaults: {
            anchor: '100%'
        },
        items: [
            {
                fieldLabel: 'Имя пользователя',
                name: 'j_username',
                emptyText: 'Имя пользователя...',
                blankText: 'Имя пользователя должно быть указано...',
                allowBlank:false
            },
            {
                fieldLabel: 'Пароль',
                name: 'j_password',
                inputType: 'password',
                emptyText: 'Пароль...',
                blankText: 'Пароль должен быть указан...',
                allowBlank:false,
                enableKeyEvents: true,
                listeners: {
                    keypress: function(field, event) {
                        if (event.getKey() == event.ENTER) {
                            this.up('form').getForm().submit();
                        }
                    }
                }
            }
        ],
        buttons: [
            {
                text: 'Вход',
                handler: function() {
                    this.up('form').getForm().submit();
                }
            }
        ]
    });

    Ext.create('widget.window', {
        title: 'Вход в систему',
        closable: false,
        border: false,
        layout: 'fit',
        autoShow: true,
        plain: true,
        items: [
            loginForm
        ]
    });
});
