/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 11.02.11
 * Time: 12:50
 */

Ext.ux.SingleSelectCheckColumn = Ext.extend(Ext.ux.grid.CheckColumn, {
    //Ставим красивые картинки чекбоксов. :)
    renderer : function(v, p, record) {
        p.css += ' x-grid17-check-col-td';
        return String.format('<div class="x-grid17-check-col{0}">&#160;</div>', v ? '-on' : '');
    },

    //Переопределим метод работы с евентами...
    processEvent : function(name/*имя евента*/, e, grid, rowIndex, colIndex) {
        if (name == 'mousedown') {

            //Запомним индекс данных, ибо потом, в итераторе, достучаться до него черзе this не удастся...
            var dix = this.dataIndex;
            var record = grid.store.getAt(rowIndex);

            //Если селектор уже выбран, то вообще ничего не делаем...
            if (record.data[this.dataIndex] != true) {
                //А если не выбран, то выбираем его...
                record.set(this.dataIndex, !record.data[this.dataIndex]);
                //Итератор по всем строкам данной таблицы... Нужен для того, чтобы сбросить все остальные селекторы...
                grid.store.each(function(record, i) {
                    if (i != rowIndex) {
                        //Сбрасываем селектор если индекс строки отличается от индекса строки на селектор которой мы нажали...
                        record.set(dix, false);
                    }
                });
            }
        } else {
            return Ext.grid.ActionColumn.superclass.processEvent.apply(this, arguments);
        }
    }
});