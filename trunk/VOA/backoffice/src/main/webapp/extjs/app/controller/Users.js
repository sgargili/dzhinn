/**
 * @author Andrey Popov creates on 05.05.11 (10:47)
 */
Ext.define('AM.controller.Users', {
    extend: 'Ext.app.Controller',
    stores: [
        'Users'
    ],
    models: ['User'],
    views: [
        'user.List',
        'user.Edit'
    ],
    init: function() {
        this.control({
            'userlist': {
                itemdblclick: this.editUser
            }
        });
    },

    editUser: function(grid, record) {
        console.debug('ddddddd');
        var edit = Ext.create('AM.view.user.Edit').show();

        view.down('form').loadRecord(record);
    }

});