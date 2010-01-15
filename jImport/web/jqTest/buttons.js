/*!
 * Ext JS Library 3.1.0
 * Copyright(c) 2006-2009 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){

    // This function renders a block of buttons
    function renderButtons(title){

        Ext.getBody().createChild({
            tag: 'h2',
            html: title
        });

        new ButtonPanel(
            'Text Only',
            [{
                text: 'Add User'
            },{
                text: 'Add User',
                scale: 'medium'
            },{
                text: 'Add User',
                scale: 'large'
            }]
            );
    }

    renderButtons('Normal Buttons');

    ButtonPanel.override({
        enableToggle: true
    });

    renderButtons('Toggle Buttons');

    ButtonPanel.override({
        enableToggle : undefined,
        menu : {
            items: [{
                text:'Menu Item 1'
            },{
                text:'Menu Item 2'
            },{
                text:'Menu Item 3'
            }]
        }
    });
});

// Helper class for organizing the buttons
ButtonPanel = Ext.extend(Ext.Panel, {
    layout:'table',
    defaultType: 'button',
    baseCls: 'x-plain',
    cls: 'btn-panel',
    renderTo : 'docbody',
    menu: undefined,
    split: false,

    layoutConfig: {
        columns:3
    },

    constructor: function(desc, buttons){
        // apply test configs
        for(var i = 0, b; b = buttons[i]; i++){
            b.menu = this.menu;
            b.enableToggle = this.enableToggle;
            b.split = this.split;
            b.arrowAlign = this.arrowAlign;
        }
        var items = [{
            xtype: 'box',
            autoEl: {
                tag: 'h3',
                html: desc,
                style:"padding:15px 0 3px;"
            },
            colspan: 3
        }].concat(buttons);

        ButtonPanel.superclass.constructor.call(this, {
            items: items
        });
    }
});