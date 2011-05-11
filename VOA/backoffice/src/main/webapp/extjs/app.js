/**
 * @author Andrey Popov creates on 05.05.11 (10:48)
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'core/ext'
    }
});


Ext.application({
    name: 'AM',
    appFolder: 'app',
    controllers: [
        'Users'
    ],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'userlist'
                }
            ]
        });
    }
});