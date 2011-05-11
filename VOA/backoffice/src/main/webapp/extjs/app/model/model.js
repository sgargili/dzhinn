/**
 * @author Andrey Popov creates on 03.05.11 (16:08)
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'ext4/src'
    }
});

Ext.require([
    'Ext.data.Store',
    'Ext.data.Model',
    'Ext.data.Association',
    'Ext.data.BelongsToAssociation',
    'Ext.data.HasManyAssociation'
]);

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

Ext.onReady(function() {

    var myStore = Ext.create('Ext.data.Store', {
        model: 'Car',
        proxy: {
            type: 'ajax',
            url : 'rest/carById?id=3413',
            reader: {
                type: 'json'
            }
        }
    });
    myStore.load(function() {
        myStore.each(function(record) {
            console.log(record.get('carModel'));
        });
    });

});

