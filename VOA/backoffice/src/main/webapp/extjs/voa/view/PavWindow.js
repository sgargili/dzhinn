/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('voa.view.PavWindow', {
            extend: 'Ext.ux.desktop.Module',
            alias : 'widget.pavwindow',
            requires: [
                'Ext.tab.Panel'
            ],

            id:'pav-win',

            init : function() {
                this.launcher = {
                    text: 'Cars',
                    iconCls:'notepad',
                    handler : this.createWindow,
                    scope: this
                }
            },

            createWindow : function() {
                console.debug('CreateWindow');
                var desktop = this.app.getDesktop();
                var win = desktop.getWindow('pav-win');
                if (!win) {
                    console.debug('CreateWindow');
                    win = desktop.createWindow({
                                id: 'pav-win',
                                title:'Cars',
                                width:600,
                                height:400,
                                iconCls: 'notepad',
                                animCollapse:false,
                                border: false,
                                hideMode: 'offsets',
                                layout: 'fit',
                                items: [
                                    {
//                                        xtype: 'cars'
                                    }
                                ]
                            });
                }
                win.show();
                return win;
            }
        });
