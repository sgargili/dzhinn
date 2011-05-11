/**
 * @author Andrey Popov creates on 11.05.11 (17:00)
 */
Ext.define('voa.model.CarModel', {
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
