/**
 * @author Andrey Popov creates on 11.05.11 (16:59)
 */
Ext.define('voa.model.Region', {
    extend: 'Ext.data.Model',
    requires: [
        'Ext.data.Model'
    ],
    fields: [
        {name: 'regionID', type: 'int'},
        {name: 'regionName', type: 'string'}
    ],
    validations: [
        {type: 'presence', field: 'regionName'}
    ]
});
