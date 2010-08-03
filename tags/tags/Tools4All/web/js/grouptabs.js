/*!
 * Ext JS Library 3.2.0
 * Copyright(c) 2006-2010 Ext JS, Inc.
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function() {
    Ext.QuickTips.init();
    

    var panel = new Ext.ux.GroupTabPanel(
    {
        tabWidth: 170,
        id:'tabPanel',
        activeGroup: 0,
        items: [{
            mainItem: 0,
            items: [{
                title: 'Article1',
                tabTip: 'Article1 Content',
                style: 'padding: 10px;',
                html:'Hello!'
            }]
        }, {
            items: [{
                title: 'Article2',
                tabTip: 'Article2 Content',
                style: 'padding: 10px;',
                items: [{
                    xtype: 'button',
                    text: '<<Отправить>>>',
                    style: {
                        marginTop: '7px',
                        align: 'center'
                    },
                    bodyStyle: 'align:center',
                    listeners: {
                        click: function() {
                            panel.add({
                                items: [{
                                    title: 'Sites'
                                }]
                            });


                        }
                    }
                }]
            }]
        }]
    });

   

    var viewport = new Ext.Viewport({
        //layout:'fit',
        items:[{
            xtype: 'button',
            text: '<<>>>',
            style: {
                marginTop: '7px',
                align: 'center'
            },
            bodyStyle: 'align:center',
            listeners: {
                click: function() {
                    panel.add({
                        items: [{
                            title: 'Sites'
                        }]
                    });


                }
            }
        },
        {
            xtype: 'button',
            text: '<<Создать>>>',
            style: {
                marginTop: '7px',
                align: 'center'
            },
            bodyStyle: 'align:center',
            listeners: {
                click: function() {
                    viewport.add(
                        panel
                        );


                }
            }
        },panel]
    });
});
