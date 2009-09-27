/*!
 * Ext JS Library 3.0.0
 * Copyright(c) 2006-2009 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
/*
 * ================  TabPanel with nested layouts  =======================
 */
// fake grid data used below in the tabsNestedLayouts config


var price_Concentrator = {
    xtype: 'tabpanel',
    id: 'Price_Concentrator-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
        
    },
    items:[{
        title: 'Suppliers & Prices',
        contentEl: 'EEE',
        autoScroll: true
    },{
        title: 'Manufacturers & Product Types',
        contentEl: 'ManPT',
        autoScroll: true
    },{
        title: 'Matching',
        contentEl: 'Matching'
    },{
        title: 'Price Rules',
        html: 'This is tab 3 content.'
    },{
        title: 'Output',
        html: 'This is tab 3 content.'
    }]
};



var yandex = {
    id: 'Yandex-panel',
    title: 'Yandex Comporator',
    layout: 'fit',
    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
    //	bodyStyle: 'padding:25px',
    contentEl: 'Yandex_Comporator' // pull existing content from the page

};
