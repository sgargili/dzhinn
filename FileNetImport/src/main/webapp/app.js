Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'js/src'
    }
});
Ext.require([
    'Ext.form.Panel'
]);

Ext.onReady(function() {

    var fileUploadForm = Ext.create('Ext.form.Panel', {
        width: 500,
        frame: true,
        title: '',
        titleCollapse: true,
        bodyPadding: '10 10 0',

        defaults: {
            anchor: '100%',
            allowBlank: false,
            msgTarget: 'side',
            labelWidth: 100
        },

        items: [
            {
                xtype: 'filefield',
                id: 'fileData',
                emptyText: 'Выберите файл для загрузки...',
                fieldLabel: 'Excel Файл',
                name: 'fileData',
                regex: /.*\.xlsx/,
                regexText: 'Файл не экселевский...',
                buttonText: 'Файл'/*,
             buttonConfig: {
             iconCls: 'upload-icon'
             }*/
            }
        ],

        buttons: [
            {
                text: 'Отмена',
                handler: function() {
                    this.up('form').getForm().reset();
                }
            },
            {
                text: 'Сохранить',
                handler: function() {
                    var form = this.up('form').getForm();
                    if (form.isValid()) {
                        form.submit({
                            url: 'upload/uploadForm',
                            waitMsg: 'Загрузка файла...',
                            success: function(form, action) {
                                console.debug(action.response);
                                Ext.Msg.alert('Success');
                            }
                        });
                    }
                }
            }
        ]
    });

    Ext.create('widget.window', {
        title: 'Загрузка Excel файла',
        closable: false,
        border: false,
        layout: 'fit',
        autoShow: true,
        plain: true,
        items: [
            fileUploadForm
        ]
    });
});
