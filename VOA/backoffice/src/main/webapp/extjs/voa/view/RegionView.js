/**
 * @author Andrey Popov creates on 11.05.11 (17:12)
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'extjs/core/ext',
        'voa': 'extjs/voa'
    }
});

Ext.require([
    'Ext.grid.Panel',
    'Ext.grid.RowNumberer',
    'voa.store.RegionStore'
]);

Ext.onReady(function() {
    var grid = Ext.create('Ext.grid.Panel', {
        store: new RegionStore().load(),
        columns: [
            new Ext.grid.RowNumberer({
                text: '#'
            }),
            {
                text     : 'Id',
                sortable : false,
                dataIndex: 'regionID'
            },
            {
                text     : 'Регион',
                sortable : true,
                flex     : 1,
                dataIndex: 'regionName'
            }
        ],
        layout: 'fit',
        height: 600,
        title: 'Region Grid',
        renderTo: Ext.getBody(),
        viewConfig: {
            stripeRows: true
        }
    });
});
