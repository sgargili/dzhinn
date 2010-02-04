dojo.require("dojo.parser");
dojo.require("dijit.TitlePane");
dojo.require("dijit.form.CheckBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.Dialog");
dojo.require("dijit.form.FilteringSelect");
dojo.require("dojo.data.ItemFileReadStore");

function Show(ID){
    dojo.byId(ID).style.height = "0px";
    var w1 = dojo.fx.wipeIn({
        node: ID,
        duration: 500
    });
    var f1 = dojo.fadeOut({
        node: ID,
        duration: 500
    });
    var a1 = dojo.fx.chain([w1, f1]);

    dojo.byId(ID).style.height = "0px";
    var w2 = dojo.fx.wipeIn({
        node: ID,
        duration: 500
    });
    var f2 = dojo.fadeIn({
        node: ID,
        duration: 1000
    });
    var a2 = dojo.fx.combine([w2, f2]);

    dojo.connect(a1, "onEnd", function(){
        a2.play();
    });
    dojo.connect(a2, "onEnd", function(){
        });
    a1.play();
};

function Hide(id){
    dojo.byId(id).style.height = "0px";
    var w = dojo.fx.wipeIn({
        node: id,
        duration: 100
    });
    var f = dojo.fadeOut({
        node: id,
        duration: 1000
    });
    var a = dojo.fx.chain([w, f]);

    dojo.byId(id).style.height = "0px";
    var w3 = dojo.fx.wipeIn({
        node: id,
        duration: 100
    });
    var f3 = dojo.fadeIn({
        node: id,
        duration: 1000
    });
    var a3 = dojo.fx.combine([w3, f3]);

    dojo.connect(a3, "onEnd", function(){
        a.play();
    });
    dojo.connect(a, "onEnd", function(){
        });
    a3.play();
};

function UploadeCsv(){
    var fileName = dojo.byId('uploadFileeCsv').value;
    var checkSeparator = dojo.byId('eCsvSeparator').checked;
    var checkZip = dojo.byId('eCsvZip').checked;
    var file = dwr.util.getValue('uploadFileeCsv');
    var encoding = dojo.byId('eCsvEncoding').value;
    var engine = dojo.byId('eCsvEngine').value;

    dojo.byId('it4profitCsvLoadingProcess').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    CsvProcessing.convertXLSCSV(file, fileName, encoding, checkSeparator, checkZip, engine, function(data) {
        dwr.engine.openInDownload(data);
        dojo.byId('it4profitCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и xls.");
        }
    });
}

function FixProfitCsv(){
    var fileName = dojo.byId('uploadit4profitCsv').value;
    var file = dwr.util.getValue('uploadit4profitCsv');
    dojo.byId('it4profitCsvLoadingProcess').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    CsvProcessing.fixItprofitFile(file, fileName, function(data) {
        dwr.engine.openInDownload(data);
        dojo.byId('it4profitCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и zip.");
        }
    });
}

function UpdateManPT(){
    dojo.byId('Test').innerHTML = "Loading...";
    UploadDownload.createUpdateManPt(function(data) {
        dojo.byId('Test').innerHTML = data;
        alert(data);
    });
}
function Watch_All_PT_Nix(){
    dojo.byId('TablenixPT_Out').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    Nix.getAllPT(function(data) {
        dojo.byId('TablenixPT_Out').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}
function ShowYandexFile(){
    if(dojo.byId("yandexType").value =="Загрузить из файла"){
        dojo.byId('tduploadYandexFile').style.display = "inline";
    } else{
        dojo.byId('tduploadYandexFile').style.display = "none";

    }
}

function exportByProduct(){
    dojo.byId('ulexpProdLog').innerHTML = "";
    var data = dojo.byId('Articles').value;
    var ruEnBool = dwr.util.getValue('ruEnOnly');
    Ajax.exportByProducts(data, ruEnBool, function(data) {
        dojo.byId('ulexpProdLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function exportMarketing(){
    dojo.byId('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = dojo.byId('ArticlesExpMark').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.exportMarketing(data, function(data) {
        dojo.byId('ulexpMarkLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function addLink(){
    dojo.byId('uladdLinkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = dojo.byId('ArticlesAddLink').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.addLink(data, function(data) {
        dojo.byId('uladdLinkLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function clearSession(){
    dojo.byId('uloptSesLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Show('uloptSesLog');
    Ajax.clearSession(function(data) {
        dojo.byId('uloptSesLog').innerHTML = data;
        Hide('uloptSesLog');
    });

}

function clearCache(){
    dojo.byId('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearCache(function(data) {
        dojo.byId('ulexpProdLog').innerHTML = data;
    });
}

function clearCacheMark(){
    dojo.byId('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearCache(function(data) {
        dojo.byId('ulexpMarkLog').innerHTML = data;
    });
}

function changeStatus(){
    dojo.byId('ulstatusChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var status = "";
    var data = dojo.byId('ArticlesStatusChange').value;
    var rBool = dojo.byId('statusOne').checked;
    var cBool = dojo.byId('statusTwo').checked;
    var dBool = dojo.byId('statusThree').checked;
    if(rBool){
        status = dojo.byId('statusOne').value;
    }
    if(cBool){
        status = dojo.byId('statusTwo').value;
    }
    if(dBool){
        status = dojo.byId('statusThree').value;
    }
    Ajax.changeStatus(data, status, function(data) {
        dojo.byId('ulstatusChangeLog').innerHTML = data;
    });

}
function changeOwner(){
    dojo.byId('ulownerChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var owner = dijit.byId('owner').attr('value');
    var data = dojo.byId('ArticlesOwnerChange').value;
    Ajax.changeOwner(data, owner, function(data) {
        dojo.byId('ulownerChangeLog').innerHTML = data;
    });
}

function showStatistics(){
    window.open("https://cf.value4it.com/cf/export/stat.jsp","", config="");
}
function sendMessage() { 
    if(dwr.util.getValue("nick_id")==""||dwr.util.getValue("nick_id")=="Введите ник..."||dwr.util.getValue("nick_id")=="60511120540229999"){
        alert("Введите ник...");
        return;
    }
    Ajax.addMessage(dwr.util.getValue("nick_id") + ": " + dwr.util.getValue("text"), function(data) {
        dojo.byId("text").value = "";
    });
//dojo.byId("text").value="";
}
function updateMessage() {
    Ajax.updateMessage();
}

var start = {
    id: 'start-panel',
    title: 'Стартовая страница',
    layout: 'fit',
    //	bodyStyle: 'padding:25px',
    contentEl: 'start-div'
};

var value4export = {

    xtype: 'tabpanel',
    id: 'vExp-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Экспорт по продукту',
        //contentEl: 'expByProd',
        autoScroll: true,
        items:[{
            title: 'Экспорт',
            contentEl: 'expByProdInput',
            autoScroll: true
        },{
            bodyStyle: 'padding:0px; border: 0',
            html: '<div id="brId" style="background-color: #e1e8ff"><br/></div>'
        },{
            title: 'Логи сервера',
            contentEl: 'expProdLogs',
            autoScroll: true
        }]
    },{
        title: 'Экспорт маркетинга',
        //contentEl: 'expMark',
        autoScroll: true,
        items:[{
            title: 'Экспорт маркетинга',
            contentEl: 'expMarkInput',
            autoScroll: true
        },{
            bodyStyle: 'padding:0px; border: 0',
            html: '<div id="brId" style="background-color: #e1e8ff"><br/></div>'
        },{
            title: 'Логи сервера',
            contentEl: 'expMarkLogs',
            autoScroll: true
        }]
    }]
};
var echat = {

    xtype: 'tabpanel',
    id: 'eChat-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Типа чат...',
        contentEl: 'chat_id',
        autoScroll: true
    }]
};
var value4ovnerstatus = {

    xtype: 'tabpanel',
    id: 'vStat-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Смена автора',
        contentEl: 'ownerChange',
        autoScroll: true
    },{
        title: 'Смена статуса',
        contentEl: 'statusChange',
        autoScroll: true
    }
    ]
};

var value4link = {

    xtype: 'tabpanel',
    id: 'vLink-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Добавление ссылок',
        contentEl: 'addLink',
        autoScroll: true
    }
    //    ,{
    //        title: 'Смена статуса',
    //        contentEl: 'statusChange',
    //        autoScroll: true
    //    }
    ]
};
var osession = {

    xtype: 'tabpanel',
    id: 'oSes-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Сброс сессии',
        contentEl: 'optSes',
        autoScroll: true
    }
    //    ,{
    //        title: 'Смена статуса',
    //        contentEl: 'statusChange',
    //        autoScroll: true
    //    }
    ]
};
var ecsv = {
    id: 'eCsv-panel',
    title: 'Преобразование файла из форматов XLS и CSV(Excel) в нормальный CSV!',
    layout: 'fit',
    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
    //	bodyStyle: 'padding:25px',
    contentEl: 'eCsv' // pull existing content from the page

};
function update(allCount, count){
    if(count==1){
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
Ext.onReady(function(){
    Ext.get('products_importByArticle_button').on('click', function(){
        Ext.MessageBox.buttonText.yes = "ага";
        Ext.MessageBox.buttonText.no = "нах";
        Ext.Msg.show({
            title:'Подтверждение!',
            msg: 'Запустить ЭКСПОРТ продуктов?',
            buttons: Ext.Msg.YESNO,
            fn: function(btn){
                if (btn == 'yes'){
                    exportByProduct()();
                }
            },
            icon: Ext.MessageBox.QUESTION
        });
    });
    updateMessage();
    Ext.QuickTips.init();
    var detailEl;
    var contentPanel = {
        id: 'content-panel',
        region: 'center', // this is what makes this panel into a region within the containing layout
        layout: 'card',
        margins: '2 5 5 0',
        activeItem: 0,
        border: false,
        items: [
        // start,
        value4export,
        echat,
        value4ovnerstatus,
        value4link,
        osession,
        ecsv
        ]
    };
    var treePanel = new Ext.tree.TreePanel({
        id: 'tree-panel',
        title: 'Меню',
        region:'north',
        split: true,
        height: 300,
        width: 150,
        minSize: 300,
        autoScroll: true,
        rootVisible: false,
        lines: false,
        singleExpand: false,
        useArrows: true,
        animCollapse: true,
        listeners: {
            click: function(n) {
                if(!n.leaf){
                    if(!n.expanded){
                        n.expand(n.getPath);
                    } else{
                        n.collapse(true);
                    }
                }
            }
        },
        loader: new Ext.tree.TreeLoader({
            dataUrl:'data/tree-data-new.json'
        }),
        root: new Ext.tree.AsyncTreeNode()
    });
    treePanel.expandAll();
    //treePanel.animate(false);
    treePanel.on('click', function(n){
        var sn = this.selModel.selNode || {}; // selNode is null on initial selection
        if(n.leaf && n.id != sn.id){  // ignore clicks on folders and currently selected node
            Ext.getCmp('content-panel').layout.setActiveItem(n.id + '-panel');
            if(!detailEl){
                var bd = Ext.getCmp('details-panel').body;
                bd.update('').setStyle('background','#fff');
                detailEl = bd.createChild(); //create default empty div
            }
            detailEl.hide().update(Ext.getDom(n.id+'-details').innerHTML).slideIn('l', {
                stopFx:true,
                duration:.2
            });
        }
    });

    var detailsPanel = {
        id: 'details-panel',
        title: 'Инфо',
        region: 'center',
        bodyStyle: 'padding-bottom:15px;background:#eee;',
        autoScroll: true,
        height: 400,
        width: 150,
        html: '<p class="details-info">Выберите нужную функцию...</p>'
    };

    var panel1 = new Ext.Panel({
        title: 'Panel 1',
        html: 'Width = container width\' - 50 px',
        // Width = container width' - 50 px.
        anchor: '-50'
    });

    new Ext.Viewport({
        layout: 'border',
        title: 'Ext Layout Browser',
        items: [{
            xtype: 'box',
            region: 'north',
            applyTo: 'header',
            height: 30
        },{
            layout: 'border',
            id: 'layout-browser',
            region:'west',
            border: false,
            split:true,
            margins: '0 0 0 0',
            width: 250,
            minSize: 100,
            maxSize: 500,
            items: [treePanel, detailsPanel]
        },
        contentPanel
        ],
        renderTo: Ext.getBody()
    });
    pbar = new Ext.ProgressBar({
        text:'Ready',
        id:'pbar',
        cls:'center-align',
        renderTo:'pbarId'
    });
    pbar.hide();
});