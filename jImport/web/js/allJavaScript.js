//dojo.require("dojo.parser");
//dojo.require("dijit.TitlePane");
//dojo.require("dijit.form.CheckBox");
//dojo.require("dijit.form.Button");
//dojo.require("dijit.Dialog");
//dojo.require("dijit.form.FilteringSelect");
//dojo.require("dojo.data.ItemFileReadStore");
//
//function Show(ID){
//    Ext.get(ID).style.height = "0px";
//    var w1 = dojo.fx.wipeIn({
//        node: ID,
//        duration: 500
//    });
//    var f1 = dojo.fadeOut({
//        node: ID,
//        duration: 500
//    });
//    var a1 = dojo.fx.chain([w1, f1]);
//
//    Ext.get(ID).style.height = "0px";
//    var w2 = dojo.fx.wipeIn({
//        node: ID,
//        duration: 500
//    });
//    var f2 = dojo.fadeIn({
//        node: ID,
//        duration: 1000
//    });
//    var a2 = dojo.fx.combine([w2, f2]);
//
//    dojo.connect(a1, "onEnd", function(){
//        a2.play();
//    });
//    dojo.connect(a2, "onEnd", function(){
//        });
//    a1.play();
//};
//
//function Hide(id){
//    Ext.get(id).style.height = "0px";
//    var w = dojo.fx.wipeIn({
//        node: id,
//        duration: 100
//    });
//    var f = dojo.fadeOut({
//        node: id,
//        duration: 1000
//    });
//    var a = dojo.fx.chain([w, f]);
//
//    Ext.get(id).style.height = "0px";
//    var w3 = dojo.fx.wipeIn({
//        node: id,
//        duration: 100
//    });
//    var f3 = dojo.fadeIn({
//        node: id,
//        duration: 1000
//    });
//    var a3 = dojo.fx.combine([w3, f3]);
//
//    dojo.connect(a3, "onEnd", function(){
//        a.play();
//    });
//    dojo.connect(a, "onEnd", function(){
//        });
//    a3.play();
//};

function UploadeCsv(){
    var fileName = Ext.get('uploadFileeCsv').value;
    var checkSeparator = Ext.get('eCsvSeparator').checked;
    var checkZip = Ext.get('eCsvZip').checked;
    var file = dwr.util.getValue('uploadFileeCsv');
    var encoding = Ext.get('eCsvEncoding').value;
    var engine = Ext.get('eCsvEngine').value;

    Ext.get('it4profitCsvLoadingProcess').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    CsvProcessing.convertXLSCSV(file, fileName, encoding, checkSeparator, checkZip, engine, function(data) {
        dwr.engine.openInDownload(data);
        Ext.get('it4profitCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и xls.");
        }
    });
}

function FixProfitCsv(){
    var fileName = Ext.get('uploadit4profitCsv').value;
    var file = dwr.util.getValue('uploadit4profitCsv');
    Ext.get('it4profitCsvLoadingProcess').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    CsvProcessing.fixItprofitFile(file, fileName, function(data) {
        dwr.engine.openInDownload(data);
        Ext.get('it4profitCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и zip.");
        }
    });
}

function UpdateManPT(){
    Ext.get('Test').innerHTML = "Loading...";
    UploadDownload.createUpdateManPt(function(data) {
        Ext.get('Test').innerHTML = data;
        alert(data);
    });
}
function Watch_All_PT_Nix(){
    Ext.get('TablenixPT_Out').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    Nix.getAllPT(function(data) {
        Ext.get('TablenixPT_Out').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}
function ShowYandexFile(){
    if(Ext.get("yandexType").value =="Загрузить из файла"){
        Ext.get('tduploadYandexFile').style.display = "inline";
    } else{
        Ext.get('tduploadYandexFile').style.display = "none";

    }
}

function exportByProduct(){
    Ext.get('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = Ext.get('Articles').value;
    var ruEnBool = dwr.util.getValue('ruEnOnly');
    Ajax.exportByProducts(data, ruEnBool, function(data) {
        Ext.get('ulexpProdLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function exportMarketing(){
    Ext.get('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = Ext.get('ArticlesExpMark').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.exportMarketing(data, function(data) {
        Ext.get('ulexpMarkLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function addLink(){
    Ext.get('uladdLinkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = Ext.get('ArticlesAddLink').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.addLink(data, function(data) {
        Ext.get('uladdLinkLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function clearSession(){
    Ext.get('uloptSesLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Show('uloptSesLog');
    Ajax.clearSession(function(data) {
        Ext.get('uloptSesLog').innerHTML = data;
        Hide('uloptSesLog');
    });

}

function clearCache(){
    Ext.get('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearCache(function(data) {
        Ext.get('ulexpProdLog').innerHTML = data;
    });
}

function clearCacheMark(){
    Ext.get('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearCache(function(data) {
        Ext.get('ulexpMarkLog').innerHTML = data;
    });
}

function changeStatus(){
    Ext.get('ulstatusChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var status = "";
    var data = Ext.get('ArticlesStatusChange').value;
    var rBool = Ext.get('statusOne').checked;
    var cBool = Ext.get('statusTwo').checked;
    var dBool = Ext.get('statusThree').checked;
    if(rBool){
        status = Ext.get('statusOne').value;
    }
    if(cBool){
        status = Ext.get('statusTwo').value;
    }
    if(dBool){
        status = Ext.get('statusThree').value;
    }
    Ajax.changeStatus(data, status, function(data) {
        Ext.get('ulstatusChangeLog').innerHTML = data;
    });

}
function changeOwner(){
    Ext.get('ulownerChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var owner = dijit.byId('owner').attr('value');
    var data = Ext.get('ArticlesOwnerChange').value;
    Ajax.changeOwner(data, owner, function(data) {
        Ext.get('ulownerChangeLog').innerHTML = data;
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
    Ajax.addMessage(dwr.util.getValue("nick_id") + ": " + dwr.util.getValue("text"));
    //jQuery("#chat_id_log").html("ddd");
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
        contentEl: 'expByProd',
        autoScroll: true
    },{
        title: 'Экспорт маркетинга',
        contentEl: 'expMark',
        autoScroll: true
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

Ext.onReady(function(){
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
        height: 200,
        width: 150,
        minSize: 200,
        autoScroll: true,
        rootVisible: false,
        lines: false,
        singleExpand: true,
        useArrows: true,

        loader: new Ext.tree.TreeLoader({
            dataUrl:'data/tree-data-new.json'
        }),

        root: new Ext.tree.AsyncTreeNode()
    });
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
});

