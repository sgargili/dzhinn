/**
 *
 * User: Andrey Popov
 * Date: 14.10.2010
 * Time: 17:26:30
 */

var loginForm = new Ext.FormPanel({
    labelWidth: 120,
    url:'j_spring_security_check',
    frame:true,
    title: 'Авторизация',
    bodyStyle:'padding:5px 5px 0',
    width: 400,
    defaults: {
        width: 200
    },
    style: {
        padding: '10px'
    },
    defaultType: 'textfield',

    items: [
        {
            fieldLabel: 'Имя пользователя',
            name: 'j_username',
            maxLength: 25,
            allowBlank:false
        },
        {
            fieldLabel: 'Пароль',
            allowBlank:false,
            name: 'j_password',
            inputType: 'password',
            maxLength: 25
        }

    ],

    buttons: [
        {
            text: 'Войти',
            handler: function () {
                loginForm.getForm().submit();
            }
        }
    ]
});

loginForm.render(Ext.getBody());