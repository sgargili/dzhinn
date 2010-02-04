
var pbar;
Ext.onReady(function(){
    pbar = new Ext.ProgressBar({
        text:'Ready',
        id:'pbar',
        cls:'left-align',
        renderTo:'pbarId'
    });
    pbar.hide();
});

function update(allCount, count){
    if(count==0){
        pbar.show();
    }
    Runner.run(pbar, allCount, count);
    if(allCount==count){
        pbar.reset();
        pbar.hide();
    }
}
//Please do not use the following code as a best practice! :)
var Runner = function(){
    return {
        run : function(pbar, allCount, count){
            pbar.updateProgress(count/allCount, 'Export ' + count + ' in '+allCount+'...');
        }
    }
}();

function setCount(){
    Ajax.test();
}