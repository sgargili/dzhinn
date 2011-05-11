/**
 * @author Andrey Popov creates on 11.05.11 (16:37)
 */
Ext.define('voa.model.InsuarancePolicy', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'policyType', type: 'string'},
        {name: 'insuaranceCompany', type: 'string'},
        {name: 'policyEndDate', type: 'date'}
    ],
    validations: [
        {type: 'presence', field: 'insuaranceCompany'}
    ]
});