/**
 * @author Andrey Popov creates on 11.05.11 (15:10)
 */
Ext.define('Voa.util.Message', {
    alternateClassName: 'Message',
    delay: 1000,

    constructor: function(delay) {
        if (delay) {
            this.delay = delay;
        }
        return this;
    },

    createBox: function(t, s) {
        return '<div class="msg"><h3>' + t + '</h3><p>' + s + '</p></div>';
    },

    show: function(title, format) {
        var msgCt;
        if (!msgCt) {
            msgCt = Ext.core.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
        }
        var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
        var m = Ext.core.DomHelper.append(msgCt, this.createBox(title, s), true);
        m.hide();
        m.slideIn('t').ghost("t", { delay: this.delay, remove: true});
    }
});