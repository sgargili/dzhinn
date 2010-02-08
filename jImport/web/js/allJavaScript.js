dojo.require("dojo.parser");
dojo.require("dijit.TitlePane");
dojo.require("dijit.form.CheckBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.Dialog");
dojo.require("dijit.form.FilteringSelect");
dojo.require("dojo.data.ItemFileReadStore");


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
    dijit.byId('products_importByArticle_button').setAttribute("disabled", true);
    dojo.byId('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data =  Ext.get('Articles').getValue();
    var ruEnBool = dwr.util.getValue('ruEnOnly');
    Ajax.exportByProducts(data, ruEnBool, function(data) {
        dijit.byId('products_importByArticle_button').setAttribute("disabled", false);
        dojo.byId('ulexpProdLog').innerHTML = data;
    });
}

function exportMarketing(){
    dijit.byId('products_importMark_button').setAttribute("disabled", true);
    dojo.byId('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = dojo.byId('ArticlesExpMark').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.exportMarketing(data, function(data) {
        dijit.byId('products_importMark_button').setAttribute("disabled", false);
        dojo.byId('ulexpMarkLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function addLink(){
    dijit.byId('addLink_button').setAttribute("disabled", true);
    dojo.byId('uladdLinkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = dojo.byId('ArticlesAddLink').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.addLink(data, function(data) {
        dojo.byId('uladdLinkLog').innerHTML = data;
        dijit.byId('addLink_button').setAttribute("disabled", false);
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
    dijit.byId('statusChange_button').setAttribute("disabled", true);
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
        dijit.byId('statusChange_button').setAttribute("disabled", false);

    });

}
function changeOwner(){
    dijit.byId('ownerChange_button').setAttribute("disabled", true);
    dojo.byId('ulownerChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var owner = dijit.byId('owner').attr('value');
    var data = dojo.byId('ArticlesOwnerChange').value;
    Ajax.changeOwner(data, owner, function(data) {
        dojo.byId('ulownerChangeLog').innerHTML = data;
        dijit.byId('ownerChange_button').setAttribute("disabled", false);
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
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:1000px'
    },
    items:[{
        title: 'Экспорт по продукту',
        autoScroll: true,
        items:[{
            title: 'Экспорт',
            contentEl: 'expByProdInput',
            autoScroll: true 
        },{
            items: {
                id: 'pbarProd',
                xtype: 'progress',
                text:'Ready',
                animate:true,
                style: {
                    width:'100%',
                    //                    font: { text-decoration:underline
                    //                        name: 'Tahoma',
                    //                        color: 0x444444,
                    //                        size: 22
                    //                    },
//                                        text: {
//                                            align:'right',
//                                            decoration:'underline'
//                                        },
                    margin: '0px auto',
                    border:'0px'
                }
            }
        },{
            title: 'Логи сервера',
            contentEl: 'expProdLogs',
            autoScroll: true
        }]
    },{
        title: 'Экспорт маркетинга',
        autoScroll: true,
        items:[{
            title: 'Экспорт маркетинга',
            contentEl: 'expMarkInput',
            autoScroll: true
        },{
            items: {
                id: 'pbarMark',
                text:'Ready',
                xtype: 'progress',
                animate:true,
                style: {
                    width: '100%',
                   // textalign:'left',
                    margin: '0px auto',
                    border:'0px'
                }
            }
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
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:1000px;'
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
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:1000px;'
    },
    items:[{
        title: 'Смена автора',
        contentEl: 'ownerChange',
        autoScroll: true,
        items:[{
            title: 'Смена автора',
            contentEl: 'ownerChangeInput',
            autoScroll: true
        },{
            items: {
                id: 'pbarOwn',
                text:'Ready',
                xtype: 'progress',
                animate:true,
                style: {
                    width: '100%',
                    margin: '0px auto',
                    border:'0px'
                }
            }
        },{
            title: 'Логи сервера',
            contentEl: 'ownerChangeLogs',
            autoScroll: true
        }]
    },{
        title: 'Смена статуса',
        contentEl: 'statusChange',
        autoScroll: true,
        items:[{
            title: 'Смена статуса',
            contentEl: 'statusChangeInput',
            autoScroll: true
        },{
            items: {
                id: 'pbarStat',
                text:'Ready',
                xtype: 'progress',
                animate:true,
                style: {
                    width: '100%',
                    margin: '0px auto',
                    border:'0px'
                }
            }
        },{
            title: 'Логи сервера',
            contentEl: 'statusChangeLogs',
            autoScroll: true
        }]
    }
    ]
};

var value4link = {

    xtype: 'tabpanel',
    id: 'vLink-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:1000px;'
    },
    items:[{
        title: 'Добавление ссылок',
        contentEl: 'addLink',
        autoScroll: true,
        items:[{
            title: 'Добавление ссылок',
            contentEl: 'addLinkInput',
            autoScroll: true
        },{
            items: {
                id: 'pbarLink',
                text:'Ready',
                xtype: 'progress',
                animate:true,
                style: {
                    width: '100%',
                    margin: '0px auto',
                    border:'0px'
                }
            }
        },{
            title: 'Логи сервера',
            contentEl: 'addLinkLogs',
            autoScroll: true
        }]
    }]
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
       // contentEl: 'optSes',
        autoScroll: true,
        items:[{
            title: 'Сброс сессии',
            contentEl: 'optSesInput',
            autoScroll: true
        }]
    }]
};

var ecsv = {
    id: 'eCsv-panel',
    title: 'Преобразование файла из форматов XLS и CSV(Excel) в нормальный CSV!',
    layout: 'fit',
    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
    contentEl: 'eCsv'
};


function updateProd(allCount, count){
//    if(count==1){
//        // butProd.dom.disabled = true;
//        //dijit.byId('products_importByArticle_button').setAttribute("disabled", true);
//        Ext.getCmp('pbarProd').setDisabled(false);
//       // Ext.getCmp('pbarProd').setStyle("text-align", "left");
//    }
    RunnerProd.run(Ext.getCmp('pbarProd'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            // dijit.byId('products_importByArticle_button').setAttribute("disabled", false);
            Ext.getCmp('pbarProd').reset();
            Ext.getCmp('pbarProd').updateText("Ready to Export");
            //Ext.getCmp('pbarProd').setDisabled(true);
        }
    }, 500);
}
//Please do not use the following code as a best practice! :)
var RunnerProd = function(){
    return {
        run : function(pbarProd, allCount, count){
            pbarProd.updateProgress(count/allCount, 'Export ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateMark(allCount, count){
//    if(count==1){
//        //dijit.byId('products_importMark_button').setAttribute("disabled", true);
//        Ext.getCmp('pbarMark').setDisabled(false);
//    }
    RunnerMar.run(Ext.getCmp('pbarMark'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            //dijit.byId('products_importMark_button').setAttribute("disabled", false);
            Ext.getCmp('pbarMark').reset();
            Ext.getCmp('pbarMark').updateText("Ready to Export Marketing");
            //Ext.getCmp('pbarMark').setDisabled(true);
        }
    }, 500);
}
//Please do not use the following code as a best practice! :)
var RunnerMar = function(){
    return {
        run : function(pbarMar, allCount, count){
            pbarMar.updateProgress(count/allCount, 'Export Marketing ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateStat(allCount, count){
//    if(count==1){
//        //dijit.byId('statusChange_button').setAttribute("disabled", true);
//        Ext.getCmp('pbarStat').setDisabled(false);
//    }
    RunnerStat.run(Ext.getCmp('pbarStat'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            // dijit.byId('statusChange_button').setAttribute("disabled", false);
            Ext.getCmp('pbarStat').reset();
            Ext.getCmp('pbarStat').updateText("Ready to change Status");
           // Ext.getCmp('pbarStat').setDisabled(true);
        }
    }, 500);
}
//Please do not use the following code as a best practice! :)
var RunnerStat = function(){
    return {
        run : function(pbarStat, allCount, count){
            pbarStat.updateProgress(count/allCount, 'Change Status ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateOwn(allCount, count){
//    if(count==1){
//        //dijit.byId('ownerChange_button').setAttribute("disabled", true);
//        Ext.getCmp('pbarOwn').setDisabled(false);
//    }
    RunnerOwn.run(Ext.getCmp('pbarOwn'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            // dijit.byId('ownerChange_button').setAttribute("disabled", false);
            Ext.getCmp('pbarOwn').reset();
            Ext.getCmp('pbarOwn').updateText("Ready to change Owner");
           // Ext.getCmp('pbarOwn').setDisabled(true);
        }
    }, 500);
}
//Please do not use the following code as a best practice! :)
var RunnerOwn = function(){
    return {
        run : function(pbarOwn, allCount, count){
            pbarOwn.updateProgress(count/allCount, 'Change Owner ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateLink(allCount, count){
//    if(count==1){
//        //        dijit.byId('addLink_button').setAttribute("disabled", true);
//        Ext.getCmp('pbarLink').setDisabled(false);
//    }
    RunnerLink.run(Ext.getCmp('pbarLink'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            //dijit.byId('addLink_button').setAttribute("disabled", false);
            Ext.getCmp('pbarLink').reset();
            Ext.getCmp('pbarLink').updateText("Ready to add Link");
           // Ext.getCmp('pbarLink').setDisabled(true);
        }
    }, 500);
}
//Please do not use the following code as a best practice! :)
var RunnerLink = function(){
    return {
        run : function(pbarLink, allCount, count){
            pbarLink.updateProgress(count/allCount, 'Add Link ' + count + ' in '+allCount+'...');
        }
    }
}();

Ext.onReady(function(){

    updateMessage();

    Ext.QuickTips.init();
    
    Ext.get('products_importByArticle_button').on('click', function(){
        Ext.MessageBox.buttonText.yes = "ага";
        Ext.MessageBox.buttonText.no = "нах";
        Ext.Msg.show({
            title:'Подтверждение!',
            msg: 'Запустить ЭКСПОРТ продуктов?',
            buttons: Ext.Msg.YESNO,
            fn: function(btn){
                if (btn == 'yes'){
                    exportByProduct();
                }
            },
            icon: Ext.MessageBox.QUESTION
        });
    });

    var detailEl;

    var contentPanel = {
        id: 'content-panel',
        region: 'center', // this is what makes this panel into a region within the containing layout
        layout: 'card',
        margins: '2 5 5 0',
        activeItem: 0,
        border: false,
        width:'100%',
        items: [
        //start,
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
        html: '<p class="details-info"><b style="color:red">Для правильной работы прогресс-баров и чата в IE8 включите режим совместимости с IE7. (Значек с разорванной страничкой справа от адресной строки.)</b><br/><br/>Выберите нужную функцию...</p>'
    };

    //    var panel1 = new Ext.Panel({
    //        title: 'Panel 1',
    //        html: 'Width = container width\' - 50 px',
    //        // Width = container width' - 50 px.
    //        anchor: '-50'
    //    });

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