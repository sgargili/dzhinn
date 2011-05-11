/**
 * @author Andrey Popov creates on 04.05.11 (15:55)
 */

Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'js/core/ext'
    }
});

Ext.require([
    'Ext.data.Store',
    'Ext.data.Model',
    'Ext.data.Association',
    'Ext.data.BelongsToAssociation',
    'Ext.data.HasManyAssociation'
]);

//Ext.require([
//    'Ext.data.Store',
//    'Ext.data.Model',
//    'Ext.data.Association',
//    'Ext.data.BelongsToAssociation',
//    'Ext.data.HasManyAssociation'
//]);
Ext.onReady(function() {
    var MemberGridColumns = [
        Ext.create('Ext.grid.RowNumberer'),
        {text: 'Номер ЛС члена ВОА', dataIndex: 'id'},
        {text: 'Фамилия',  dataIndex: 'surName', flex: 1},
        {text: 'Имя',  dataIndex: 'name'},
        {text: 'Отчество',  dataIndex: 'patronymic'},
        {text: 'Пол',  dataIndex: 'gender'},
        {text: 'Место жительства',  dataIndex: 'location'},
        {text: 'Сотовый телефон',  dataIndex: 'mobilePhone'},
        {text: 'E-Mail',  dataIndex: 'email'}
    ];

    Ext.define('CarBrand', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'brandName', type: 'string'}
        ],
        validations: [
            {type: 'presence', field: 'brandName'}
        ]
    });

    Ext.define('CarModel', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'usageType', type: 'string'},
            {name: 'registrationNumber', type: 'string'},
            {name: 'originDate', type: 'date'}
        ],
        validations: [
            {type: 'presence', field: 'registrationNumber'}
        ]
    });

    Ext.define('Car', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'modelName', type: 'string'},
            {name: 'brandId', type: 'int'}
        ],
        validations: [
            {type: 'presence', field: 'modelName'},
            {type: 'presence', field: 'brandId'}
        ],
        associations: [
            {type: 'belongsTo', model: 'CarModel', name: 'carModel'},
            {type: 'belongsTo', model: 'CarBrand', name: 'carBrand'}
        ]

    });


    Ext.define('Member', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},
            {name: 'surName', type: 'string'},
            {name: 'name', type: 'string'},
            {name: 'patronymic', type: 'string'},
            {name: 'gender', type: 'string'},
            {name: 'location', type: 'string'},
            {name: 'mobilePhone', type: 'string'},
            {name: 'email', type: 'string'}
        ],
        validations: [
            {type: 'surName', field: 'registrationNumber'}
        ],
        associations: [
            {type: 'belongsTo', model: 'Car', name: 'memberCars'}
        ]
    });


    var myStore = new Ext.data.Store({
        model: 'Member',
        proxy: {
            type: 'ajax',
            url : '../rest/members?firstRow=0&listSize=5&sortOrder=asc&sortColumn=id',
            reader: {
                type: 'json',
                root: 'members'
            }
        }
    });

    Ext.create('Ext.grid.Panel', {
        title: 'Members',
        store: myStore,
        columns: MemberGridColumns,
        renderTo: Ext.getBody()
    });

    myStore.load(function() {
        myStore.each(function(record) {
            console.debug(record.getAssociatedData().modelName);
        });
    });

});