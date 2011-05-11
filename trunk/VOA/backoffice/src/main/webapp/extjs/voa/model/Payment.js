/**
 * @author Andrey Popov creates on 11.05.11 (16:41)
 */
Ext.define('voa.model.Payment', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'paymentDate', type: 'date'},
        {name: 'bic', type: 'string'},
        {name: 'ticketNumber', type: 'string'},
        {name: 'paymentWay', type: 'string'},
        {name: 'paymentType', type: 'string'},
        {name: 'ammount', type: 'number'},
        {name: 'payStatus', type: 'string'},
        {name: 'paymentDestination', type: 'string'},
        {name: 'memberBankBook', type: 'string'},
        {name: 'registrationDate', type: 'date'},
        {name: 'memberId', type: 'int'}
    ],
    validations: [
        {type: 'presence', field: 'paymentDate'},
        {type: 'presence', field: 'bic'}
    ]
});