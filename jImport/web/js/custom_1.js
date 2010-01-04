var value4export = {

    xtype: 'tabpanel',
    id: 'vExp-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Экспорт по продукту',
        contentEl: 'expByProd',
        autoScroll: true
    },{
        title: 'Экспорт маркетинга',
        contentEl: 'expMark'
    }
    //    ,{
    //        title: 'Импорт изображений',
    //        contentEl: 'images_import'
    //    },{
    //        title: 'Дополнительно',
    //        contentEl: 'add_import'
    //    }
    ]
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
        contentEl: 'nixGrabPT',
        autoScroll: true
    },{
        title: 'Content',
        contentEl: 'nixGrabCont'
    },{
        title: 'Output',
        contentEl: 'nixGrabOut'
    }]
};

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