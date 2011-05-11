/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('voa.view.VoaDesktop', {
    extend: 'Ext.ux.desktop.App',

    requires: [
        'Ext.window.MessageBox',
        'Ext.ux.desktop.ShortcutModel',
        'voa.view.PavWindow',
        'voa.view.Cars'
    ],

    init: function() {
        this.callParent();
    },

    getModules : function() {
        return [
            new voa.view.PavWindow()
        ];
    },

    getDesktopConfig: function () {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
//                            cls: 'ux-desktop-black',

            contextMenuItems: [
                { text: 'Change Settings', handler: me.onSettings, scope: me },
                { text: 'LogOut', handler: me.onLogout, scope: me }
            ],

            shortcuts: Ext.create('Ext.data.Store', {
                model: 'Ext.ux.desktop.ShortcutModel',
                data: [
                    /*{ name: 'Grid Window', iconCls: 'grid-shortcut', module: 'grid-win' },
                     { name: 'Accordion Window', iconCls: 'accordion-shortcut', module: 'acc-win' },
                     { name: 'Notepad', iconCls: 'notepad-shortcut', module: 'notepad' },*/
                    { name: '1', iconCls: 'grid-shortcut', module: 'pav-win'},
                    { name: '2', iconCls: 'accordion-shortcut', module: 'pav-win'},
                    { name: '3', iconCls: 'cpu-shortcut', module: 'pav-win'}
                ]
            }),

            wallpaper: 'extjs/voa/wallpapers/Blue-Sencha.jpg',
            wallpaperStretch: false
        });
    },

    // config for the start menu
    getStartConfig : function() {
        var me = this, ret = me.callParent();

        return Ext.apply(ret, {
            title: 'Don Griffin',
            iconCls: 'user',
            height: 300,
            toolConfig: {
                width: 100,
                items: [
                    {
                        text:'Settings',
                        iconCls:'settings',
                        handler: me.onSettings,
                        scope: me
                    },
                    '-',
                    {
                        text:'Logout',
                        iconCls:'logout',
                        handler: me.onLogout,
                        scope: me
                    }
                ]
            }
        });
    },

    getTaskbarConfig: function () {
        var ret = this.callParent();

        return Ext.apply(ret, {
            quickStart: [
                /*{ name: 'Accordion Window', iconCls: 'accordion', module: 'acc-win' },
                 { name: 'Grid Window', iconCls: 'icon-grid', module: 'grid-win' }*/
            ],
            trayItems: [
                { xtype: 'trayclock', flex: 1 }
            ]
        });
    },

    onLogout: function () {
//        Ext.Msg.confirm('Logout', 'Are you sure you want to logout?');
        location.replace("logout");
    },

    onSettings: function () {
        Ext.Msg.confirm('Settings');

//                var dlg = new MyDesktop.Settings({
//                            desktop: this.desktop
//                        });
//                dlg.show();
    }
});
