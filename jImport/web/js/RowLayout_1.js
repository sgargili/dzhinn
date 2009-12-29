Ext.ns('Ext.ux.layout');
Ext.ux.layout.RowLayout = Ext.extend(Ext.layout.ContainerLayout, {
    // private
    monitorResize:true,
    isValidParent : function(c, target){
        return c.getEl().dom.parentNode == this.innerCt.dom;
    },
    onLayout : function(ct, target){
        var rs = ct.items.items, len = rs.length, r, i;

        if(!this.innerCt){
            target.addClass('ux-row-layout-ct');
            this.innerCt = target.createChild({
                cls:'x-row-inner'
            });
        }
        this.renderAll(ct, this.innerCt);

        var size = target.getViewSize();

        if(size.width < 1 && size.height < 1){ // display none?
            return;
        }

        var h = size.height - target.getPadding('tb'),
        ph = h;

        this.innerCt.setSize({
            height:h
        });

        for(i = 0; i < len; i++){
            r = rs[i];
            if(!r.rowHeight){
                ph -= (r.getSize().height + r.getEl().getMargins('tb'));
            }
        }

        ph = ph < 0 ? 0 : ph;

        for(i = 0; i < len; i++){
            r = rs[i];
            if(r.rowHeight){
                r.setSize({
                    height: Math.floor(r.rowHeight*ph) - r.getEl().getMargins('tb')
                });
            }
        }
    }
});

Ext.Container.LAYOUTS['ux.row'] = Ext.ux.layout.RowLayout;
