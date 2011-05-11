/**
 * @author Andrey Popov creates on 11.05.11 (17:00)
 */
Ext.define('voa.model.Car', {
    extend: 'Ext.data.Model',
    requires: [
        'Ext.data.Store',
        'Ext.data.Model',
        'Ext.data.Association',
        'Ext.data.BelongsToAssociation',
        'Ext.data.HasManyAssociation'
    ],
    fields: [
        {name: 'id', type: 'int'},
        {name: 'originDate', type: 'string'},
        {name: 'registrationNumber', type: 'string'}
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
