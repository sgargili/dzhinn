/**
 * @author Andrey Popov creates on 11.05.11 (16:51)
 */
Ext.define('voa.model.Member', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'name', type: 'string'},
        {name: 'patronymic', type: 'string'},
        {name: 'surName', type: 'string'},
        {name: 'birthDate', type: 'date'},
        {name: 'gender', type: 'string'},
        {name: 'citizenship', type: 'string'},
        {name: 'location', type: 'string'},
        {name: 'postCode', type: 'string'},
        {name: 'street', type: 'string'},
        {name: 'houseNumber', type: 'string'},
        {name: 'unitNumber', type: 'string'},
        {name: 'appartmentNumber', type: 'string'},
        {name: 'mobilePhone', type: 'string'},
        {name: 'workPhone', type: 'string'},
        {name: 'homePhone', type: 'string'},
        {name: 'email', type: 'string'},
        {name: 'questionnairyDate', type: 'date'},
        {name: 'membershipStatus', type: 'string'},
        {name: 'comment', type: 'string'},
        {name: 'documentType', type: 'string'},
        {name: 'documentSeries', type: 'string'},
        {name: 'documentNumber', type: 'string'},
        {name: 'documentDate', type: 'date'},
        {name: 'documentPublisher', type: 'string'}
    ],
    associations: [
        {type: 'belongsTo', model: 'Region', name: 'region'},
        {type: 'belongsTo', model: 'MemberCard', name: 'memberCard'},
        {type: 'hasMany', model: 'Car', name: 'cars'},
        {type: 'hasMany', model: 'InsuarancePolicy', name: 'insuarancePolicyes'},
        {type: 'hasMany', model: 'Payment', name: 'payments'}
    ]
});