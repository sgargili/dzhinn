
var pbar2;
var btn2;
Ext.onReady(function(){
    pbar2 = new Ext.ProgressBar({
        text:'Ready',
        id:'pbar2',
        cls:'left-align',
        renderTo:'p2'
    });
    pbar2.hide();
    btn2 = Ext.get('btn2');
    btn2.on('click', function(){
        Ajax.getCountAll(function(data) {
            Runner.run(pbar2, btn2, data);
        });
    });
});

function update(allCount, count){
    if(count==0){
        pbar2.show();
    }
    Runner.run(pbar2, btn2, allCount, count);
    if(allCount==count){
        pbar2.reset();
        pbar2.updateText("Ready");
        pbar2.hide();
    }
}
//Please do not use the following code as a best practice! :)
var Runner = function(){
    return {
        run : function(pbar, btn, allCount, count){
            pbar.updateProgress(count/allCount, 'Export ' + count + ' in '+allCount+'...');
        }
    }
}();

function setCount(){
    Ajax.test();
}