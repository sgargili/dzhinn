Ext.define('voa.view.Cars', {
    extend: 'Ext.grid.Panel',
    alias : 'widget.cars',

    title : 'All Cars',
    store: 'Cars',

    columns: [
        {header: 'id',  dataIndex: 'id'},
        {header: 'originDate', dataIndex: 'originDate', flex:1},
        {header: 'registrationNumber', dataIndex: 'registrationNumber'}
    ]
});
