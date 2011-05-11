/**
 * @author Andrey Popov creates on 11.05.11 (17:00)
 */
Ext.define('voa.model.CarBrand', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'brandName', type: 'string'}
    ],
    validations: [
        {type: 'presence', field: 'brandName'}
    ]
});
