
var pbar2;
var btn2;
Ext.onReady(function(){
    pbar2 = new Ext.ProgressBar({
        text:'Ready',
        id:'pbar2',
        cls:'left-align',
        renderTo:'p2'
    });
    btn2 = Ext.get('btn2');
    btn2.on('click', function(){
        Ajax.getCountAll(function(data) {
            Runner.run(pbar2, btn2, data);
        });
    });
});

function update(allCount, count){
    //Ajax.getCountAll(function(data) {
    Runner.run(pbar2, btn2, allCount, count);
}
//);
//}
//Please do not use the following code as a best practice! :)
var Runner = function(){
    return {
        run : function(pbar, btn, allcount, count){
            btn.dom.disabled = true;
            dwr.engine.setAsync(false);
            //Ajax.getCount(function(data) {

            pbar.updateProgress(allcount/count, 'Export ' + count + ' in '+allcount+'...');
            //});
            //            pbar.reset();
            //            pbar.updateText('Ready');
            btn.dom.disabled = false;
        }
    }
}();

function getCount(){
    Ajax.getCount(function(data) {
        dwr.util.setValue("text",data);
    });
}
function setCount(){
    Ajax.test();
}