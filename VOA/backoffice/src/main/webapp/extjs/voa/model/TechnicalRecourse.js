/**
 * @author Andrey Popov creates on 11.05.11 (17:00)
 */
Ext.define('voa.model.TechnicalRecourse', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'memberId', type: 'int'},
        {name: 'phoneNumber', type: 'string'},
        {name: 'action', type: 'string'},
        {name: 'recourseDate', type: 'date'},
        {name: 'regionId', type: 'int'},
        {name: 'accidentPlace', type: 'string'},
        {name: 'comment', type: 'string'},
        {name: 'supportServiceId', type: 'int'}
    ]
});