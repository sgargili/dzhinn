/**
 * Developed by: Администратор
 * Date (time): 08.05.11 (0:39)
 */
Ext.define('voa.controller.Cars', {
            extend: 'Ext.app.Controller',
            stores: ['Cars'],
            models: ['Car'],
            views: [
                'PavWindow'
            ],

            /*refs: [
                {
                    ref: 'usersPanel',
                    selector: 'panel'
                }
            ],*/

            init: function() {
                this.control({
                            'viewport > pavwindow dataview': {
                                itemdblclick: this.carFunc
                            }/*,
                            'useredit button[action=save]': {
                                click: this.updateUser
                            }*/
                        });
            },

            carFunc: function(grid, record) {
                console.debug('Edit Car!');
            }
        });

