/**
 * @author Andrey Popov creates on 11.05.11 (16:39)
 */
Ext.define('voa.model.MemberCard', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'cardNumber', type: 'string'},
        {name: 'cardStatus', type: 'string'},
        {name: 'joinDate', type: 'date'},
        {name: 'endDate', type: 'date'},
        {name: 'printPitchNumber', type: 'string'},
        {name: 'printSendDate', type: 'date'},
        {name: 'printReciveDate', type: 'date'},
        {name: 'regionSendDate', type: 'date'},
        {name: 'memberSendDate', type: 'date'},
        {name: 'memberReciveDate', type: 'date'},
        {name: 'membershipYear', type: 'string'}
    ],
    validations: [
        {type: 'presence', field: 'cardNumber'},
        {type: 'presence', field: 'cardStatus'}
    ]
});