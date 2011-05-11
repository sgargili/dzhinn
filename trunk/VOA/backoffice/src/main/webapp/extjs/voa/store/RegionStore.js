/**
 * @author Andrey Popov creates on 11.05.11 (16:59)
 */
Ext.define('voa.store.RegionStore', {
    extend: 'Ext.data.Store',
    requires: [
        'voa.model.Region'
    ],
    model: 'voa.model.Region',
    alternateClassName: 'RegionStore',
    sorters: [
        {
            property : 'regionID',
            direction: 'ASC'
        }
    ],
//    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            read: 'rest/regions'
        },
        reader: {
            type: 'json'
        }
    }
});
