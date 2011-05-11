/**
 * @author Andrey Popov creates on 11.05.11 (17:00)
 */
Ext.define('voa.model.TechnicalSupport', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'companyName', type: 'string'},
        {name: 'companyDirector', type: 'string'},
        {name: 'hasInsuarance', type: 'string'},
        {name: 'phoneNumber', type: 'string'},
        {name: 'location', type: 'string'},
        {name: 'street', type: 'string'},
        {name: 'house', type: 'string'},
        {name: 'houseUnit', type: 'string'},
        {name: 'serviceTerritory', type: 'string'},
        {name: 'regionEvacuationPrice', type: 'string'},
        {name: 'countrysidePrice', type: 'string'},
        {name: 'truckEvacuation', type: 'boolean'},
        {name: 'companyStatus', type: 'string'}
    ],
    associations: [
        {type: 'belongsTo', model: 'Region', name: 'region'}
    ]
});