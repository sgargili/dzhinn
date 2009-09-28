/*!
 * Ext JS Library 3.0.0
 * Copyright(c) 2006-2009 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
/*
 * CenterLayout demo panel
 */
 
var euromall = {

    xtype: 'tabpanel',
    id: 'Euromall-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:15px'
    },
    items:[{
        title: 'Shops',
        contentEl: 'www'
    },{
        title: 'Customers',
        contentEl: 'EEE'
    },{
        title: 'Matching',
        html: 'This is tab 3 content.'
    },{
        title: 'Price Rules',
        html: 'This is tab 3 content.'
    },{
        title: 'Output',
        html: 'This is tab 3 content.'
    }]
};

var nix = {

    xtype: 'tabpanel',
    id: 'Nix-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Product Types/Links',
        contentEl: 'nixGrabPT'
    },{
        title: 'Content',
        contentEl: 'nixGrabCont'
    },{
        title: 'Output',
        contentEl: 'nixGrabOut'
    }]
};







/*
 * RowLayout demo panel
 */
var a2Zmall = {
    xtype: 'tabpanel',
    id: 'A2Zmall-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:15px'
    },
    items:[{
        title: 'Shops',
        contentEl: 'www'
    },{
        title: 'Customers',
        contentEl: 'EEE'
    },{
        title: 'Matching',
        html: 'This is tab 3 content.'
    },{
        title: 'Price Rules',
        html: 'This is tab 3 content.'
    },{
        title: 'Output',
        html: 'This is tab 3 content.'
    }]
};

var magento = {
    xtype: 'tabpanel',
    id: 'Magento-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:15px'
    },
    items:[{
        title: 'Shops',
        contentEl: 'www'
    },{
        title: 'Customers',
        contentEl: 'EEE'
    },{
        title: 'Matching',
        html: 'This is tab 3 content.'
    },{
        title: 'Price Rules',
        html: 'This is tab 3 content.'
    },{
        title: 'Output',
        html: 'This is tab 3 content.'
    }]
};