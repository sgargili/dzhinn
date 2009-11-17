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
var ecsv = {
    id: 'eCsv-panel',
    title: 'Преобразование файла из форматов XLS и CSV(Excel) в нормальный CSV!',
    layout: 'fit',
    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
    //	bodyStyle: 'padding:25px',
    contentEl: 'eCsv' // pull existing content from the page

};