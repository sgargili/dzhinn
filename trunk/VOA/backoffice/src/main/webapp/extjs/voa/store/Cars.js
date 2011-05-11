/**
 * Developed by: Администратор
 * Date (time): 08.05.11 (0:37)
 */

Ext.define('voa.store.Cars', {
    extend: 'Ext.data.Store',
    model: 'voa.model.Car',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        api: {
            read: '../../rest/carById?id=3420'/*,
             update: 'data/updateUsers.json'*/
        },
        reader: {
            type: 'json'
        }
    }
});