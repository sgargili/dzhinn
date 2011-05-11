/**
 * @author Andrey Popov creates on 11.05.11 (18:19)
 */
Ext.Loader.setConfig({
    enabled: true,
    paths: {
        'Ext': 'extjs/core/ext',
        'Ext.ux.desktop': 'extjs/core/ext/desktop/js',
        'voa': 'extjs/voa'
    }
});

Ext.require('voa.view.VoaDesktop');

var voaDesktop;

Ext.onReady(function () {
    voaDesktop = new voa.view.VoaDesktop();
});