Ext.tree.JsonTreeLoader = function(config) {
    Ext.tree.JsonTreeLoader.superclass.constructor.call(this, config);
}

Ext.extend(Ext.tree.JsonTreeLoader, Ext.tree.TreeLoader, {
    rootNode: undefined,

    processResponse : function(response, node, callback, scope) {
        var json = response.responseText;
        try {
            var o = response.responseData || Ext.decode(json, true);
            //Функция перехода к новой ноду root...
            var getSubRoot = this.createAccessor(this.rootNode);
            //Переопределяем объект относительно нового root...
            o = getSubRoot(o);
            node.beginUpdate();
            for (var i = 0, len = o.length; i < len; i++) {
                var n = this.createNode(o[i]);
                if (n) {
                    node.appendChild(n);
                }
            }
            node.endUpdate();
            this.runCallback(callback, scope || node, [node]);
        } catch(e) {
            this.handleFailure(response);
        }
    },

    createAccessor : function() {
        var re = /[\[\.]/;
        return function(expr) {
            if (Ext.isEmpty(expr)) {
                return Ext.emptyFn;
            }
            if (Ext.isFunction(expr)) {
                return expr;
            }
            var i = String(expr).search(re);
//            alert(i);
            if (i >= 0) {
                return new Function('obj', 'return obj' + (i > 0 ? '.' : '') + expr);
            }
            return function(obj) {
                return obj[expr];
            };

        };
    }()
});
