//dojo.require("dojo.parser");
//dojo.require("dijit.TitlePane");
//dojo.require("dijit.form.CheckBox");
//dojo.require("dijit.form.Button");
//dojo.require("dijit.Dialog");
//dojo.require("dijit.form.FilteringSelect");
//dojo.require("dojo.data.ItemFileReadStore");

function byId(id){
    return dwr.util.byId(id);
}

var butt = {
    xtype: 'buttongroup',
    rowspan: 3,
    columns: 3,
    items: [{
        text: '<<<Запуск>>>'
    },{
        text: '<<<Почистить кэш>>>'
    },{
        text: '<<<Статистика>>>'
    }]
///,
//    renderTo:'tableTT'
};

function UploadeCsv(){
    var fileName = byId('uploadFileeCsv').value;
    var checkSeparator = byId('eCsvSeparator').checked;
    var checkZip = byId('eCsvZip').checked;
    var file = dwr.util.getValue('uploadFileeCsv');
    var encoding = byId('eCsvEncoding').value;
    var engine = byId('eCsvEngine').value;

    byId('it4profitCsvLoadingProcess').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    CsvProcessing.convertXLSCSV(file, fileName, encoding, checkSeparator, checkZip, engine, function(data) {
        dwr.engine.openInDownload(data);
        byId('it4profitCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и xls.");
        }
    });
}

function FixProfitCsv(){
    var fileName = byId('uploadit4profitCsv').value;
    var file = dwr.util.getValue('uploadit4profitCsv');
    byId('it4profitCsvLoadingProcess').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    CsvProcessing.fixItprofitFile(file, fileName, function(data) {
        dwr.engine.openInDownload(data);
        byId('it4profitCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и zip.");
        }
    });
}

function UpdateManPT(){
    byId('Test').innerHTML = "Loading...";
    UploadDownload.createUpdateManPt(function(data) {
        byId('Test').innerHTML = data;
        alert(data);
    });
}
function Watch_All_PT_Nix(){
    byId('TablenixPT_Out').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    Nix.getAllPT(function(data) {
        byId('TablenixPT_Out').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}
function ShowYandexFile(){
    if(byId("yandexType").value =="Загрузить из файла"){
        byId('tduploadYandexFile').style.display = "inline";
    } else{
        byId('tduploadYandexFile').style.display = "none";

    }
}

function exportByProduct(data, ruEnBool, btn){
    //alert(byId('Articles').value);
    //byId('products_importByArticle_button').disabled = true;
    //byId('products_importByArticle_button').disabled = true;
    btn.disable();
    byId('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    //var data =  Ext.get('Articles').getValue();
    //var ruEnBool = dwr.util.getValue('ruEnOnly');
    Ajax.exportByProducts(data, ruEnBool, function(data) {
        //byId('products_importByArticle_button').disabled = false;
        //byId('products_importByArticle_button').disabled = false;
        byId('ulexpProdLog').innerHTML = data;
        btn.enable();
    });
}

function exportMarketing(){
    byId('products_importMark_button').disabled = true;
    byId('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = byId('ArticlesExpMark').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.exportMarketing(data, function(data) {
        byId('products_importMark_button').disabled = false;
        byId('ulexpMarkLog').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function addLink(){
    byId('addLink_button').disabled = true;
    byId('uladdLinkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var data = byId('ArticlesAddLink').value;
    //var ruEnBool = dwr.util.getValue('ruEnOnlyExpMark');
    Ajax.addLink(data, function(data) {
        byId('uladdLinkLog').innerHTML = data;
        byId('addLink_button').disabled = false;
    //        Show("AllDialog_Suppliers_Out");
    });
}

function clearSession(){
    byId('uloptSesLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Show('uloptSesLog');
    Ajax.clearSession(function(data) {
        byId('uloptSesLog').innerHTML = data;
        Hide('uloptSesLog');
    });

}

function clearCache(){
    byId('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearCache(function(data) {
        byId('ulexpProdLog').innerHTML = data;
    });
}

function clearCacheMark(){
    byId('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearCache(function(data) {
        byId('ulexpMarkLog').innerHTML = data;
    });
}

function changeStatus(){
    byId('statusChange_button').disabled = true;
    byId('ulstatusChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var status = "";
    var data = byId('ArticlesStatusChange').value;
    var rBool = byId('statusOne').checked;
    var cBool = byId('statusTwo').checked;
    var dBool = byId('statusThree').checked;
    if(rBool){
        status = byId('statusOne').value;
    }
    if(cBool){
        status = byId('statusTwo').value;
    }
    if(dBool){
        status = byId('statusThree').value;
    }
    Ajax.changeStatus(data, status, function(data) {
        byId('ulstatusChangeLog').innerHTML = data;
        byId('statusChange_button').disabled = false;

    });

}
function changeOwner(){
    byId('ownerChange_button').disabled = true;
    byId('ulownerChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    var owner = byId('owner').attr('value');
    var data = byId('ArticlesOwnerChange').value;
    Ajax.changeOwner(data, owner, function(data) {
        byId('ulownerChangeLog').innerHTML = data;
        byId('ownerChange_button').disabled = false;
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
        byId("text").value = "";
    });
//byId("text").value="";
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
            //contentEl: 'expByProdInput',
            autoScroll: true,
            defaults: {
                bodyStyle: 'background-color:#e1e8ff;'
            },
            items: [{
                layout:'column',
                width: '100%',
                height: '100%',
                bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                buttonAlign: 'center',
                items:[{
                    bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                    items: [{
                        xtype: 'textarea',
                        fieldLabel: 'Message text',
                        width: 350,
                        height: 150,
                        hideLabel: true,
                        bodyStyle: 'padding:12px; border:0; background-color:#E1E1E1;',
                        name: 'msg',
                        flex: 1,
                        id:'dsdsds'
                    }]
                },{
                    columnWidth:.5,
                    style: {
                        margin: '70px auto'
                    },
                    bodyStyle: 'border:0px; background-color:#E1E1E1;',
                    //layout:'column',
                    items:[{
                        //                        xtype: 'buttongroup',
                        xtype: 'button',
                        //                        rowspan: 3,
                        //                        columns: 3,
                        //                        bodyStyle: 'border:0px; background-color:#E1E1E1;',
                        //                        items: [{
                        id:'toogleBtn',
                        text: 'ru/en language only...',
                        style: {
                            //marginBottom: '10px'
                            marginLeft: '97px',
                            marginBottom: '10px'
                        },
                        enableToggle: true
                    //                        }]
                    },{
                        xtype: 'buttongroup',
                        rowspan: 3,
                        columns: 3,
                        bodyStyle: 'border:0px; background-color:#E1E1E1;',
                        items: [{
                            text: '<<<Запуск>>>',
                            id:'expProdBtn',
                            style: {
                                marginRight: '10px'
                            },
                            listeners: {
                                click: function(n) {
                                    Ext.MessageBox.buttonText.yes = "ага";
                                    Ext.MessageBox.buttonText.no = "нах";
                                    Ext.Msg.show({
                                        title:'Подтверждение!',
                                        msg: 'Запустить ЭКСПОРТ продуктов?',
                                        buttons: Ext.Msg.YESNO,
                                        fn: function(btn){
                                            if (btn == 'yes'){
                                                //Ext.getCmp('expProdBtn').disable();
                                                if(Ext.getCmp('toogleBtn').pressed){
                                                    exportByProduct(Ext.getCmp('dsdsds').getValue(), true, Ext.getCmp('expProdBtn'));
                                                } else{
                                                    exportByProduct(Ext.getCmp('dsdsds').getValue(), false, Ext.getCmp('expProdBtn'));
                                                }
                                                //Ext.getCmp('expProdBtn').enable();
                                            }
                                        },
                                        icon: Ext.MessageBox.QUESTION
                                    });
                                }
                            }
                        },{
                            text: '<<<Почистить кэш>>>',
                            id:'clearChBtn',
                            style: {
                                marginRight: '10px'
                            }
                        },{
                            text: '<<<Статистика>>>',
                            id:'statBtn'
                        }]
                    }]
                }]
            }]
        },{
            items: {
                id: 'pbarProd',
                xtype: 'progress',
                text:'Ready',
                animate:true,
                style: {
                    width:'100%',
                    margin: '0px auto',
                    border:'0px'
                }
            }
        },{
            title: 'Логи сервера',
            contentEl: 'expProdLogs',
            autoScroll: true
        //            items: {
        //                        id: 'but',
        //                        xtype: 'button',
        //                        text:'<<<Запуск>>>'
        //            }
        }
        //        ,butt
        ]
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

//var buttonsExp = {
//    xtype: 'buttongroup',
//    columns: 3,
//    title: 'Clipboard',
//    items: [{
//        text: 'Paste',
//        scale: 'large',
//        rowspan: 3,
//        iconCls: 'add',
//        iconAlign: 'top',
//        cls: 'x-btn-as-arrow'
//    },{
//        xtype:'splitbutton',
//        text: 'Menu Button',
//        scale: 'large',
//        rowspan: 3,
//        iconCls: 'add',
//        iconAlign: 'top',
//        arrowAlign:'bottom',
//        menu: [{
//            text: 'Menu Item 1'
//        }]
//    },{
//        xtype:'splitbutton',
//        text: 'Cut',
//        iconCls: 'add16',
//        menu: [{
//            text: 'Cut Menu Item'
//        }]
//    },{
//        text: 'Copy',
//        iconCls: 'add16'
//    },{
//        text: 'Format',
//        iconCls: 'add16'
//    }]
//
//};

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
    //        //byId('products_importByArticle_button').disabled = true;
    //        Ext.getCmp('pbarProd').setDisabled(false);
    //       // Ext.getCmp('pbarProd').setStyle("text-align", "left");
    //    }
    RunnerProd.run(Ext.getCmp('pbarProd'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            // byId('products_importByArticle_button').disabled = false;
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
    //        //byId('products_importMark_button').disabled = true;
    //        Ext.getCmp('pbarMark').setDisabled(false);
    //    }
    RunnerMar.run(Ext.getCmp('pbarMark'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            //byId('products_importMark_button').disabled = false;
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
    //        //byId('statusChange_button').disabled = true;
    //        Ext.getCmp('pbarStat').setDisabled(false);
    //    }
    RunnerStat.run(Ext.getCmp('pbarStat'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            // byId('statusChange_button').disabled = false;
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
    //        //byId('ownerChange_button').disabled = true;
    //        Ext.getCmp('pbarOwn').setDisabled(false);
    //    }
    RunnerOwn.run(Ext.getCmp('pbarOwn'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            // byId('ownerChange_button').disabled = false;
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
    //        //        byId('addLink_button').disabled = true;
    //        Ext.getCmp('pbarLink').setDisabled(false);
    //    }
    RunnerLink.run(Ext.getCmp('pbarLink'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            //byId('addLink_button').disabled = false;
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

    //    var p = new Ext.Panel({
    //        renderTo: 'tableTT',
    //            items:{
    //                xtype: 'buttongroup',
    //                rowspan: 3,
    //                columns: 3,
    //                items: [{
    //                    text: '<<<Запуск>>>'
    //                }]
    //            }
    //    });


    //var top = new Ext.FormPanel({
    //        labelAlign: 'top',
    //        frame:true,
    //        title: 'Multi Column, Nested Layouts and Anchoring',
    //        bodyStyle:'padding:5px 5px 0',
    //        width: 600,
    //        items: [{
    //            layout:'column',
    //            items:[{
    //                columnWidth:.5,
    //                layout: 'form',
    //                items: [{
    //                    xtype:'textfield',
    //                    fieldLabel: 'First Name',
    //                    name: 'first',
    //                    anchor:'95%'
    //                }, {
    //                    xtype:'textfield',
    //                    fieldLabel: 'Company',
    //                    name: 'company',
    //                    anchor:'95%'
    //                }]
    //            },{
    //                columnWidth:.5,
    //                layout: 'form',
    //                items: [{
    //                    xtype:'textfield',
    //                    fieldLabel: 'Last Name',
    //                    name: 'last',
    //                    anchor:'95%'
    //                },{
    //                    xtype:'textfield',
    //                    fieldLabel: 'Email',
    //                    name: 'email',
    //                    vtype:'email',
    //                    anchor:'95%'
    //                }]
    //            }]
    //        },{
    //            xtype:'htmleditor',
    //            id:'bio',
    //            fieldLabel:'Biography',
    //            height:200,
    //            anchor:'98%'
    //        }],
    //
    //        buttons: [{
    //            text: 'Save'
    //        },{
    //            text: 'Cancel'
    //        }]
    //    });
    //
    //    top.render("tableTT");



    //    Ext.get('products_importByArticle_button').on('click', function(){
    //        Ext.MessageBox.buttonText.yes = "ага";
    //        Ext.MessageBox.buttonText.no = "нах";
    //        Ext.Msg.show({
    //            title:'Подтверждение!',
    //            msg: 'Запустить ЭКСПОРТ продуктов?',
    //            buttons: Ext.Msg.YESNO,
    //            fn: function(btn){
    //                if (btn == 'yes'){
    //                    exportByProduct();
    //                }
    //            },
    //            icon: Ext.MessageBox.QUESTION
    //        });
    //    });


    //    Ext.getCmp('expProdBtn').on('click', function(){
    //        alert();
    ////        Ext.MessageBox.buttonText.yes = "ага";
    ////        Ext.MessageBox.buttonText.no = "нах";
    ////        Ext.Msg.show({
    ////            title:'Подтверждение!',
    ////            msg: 'Запустить ЭКСПОРТ продуктов?',
    ////            buttons: Ext.Msg.YESNO,
    ////            fn: function(btn){
    ////                if (btn == 'yes'){
    ////                    exportByProduct();
    ////                }
    ////            },
    ////            icon: Ext.MessageBox.QUESTION
    ////        });
    //    });

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