
/**
 *
 * @author APopov
 */

// Блок опрдеделений...

function byId(id){
    return Ext.getDom(id);
}

var tempValue="";
var superGroupe = "";
var xg = Ext.grid;
var fm = Ext.form;


// Блок хранилищ...

// Хранилища ПТ.
// Все ПТ.

var storePtsProxy = new Ext.data.HttpProxy({
    url:    'ProductType.exml',
    method: 'GET'
})

var storePts = new Ext.data.Store({
    proxy: storePtsProxy,
    //url: 'ProductType.exml',
    reader: new Ext.data.XmlReader({
        record: 'ProductType',
        id: 'Id'
    }, [
    {
        name: 'pt',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storePtsAll = new Ext.data.Store({
    url: 'ProductType.exml?all=1',
    reader: new Ext.data.XmlReader({
        record: 'ProductType',
        id: 'Id'
    }, [
    {
        name: 'pt',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

// Все переводы
var storePtsAlt = new Ext.data.Store({
    //url: 'data/Owners.xml',
    url: 'ProductType.exml',
    reader: new Ext.data.XmlReader({
        record: 'ProductType',
        id: 'Id'
    }, [
    {
        name: 'pt',
        mapping: 'altName'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storePtsNeed = new Ext.data.Store({
    //url: 'data/Owners.xml',
    url: 'ProductType.exml',
    reader: new Ext.data.XmlReader({
        record: 'ProductType',
        id: 'Id'
    }, [
    {
        name: 'pt',
        mapping: 'altName'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});







var ds = new Ext.data.ArrayStore({
    data: [[123,'One Hundred Twenty Three'],
    ['1', 'One'], ['2', 'Two'], ['3', 'Three'], ['4', 'Four'], ['5', 'Five'],
    ['6', 'Six'], ['7', 'Seven'], ['8', 'Eight'], ['9', 'Nine']],
    fields: ['value','text'],
    sortInfo: {
        field: 'value',
        direction: 'ASC'
    }
});




var chatForm = new Ext.form.FormPanel({
    style: {
        width:'100%',
        marginTop: '0px',
        marginBottom: '0px'
    },
    buttonAlign: 'right',
    layout:'column',
    items:[
    {
        html:'<h1>Ник:</h1>',
        style: {
            marginTop: '5px',
            marginRight: '7px'
        },
        bodyStyle: 'border: 0px'
    },
    {
        xtype: 'textfield',
        //html:'<h1>Ник:</h1>',
        //        fieldLabel: 'Ник',
        //        labelStyle: 'width:125px; font-weight:bold;',
        //        labelSeparator: '...',
        hideLabel: true,
        height:25,
        id:'chatNick',
        blankText:'Введите что-нибудь...',
        allowBlank:false,
        style: {
            marginTop: '3px'
        }

    },{
        xtype: 'textarea',
        //width: 700,
        height:170,
        autoScroll:true,
        //allowBlank:false,
        hideLabel: true,
        //blankText:'Введите сообщение...',
        id:'chatData',
        // allowBlank:false,
        enableKeyEvents:true,
        style: {
            width:'98.7%',
            marginTop: '3px',
            marginLeft: '3px',
            marginRight: '0px',
            marginBottom: '3px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
                }
            }
        }

    }
    //        ,{
    //            xtype: 'button',
    //            text: '<<Отправить>>>',
    //            style: {
    //                marginTop: '7px',
    //                align: 'center'
    //            },
    //            bodyStyle: 'align:center',
    //            listeners: {
    //                click: function() {
    //                    sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
    //                }
    //            }
    //        }

    ],

    buttons: [{
        text: 'Отправить',
        handler: function(){
            if(chatForm.getForm().isValid()){
                sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
            }
        }
    }]
});


var dialog = new Ext.ux.UploadDialog.Dialog({
    proxyDrag: false,
    resizable: false,
    draggable: false,
    url: 'database.php',
    base_params: {
        'task': 'ADDTEMPLATE'
    },
    permitted_extensions: ['jpg','jpe','jpeg','gif','png','htm','html','txt','zip','rar','css','xls','doc','rtf','pdf'],
    reset_on_hide: false,
    upload_single_file: false,
    allow_close_on_upload: false,
    title: 'Files for create new template',
    upload_autostart: false,
    post_var_name: 'template'
});

//var map = new Ext.KeyMap(Ext.getBody(), [
//{
//    key: 13,
//    ctrl:true,
//    fn: function(){
//        alert('Control + shift + tab was pressed.');
//    }
//}
//]);

var storeOwners = new Ext.data.Store({
    //url: 'data/Owners.xml',
    url: 'ValueUsers.exml',
    reader: new Ext.data.XmlReader({
        record: 'Owner',
        id: 'Id'
    }, [
    {
        name: 'owner',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});



var storeAtrsProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})


var storeAtrs = new Ext.data.Store({
    proxy: storeAtrsProxy,
    reader: new Ext.data.XmlReader({
        record: 'Attribute',
        id: 'Id'
    }, [
    {
        name: 'atr',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

function storeAtrsUpdate(id){
    storeAtrsProxy.setUrl("Attribute.exml?ptId="+id);
    storeAtrs.load();
}

var comboOwner = new Ext.form.ComboBox({
    store: storeOwners,
    displayField:'owner',
    valueField: 'id',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите автора...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200
});

var comboOwner2 = new Ext.form.ComboBox({
    store: storePts,
    hideLabel: true,
    displayField:'pt',
    valueField: 'id',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите PT...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        'select': function(){
            storeAtrsProxy.setUrl("Attribute.exml?ptId=" + comboOwner2.getValue());
            storeAtrs.clearData();
            storeAtrs.load();
        }
    }
});

var storeLanguages = new Ext.data.Store({
    url: 'data/Languages.xml',
    reader: new Ext.data.XmlReader({
        record: 'Language',
        id: 'Value'
    }, [
    {
        name: 'lang',
        mapping: 'Name'
    }, {
        name:'value',
        mapping:'Value'
    }
    ])
});

var storeLngs = new Ext.data.Store({
    //url: 'data/Owners.xml',
    url: 'Language.exml',
    reader: new Ext.data.XmlReader({
        record: 'Language',
        id: 'Name'
    }, [
    {
        name: 'name',
        mapping: 'Name'
    }, {
        name:'desc',
        mapping:'Description'
    }
    ])
});

var comboLanguages = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 250,
    height: 200,
    allowBlank:false,
    //autoScroll: true,
    displayField:'desc',
    valueField: 'name',
    minSelections:1,
    minSelectionsText:'Нужно выбрать хотя бы {1} язык!',
    blankText:'Выберите язык!',
    style:{
        marginBottom: '10px'
    },
    store: storeLngs,
    tbar:[{
        text: 'Default',
        handler: function(){
            comboLanguages.setValue('ru,en,bg,pl,hr,sl');
        }
    }
    //    ,{
    //        text:'Посмареть',
    //        handler: function(){
    //            if(comboLanguages.isValid()){
    //                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
    //                    comboLanguages.getValue());
    //            }
    //        }
    //    }
    ,{
        text: 'Ru/En only',
        handler: function(){
            comboLanguages.setValue('ru,en');
        }
    },{
        text: 'En only',
        handler: function(){
            comboLanguages.setValue('en');
        }
    },{
        text: 'Clear',
        handler: function(){
            comboLanguages.reset();
        }
    }],
    ddReorder: true

});



var ptMulti = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 400,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'pt',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'Нужно выбрать хотя бы {1} язык!',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginBottom: '9px'
    },
    store: storePts,
    listeners: {
        click: function() {
            //alert(ptMulti.getValue());
            getPtAltName(ptMulti.getValue());
        //            if(ptForm.getForm().isValid()){
        //                addProductType(ptForm.getForm().findField('newPT').getValue());
        //            } else{
        //                Ext.Msg.show({
        //                    title: 'Предупреждение!',
        //                    msg: 'Укажите название ПТ!',
        //                    buttons: Ext.MessageBox.OK,
        //                    width: 300
        //                });
        //            }
        }
    },
    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'ptTemplate',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    //                    Ajax.addAttributeAltName(atrMulti.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                    //                        if(data=="MultiSelectInRequest"){
                    //                            Ext.Msg.show({
                    //                                title: 'Предупреждение!!!',
                    //                                msg: 'Выбирайте только одно значение!',
                    //                                buttons: Ext.MessageBox.OK,
                    //                                width: 300,
                    //                                icon: Ext.MessageBox.ERROR
                    //                            });
                    //                        } else {
                    //                            Ext.getCmp('atrAltName').setValue("");
                    //                            storeGrpProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
                    //                            storeGrpAlt.clearData();
                    //                            storeGrpAlt.load();
                    //                        }
                    //                    });
                    storePtsProxy.setUrl("ProductType.exml?template=" + Ext.getCmp('ptTemplate').getValue());
                    storePts.clearData();
                    storePts.load();


                }
            }
        }
    },{
        text: 'Показать ПТ',
        handler: function(){
            storePtsProxy.setUrl("ProductType.exml?template=" + Ext.getCmp('ptTemplate').getValue());
            storePts.clearData();
            storePts.load();
        }
    },
    {
        text: 'Удалить ПТ',
        handler: function(){
            Ext.MessageBox.buttonText.yes = "ага";
            Ext.MessageBox.buttonText.no = "нах";
            Ext.Msg.show({
                title:'Подтверждение!',
                msg: 'Удалить ПТ?',
                buttons: Ext.Msg.YESNO,
                fn: function(btn){
                    if (btn == 'yes'){
                        Ajax.deleteProductType(ptMulti.getValue(), function(data) {
                            if(data=="MultiSelectInRequest"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!!!',
                                    msg: 'Выбирайте только одно значение!',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            } else {
                                ptField.setValue("");
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'ПТ удален.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                                storePtsProxy.setUrl("ProductType.exml?template=" + Ext.getCmp('ptTemplate').getValue());
                                storePts.clearData();
                                storePts.load();
                            }

                        });
                    //alert("Удален нах...");
                    }
                },
                icon: Ext.MessageBox.QUESTION
            });
        }
    },{
        text: 'Загрузить файл с ПТ',
        handler: function(){
            Ajax.downloadPTData(function(data) {
                dwr.engine.openInDownload(data);
            });
        }
    }],
    ddReorder: true

});




var ptField = new Ext.form.TextArea({
    //xtype: 'textarea',
    //width: 700,
    height:200,
    autoScroll:true,
    //allowBlank:false,
    hideLabel: true,
    //blankText:'Введите сообщение...',
    id:'ptData',
    // allowBlank:false,
    enableKeyEvents:true,
    style: {
        width:'50%',
        marginTop: '1px',
        marginLeft: '3px',
        marginRight: '0px',
        marginBottom: '9px'
    },
    listeners: {
        specialkey: function(something,e){
            if (e.getKey() == e.ENTER) {
                sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
            }
        }
    }

});



var ptForm = new Ext.form.FormPanel({
    title: 'Product Types',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [
        {
            html:'<h1>Новый ПТ:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'textfield',
            hideLabel: true,
            height:22,
            id:'newPT',
            blankText:'Введите что-нибудь...',
            allowBlank:false,
            style: {
                marginTop: '1px'
            }
        },{
            xtype: 'button',
            text: '<<<Добавить>>>',
            style: {
                //                marginTop: '1px',
                marginLeft: '7px'
            },
            bodyStyle: 'align:center',
            listeners: {
                click: function() {
                    //alert(isForm.getForm().findField('newPT').getValue());
                    if(ptForm.getForm().isValid()){
                        addProductType(ptForm.getForm().findField('newPT').getValue());
                    } else{
                        Ext.Msg.show({
                            title: 'Предупреждение!',
                            msg: 'Укажите название ПТ!',
                            buttons: Ext.MessageBox.OK,
                            width: 300,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
            }
        },{
            html:'<h1>Залить ПТ файлом:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'fileuploadfield',
            width:350,
            id: 'ptFile',
            emptyText: 'Выберите файл...',
            style: {
                marginTop: '0px',
                marginBottom: '0px'
            },
            buttonText: 'Выбрать'
        //        buttonCfg: {
        //            iconCls: 'upload-icon'
        //        }
        },{
            xtype: 'button',
            text: '<<<Запуск>>>',
            id:'ptUploadBtn',
            style: {
                marginLeft: '5px'
            },
            listeners: {
                click: function() {
                    //var file = Ext.getDom('ptFile-file');
                    var file = dwr.util.getValue('ptFile-file');
                    //                    alert(Ext.get('ptFile-file').getValue());
                    //                    Ext.getCmp('ptFile').reset();
                    //                    alert(Ext.get('ptFile-file').getValue());
                    Ajax.updatePtByFile(file, Ext.getCmp('ptFile').getValue(), function(data) {
                        Ext.getCmp('ptFile').reset();
                        if(data=="!csv"){
                            Ext.Msg.show({
                                title:'Неверный формат файла...',
                                msg: 'Верный смотри в инфо...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else{
                            Ext.Msg.show({
                                title:'Выполненно!',
                                msg: 'Файл залит.',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.INFO
                            });
                            storePts.load();
                        }
                    });
                // alert("Ушло");

                }
            }
        }]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    },{
        bodyStyle: 'padding:7px;',
        layout:'column',
        items: [ptMulti, ptField]
    }]
//    ,
//
//    buttons: [{
//        text: 'Save',
//        handler: function(){
//            if(ptForm.getForm().isValid()){
//                updatePtAltName(ptMulti.getValue(), ptField.getValue());
//            }
//        }
//    }]
});

var comboPT = new Ext.form.ComboBox({
    store: storePtsAll,
    hideLabel: true,
    displayField:'pt',
    valueField: 'id',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите PT...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200
//    listeners: {
//        'select': function(){
//            storeAtrsProxy.setUrl("Attribute.exml?ptId=" + comboOwner2.getValue());
//            storeAtrs.clearData();
//            storeAtrs.load();
//        }
//    }
});

var storeAtrProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeAtr = new Ext.data.Store({
    proxy: storeAtrProxy,
    reader: new Ext.data.XmlReader({
        record: 'Attribute',
        id: 'Id'
    }, [
    {
        name: 'atr',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeAtrProxyAlt = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeAtrAlt = new Ext.data.Store({
    proxy: storeAtrProxyAlt,
    reader: new Ext.data.XmlReader({
        record: 'AltName',
        id: 'Id'
    }, [
    {
        name: 'name',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});


var atrMulti = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 400,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'atr',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginBottom: '2px'
    },
    store: storeAtr,
    listeners: {
        click: function() {
        //            Ajax.getAttributeAltName(atrMulti.getValue(), function(data) {
        //                if(data=="MultiSelectInRequest"){
        //                    atrField.setValue("");
        //                    Ext.Msg.show({
        //                        title: 'Предупреждение!!!',
        //                        msg: 'Выбирайте только одно значение!',
        //                        buttons: Ext.MessageBox.OK,
        //                        width: 300,
        //                        icon: Ext.MessageBox.ERROR
        //                    });
        //                } else {
        //                    atrField.setValue(data);
        //                }
        //            });
        //            alert(atrMulti.getValue());
        //            storeAtrProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
        //            storeAtrAlt.clearData();
        //            storeAtrAlt.load();
        //            storeRegexpProxy.setUrl("Service.exml?request=regexp/attributeId=" + atrMulti.getValue());
        //            storeRegexp.clearData();
        //            storeRegexp.load();
        //atrField.setValue("");
        }
    },
    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'attributeTemplate',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    //                    Ajax.addAttributeAltName(atrMulti.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                    //                        if(data=="MultiSelectInRequest"){
                    //                            Ext.Msg.show({
                    //                                title: 'Предупреждение!!!',
                    //                                msg: 'Выбирайте только одно значение!',
                    //                                buttons: Ext.MessageBox.OK,
                    //                                width: 300,
                    //                                icon: Ext.MessageBox.ERROR
                    //                            });
                    //                        } else {
                    //                            Ext.getCmp('atrAltName').setValue("");
                    //                            storeGrpProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
                    //                            storeGrpAlt.clearData();
                    //                            storeGrpAlt.load();
                    //                        }
                    //                    });
                    storeAtrProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('attributeTemplate').getValue());
                    storeAtr.clearData();
                    storeAtr.load();
                    

                }
            }
        }
    },{
        text: 'Показать Атрибуты',
        handler: function(){
            //            if(comboPT.getValue()==""){
            //                Ext.Msg.show({
            //                    title: 'Предупреждение!!!',
            //                    msg: 'Выбирайте ПТ!',
            //                    buttons: Ext.MessageBox.OK,
            //                    width: 300,
            //                    icon: Ext.MessageBox.ERROR
            //                });
            //                return;
            //            }
            //            storeAtrProxy.setUrl("Attribute.exml?ptId="+ comboPT.getValue());
            //            storeAtr.clearData();
            //            storeAtr.load();
            storeAtrProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('attributeTemplate').getValue());
            storeAtr.clearData();
            storeAtr.load();
            atrField.setValue("");
        }
    },{
        text: 'Удалить Атрибут',
        handler: function(){
            Ext.MessageBox.buttonText.yes = "ага";
            Ext.MessageBox.buttonText.no = "нах";
            Ext.Msg.show({
                title:'Подтверждение!',
                msg: 'Удалить Атрибут? Он будет удален из всех ПТ...',
                buttons: Ext.Msg.YESNO,
                fn: function(btn){
                    if (btn == 'yes'){
                        Ajax.deleteAttribute(atrMulti.getValue(), function(data) {
                            if(data=="MultiSelectInRequest"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!!!',
                                    msg: 'Выбирайте только одно значение!',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                            else {
                                atrField.setValue("");
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'Атрибут удален.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                                storeAtrProxy.setUrl("Attribute.exml?ptId="+ comboPT.getValue());
                                storeAtr.clearData();
                                storeAtr.load();
                                atrField.setValue("");
                            }

                        });
                    }
                },
                icon: Ext.MessageBox.QUESTION
            });
        }
    },{
        text: 'Загрузить файл с Атрибутами',
        handler: function(){
            Ajax.downloadAtrData(function(data) {
                dwr.engine.openInDownload(data);
            });
        }
    }
    ],
    ddReorder: true

});

var atrMultiAlt = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 350,
    height: 293,
    allowBlank:true,
    //autoScroll: true,
    displayField:'name',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '6px',
        marginLeft: '1px',
        marginBottom: '2px'
    },
    store: storeAtrAlt,
    listeners: {
        click: function() {
            storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                +atrMultiAlt.getValue());
            storeRegexp.clearData();
            storeRegexp.load();
        }
    },
    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'atrAltName',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    Ajax.addAttributeAltName(Ext.getCmp('multiG2ASel').getValue(), comboGroupes.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                        if(data=="MultiSelectInRequest"){
                            Ext.Msg.show({
                                title: 'Предупреждение!!!',
                                msg: 'Выбирайте только одно значение!',
                                buttons: Ext.MessageBox.OK,
                                width: 300,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else {
                            Ext.getCmp('atrAltName').setValue("");
                            storeAtrProxyAlt.setUrl("AttributeAltName?attribute="+ Ext.getCmp('multiG2ASel').getValue()+"&groupe="+comboGroupes.getValue());
                            storeAtrAlt.clearData();
                            storeAtrAlt.load();
                        }
                    });

                }
            }
        }
    },{
        text: 'Добавить',
        handler: function(){
            if(Ext.getCmp('multiG2ASel').getValue()==null||Ext.getCmp('multiG2ASel').getValue()==""||comboGroupes.getValue()==null||comboGroupes.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите атрибут и введите значение алиаса...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            Ajax.addAttributeAltName(Ext.getCmp('multiG2ASel').getValue(), comboGroupes.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                if(data=="MultiSelectInRequest"){
                    Ext.Msg.show({
                        title: 'Предупреждение!!!',
                        msg: 'Выбирайте только одно значение!',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.ERROR
                    });
                } else {
                    Ext.getCmp('atrAltName').setValue("");
                    storeAtrProxyAlt.setUrl("AttributeAltName?attribute="+ Ext.getCmp('multiG2ASel').getValue()+"&groupe="+comboGroupes.getValue());
                    storeAtrAlt.clearData();
                    storeAtrAlt.load();
                }
            });
        }
    },{
        text: 'Удалить',
        handler: function(){
            if(atrMultiAlt.getValue()==null||atrMultiAlt.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите алиас...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            Ajax.deleteAttributeAltName(atrMultiAlt.getValue(), function(data) {
                //                Ext.getCmp('atrAltName').setValue("");
                storeAtrProxyAlt.setUrl("AttributeAltName?attribute="+ Ext.getCmp('multiG2ASel').getValue()+"&groupe="+comboGroupes.getValue());
                storeAtrAlt.clearData();
                storeAtrAlt.load();
                storeRegexp.removeAll();
            //                storeRegexp.commitChanges();
            });
        }
    },{
        text: 'Regexp Type',
        handler:function(){
            if(atrMultiAlt.getValue()==null||atrMultiAlt.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите алиас...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            Ajax.updateRegexpElabType(atrMultiAlt.getValue(), function(data) {
                storeAtrProxyAlt.setUrl("AttributeAltName?attribute="+ Ext.getCmp('multiG2ASel').getValue()+"&groupe="+comboGroupes.getValue());
                storeAtrAlt.clearData();
                storeAtrAlt.load();
            });
        //                        updateAtrsToOutExternal();
        }
    }
    ],
    ddReorder: true

});

var storeRegexpPreviewProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeRegexpPreview = new Ext.data.Store({
    // load using HTTP
    proxy: storeRegexpPreviewProxy,

    // the return will be XML, so lets set up a reader
    reader: new Ext.data.XmlReader({
        record: 'Article',
        id: 'Id'
    }, [
    {
        name: 'value',
        mapping: 'Value'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

// create the grid
var gridRegexpPreview = new Ext.grid.GridPanel({
    store: storeRegexpPreview,
    columns: [
    {
        header: "Attribute Value",
        width: 580,
        dataIndex: 'value',
        sortable: true
    }
    ]
});




var regexpTestWin = new Ext.Window({
    //applyTo:'hello-win',
    layout:'fit',
    width:600,
    height:300,
    closeAction:'hide',
    plain: true,

    items: gridRegexpPreview,

    buttons: [{
        text:'Submit',
        disabled:true
    },{
        text: 'Close',
        handler: function(){
            regexpTestWin.hide();
        }
    }]
});

var storeRegexpPreviewAfterProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeRegexpPreviewAfter = new Ext.data.Store({
    // load using HTTP
    proxy: storeRegexpPreviewAfterProxy,

    // the return will be XML, so lets set up a reader
    reader: new Ext.data.XmlReader({
        record: 'Article',
        id: 'Id'
    }, [
    {
        name: 'valueBefore',
        mapping: 'ValueBefore'
    },{
        name: 'valueAfter',
        mapping: 'ValueAfter'
    }, {
        name:'id',
        mapping:'Id'
    }, {
        name:'composite',
        mapping:'Composite'
    },{
        name:'weight',
        mapping:'Weight'
    }
    ])
});

// create the grid
var gridRegexpPreviewAfter = new Ext.grid.GridPanel({
    store: storeRegexpPreviewAfter,
    columns: [
    {
        header: "Attribute Value Before",
        width: 270,
        dataIndex: 'valueBefore',
        sortable: true
    },
    {
        header: "Attribute Value After",
        width: 270,
        dataIndex: 'valueAfter',
        sortable: true
    },
    {
        header: "Composite",
        width: 100,
        dataIndex: 'composite',
        sortable: true
    },
    {
        header: "Weight",
        width: 70,
        dataIndex: 'weight',
        sortable: true
    }
    ]
});




var regexpTestWinAfter = new Ext.Window({
    //applyTo:'hello-win',
    layout:'fit',
    width:800,
    height:300,
    closeAction:'hide',
    plain: true,

    items: gridRegexpPreviewAfter,
    tbar:[{
        text:'<h1>Лимит строк:</h1>',
        style: {
            marginRight: '7px',
            marginLeft: '7px'
        },
        bodyStyle: 'border: 0px'
    },{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'regexpLimit',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    storeRegexpPreviewAfterProxy.setUrl("Service.exml?request=outputData/"
                        +"attrAltId="
                        +atrMultiAlt.getValue()
                        +"/groupeId="
                        +comboGroupes.getValue()
                        +"/attributeId="
                        +Ext.getCmp('multiG2ASel').getValue()
                        +"/regexpLimit="
                        +Ext.getCmp('regexpLimit').getValue());
                    storeRegexpPreviewAfter.clearData();
                    storeRegexpPreviewAfter.load();
                }
            }
        }
    },{
        text: 'Обновить',
        handler: function(){
            storeRegexpPreviewAfterProxy.setUrl("Service.exml?request=outputData/"
                +"attrAltId="
                +atrMultiAlt.getValue()
                +"/groupeId="
                +comboGroupes.getValue()
                +"/attributeId="
                +Ext.getCmp('multiG2ASel').getValue()
                +"/regexpLimit="
                +Ext.getCmp('regexpLimit').getValue());
            storeRegexpPreviewAfter.clearData();
            storeRegexpPreviewAfter.load();
        }
    }],

    buttons: [{
        text: 'Close',
        handler: function(){
            regexpTestWinAfter.hide();
        }
    }]
});


var regexpFieldWin = new Ext.Window({
    animateTarget:'regexpPattern',
    title: 'Regexp Pattern',
    layout:'fit',
    width:800,
    height:90,
    closeAction:'hide',
    plain: false,

    items:[{
        xtype: 'textfield',
        hideLabel: true,
        enableKeyEvents: true,
        width:30,
        height:10,
        id:'regexpField',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    Ext.getCmp('regexpPattern').setValue(Ext.getCmp('regexpField').getValue());
                    regexpFieldWin.hide();
                }
            },
            'keyup': function(){
                Ext.getCmp('regexpPattern').setValue(Ext.getCmp('regexpField').getValue());
            }
        }
    }],
    buttons: [
    //        {
    //        text: 'Update',
    //        handler: function(){
    //            Ext.getCmp('regexpPattern').setValue(Ext.getCmp('regexpField').getValue());
    //        }
    //    },
    {
        text: 'Close',
        handler: function(){
            regexpFieldWin.hide();
        }
    }]
});

var regexpReplaceFieldWin = new Ext.Window({
    animateTarget:'regexpReplacement',
    layout:'fit',
    title: 'Regexp Replacement',
    width:800,
    height:90,
    closeAction:'hide',
    plain: true,
    items:[{
        xtype: 'textfield',
        hideLabel: true,
        width:30,
        height:10,
        id:'regexpReplaceField',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        enableKeyEvents: true,
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    Ext.getCmp('regexpReplacement').setValue(Ext.getCmp('regexpReplaceField').getValue());
                    regexpReplaceFieldWin.hide();
                }
            },
            'keyup': function(){
                Ext.getCmp('regexpReplacement').setValue(Ext.getCmp('regexpReplaceField').getValue());
            }
        }
    }],
    buttons: [{
        text: 'Close',
        handler: function(){
            regexpReplaceFieldWin.hide();
        }
    }]
});



var storeAtrPreviewProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeAtrPreview = new Ext.data.Store({
    // load using HTTP
    proxy: storeAtrPreviewProxy,

    // the return will be XML, so lets set up a reader
    reader: new Ext.data.XmlReader({
        record: 'Article',
        id: 'Id'
    }, [
    {
        name: 'valueBefore',
        mapping: 'oldValue'
    },{
        name: 'valueAfter',
        mapping: 'Value'
    }, {
        name:'id',
        mapping:'Id'
    }, {
        name:'composite',
        mapping:'composite'
    }, {
        name:'weight',
        mapping:'weight'
    }
    ])
});

// create the grid
var gridStoreAtrPreview = new Ext.grid.GridPanel({
    store: storeAtrPreview,
    columns: [
    {
        header: "Attribute Value Before",
        width: 270,
        dataIndex: 'valueBefore',
        sortable: true
    },
    {
        header: "Attribute Value After",
        width: 270,
        dataIndex: 'valueAfter',
        sortable: true
    },
    {
        header: "Composite",
        width: 100,
        dataIndex: 'composite',
        sortable: true
    },
    {
        header: "Weight",
        width: 100,
        dataIndex: 'weight',
        sortable: true
    }
    ]
});




var atrPreviewWinAfter = new Ext.Window({
    //applyTo:'hello-win',
    layout:'fit',
    width:800,
    height:300,
    closeAction:'hide',
    plain: true,

    items: gridStoreAtrPreview,
    tbar:[{
        text:'<h1>Лимит строк:</h1>',
        style: {
            marginRight: '7px',
            marginLeft: '7px'
        },
        bodyStyle: 'border: 0px'
    },{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'regexpLimit2',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    groupe = gridToOut.getSelectionModel().selection.record.data.groupe;
                    attribute = gridToOut.getSelectionModel().selection.record.data.attribute;
                    storeAtrPreviewProxy.setUrl("Service.exml?request=outputData/attributeValue="
                        +attribute.replace("/","|||")
                        +"/groupeValue="
                        +groupe+
                        "/regexpLimit="
                        + Ext.getCmp('regexpLimit2').getValue()
                        +"/session="
                        + Ext.getCmp('SessionIdUp').getValue()
                        +"/regexpPreview=before");
                    storeAtrPreview.clearData();
                    storeAtrPreview.load();
                }
            }
        }
    },{
        text: 'Обновить',
        handler: function(){
            groupe = escape(gridToOut.getSelectionModel().selection.record.data.groupe);
            attribute = escape(gridToOut.getSelectionModel().selection.record.data.attribute);
            storeAtrPreviewProxy.setUrl("Service.exml?request=outputData/attributeValue="
                +attribute.replace("/","|||")
                +"/groupeValue="
                +groupe+
                "/regexpLimit="
                + Ext.getCmp('regexpLimit2').getValue()
                +"/session="
                + Ext.getCmp('SessionIdUp').getValue()
                +"/regexpPreview=before");
            storeAtrPreview.clearData();
            storeAtrPreview.load();
        }
    }],

    buttons: [{
        text: 'Close',
        handler: function(){
            atrPreviewWinAfter.hide();
        }
    }]
});

var storeSessionProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeSession = new Ext.data.Store({
    // load using HTTP
    proxy: storeSessionProxy,

    // the return will be XML, so lets set up a reader
    reader: new Ext.data.XmlReader({
        record: 'Session',
        id: 'Article'
    }, [
    {
        name: 'sessionId',
        mapping: 'SessionId'
    },{
        name: 'article',
        mapping: 'Article'
    }
    ])
});

// create the grid
var gridSession = new xg.EditorGridPanel({
    store: storeSession,
    columns: [
    {
        header: "Article",
        width: 270,
        dataIndex: 'article',
        sortable: true
    },
    {
        header: "SessionId",
        width: 270,
        dataIndex: 'sessionId',
        sortable: true,
        editor: new fm.TextField({
            allowBlank: false
        })
    }
    ]
});




var sessionWin = new Ext.Window({
    //applyTo:'hello-win',
    layout:'fit',
    width:600,
    height:300,
    closeAction:'hide',
    plain: true,

    items: gridSession,
    tbar:[{
        text:'<h1>Article:</h1>',
        style: {
            marginRight: '7px',
            marginLeft: '7px'
        },
        bodyStyle: 'border: 0px'
    },{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'article4Session',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    storeSessionProxy.setUrl("Service.exml?request=sessions/article="
                        + Ext.getCmp('article4Session').getValue());
                    storeSession.clearData();
                    storeSession.load();
                }
            }
        }
    },{
        text: 'Показать',
        handler: function(){
            storeSessionProxy.setUrl("Service.exml?request=sessions/article="
                + Ext.getCmp('article4Session').getValue());
            storeSession.clearData();
            storeSession.load();
        }
    },{
        text: 'Удалить все сессии!!!',
        handler: function(){
            Ext.Msg.show({
                title:'Подтверждение!',
                msg: 'Точно удалить все сессии? Все сессии проподут, но зато следующие выборки будут работать быстрее...',
                buttons: Ext.Msg.YESNO,
                fn: function(btn){
                    if (btn == 'yes'){
                        Ajax.deleteAllSessionId(function(data) {
                            Ext.Msg.show({
                                title:'Выполненно!',
                                msg: 'Все сессии удалены...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.INFO
                            });

                        });
                    }
                },
                icon: Ext.MessageBox.QUESTION
            });
        }
    }],

    buttons: [{
        text: 'Close',
        handler: function(){
            sessionWin.hide();
        }
    }]
});


var storeRegexpProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeRegexp = new Ext.data.Store({
    proxy: storeRegexpProxy,
    reader: new Ext.data.XmlReader({
        record: 'Regexp',
        id: 'Id'
    }, [
    {
        name: 'name',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeRegexpTypes = new Ext.data.Store({
    url: "data/RegexpTypes.xml",
    reader: new Ext.data.XmlReader({
        record: 'RegexpType',
        id: 'Id'
    }, [
    {
        name: 'regexpType',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeRegexpUsedData = new Ext.data.Store({
    url: "data/UsedData.xml",
    reader: new Ext.data.XmlReader({
        record: 'UsedData',
        id: 'Id'
    }, [
    {
        name: 'data',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});



var atrRegexp = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 1021,
    height: 300,
    allowBlank:true,
    //autoScroll: true,
    displayField:'name',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '0px',
        marginLeft: '0px',
        marginBottom: '0px'
    },
    store: storeRegexp,
    listeners: {
        click: function() {
            Ajax.updateRegexp(atrRegexp.getValue(), function(data) {
                Ext.getCmp('regexpType').setValue(data[0]);
                Ext.getCmp('regexpPattern').setValue(data[1]);
                Ext.getCmp('regexpReplacement').setValue(data[2]);
                //                if(data[3]=="0"){
                //                    Ext.getCmp('regexpUsedData').setValue("Value");
                //                } else if(data[3]=="1"){
                //                    Ext.getCmp('regexpUsedData').setValue("Attribute");
                //                } else {
                //                    Ext.getCmp('regexpUsedData').setValue("Both");
                //                }
                Ext.getCmp('regexpUsedData').setValue(data[3]);
            });
            
        }
    },
    tbar:[{
        text:'<h1>Type:</h1>',
        style: {
            marginBottom: '3px',
            marginRight: '5px',
            marginLeft: '5px'
        },
        bodyStyle: 'border: 0px'
    },
    {
        xtype: 'combo',
        store: storeRegexpTypes,
        id:'regexpType',
        displayField:'regexpType',
        valueField: 'regexpType',
        typeAhead: true,
        mode: 'remote',
        forceSelection: true,
        triggerAction: 'all',
        //emptyText:'Выберите автора...',
        editable: false,
        width:90,
        style: {
            marginBottom: '3px',
            margin: '0px'
        }
    },
    {
        text:'<h1>Pattern:</h1>',
        style: {
            marginBottom: '3px',
            marginRight: '5px',
            marginLeft: '5px'
        },
        bodyStyle: 'border: 0px'
    },{
        xtype: 'textfield',
        hideLabel: true,
        enableKeyEvents: true,
        height:22,
        width:100,
        id:'regexpPattern',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            render : {
                single : true,
                buffer : 100,
                fn     :function() {

                    this.el.setWidth(250);
                }
            }
        //            'focus': function(){
        //                Ext.getCmp('regexpField').setValue(Ext.getCmp('regexpPattern').getValue());
        //                regexpFieldWin.show();
        //            //                Ext.getCmp('regexpField').focus();
        //            },
        //            specialkey: function(something,e){
        //            },
        //            'keyup': function(){
        //                Ext.getCmp('regexpField').setValue(Ext.getCmp('regexpPattern').getValue());
        //            }
        }
    },{
        text:'<h1>Replace:</h1>',
        style: {
            marginBottom: '3px',
            marginRight: '5px',
            marginLeft: '5px'
        },
        bodyStyle: 'border: 0px'
    },{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'regexpReplacement',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        enableKeyEvents: true,
        style: {
            marginTop: '1px'
        }
    //        listeners: {
    //            'focus': function(){
    //                Ext.getCmp('regexpReplaceField').setValue(Ext.getCmp('regexpReplacement').getValue());
    //                regexpReplaceFieldWin.show();
    //            //                Ext.getCmp('regexpReplaceField').focus();
    //            },
    //            specialkey: function(something,e){
    //            },
    //            'keyup': function(){
    //                Ext.getCmp('regexpReplaceField').setValue(Ext.getCmp('regexpReplacement').getValue());
    //            }
    //        }
    },{
        text:'<h1>Data:</h1>',
        style: {
            marginBottom: '3px',
            marginRight: '5px',
            marginLeft: '5px'
        },
        bodyStyle: 'border: 0px'
    },
    {
        xtype: 'combo',
        store: storeRegexpUsedData,
        id:'regexpUsedData',
        displayField:'data',
        valueField: 'id',
        typeAhead: true,
        mode: 'remote',
        forceSelection: true,
        triggerAction: 'all',
        //emptyText:'Выберите автора...',
        editable: false,
        width:80,
        style: {
            marginBottom: '3px',
            margin: '0px'
        }
    },{
        text: 'Add',
        handler: function(){
            if(atrMultiAlt.getValue()==null||atrMultiAlt.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите алиас...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            Ajax.addRegexp(
                atrMultiAlt.getValue(),
                Ext.getCmp('regexpType').getValue(),
                Ext.getCmp('regexpPattern').getValue(),
                Ext.getCmp('regexpReplacement').getValue(),
                Ext.getCmp('regexpUsedData').getValue(),
                "new",
                function(data) {
                    if(data=="MultiSelectInRequest"){
                        Ext.Msg.show({
                            title: 'Предупреждение!!!',
                            msg: 'Выбирайте только одно значение!',
                            buttons: Ext.MessageBox.OK,
                            width: 300,
                            icon: Ext.MessageBox.ERROR
                        });
                    } else {
                        Ext.getCmp('regexpType').setValue("");
                        Ext.getCmp('regexpPattern').setValue("");
                        Ext.getCmp('regexpReplacement').setValue("");
                        Ext.getCmp('regexpUsedData').setValue("");
                        storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                            +atrMultiAlt.getValue());
                        storeRegexp.clearData();
                        storeRegexp.load();
                        storeRegexp.on('load', function(){
                            var _count = storeRegexp.getTotalCount();
                            var _records = storeRegexp.getRange(0, _count);
                            var _data = "";
                            for(i=0; i<_records.length; i++){
                                if(i<_records.length-1){
                                    _data += _records[i].get('id') + ",";
                                }else{
                                    _data += _records[i].get('id');
                                }
                            }
                            Ajax.updateRegexpPor(atrMultiAlt.getValue(),_data,
                                function(data) {
                                //                                    Ext.Msg.show({
                                //                                        title:'Выполненно!',
                                //                                        msg: 'Порядок установлен...',
                                //                                        buttons: Ext.Msg.OK,
                                //                                        width:250,
                                //                                        icon: Ext.MessageBox.INFO
                                //                                    });
                                //                                    storeRegexp.purgeListeners();
                                //                                    storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                                //                                        +atrMultiAlt.getValue());
                                //                                    storeRegexp.clearData();
                                //                                    storeRegexp.load();
                                //                                    storeRegexp.resumeEvents();
                                });
                        });
                        storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                            +atrMultiAlt.getValue());
                        storeRegexp.clearData();
                        storeRegexp.load();
                    //                        regexpPor();
                    }
                });
             
        }
    },{
        text: 'Update',
        handler: function(){
            if(atrMultiAlt.getValue()==null||atrMultiAlt.getValue()==""||atrRegexp.getValue()==null||atrRegexp.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите алиас и регексп...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }

            Ajax.addRegexp(atrMultiAlt.getValue(),
                Ext.getCmp('regexpType').getValue(),
                Ext.getCmp('regexpPattern').getValue(),
                Ext.getCmp('regexpReplacement').getValue(),
                Ext.getCmp('regexpUsedData').getValue(),
                atrRegexp.getValue(),
                function(data) {
                    if(data=="MultiSelectInRequest"){
                        Ext.Msg.show({
                            title: 'Предупреждение!!!',
                            msg: 'Выбирайте только одно значение!',
                            buttons: Ext.MessageBox.OK,
                            width: 300,
                            icon: Ext.MessageBox.ERROR
                        });
                    } else {
                        Ext.getCmp('regexpType').setValue("");
                        Ext.getCmp('regexpPattern').setValue("");
                        Ext.getCmp('regexpReplacement').setValue("");
                        Ext.getCmp('regexpUsedData').setValue("");
                        storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                            +atrMultiAlt.getValue());
                        storeRegexp.clearData();
                        storeRegexp.load();
                        storeRegexp.on('load', function(){
                            var _count = storeRegexp.getTotalCount();
                            var _records = storeRegexp.getRange(0, _count);
                            var _data = "";
                            for(i=0; i<_records.length; i++){
                                if(i<_records.length-1){
                                    _data += _records[i].get('id') + ",";
                                }else{
                                    _data += _records[i].get('id');
                                }
                            }
                            Ajax.updateRegexpPor(atrMultiAlt.getValue(),_data,
                                function(data) {
                                //                                    Ext.Msg.show({
                                //                                        title:'Выполненно!',
                                //                                        msg: 'Порядок установлен...',
                                //                                        buttons: Ext.Msg.OK,
                                //                                        width:250,
                                //                                        icon: Ext.MessageBox.INFO
                                //                                    });
                                    
                                });
                        });
                        storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                            +atrMultiAlt.getValue());
                        storeRegexp.clearData();
                        storeRegexp.load();
                    }
                });


        }
    },{
        text: 'Remove',
        handler: function(){
            if(atrRegexp.getValue()==null||atrRegexp.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите регексп...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            Ajax.deleteRegexp(atrRegexp.getValue(),
                function(data) {
                    storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                        +atrMultiAlt.getValue());
                    storeRegexp.clearData();
                    storeRegexp.load();
                    storeRegexp.on('load', function(){
                        var _count = storeRegexp.getTotalCount();
                        var _records = storeRegexp.getRange(0, _count);
                        var _data = "";
                        for(i=0; i<_records.length; i++){
                            if(i<_records.length-1){
                                _data += _records[i].get('id') + ",";
                            }else{
                                _data += _records[i].get('id');
                            }
                        }
                        Ajax.updateRegexpPor(atrMultiAlt.getValue(),_data,
                            function(data) {
                            //                                    Ext.Msg.show({
                            //                                        title:'Выполненно!',
                            //                                        msg: 'Порядок установлен...',
                            //                                        buttons: Ext.Msg.OK,
                            //                                        width:250,
                            //                                        icon: Ext.MessageBox.INFO
                            //                                    });
                            //                                storeRegexp.purgeListeners();
                            //                                storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                            //                                    +atrMultiAlt.getValue());
                            //                                storeRegexp.clearData();
                            //                                storeRegexp.load();
                            //                                storeRegexp.resumeEvents();
                            });
                    });
                    storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                        +atrMultiAlt.getValue());
                    storeRegexp.clearData();
                    storeRegexp.load();
                });
        }
    },
    {
        text: 'Order',
        handler: function regexpPor(){
            var _count = storeRegexp.getTotalCount();
            var _records = storeRegexp.getRange(0, _count);
            var _data = "";
            for(i=0; i<_records.length; i++){
                if(i<_records.length-1){
                    _data += _records[i].get('id') + ",";
                }else{
                    _data += _records[i].get('id');
                }
            }
            Ajax.updateRegexpPor(atrMultiAlt.getValue(),_data,
                function(data) {
                    Ext.Msg.show({
                        title:'Выполненно!',
                        msg: 'Порядок установлен...',
                        buttons: Ext.Msg.OK,
                        width:250,
                        icon: Ext.MessageBox.INFO
                    });
                    storeRegexpProxy.setUrl("Service.exml?request=regexp/attrAltId="
                        +atrMultiAlt.getValue());
                    storeRegexp.clearData();
                    storeRegexp.load();
                });
        }
    },
    {
        text: 'Sample',
        handler: function(){
            if(atrMultiAlt.getValue()==null||atrMultiAlt.getValue()==""||
                comboGroupes.getValue()==null||comboGroupes.getValue()==""||
                Ext.getCmp('multiG2ASel').getValue()==null||Ext.getCmp('multiG2ASel').getValue()==""||
            comboPtsNew.getValue()==null||comboPtsNew.getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите ПТ, группу, атрибут и алиас...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            storeRegexpPreviewAfterProxy.setUrl("Service.exml?request=outputData/"
                +"attrAltId="
                +atrMultiAlt.getValue()
                +"/groupeId="
                +comboGroupes.getValue()
                +"/attributeId="
                +Ext.getCmp('multiG2ASel').getValue()
                +"/productTypeId="
                +comboPtsNew.getValue()
                +"/regexpLimit=20");
            storeRegexpPreviewAfter.clearData();
            storeRegexpPreviewAfter.load();
            regexpTestWinAfter.show(this);
        }
    }
    ],
    ddReorder: true

});


var atrField = new Ext.form.TextArea({
    //xtype: 'textarea',
    //width: 700,
    height:200,
    autoScroll:true,
    //allowBlank:false,
    hideLabel: true,
    //blankText:'Введите сообщение...',
    id:'artData',
    // allowBlank:false,
    enableKeyEvents:true,
    style: {
        width:'50%',
        marginTop: '1px',
        marginLeft: '3px',
        marginRight: '0px',
        marginBottom: '9px'
    },
    listeners: {
        specialkey: function(something,e){
            if (e.getKey() == e.ENTER) {
        //sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
        }
        }
    }

});

var atrForm = new Ext.form.FormPanel({
    title: 'Атрибуты',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [
        {
            html:'<h1>Новый Атрибут:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'textfield',
            hideLabel: true,
            height:22,
            id:'newAtr',
            blankText:'Введите что-нибудь...',
            allowBlank:false,
            style: {
                marginTop: '1px'
            }
        },{
            xtype: 'button',
            text: '<<<Добавить>>>',
            style: {
                //                marginTop: '1px',
                marginLeft: '7px'
            },
            bodyStyle: 'align:center',
            listeners: {
                click: function() {
                    //alert(isForm.getForm().findField('newPT').getValue());
                    if(atrForm.getForm().isValid()){
                        //addProductType(ptForm.getForm().findField('newPT').getValue());
                        Ajax.addAttribute(atrForm.getForm().findField('newAtr').getValue(), function(data) {
                            if(data=="Already Exist"){
                                Ext.Msg.show({
                                    title: 'Дубль!!!',
                                    msg: 'Такой Атрибут уже есть...',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            } else if(data=="Empty"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!',
                                    msg: 'Одини пробелы и/или цифры в названии Атрибута...',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            } else {
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'Атрибут добавлен.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                            }
                        });
                    } else{
                        Ext.Msg.show({
                            title: 'Предупреждение!',
                            msg: 'Укажите название Атрибута!',
                            buttons: Ext.MessageBox.OK,
                            width: 300,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
            }
        },{
            html:'<h1>Залить Атрибуты файлом:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'fileuploadfield',
            width:350,
            id: 'AtrFile',
            emptyText: 'Выберите файл...',
            style: {
                marginTop: '0px',
                marginBottom: '0px'
            },
            buttonText: 'Выбрать'
        //        buttonCfg: {
        //            iconCls: 'upload-icon'
        //        }
        },{
            xtype: 'button',
            text: '<<<Запуск>>>',
            id:'AtrUploadBtn',
            style: {
                marginLeft: '5px',
                marginRight: '5px'
            },
            listeners: {
                click: function() {
                    var file = dwr.util.getValue('AtrFile-file');
                    Ajax.updateAtrByFile(file, Ext.getCmp('AtrFile').getValue(), function(data) {
                        Ext.getCmp('AtrFile').reset();
                        if(data=="!csv"){
                            Ext.Msg.show({
                                title:'Неверный формат файла...',
                                msg: 'Верный смотри в инфо...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else{
                            Ext.Msg.show({
                                title:'Выполненно!',
                                msg: 'Файл залит.',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.INFO
                            });
                        //storePts.load();
                        }
                    });
                // alert("Ушло");

                }
            }
        }]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    }
    //    ,{
    //        bodyStyle: 'padding:7px; border:0px',
    //        layout:'column',
    //        items: [comboPT]
    //    }
    ,{
        bodyStyle: 'padding:7px;',
        //layout:'column',
        //      columns: [100, 1000],
        //        horisontal: true,
        items: [
        {
            bodyStyle: 'border:0px;',
            layout:'column',
            items: [
            atrMulti
            //            ,
            //            atrMultiAlt,
            //            atrRegexp
            ]
        }
        
        ]
    }]
});



//var comboPT = new Ext.form.ComboBox({
//    store: storePtsAll,
//    hideLabel: true,
//    displayField:'pt',
//    valueField: 'id',
//    typeAhead: true,
//    mode: 'remote',
//    forceSelection: true,
//    triggerAction: 'all',
//    emptyText:'Выберите PT...',
//    editable: false,
//    style: {
//        margin: '0px'
//    },
//    width:200
////    listeners: {
////        'select': function(){
////            storeAtrsProxy.setUrl("Attribute.exml?ptId=" + comboOwner2.getValue());
////            storeAtrs.clearData();
////            storeAtrs.load();
////        }
////    }
//});

var storeGrpProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeGrp = new Ext.data.Store({
    proxy: storeGrpProxy,
    reader: new Ext.data.XmlReader({
        record: 'Groupe',
        id: 'Id'
    }, [
    {
        name: 'groupe',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeGrpProxyAlt = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeGrpAlt = new Ext.data.Store({
    proxy: storeGrpProxyAlt,
    reader: new Ext.data.XmlReader({
        record: 'AltName',
        id: 'Id'
    }, [
    {
        name: 'name',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});


var grpMulti = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 400,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'groupe',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginBottom: '9px'
    },
    store: storeGrp,
    listeners: {
        click: function() {
        //            Ajax.getAttributeAltName(atrMulti.getValue(), function(data) {
        //                if(data=="MultiSelectInRequest"){
        //                    atrField.setValue("");
        //                    Ext.Msg.show({
        //                        title: 'Предупреждение!!!',
        //                        msg: 'Выбирайте только одно значение!',
        //                        buttons: Ext.MessageBox.OK,
        //                        width: 300,
        //                        icon: Ext.MessageBox.ERROR
        //                    });
        //                } else {
        //                    atrField.setValue(data);
        //                }
        //            });
        //            alert(atrMulti.getValue());
        //            storeGrpProxyAlt.setUrl("Service.exml?request=unitAlt/unitId="+ atrMulti.getValue());
        //            storeGrpAlt.clearData();
        //            storeGrpAlt.load();
        //atrField.setValue("");
        }
    },
    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'grpTemplate',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    //                    Ajax.addAttributeAltName(atrMulti.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                    //                        if(data=="MultiSelectInRequest"){
                    //                            Ext.Msg.show({
                    //                                title: 'Предупреждение!!!',
                    //                                msg: 'Выбирайте только одно значение!',
                    //                                buttons: Ext.MessageBox.OK,
                    //                                width: 300,
                    //                                icon: Ext.MessageBox.ERROR
                    //                            });
                    //                        } else {
                    //                            Ext.getCmp('atrAltName').setValue("");
                    //                            storeGrpProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
                    //                            storeGrpAlt.clearData();
                    //                            storeGrpAlt.load();
                    //                        }
                    //                    });
                    storeGrpProxy.setUrl("Service.exml?request=groupes/template=" + Ext.getCmp('grpTemplate').getValue());
                    storeGrp.clearData();
                    storeGrp.load();

                }
            }
        }
    },{
        text: 'Показать Группы',
        handler: function(){
            //            if(comboPT.getValue()==""){
            //                Ext.Msg.show({
            //                    title: 'Предупреждение!!!',
            //                    msg: 'Выбирайте ПТ!',
            //                    buttons: Ext.MessageBox.OK,
            //                    width: 300,
            //                    icon: Ext.MessageBox.ERROR
            //                });
            //                return;
            //            }
            //            storeGrpProxy.setUrl("Service.exml?request=groupes/ptId="+ comboPT.getValue());
            //            storeGrp.clearData();
            //            storeGrp.load();
            //            grpField.setValue("");
            storeGrpProxy.setUrl("Service.exml?request=groupes/template=" + Ext.getCmp('grpTemplate').getValue());
            storeGrp.clearData();
            storeGrp.load();
        }
    },{
        text: 'Удалить Группу',
        handler: function(){
            Ext.MessageBox.buttonText.yes = "ага";
            Ext.MessageBox.buttonText.no = "нах";
            Ext.Msg.show({
                title:'Подтверждение!',
                msg: 'Удалить Группу? Она будет удален из всех ПТ...',
                buttons: Ext.Msg.YESNO,
                fn: function(btn){
                    if (btn == 'yes'){
                        Ajax.deleteGroupe(grpMulti.getValue(), function(data) {
                            if(data=="MultiSelectInRequest"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!!!',
                                    msg: 'Выбирайте только одно значение!',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                            else {
                                //                                grpField.setValue("");
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'Группа удалена.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                                storeGrpProxy.setUrl("Service.exml?request=groupes/template=" + Ext.getCmp('grpTemplate').getValue());
                                storeGrp.clearData();
                                storeGrp.load();
                            }

                        });
                    }
                },
                icon: Ext.MessageBox.QUESTION
            });
        }
    },{
        text: 'Загрузить файл с Группами',
        handler: function(){
            Ajax.downloadGroupesData(function(data) {
                dwr.engine.openInDownload(data);
            });
        }
    }
    ],
    ddReorder: true

});

var grpMultiAlt = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 400,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'name',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginLeft: '3px',
        marginBottom: '9px'
    },
    store: storeGrpAlt,
    //    listeners: {
    //        click: function() {
    //            Ajax.getAttributeAltName(atrMulti.getValue(), function(data) {
    //                if(data=="MultiSelectInRequest"){
    //                    atrField.setValue("");
    //                    Ext.Msg.show({
    //                        title: 'Предупреждение!!!',
    //                        msg: 'Выбирайте только одно значение!',
    //                        buttons: Ext.MessageBox.OK,
    //                        width: 300,
    //                        icon: Ext.MessageBox.ERROR
    //                    });
    //                } else {
    //                    atrField.setValue(data);
    //                }
    //            });
    //        } atrForm.getForm().findField('newAtr').getValue()
    //    },
    tbar:[{
        text: 'Добавить значение',
        handler: function(){
            Ajax.addAttributeAltName(atrMulti.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                if(data=="MultiSelectInRequest"){
                    Ext.Msg.show({
                        title: 'Предупреждение!!!',
                        msg: 'Выбирайте только одно значение!',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.ERROR
                    });
                } else {
                    Ext.getCmp('atrAltName').setValue("");
                    storeGrpProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
                    storeGrpAlt.clearData();
                    storeGrpAlt.load();
                }
            });
        }
    },{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'atrAltName',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    Ajax.addAttributeAltName(atrMulti.getValue(), Ext.getCmp('atrAltName').getValue(), function(data) {
                        if(data=="MultiSelectInRequest"){
                            Ext.Msg.show({
                                title: 'Предупреждение!!!',
                                msg: 'Выбирайте только одно значение!',
                                buttons: Ext.MessageBox.OK,
                                width: 300,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else {
                            Ext.getCmp('atrAltName').setValue("");
                            storeGrpProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
                            storeGrpAlt.clearData();
                            storeGrpAlt.load();
                        }
                    });

                }
            }
        }
    },{
        text: 'Удалить значения',
        handler: function(){
            Ajax.deleteAttributeAltName(atrMulti.getValue(), atrMultiAlt.getValue(), function(data) {
                storeGrpProxyAlt.setUrl("AttributeAltName?attribute="+ atrMulti.getValue());
                storeGrpAlt.clearData();
                storeGrpAlt.load();
            });
        }
    }
    ],
    ddReorder: true

});


var grpField = new Ext.form.TextArea({
    //xtype: 'textarea',
    //width: 700,
    height:200,
    autoScroll:true,
    //allowBlank:false,
    hideLabel: true,
    //blankText:'Введите сообщение...',
    id:'grpData',
    // allowBlank:false,
    enableKeyEvents:true,
    style: {
        width:'50%',
        marginTop: '1px',
        marginLeft: '3px',
        marginRight: '0px',
        marginBottom: '9px'
    },
    listeners: {
        specialkey: function(something,e){
            if (e.getKey() == e.ENTER) {
        //sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
        }
        }
    }

});

var grpForm = new Ext.form.FormPanel({
    title: 'Группы',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [
        {
            html:'<h1>Новая Группа:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'textfield',
            hideLabel: true,
            height:22,
            id:'newGroupe',
            blankText:'Введите что-нибудь...',
            allowBlank:false,
            style: {
                marginTop: '1px'
            }
        },{
            xtype: 'button',
            text: '<<<Добавить>>>',
            style: {
                //                marginTop: '1px',
                marginLeft: '7px'
            },
            bodyStyle: 'align:center',
            listeners: {
                click: function() {
                    //alert(isForm.getForm().findField('newPT').getValue());
                    if(grpForm.getForm().isValid()){
                        //addProductType(ptForm.getForm().findField('newPT').getValue());
                        Ajax.addGroupe(Ext.getCmp('newGroupe').getValue(), function(data) {
                            if(data=="Already Exist"){
                                Ext.Msg.show({
                                    title: 'Дубль!!!',
                                    msg: 'Такая группа уже есть...',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            } else if(data=="Empty"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!',
                                    msg: 'Одини пробелы и/или цифры в названии Группы...',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                            else {
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'Группа добавлена.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                            }
                        });
                    } else{
                        Ext.Msg.show({
                            title: 'Предупреждение!',
                            msg: 'Укажите название Группы!',
                            buttons: Ext.MessageBox.OK,
                            width: 300,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
            }
        },{
            html:'<h1>Залить Группы файлом:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'fileuploadfield',
            width:350,
            id: 'GrpFile',
            emptyText: 'Выберите файл...',
            style: {
                marginTop: '0px',
                marginBottom: '0px'
            },
            buttonText: 'Выбрать'
        //        buttonCfg: {
        //            iconCls: 'upload-icon'
        //        }
        },{
            xtype: 'button',
            text: '<<<Запуск>>>',
            id:'GrpUploadBtn',
            style: {
                marginLeft: '5px',
                marginRight: '5px'
            },
            listeners: {
                click: function() {
                    var file = dwr.util.getValue('GrpFile-file');
                    Ajax.updateGroupesByFile(file, Ext.getCmp('GrpFile').getValue(), function(data) {
                        Ext.getCmp('GrpFile').reset();
                        if(data=="!csv"){
                            Ext.Msg.show({
                                title:'Неверный формат файла...',
                                msg: 'Верный смотри в инфо...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else{
                            Ext.Msg.show({
                                title:'Выполненно!',
                                msg: 'Файл залит.',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.INFO
                            });
                        //storePts.load();
                        }
                    });
                // alert("Ушло");

                }
            }
        }]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    }
    //    ,{
    //        bodyStyle: 'padding:7px; border:0px',
    //        layout:'column',
    //        items: [comboPT]
    //    }
    ,{
        bodyStyle: 'padding:7px;',
        //layout:'column',
        //      columns: [100, 1000],
        //        horisontal: true,
        items: [
        {
            bodyStyle: 'border:0px;',
            layout:'column',
            items: [
            grpMulti
            ]
        }
        ]
    }]
});



var storeUnitsProxyAlt = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeUnitsAlt = new Ext.data.Store({
    proxy: storeUnitsProxyAlt,
    reader: new Ext.data.XmlReader({
        record: 'UnitAltName',
        id: 'Id'
    }, [
    {
        name: 'name',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeUnitsProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeUnits = new Ext.data.Store({
    proxy: storeUnitsProxy,
    reader: new Ext.data.XmlReader({
        record: 'Unit',
        id: 'Id'
    }, [
    {
        name: 'unit',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var unitsMulti = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 400,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'unit',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginBottom: '9px'
    },
    store: storeUnits,
    listeners: {
        click: function() {
            //            Ajax.getAttributeAltName(atrMulti.getValue(), function(data) {
            //                if(data=="MultiSelectInRequest"){
            //                    atrField.setValue("");
            //                    Ext.Msg.show({
            //                        title: 'Предупреждение!!!',
            //                        msg: 'Выбирайте только одно значение!',
            //                        buttons: Ext.MessageBox.OK,
            //                        width: 300,
            //                        icon: Ext.MessageBox.ERROR
            //                    });
            //                } else {
            //                    atrField.setValue(data);
            //                }
            //            });
            //            alert(atrMulti.getValue());
            storeUnitsProxyAlt.setUrl("Service.exml?request=unitAlt/unitId=" + unitsMulti.getValue());
            storeUnitsAlt.clearData();
            storeUnitsAlt.load();
        //atrField.setValue("");
        }
    },
    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'unitName',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    if(Ext.getCmp('unitName').getValue()==""){
                        storeUnitsProxy.setUrl("Service.exml?request=units");
                        storeUnits.clearData();
                        storeUnits.load();
                        Ext.getCmp('unitName').setValue("");
                    } else {
                        storeUnitsProxy.setUrl("Service.exml?request=units/unitName=" + Ext.getCmp('unitName').getValue());
                        storeUnits.clearData();
                        storeUnits.load();
                        Ext.getCmp('unitName').setValue("");
                    }
                }
            }
        }
    },{
        text: 'Показать',
        handler: function(){
            if(Ext.getCmp('unitName').getValue()==""){
                storeUnitsProxy.setUrl("Service.exml?request=units");
                storeUnits.clearData();
                storeUnits.load();
                Ext.getCmp('unitName').setValue("");
            }
            else {
                storeUnitsProxy.setUrl("Service.exml?request=units/unitName=" + Ext.getCmp('unitName').getValue());
                storeUnits.clearData();
                storeUnits.load();
                Ext.getCmp('unitName').setValue("");
            }
        }
    },{
        text: 'Удалить',
        handler: function(){
            Ext.MessageBox.buttonText.yes = "ага";
            Ext.MessageBox.buttonText.no = "нах";
            Ext.Msg.show({
                title:'Подтверждение!',
                msg: 'Удалить Единицу измерения?',
                buttons: Ext.Msg.YESNO,
                fn: function(btn){
                    if (btn == 'yes'){
                        Ajax.deleteUnit(unitsMulti.getValue(), function(data) {
                            if(data=="MultiSelectInRequest"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!!!',
                                    msg: 'Выбирайте только одно значение!',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            } else {
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'Единица измерения удалена.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                                if(Ext.getCmp('unitName').getValue()==""){
                                    storeUnitsProxy.setUrl("Service.exml?request=units");
                                    storeUnits.clearData();
                                    storeUnits.load();
                                    Ext.getCmp('unitName').setValue("");
                                }
                                else {
                                    storeUnitsProxy.setUrl("Service.exml?request=units/unitName=" + Ext.getCmp('unitName').getValue());
                                    storeUnits.clearData();
                                    storeUnits.load();
                                    Ext.getCmp('unitName').setValue("");
                                }
                            }

                        });
                    }
                },
                icon: Ext.MessageBox.QUESTION
            });
        }
    },{
        text: 'Загрузить файл с Единицами измерения',
        handler: function(){
            Ajax.downloadUnitsData(function(data) {
                dwr.engine.openInDownload(data);
            });
        }
    }
    ],
    ddReorder: true

});

var unitsMultiAlt = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 400,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'name',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginLeft: '3px',
        marginBottom: '9px'
    },
    store: storeUnitsAlt,
    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'unitsAltName',
        blankText:'Введите что-нибудь...',
        allowBlank:true,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    Ajax.addUnitAltName(unitsMulti.getValue(), Ext.getCmp('unitsAltName').getValue(), function(data) {
                        if(data=="MultiSelectInRequest"){
                            Ext.Msg.show({
                                title: 'Предупреждение!!!',
                                msg: 'Выбирайте только одно значение!',
                                buttons: Ext.MessageBox.OK,
                                width: 300,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else {
                            Ext.getCmp('unitsAltName').setValue("");
                            storeUnitsProxyAlt.setUrl("Service.exml?request=unitAlt/unitId=" + unitsMulti.getValue());
                            storeUnitsAlt.clearData();
                            storeUnitsAlt.load();
                        }
                    });

                }
            }
        }
    },{
        text: 'Добавить значение',
        handler: function(){
            Ajax.addUnitAltName(unitsMulti.getValue(), Ext.getCmp('unitsAltName').getValue(), function(data) {
                if(data=="MultiSelectInRequest"){
                    Ext.Msg.show({
                        title: 'Предупреждение!!!',
                        msg: 'Выбирайте только одно значение!',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.ERROR
                    });
                }
                else {
                    Ext.getCmp('unitsAltName').setValue("");
                    storeUnitsProxyAlt.setUrl("Service.exml?request=unitAlt/unitId=" + unitsMulti.getValue());
                    storeUnitsAlt.clearData();
                    storeUnitsAlt.load();
                }
            });
        }
    },{
        text: 'Удалить значения',
        handler: function(){
            Ajax.deleteUnitAltName(unitsMulti.getValue(), unitsMultiAlt.getValue(), function(data) {
                storeUnitsProxyAlt.setUrl("Service.exml?request=unitAlt/unitId=" + unitsMulti.getValue());
                storeUnitsAlt.clearData();
                storeUnitsAlt.load();
            });
        }
    }
    ],
    ddReorder: true

});

var unitsForm = new Ext.form.FormPanel({
    title: 'Единицы измерения',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [
        {
            html:'<h1>Новая единица измерения:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'textfield',
            hideLabel: true,
            height:22,
            id:'newUnit',
            blankText:'Введите что-нибудь...',
            allowBlank:false,
            style: {
                marginTop: '1px'
            }
        },{
            xtype: 'button',
            text: '<<<Добавить>>>',
            style: {
                //                marginTop: '1px',
                marginLeft: '7px'
            },
            bodyStyle: 'align:center',
            listeners: {
                click: function() {
                    //alert(isForm.getForm().findField('newPT').getValue());
                    if(unitsForm.getForm().isValid()){
                        //addProductType(ptForm.getForm().findField('newPT').getValue());
                        Ajax.addUnit(unitsForm.getForm().findField('newUnit').getValue(), function(data) {
                            if(data=="Already Exist"){
                                Ext.Msg.show({
                                    title: 'Дубль!!!',
                                    msg: 'Такая уже есть...',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            } else if(data=="Empty"){
                                Ext.Msg.show({
                                    title: 'Предупреждение!',
                                    msg: 'Одини пробелы и/или цифры в названии Единицы измерения...',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                            else {
                                Ext.Msg.show({
                                    title: 'Выполненно!',
                                    msg: 'Единица измерения добавлена.',
                                    buttons: Ext.MessageBox.OK,
                                    width: 300,
                                    icon: Ext.MessageBox.INFO
                                });
                            }
                        });
                    }
                    else{
                        Ext.Msg.show({
                            title: 'Предупреждение!',
                            msg: 'Укажите название Единицы измерения!',
                            buttons: Ext.MessageBox.OK,
                            width: 300,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
            }
        },{
            html:'<h1>Залить Единицы измерения файлом:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'fileuploadfield',
            width:350,
            id: 'UnitsFile',
            emptyText: 'Выберите файл...',
            style: {
                marginTop: '0px',
                marginBottom: '0px'
            },
            buttonText: 'Выбрать'
        //        buttonCfg: {
        //            iconCls: 'upload-icon'
        //        }
        },{
            xtype: 'button',
            text: '<<<Запуск>>>',
            id:'UnitsUploadBtn',
            style: {
                marginLeft: '5px',
                marginRight: '5px'
            },
            listeners: {
                click: function() {
                    var file = dwr.util.getValue('UnitsFile-file');
                    Ajax.updateUnitsByFile(file, Ext.getCmp('UnitsFile').getValue(), function(data) {
                        Ext.getCmp('UnitsFile').reset();
                        if(data=="!csv"){
                            Ext.Msg.show({
                                title:'Неверный формат файла...',
                                msg: 'Верный смотри в инфо...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else{
                            Ext.Msg.show({
                                title:'Выполненно!',
                                msg: 'Файл залит.',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.INFO
                            });
                        //storePts.load();
                        }
                    });
                // alert("Ушло");

                }
            }
        }]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    },{
        bodyStyle: 'padding:7px;',
        //layout:'column',
        //      columns: [100, 1000],
        //        horisontal: true,
        items: [
        {
            bodyStyle: 'border:0px;',
            layout:'column',
            items: [
            unitsMulti,
            unitsMultiAlt
            ]
        }
        ]
    }]
});


var storeAtr2ProdTypeProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeAtr2ProdType = new Ext.data.Store({
    proxy: storeAtr2ProdTypeProxy,
    reader: new Ext.data.XmlReader({
        record: 'Attribute',
        id: 'Id'
    }, [
    {
        name: 'atr',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeAtrAllProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeAtrAll = new Ext.data.Store({
    proxy: storeAtrAllProxy,
    reader: new Ext.data.XmlReader({
        record: 'Attribute',
        id: 'Id'
    }, [
    {
        name: 'atr',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var comboPts = new Ext.form.ComboBox({
    store: storePts,
    hideLabel: true,
    displayField:'pt',
    valueField: 'id',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите PT...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        'select': function(){
            storePT2GroupeProxy.setUrl("Service.exml?request=groupes/ptId=" + comboPts.getValue());
            storePT2Groupe.clearData();
            storePT2Groupe.load();
        }
    }
});


var Atr2PTForm = new Ext.form.FormPanel({
    title: 'Привязка ПТ к атрибутам',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [{
            html:'<h1>Продукт тип:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px'
            },
            bodyStyle: 'border: 0px'
        },
        comboPts]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    },{
        bodyStyle: 'padding:7px;',
        items: [{
            xtype: 'itemselector',
            name: 'itemselector',
            //fieldLabel: 'ItemSelector',
            //labelWidth:'0',
            hideLabel: true,
            bodyStyle: 'padding:0px;',
            imagePath: 'images/ux',
            //            fromLegend:'Возможно',
            //            toLegend:'Привязано',
            multiselects: [{
                width: 400,
                height: 500,
                store: storeAtrAll,
                displayField: 'atr',
                valueField: 'id',
                tbar:[{
                    text: 'Загрузить Атрибуты',
                    handler:function(){
                        storeAtrAllProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('atrTemplate').getValue());
                        storeAtrAll.clearData();
                        storeAtrAll.load();
                    }
                },{
                    xtype: 'textfield',
                    hideLabel: true,
                    height:22,
                    id:'atrTemplate',
                    blankText:'Введите что-нибудь...',
                    allowBlank:true,
                    style: {
                        marginTop: '1px'
                    },
                    listeners: {
                        specialkey: function(something,e){
                            if (e.getKey() == e.ENTER) {
                                storeAtrAllProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('atrTemplate').getValue());
                                storeAtrAll.clearData();
                                storeAtrAll.load();
                            }
                        }
                    }
                },{
                    text: 'Загрузить файл со связками',
                    handler:function(){
                        Ajax.downloadAtr2PtData(function(data) {
                            dwr.engine.openInDownload(data);
                        });
                    }
                }
                ]
            },{
                width: 400,
                height: 500,
                store: storeAtr2ProdType,
                displayField: 'atr',
                valueField: 'id',
                tbar:[{
                    text: 'Сохранить связи Атрибуты - ПТ',
                    handler:function(){
                        if(comboPts.getValue()==null||comboPts.getValue()==""){
                            Ext.Msg.show({
                                title:'Внимание!',
                                msg: 'Выберите ПТ',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                            return;
                        }
                        if(Atr2PTForm.getForm().findField('itemselector').getValue()==null||
                            Atr2PTForm.getForm().findField('itemselector').getValue()==""){
                            Ext.MessageBox.buttonText.yes = "ага";
                            Ext.MessageBox.buttonText.no = "нах";
                            Ext.Msg.show({
                                title:'Подтверждение!',
                                msg: 'Точно сохранить? А то поле атрибутов пустое...',
                                buttons: Ext.Msg.YESNO,
                                fn: function(btn){
                                    if (btn == 'yes'){
                                        Ajax.addAtr2Pt(comboPts.getValue(), Atr2PTForm.getForm().findField('itemselector').getValue(), function(data) {
                                            Ext.Msg.show({
                                                title:'Выполненно!',
                                                msg: 'Связки сохранены.',
                                                buttons: Ext.Msg.OK,
                                                width:250,
                                                icon: Ext.MessageBox.INFO
                                            });

                                        });
                                    }
                                },
                                icon: Ext.MessageBox.QUESTION
                            });
                        } else{
                            Ajax.addAtr2Pt(comboPts.getValue(), Atr2PTForm.getForm().findField('itemselector').getValue(), function(data) {
                                Ext.Msg.show({
                                    title:'Выполненно!',
                                    msg: 'Связки сохранены.',
                                    buttons: Ext.Msg.OK,
                                    width:250,
                                    icon: Ext.MessageBox.INFO
                                });

                            });
                        }
                    }
                }]
            }]
        // }]
        }]
    }]
//    ,
//
//    buttons: [{
//        text: 'Save',
//        handler: function(){
//            if(Atr2PTForm.getForm().isValid()){
//                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
//                    Atr2PTForm.getForm().getValues(true));
//            }
//        }
//    }]
});


var storePT2GroupeProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storePT2Groupe = new Ext.data.Store({
    proxy: storePT2GroupeProxy,
    reader: new Ext.data.XmlReader({
        record: 'Groupe',
        id: 'Id'
    }, [
    {
        name: 'groupe',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

var storeGroupeAllProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeGroupeAll = new Ext.data.Store({
    proxy: storeGroupeAllProxy,
    reader: new Ext.data.XmlReader({
        record: 'Groupe',
        id: 'Id'
    }, [
    {
        name: 'groupe',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});




var PT2GroupeForm = new Ext.form.FormPanel({
    title: 'Привязка Групп к Продукт типам',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [{
            html:'<h1>Product Type:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px'
            },
            bodyStyle: 'border: 0px'
        },
        comboPts]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    },{
        bodyStyle: 'padding:7px;',
        items: [{
            xtype: 'itemselector',
            name: 'itemselector',
            //fieldLabel: 'ItemSelector',
            //labelWidth:'0',
            hideLabel: true,
            bodyStyle: 'padding:0px;',
            imagePath: 'images/ux',
            //            fromLegend:'Возможно',
            //            toLegend:'Привязано',
            multiselects: [{
                width: 400,
                height: 500,
                store: storeGroupeAll,
                displayField: 'groupe',
                valueField: 'id',
                tbar:[{
                    xtype: 'textfield',
                    hideLabel: true,
                    height:22,
                    id:'groupeTemplate',
                    blankText:'Введите что-нибудь...',
                    allowBlank:true,
                    style: {
                        marginTop: '1px'
                    },
                    listeners: {
                        specialkey: function(something,e){
                            if (e.getKey() == e.ENTER) {
                                storeGroupeAllProxy.setUrl("Service.exml?request=groupes/template=" + Ext.getCmp('groupeTemplate').getValue());
                                storeGroupeAll.clearData();
                                storeGroupeAll.load();
                            }
                        }
                    }
                },{
                    text: 'Загрузить Группы',
                    handler:function(){
                        storeGroupeAllProxy.setUrl("Service.exml?request=groupes/template=" + Ext.getCmp('groupeTemplate').getValue());
                        storeGroupeAll.clearData();
                        storeGroupeAll.load();
                    }
                },{
                    text: 'Загрузить файл со связками ПТ->Группа',
                    handler:function(){
                        Ajax.downloadPt2GroupeData(function(data) {
                            dwr.engine.openInDownload(data);
                        });
                    }
                },{
                    text: 'Загрузить файл со связками ПТ->Группа->Атрибут',
                    handler:function(){
                        Ajax.downloadPt2Groupe2AttributeData(function(data) {
                            dwr.engine.openInDownload(data);
                        });
                    }
                }
                ]
            },{
                width: 400,
                height: 500,
                store: storePT2Groupe,
                displayField: 'groupe',
                valueField: 'id',
                tbar:[{
                    text: 'Сохранить связи ПТ - Группы',
                    handler:function(){
                        if(comboPts.getValue()==null||comboPts.getValue()==""){
                            Ext.Msg.show({
                                title:'Внимание!',
                                msg: 'Выберите ПТ',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                            return;
                        }
                        if(PT2GroupeForm.getForm().findField('itemselector').getValue()==null||
                            PT2GroupeForm.getForm().findField('itemselector').getValue()==""){
                            Ext.MessageBox.buttonText.yes = "ага";
                            Ext.MessageBox.buttonText.no = "нах";
                            Ext.Msg.show({
                                title:'Подтверждение!',
                                msg: 'Точно сохранить? А то поле Групп пустое...',
                                buttons: Ext.Msg.YESNO,
                                fn: function(btn){
                                    if (btn == 'yes'){
                                        Ajax.addPt2Groupe(comboPts.getValue(), PT2GroupeForm.getForm().findField('itemselector').getValue(), function(data) {
                                            Ext.Msg.show({
                                                title:'Выполненно!',
                                                msg: 'Связки сохранены.',
                                                buttons: Ext.Msg.OK,
                                                width:250,
                                                icon: Ext.MessageBox.INFO
                                            });
                                            updateAtrsToOutExternal();
                                        });
                                    }
                                },
                                icon: Ext.MessageBox.QUESTION
                            });
                        } else {
                            Ajax.addPt2Groupe(comboPts.getValue(), PT2GroupeForm.getForm().findField('itemselector').getValue(), function(data) {
                                Ext.Msg.show({
                                    title:'Выполненно!',
                                    msg: 'Связки сохранены.',
                                    buttons: Ext.Msg.OK,
                                    width:250,
                                    icon: Ext.MessageBox.INFO
                                });
                                updateAtrsToOutExternal();
                            });
                        }
                    }
                }]
            }]
        // }]
        }]
    }]
//    ,
//
//    buttons: [{
//        text: 'Save',
//        handler: function(){
//            if(Atr2PTForm.getForm().isValid()){
//                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
//                    Atr2PTForm.getForm().getValues(true));
//            }
//        }
//    }]
});



var storeGroupe2AtrProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeGroupe2Atr = new Ext.data.Store({
    proxy: storeGroupe2AtrProxy,
    reader: new Ext.data.XmlReader({
        record: 'Attribute',
        id: 'Id'
    }, [
    {
        name: 'atr',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});

//var storeAtrAllProxy = new Ext.data.HttpProxy({
//    url:    'someURL',
//    method: 'GET'
//})
//
//var storeAtrAll = new Ext.data.Store({
//    proxy: storeAtrAllProxy,
//    reader: new Ext.data.XmlReader({
//        record: 'Attribute',
//        id: 'Id'
//    }, [
//    {
//        name: 'atr',
//        mapping: 'Name'
//    }, {
//        name:'id',
//        mapping:'Id'
//    }
//    ])
//});

var storeGroupesProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})
var storeGroupes = new Ext.data.Store({
    proxy: storeGroupesProxy,
    //    url: 'Service.exml?request=groupes',
    reader: new Ext.data.XmlReader({
        record: 'Groupe',
        id: 'Id'
    }, [
    {
        name: 'groupe',
        mapping: 'Name'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});


var comboGroupes = new Ext.form.ComboBox({
    store: storeGroupes,
    hideLabel: true,
    displayField:'groupe',
    valueField: 'id',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите группу...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        'select': function(){
        
            storeGroupe2AtrProxy.setUrl("Service.exml?request=attrs/grpId="+ comboGroupes.getValue());
            storeGroupe2Atr.clearData();
            storeGroupe2Atr.load();
        },
        'beforequery': function(){
            if(comboPtsNew.getValue()==''||comboPtsNew.getValue()==null){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Выберите ПТ',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            } else {
                storeGroupesProxy.setUrl("Service.exml?request=groupes/ptId="+ comboPtsNew.getValue());
                storeGroupes.removeAll();
                storeGroupes.load();
            }
        }
    //        ,
    //        'collapse': function() {
    //            storeGroupes.clearData();
    //            storeGroupesProxy.setUrl("Service.exml?request=groupes/ptId="+ comboPtsNew.getValue());
    //           storeGroupes.clearData();
    //            if(storeGroupes.getCount()!=0){
    //                storeGroupes.clearData();
    //                storeGroupes.reload();
    //            }
    //        }
    }
});

var comboPtsNew = new Ext.form.ComboBox({
    store: storePts,
    hideLabel: true,
    displayField:'pt',
    valueField: 'id',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите PT...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
//        'select': function(){
//            storeGroupes.removeAll();
//            storeGroupesProxy.setUrl("Service.exml?request=groupes/ptId="+ comboPtsNew.getValue());
//            //storeGroupes.clearData();
//            if(storeGroupes.getCount()!=0){
//                storeGroupes.removeAll();
//                storeGroupes.load();
//            }
//        //storeGroupes.reload();
//        }
}
});


var Grp2AtrForm = new Ext.form.FormPanel({
    title: 'Привязка Групп к атрибутам',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        //        bodyStyle: 'padding:7px;',
        items: [{
            layout:'column',
            bodyStyle: 'padding:7px;border:0;',
            items: [{
                html:'<h1>Продукт тип:</h1>',
                style: {
                    marginTop: '3px',
                    marginRight: '7px'
                },
                bodyStyle: 'border: 0px'
            },
            comboPtsNew]
        },{
            layout:'column',
            bodyStyle: 'padding:7px;border:0;',
            items: [{
                html:'<h1>Группа:</h1>',
                style: {
                    marginTop: '3px',
                    marginRight: '7px'
                },
                bodyStyle: 'border: 0px'
            },
            comboGroupes]
        }]
    },{
        html:'&nbsp;',
        bodyStyle: 'border: 0px'
    },{
        bodyStyle: 'padding:7px;',
        layout:'column',
        items: [{
            xtype: 'itemselector',
            name: 'itemselector',
            //fieldLabel: 'ItemSelector',
            //labelWidth:'0',
            hideLabel: true,
            bodyStyle: 'padding:0px;',
            imagePath: 'images/ux',
            //            fromLegend:'Возможно',
            //            toLegend:'Привязано',
            multiselects: [{
                width: 300,
                height: 300,
                id: 'multiG2AAvail',
                store: storeAtrAll,
                displayField: 'atr',
                valueField: 'id',
                tbar:[{
                    text: 'Загрузить Атрибуты',
                    handler:function(){
                        storeAtrAllProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('atrTemplate').getValue());
                        storeAtrAll.clearData();
                        storeAtrAll.load();
                    }
                },{
                    xtype: 'textfield',
                    hideLabel: true,
                    height:22,
                    id:'atrTemplate',
                    blankText:'Введите что-нибудь...',
                    allowBlank:true,
                    style: {
                        marginTop: '1px'
                    },
                    listeners: {
                        specialkey: function(something,e){
                            if (e.getKey() == e.ENTER) {
                                storeAtrAllProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('atrTemplate').getValue());
                                storeAtrAll.clearData();
                                storeAtrAll.load();
                            }
                        }
                    }
                },{
                    text: 'Загрузить файл со связками Группа->Атрибут',
                    handler:function(){
                        Ajax.downloadGroupe2AttrData(function(data) {
                            dwr.engine.openInDownload(data);
                        });
                    }
                }
                ]
            },{
                width: 350,
                height: 300,
                store: storeGroupe2Atr,
                id: 'multiG2ASel',
                displayField: 'atr',
                valueField: 'id',
                listeners: {
                    click: function(){
                        storeAtrProxyAlt.setUrl("AttributeAltName?attribute="+ Ext.getCmp('multiG2ASel').getValue()+"&groupe="+comboGroupes.getValue());
                        storeAtrAlt.clearData();
                        storeAtrAlt.load();
                    }
                },
                tbar:[{
                    text: 'Сохранить связи',
                    handler:function saveG2A(){
                        if(comboGroupes.getValue()==null||comboGroupes.getValue()==""){
                            Ext.Msg.show({
                                title:'Внимание!',
                                msg: 'Выберите группу...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                            return;
                        }
                        if(Grp2AtrForm.getForm().findField('itemselector').getValue()==null||
                            Grp2AtrForm.getForm().findField('itemselector').getValue()==""){
                            Ext.MessageBox.buttonText.yes = "ага";
                            Ext.MessageBox.buttonText.no = "нах";
                            Ext.Msg.show({
                                title:'Подтверждение!',
                                msg: 'Точно сохранить? А то поле атрибутов пустое...',
                                buttons: Ext.Msg.YESNO,
                                fn: function(btn){
                                    if (btn == 'yes'){
                                        Ajax.addGroupe2Attr(comboGroupes.getValue(), Grp2AtrForm.getForm().findField('itemselector').getValue(), function(data) {
                                            storeGroupe2AtrProxy.setUrl("Service.exml?request=attrs/grpId="+ comboGroupes.getValue());
                                            storeGroupe2Atr.clearData();
                                            storeGroupe2Atr.load();
                                            Ext.Msg.show({
                                                title:'Выполненно!',
                                                msg: 'Связки сохранены.',
                                                buttons: Ext.Msg.OK,
                                                width:250,
                                                icon: Ext.MessageBox.INFO
                                            });

                                        });
                                        updateAtrsToOutExternal();
                                        
                                    }
                                },
                                icon: Ext.MessageBox.QUESTION
                            });
                        } else{
                            Ajax.addGroupe2Attr(comboGroupes.getValue(), Grp2AtrForm.getForm().findField('itemselector').getValue(), function(data) {
                                storeGroupe2AtrProxy.setUrl("Service.exml?request=attrs/grpId="+ comboGroupes.getValue());
                                storeGroupe2Atr.clearData();
                                storeGroupe2Atr.load();
                                Ext.Msg.show({
                                    title:'Выполненно!',
                                    msg: 'Связки сохранены.',
                                    buttons: Ext.Msg.OK,
                                    width:250,
                                    icon: Ext.MessageBox.INFO
                                });
                                updateAtrsToOutExternal();
                                
                            });
                        }
                    }
                },{
                    text: 'Composite',
                    handler:function(){
                        if(comboGroupes.getValue()==null||comboGroupes.getValue()==""||Ext.getCmp('multiG2ASel').getValue()==null||
                            Ext.getCmp('multiG2ASel').getValue()==""){
                            Ext.Msg.show({
                                title:'Внимание!',
                                msg: 'Выберите группу и атрибут...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                            return;
                        }
                        Ajax.updateComposite(Ext.getCmp('multiG2ASel').getValue(), comboGroupes.getValue(), function(data) {
                            storeGroupe2AtrProxy.setUrl("Service.exml?request=attrs/grpId="+ comboGroupes.getValue());
                            storeGroupe2Atr.clearData();
                            storeGroupe2Atr.load();
                        });
                    //                        updateAtrsToOutExternal();
                    }
                }]
            }]
        // }]
        },
        atrMultiAlt,
        atrRegexp
        ]
    }
    ]

//    ,
//
//    buttons: [{
//        text: 'Save',
//        handler: function(){
//            if(Atr2PTForm.getForm().isValid()){
//                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
//                    Atr2PTForm.getForm().getValues(true));
//            }
//        }
//    }]
});






var fileGrabliInput = new Ext.ux.form.FileUploadField({
    width:350,
    id: 'fileGrabliFile',
    emptyText: 'Выберите файл...',
    style: {
        marginTop: '0px',
        marginBottom: '0px'
    },
    buttonText: 'Выбрать'
});

var storeCsvDataProxy = new Ext.data.HttpProxy({
    url:    'someURL',
    method: 'GET'
})

var storeCsvData = new Ext.data.Store({
    //url: 'GrabliData?fileId=123456789',
    proxy:storeCsvDataProxy,
    reader: new Ext.data.XmlReader({
        // records will have an "Item" tag
        record: 'Csv',
        id: 'article'
    }, [{
        name: 'article',
        mapping: 'article'
    }, {
        name:'description',
        mapping:'description'
    }, {
        name:'pt',
        mapping:'pt'
    }, {
        name:'url',
        mapping:'url'
    }])
});

var storeCsvColumnData = new Ext.data.Store({
    url: 'GrabliCsvColumnData',
    reader: new Ext.data.XmlReader({
        // records will have an "Item" tag
        record: 'entry',
        id: 'int'
    }, [{
        name: 'int',
        mapping: 'int'
    }, {
        name:'string',
        mapping:'string'
    }])
});

var comboCsvColumnData1 = new Ext.form.ComboBox({
    store: storeCsvColumnData,
    hideLabel: true,
    displayField:'string',
    valueField: 'int',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите тип...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        'select': function(){
        //            storeAtr2ProdTypeProxy.setUrl("Attribute.exml?ptId="+ comboPts.getValue());
        //            storeAtr2ProdType.clearData();
        //            storeAtr2ProdType.load();
        }
    }
});
var comboCsvColumnData2 = new Ext.form.ComboBox({
    store: storeCsvColumnData,
    hideLabel: true,
    displayField:'string',
    valueField: 'int',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите тип...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:300,
    listeners: {
        'select': function(){
        //            storeAtr2ProdTypeProxy.setUrl("Attribute.exml?ptId="+ comboPts.getValue());
        //            storeAtr2ProdType.clearData();
        //            storeAtr2ProdType.load();
        }
    }
});
var comboCsvColumnData3 = new Ext.form.ComboBox({
    store: storeCsvColumnData,
    hideLabel: true,
    displayField:'string',
    valueField: 'int',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите тип...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        'select': function(){
        //            storeAtr2ProdTypeProxy.setUrl("Attribute.exml?ptId="+ comboPts.getValue());
        //            storeAtr2ProdType.clearData();
        //            storeAtr2ProdType.load();
        }
    }
});

var comboCsvColumnData4 = new Ext.form.ComboBox({
    store: storeCsvColumnData,
    hideLabel: true,
    displayField:'string',
    valueField: 'int',
    typeAhead: true,
    mode: 'local',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Выберите тип...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        'select': function(){
        //            storeAtr2ProdTypeProxy.setUrl("Attribute.exml?ptId="+ comboPts.getValue());
        //            storeAtr2ProdType.clearData();
        //            storeAtr2ProdType.load();
        }
    }
});

var grid = new Ext.grid.GridPanel({
    store: storeCsvData,
    tbar : [comboCsvColumnData1,
    comboCsvColumnData2,
    comboCsvColumnData3,
    comboCsvColumnData4],
    columns: [
    {
        header: "",
        width: 200,
        dataIndex: 'article',
        sortable: true
    },

    {
        header: "",
        width: 300,
        dataIndex: 'description',
        sortable: true
    },

    {
        header: "",
        width: 200,
        dataIndex: 'pt',
        sortable: true
    },

    {
        header: "",
        width: 200,
        dataIndex: 'url',
        sortable: true
    }
    ],
    headerAsText: true,
    //hidden: true,
    hideHeaders:true,
    //renderTo:'example-grid',
    width:'100%',
    height:200,
    style: {
//        marginTop: '3px'
}
});


var grabliFile = new Ext.form.FormPanel({
    title: 'Файл для заливки данных',
    width: '100%',
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    items: [{
        layout:'column',
        bodyStyle: 'padding:7px;',
        items: [fileGrabliInput,
        {
            xtype: 'button',
            text: '<<<Запуск обработки файла>>>',
            id:'fileGrabliInputBtn',
            style: {
                marginLeft: '5px'
            },
            listeners: {
                click: function() {
                    var file2 = dwr.util.getValue('fileGrabliFile-file');
                    Ajax.uploadGrabliFile(file2, Ext.getCmp('fileGrabliFile').getValue(), Ext.getCmp('proxyBool').getValue(), Ext.getCmp('proxyIP').getValue(), function(data) {
                        Ext.getCmp('fileGrabliFile').reset();
                        if(data==null){
                            Ext.Msg.show({
                                title:'Неверный формат файла...',
                                msg: 'Верный смотри в инфо...',
                                buttons: Ext.Msg.OK,
                                width:250,
                                icon: Ext.MessageBox.ERROR
                            });
                        } else {
                            //                            storeCsvDataProxy.setUrl("GrabliData?fileId=" + data);
                            //                            storeCsvData.clearData();
                            //                            storeCsvData.load();
                            //                            comboCsvColumnData1.setValue("1");
                            //                            comboCsvColumnData2.setValue("2");
                            //                            comboCsvColumnData3.setValue("3");
                            //                            comboCsvColumnData4.setValue("4");
                            //                            grabliGrid.getEl().fadeIn({
                            //                                duration: 2
                            //                            });
                            //                            grabliGrid.show();
                            //                            Ext.getCmp('SessionId').setValue(data);
                            Ext.getCmp('SessionIdUp').setValue(data);
                            grabliPBar.getEl().fadeIn({
                                duration: 1.5
                            });
                        //                            Ajax.processGrabli(function(data) {
                        //                                //dwr.engine.openInDownload(data);
                        //                                });
                        //                            grabliPBar.show();
                        }
                    });
                //                    Ajax.getSessionId(function(data) {
                //                        Ext.getCmp('SessionId').setValue(data);
                //                    });
                }
            }
        }
        //        ,{
        //            html:'<h1>Сессия:</h1>',
        //            style: {
        //                marginTop: '3px',
        //                marginRight: '7px',
        //                marginLeft: '7px'
        //            },
        //            bodyStyle: 'border: 0px'
        //        },{
        //            xtype: 'textfield',
        //            hideLabel: true,
        //            height:22,
        //            width:190,
        //            id:'SessionId',
        //            blankText:'Id Сессии...',
        //            allowBlank:true,
        //            style: {
        //        // marginTop: '1px'
        //        }
        //        }
        ,{
            html:'<h1>Использовать Proxy:</h1>',
            style: {
                marginTop: '3px',
                marginRight: '7px',
                marginLeft: '7px'
            },
            bodyStyle: 'border: 0px'
        },{
            xtype: 'checkbox',
            //        height:25,
            checked: true,
            id:'proxyBool',
            //        blankText:'Введите что-нибудь...',
            //        allowBlank:false,
            style: {
                marginTop: '3px'
                
            },
            handler:function(){
                if(Ext.getCmp('proxyBool').getValue()){
                    Ext.getCmp('proxyIP').setDisabled(false);
                } else{
                    Ext.getCmp('proxyIP').setDisabled(true);
                    Ext.getCmp('proxyIP').setValue('');
                }
            }


        }, {
            xtype: 'textfield',
            height:22,
            width:190,
            id:'proxyIP',
            blankText:'Введите что-нибудь...',
            allowBlank:true,
            style: {
                marginLeft: '7px'
            }

        }]
    }]
});

var grabliGrid = new Ext.form.FormPanel({
    title: 'Разбор данных входного файла',
    width: '100%',
    id:'grabliGrid',
    //disabled: true,
    // hidden: true,
    animCollapse:true,
    //height:400,
    //bodyStyle: 'padding:10px;',
    bodyStyle: 'padding:7px;',
    //    items:[{
    //        style: {
    //            padding: '10px auto'
    //        },
    //layout:'column',
    style: {
        marginTop: '3px'
    },
    items: [grid],
    buttons: [{
        text: 'Сохранить и запустить',
        handler: function(){
            //            alert(comboCsvColumnData1.getValue() + " "
            //                +comboCsvColumnData2.getValue() + " "
            //                +comboCsvColumnData3.getValue() + " "
            //                +comboCsvColumnData4.getValue());
            grabliPBar.getEl().fadeIn({
                duration: 1.5
            });
            //            Ajax.processGrabli(function(data) {
            //                //dwr.engine.openInDownload(data);
            //                });
            grabliPBar.show();
        //            if(Atr2PTForm.getForm().isValid()){
        //                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
        //                    Atr2PTForm.getForm().getValues(true));
        //            }
        }
    }]
});

var grabliPBarOutside = new Ext.ProgressBar({
    text:'Ready',
    xtype: 'progress',
    animate:true,
    style: {
        width: '100%',
        margin: '0px auto',
        border:'0px'
    }
});

var grabliPBar = new Ext.form.FormPanel({
    title: 'Обработка...',
    width: '100%',
    style: {
        marginTop: '3px'
    },
    items: [grabliPBarOutside]
});


function getPtAltName(id){
    Ajax.getProductTypeAltName(id, function(data) {
        if(data=="MultiSelectInRequest"){
            ptField.setValue("");
            Ext.Msg.show({
                title: 'Предупреждение!!!',
                msg: 'Выбирайте только одно значение!',
                buttons: Ext.MessageBox.OK,
                width: 300,
                icon: Ext.MessageBox.ERROR
            });
        } else {
            ptField.setValue(data);
        }
    });
}



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

//function matchData(file, filename){
//    Ajax.matchData(file, filename, function(data) {
//        dwr.engine.openInDownload(data);
//    });
//
//}






var article='Just4Article';
var pt;
var groupe;
var attribut;

var storeAtrsProxyToOut = new Ext.data.HttpProxy({
    url:    'some url',
    method: 'GET'
})


var storeAtrsToOut = new Ext.data.Store({
    proxy: storeAtrsProxyToOut,
    reader: new Ext.data.XmlReader({
        record: 'Attribute',
        id: 'Id'
    }, [
    {
        name: 'atr',
        mapping: 'Name'
    },{
        name: 'groupe',
        mapping: 'Groupe'
    }, {
        name:'id',
        mapping:'Id'
    }
    ])
});
var checkColumn = new Ext.grid.CheckColumn({
    header: 'Active',
    dataIndex: 'available',
    width: 5
});

var comboAtrsToOut = new Ext.form.ComboBox({
    store: storeAtrsToOut,
    displayField:'atr',
    valueField: 'atr',
    typeAhead: true,
    mode: 'local',
    forceSelection: true,
    triggerAction: 'all',
    //emptyText:'Выберите автора...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:200,
    listeners: {
        beforequery : function updateAtrsToOut(){
            if(article!=gridToOut.getSelectionModel().selection.record.data.article){
                pt = gridToOut.getSelectionModel().selection.record.data.pt;
                storeAtrsProxyToOut.setUrl("Service.exml?request=attributes/productType="+pt);
                article=gridToOut.getSelectionModel().selection.record.data.article;
                storeAtrsToOut.clearData();
                storeAtrsToOut.load();
            }
        },
        select : function(combo, record, index){
            superGroupe = record.get('groupe');
        }
    },
    tpl: new Ext.XTemplate(
        '<tpl for=".">',
        '<tpl if="this.groupe != values.groupe">',
        '<tpl exec="this.groupe = values.groupe"></tpl>',
        '<h1>{groupe}</h1>',
        '</tpl>',
        '<div class="x-combo-list-item">{atr}</div>',
        '</tpl>'
        )
});

function updateAtrsToOutExternal(){
    article='|||!!!|||!!!|||';
    updateAtrsToOut();
}

var comboRegexpTypes = new Ext.form.ComboBox({
    store: storeRegexpTypes,
    displayField:'regexpType',
    valueField: 'regexpType',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    //emptyText:'Выберите автора...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:20
//    listeners: {
//        beforequery : function test(){
//            if(article!=gridToOut.getSelectionModel().selection.record.data.article){
//                pt = gridToOut.getSelectionModel().selection.record.data.pt;
//                storeAtrsProxyToOut.setUrl("Service.exml?request=attributes/productType="+pt);
//                article=gridToOut.getSelectionModel().selection.record.data.article;
//                storeAtrsToOut.clearData();
//                storeAtrsToOut.load();
//            }
//        }
//    }
});

var outputDataStoreProxy = new Ext.data.HttpProxy({
    url:    'some url',
    method: 'GET'
})

var outputDataStore = new Ext.data.GroupingStore({
    //url: 'data/Owners.xml',
    proxy : outputDataStoreProxy,
    sortInfo:{
        field: 'article',
        direction: "ASC"
    },
    //    listners:{
    //
    //    },
    groupField:'article',
    //url: 'Service.exml?request=outputData',
    reader: new Ext.data.XmlReader({
        record: 'Article',
        id: 'Id',
        fields:[
        {
            name: 'id',
            mapping: 'Id'
        },{
            name: 'sessionId',
            mapping: 'Sid'
        },{
            name: 'article',
            mapping: 'Name'
        }, {
            name:'pt',
            mapping:'PT',
            type: 'string'
        }, {
            name:'groupe',
            mapping:'Groupe'
        }, {
            name:'attribute',
            mapping:'Attribute'
        }, {
            name:'value',
            mapping:'Value'
        }, {
            name:'unit',
            mapping:'Unit'
        }, {
            name:'available',
            mapping:'Available',
            type: 'bool'
        }, {
            name:'oldAttribute',
            mapping:'oldAttribute'
        }, {
            name:'composite',
            mapping:'composite'
        }, {
            name:'weight',
            mapping:'weight'
        }
        ]
    })
});




var cm = new Ext.grid.ColumnModel({
    // specify any defaults for each column
    defaults: {
        sortable: true // columns are not sortable by default,
    },
    columns: [
    {
        //id:'article',
        header: "Article",
        width: 7,
        sortable: true,
        dataIndex: 'article'

    },
    {
        header: "Product Type",
        width: 10,
        sortable: true,
        editable: true,
        dataIndex: 'pt'
    },
    {
        header: "Groupe",
        width: 20,
        sortable: true,
        dataIndex: 'groupe'
    },
    {
        header: "Attribute",
        width: 20,
        sortable: true,
        dataIndex: 'attribute',
        editor: comboAtrsToOut
    },{
        header: "Composite",
        width: 6,
        sortable: true,
        dataIndex: 'composite'
    },

    {
        header: "Value",
        width: 30,
        sortable: true,
        dataIndex: 'value',
        editor: new fm.TextField({
            allowBlank: false
        })
    },
    {
        header: "Unit",
        width: 10,
        sortable: true,
        dataIndex: 'unit',
        editor: new fm.TextField({
            allowBlank: false
        })
    },
    checkColumn,
    {
        header: "Old",
        width: 10,
        sortable: true,
        dataIndex: 'oldAttribute',
        editor: new fm.TextField({
            allowBlank: false
        })
    },
    {
        header: "Weight",
        width: 5,
        sortable: true,
        dataIndex: 'weight'
    }
    ]
});

function colorByPercentAvailable(row){
    var allCount = row.length;
    var count = 0;
    for(i=0; i < allCount; i++){
        if(row[i].data.available == true){
            count++;
        }
    }
    var percent = count * 100 / allCount;
    if(percent == 100){
        return '#00cc00'; //green
    } else if(percent>=60){
        return '#ff6600'; //orange
    } else{
        return '#ff0000'; //red
    }
}



var statusStore = new Ext.data.GroupingStore({
    url: 'data/Statuses.xml',
    reader: new Ext.data.XmlReader({
        record: 'Status',
        id: 'Id',
        fields:[
        {
            name: 'id',
            mapping: 'Id'
        },{
            name: 'status',
            mapping: 'Name'
        }]
    })
});

var comboStatus = new Ext.form.ComboBox({
    store: statusStore,
    disabled: true,
    displayField:'status',
    valueField: 'status',
    typeAhead: true,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText:'Status...',
    editable: false,
    style: {
        margin: '0px'
    },
    width:90
});

var gridToOut = new xg.EditorGridPanel({
    store: outputDataStore,
    id:'gridToOut',
    cm:cm,
    plugins: checkColumn,
    clicksToEdit: 2,
    view: new Ext.grid.GroupingView({
        forceFit:true,
        startCollapsed:true,
        groupTextTpl: '<p style="color:{[colorByPercentAvailable(values.rs)]}">{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})</p>',
        listeners:{
            rowupdated: function(view, firstRow, record){
                if(record.getChanges().attribute != 'undefined'
                    && record.getChanges().attribute != null){
                    Ajax.addAttributeAltNameByName(record.getChanges().attribute, superGroupe, tempValue, function(data) {
                        });
                }
                tempValue = record.get('id')
                + "|||"
                + record.get('sessionId')
                + "|||"
                + record.get('article')
                + "|||"
                + record.get('pt')
                + "|||"
                + record.get('groupe')
                + "|||"
                + record.get('attribute')
                + "|||"
                + record.get('value')
                + "|||"
                + record.get('unit')
                + "|||"
                + record.get('available');
            
                Ajax.updateOutputData(tempValue, function(data) {
                    });
                tempValue = "";
                superGroupe = "";
            }
        },
        getRowClass : function (row, index)
        {
            if (row.data.available == true) {
                return 'outputData-green';
            }
            return 'outputData-red';
        }
    }),
    frame:true,
    height: 500,
    collapsible: true,
    // collapsed: true,
    animCollapse: true,
    columnLines:true,
    title: 'Выходные данные',
    //renderTo: document.body,
    style: {
        marginTop: '3px'
    },
    listeners: {
        celldblclick:function(grid, rowIndex, columnIndex, e) {
            var record = grid.getStore().getAt(rowIndex);  // Get the Record
            var fieldName = grid.getColumnModel().getDataIndex(columnIndex); // Get field name
            tempValue = record.get(fieldName);
        }
    },
    buttons: [{
        text: 'Получить файл',
        //arrowAlign:'bottom',
        handler: function(){
            if(Ext.getCmp('SessionIdUp').getValue()==null||Ext.getCmp('SessionIdUp').getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Укажите сессию...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            var data="";
            if(Ext.getCmp('statusBool').getValue()){
                Ajax.updateDownloadData(Ext.getCmp('SessionIdUp').getValue(), data, comboStatus.getValue(), function(data) {
                    dwr.engine.openInDownload(data);
                });
            } else{
                Ajax.updateDownloadData(Ext.getCmp('SessionIdUp').getValue(), data, "NoStatus", function(data) {
                    dwr.engine.openInDownload(data);
                });
            }
        }
    }],


    tbar:[{
        xtype: 'textfield',
        hideLabel: true,
        height:22,
        id:'SessionIdUp',
        blankText:'Введите что-нибудь...',
        allowBlank:false,
        style: {
            marginTop: '1px'
        },
        listeners: {
            specialkey: function(something,e){
                if (e.getKey() == e.ENTER) {
                    outputDataStore.load();
                //                    storeAtrAllProxy.setUrl("Attribute.exml?template=" + Ext.getCmp('atrTemplate').getValue());
                //                    storeAtrAll.clearData();
                //                    storeAtrAll.load();
                }
            }
        }
    },
    {
        text: 'Загрузить данные Сессии',
        handler:function(){
            if(Ext.getCmp('SessionIdUp').getValue()==null||Ext.getCmp('SessionIdUp').getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Укажите сессию...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            outputDataStoreProxy.setUrl("Service.exml?request=outputData/sessionId=" + Ext.getCmp('SessionIdUp').getValue());
            outputDataStore.clearData();
            outputDataStore.load();
        }
    },
    {
        text: 'Обновить/Загрузить данные Сессии',
        handler:function(){
            if(Ext.getCmp('SessionIdUp').getValue()==null||Ext.getCmp('SessionIdUp').getValue()==""){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Укажите сессию...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            Ajax.processGrabli(Ext.getCmp('SessionIdUp').getValue(),function(data) {
                if(data=='Done'){
                    outputDataStoreProxy.setUrl("Service.exml?request=outputData/sessionId=" + Ext.getCmp('SessionIdUp').getValue());
                    outputDataStore.clearData();
                    outputDataStore.load();
                }
            });

        }
    }, {
        text: 'Сессии',
        handler:function(){
            sessionWin.show();
        }
    },{
        xtype: 'tbfill'
    },{
        text: 'Посмотреть значения',
        handler:function(){
            if(Ext.getCmp('SessionIdUp').getValue()==null||Ext.getCmp('SessionIdUp').getValue()==""||gridToOut.getSelectionModel().selection==null){
                Ext.Msg.show({
                    title:'Внимание!',
                    msg: 'Укажите сессию и атрибут...',
                    buttons: Ext.Msg.OK,
                    width:250,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            groupe = escape(gridToOut.getSelectionModel().selection.record.data.groupe);
            attribute = escape(gridToOut.getSelectionModel().selection.record.data.attribute);
            storeAtrPreviewProxy.setUrl("Service.exml?request=outputData/attributeValue="
                +attribute.replace("/","|||")
                +"/groupeValue="
                +groupe+
                "/regexpLimit="
                + Ext.getCmp('regexpLimit2').getValue()
                +"/session="
                + Ext.getCmp('SessionIdUp').getValue()
                +"/regexpPreview=before");
            storeAtrPreview.clearData();
            storeAtrPreview.load();
            atrPreviewWinAfter.show();
        }
    }

    ],
    bbar:[{
        xtype: 'tbfill'
    },{
        text:'<h1>Сменить статус:</h1>',
        style: {
            marginBottom: '3px',
            marginRight: '5px'
        },
        bodyStyle: 'border: 0px'
    },{
        xtype: 'checkbox',
        id:'statusBool',
        style: {
            marginBottom: '3px',
            marginRight: '6px'

        },
        handler:function(){
            if(Ext.getCmp('statusBool').getValue()){
                comboStatus.setDisabled(false);
                comboStatus.setValue("Done");
            } else{
                comboStatus.setDisabled(true);
            }
        }


    },
    comboStatus
    ]
});






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


function exportByProduct(data, langs, btn){
    btn.disable();
    byId('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.exportByProducts(data, langs, function(data) {
        byId('ulexpProdLog').innerHTML = data;
        btn.enable();
        comboLanguages.reset();
    });
}

function exportMarketing(data, btn){
    btn.disable();
    byId('ulexpMarkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.exportMarketing(data, function(data) {
        byId('ulexpMarkLog').innerHTML = data;
        btn.enable();
    });
}

function addLink(data, btn){
    btn.disable();
    byId('uladdLinkLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.addLink(data, function(data) {
        byId('uladdLinkLog').innerHTML = data;
        btn.enable();
    });
}

function addProductType(data){
    Ajax.addProductType(data, function(data) {
        if(data=="Already Exist"){
            storePts.clearData();
            storePts.load();
            Ext.Msg.show({
                title: 'Дубль!!!',
                msg: 'Такой ПТ уже есть...',
                buttons: Ext.MessageBox.OK,
                width: 300,
                icon: Ext.MessageBox.ERROR
            });
        } else if(data=="Empty"){
            Ext.Msg.show({
                title: 'Предупреждение!',
                msg: 'Одини пробелы и/или цифры в названии пт...',
                buttons: Ext.MessageBox.OK,
                width: 300,
                icon: Ext.MessageBox.ERROR
            });
        }
        else {
            storePts.clearData();
            storePts.load();
            Ext.Msg.show({
                title: 'Выполненно!',
                msg: 'ПТ добавлен.',
                buttons: Ext.MessageBox.OK,
                width: 300,
                icon: Ext.MessageBox.INFO
            });
        }
    });
}


function clearSession(){
    byId('uloptSesLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.clearSession(function(data) {
        byId('uloptSesLog').innerHTML = data;
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

function changeStatus(data, status, btn){
    btn.disable();
    byId('ulstatusChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.changeStatus(data, status, function(data) {
        byId('ulstatusChangeLog').innerHTML = data;
        btn.enable();
    });

}
function changeOwner(data, owner, btn){
    btn.disable();
    byId('ulownerChangeLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
    Ajax.changeOwner(data, owner, function(data) {
        byId('ulownerChangeLog').innerHTML = data;
        btn.enable();
    });
}

function showStatistics(){
    window.open("https://cf.value4it.com/cf/export/stat.jsp","", config="");
}
function sendMessage(message, nick) {
    if(nick==""||nick=="Введите ник..."||nick=="60511120540229999"){
        alert("Введите ник...");
        Ext.getCmp('chatNick').setValue("");
        return;
    }
    if(message==""||message==" "){
        return;
    }
    Ajax.addMessage(nick + ": " + message, function(data) {
        Ext.getCmp('chatData').setValue("");
    });
}
function updateMessage() {
    Ajax.updateMessage();
}

function updateNick() {
    Ajax.updateNick(function(data) {
        Ext.getCmp('chatNick').setValue(data);
    });
}

var RunnerGrabli = function(){
    return {
        run : function(grabliPBarOutside, allCount, count){
            grabliPBarOutside.updateProgress(count/allCount, 'Обрабатывается ' + count + ' из '+allCount+'...');
        }
    }
}();


function updateGrabli(allCount, count){
    RunnerGrabli.run(grabliPBarOutside, allCount, count);
    setTimeout(function(){
        if(allCount==count){
            grabliPBarOutside.reset();
            grabliPBarOutside.updateText("Готово");
        //            grabliPBar.getEl().fadeOut({
        //                duration: 1
        //            });
        //            gridToOut.getEl().fadeIn({
        //                duration: 2
        //            });
        //            gridToOut.show();
        }
    }, 500);
}


function updateProd(allCount, count){
    RunnerProd.run(Ext.getCmp('pbarProd'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            Ext.getCmp('pbarProd').reset();
            Ext.getCmp('pbarProd').updateText("Ready to Export");
        }
    }, 500);
}
var RunnerProd = function(){
    return {
        run : function(pbarProd, allCount, count){
            pbarProd.updateProgress(count/allCount, 'Export ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateMark(allCount, count){
    RunnerMar.run(Ext.getCmp('pbarMark'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            Ext.getCmp('pbarMark').reset();
            Ext.getCmp('pbarMark').updateText("Ready to Export Marketing");
        }
    }, 500);
}
var RunnerMar = function(){
    return {
        run : function(pbarMar, allCount, count){
            pbarMar.updateProgress(count/allCount, 'Export Marketing ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateStat(allCount, count){
    RunnerStat.run(Ext.getCmp('pbarStat'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            Ext.getCmp('pbarStat').reset();
            Ext.getCmp('pbarStat').updateText("Ready to change Status");
        }
    }, 500);
}
var RunnerStat = function(){
    return {
        run : function(pbarStat, allCount, count){
            pbarStat.updateProgress(count/allCount, 'Change Status ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateOwn(allCount, count){
    RunnerOwn.run(Ext.getCmp('pbarOwn'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            Ext.getCmp('pbarOwn').reset();
            Ext.getCmp('pbarOwn').updateText("Ready to change Owner");
        }
    }, 500);
}
var RunnerOwn = function(){
    return {
        run : function(pbarOwn, allCount, count){
            pbarOwn.updateProgress(count/allCount, 'Change Owner ' + count + ' in '+allCount+'...');
        }
    }
}();

function updateLink(allCount, count){
    RunnerLink.run(Ext.getCmp('pbarLink'), allCount, count);
    setTimeout(function(){
        if(allCount==count){
            Ext.getCmp('pbarLink').reset();
            Ext.getCmp('pbarLink').updateText("Ready to add Link");
        }
    }, 500);
}
var RunnerLink = function(){
    return {
        run : function(pbarLink, allCount, count){
            pbarLink.updateProgress(count/allCount, 'Add Link ' + count + ' in '+allCount+'...');
        }
    }
}();

var start = {
    id: 'start-panel',
    title: 'Стартовая страница',
    layout: 'fit',
    contentEl: 'start-div'
};

var value4export = {

    xtype: 'tabpanel',
    id: 'vExp-panel',
    plain: true,
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%'
    },
    items:[{
        title: 'Экспорт по продукту',
        //autoScroll: true,
        items:[{
            title: 'Экспорт',
            autoScroll: true,
            //            defaults: {
            //                bodyStyle: 'background-color:#e1e8ff;'
            //            },
            items: [
            {
                layout:'column',
                //                width: '100%',
                //                height: '100%',
                bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                buttonAlign: 'center',
                items: [{
                    bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                    items: [{
                        xtype: 'textarea',
                        fieldLabel: 'Message text',
                        width: 350,
                        height: 150,
                        hideLabel: true,
                        name: 'msg',
                        flex: 1,
                        id:'expArt'
                    }]
                },{
                    style: {
                        margin: '7px auto'
                    },

                    bodyStyle: 'padding:7px; border: 1px solid #B7C8D7; background-color:#E1E1E1;',

                    items: [
                    //                        {
                    //                        xtype: 'checkbox',
                    //                        style: {
                    //                            marginLeft: '100px'
                    //                        },
                    //                        boxLabel: 'ru/en language only...',
                    //                        id:'toogleBtn'
                    //                    }
                    comboLanguages,{
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
                                click: function() {
                                    Ext.MessageBox.buttonText.yes = "ага";
                                    Ext.MessageBox.buttonText.no = "нах";
                                    Ext.Msg.show({
                                        title:'Подтверждение!',
                                        msg: 'Запустить ЭКСПОРТ продуктов?',
                                        buttons: Ext.Msg.YESNO,
                                        fn: function(btn){
                                            if (btn == 'yes'){
                                                //                                                if(Ext.getCmp('toogleBtn').checked){
                                                //                                                    exportByProduct(Ext.getCmp('expArt').getValue(), true, Ext.getCmp('expProdBtn'));
                                                //                                                } else{
                                                //                                                    exportByProduct(Ext.getCmp('expArt').getValue(), false, Ext.getCmp('expProdBtn'));
                                                //                                                }
                                                if(comboLanguages.isValid()){
                                                    exportByProduct(Ext.getCmp('expArt').getValue(), comboLanguages.getValue(), Ext.getCmp('expProdBtn'));
                                                }
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
                            },
                            listeners: {
                                click: function() {
                                    clearCache();
                                }
                            }
                        },{
                            text: '<<<Статистика>>>',
                            id:'statBtn',
                            listeners: {
                                click: function() {
                                    showStatistics();
                                }
                            }
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
        }
        ]
    },{
        title: 'Экспорт маркетинга',
        autoScroll: true,
        items:[{
            title: 'Экспорт маркетинга',
            autoScroll: true,
            items:[{
                layout:'column',
                width: '100%',
                height: '100%',
                bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                buttonAlign: 'center',
                items: [{
                    bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                    items: [{
                        xtype: 'textarea',
                        fieldLabel: 'Message text',
                        width: 350,
                        height: 150,
                        hideLabel: true,
                        flex: 1,
                        id:'expMarkArt'
                    }]
                },{
                    style: {
                        marginTop: '80px'
                    },
                    xtype: 'buttongroup',
                    bodyStyle: 'padding:1px; border:0; background-color:#E1E1E1;',
                    items: [{
                        text: '<<<Запуск>>>',
                        id:'expMarkBtn',
                        style: {
                            marginRight: '10px'
                        },
                        listeners: {
                            click: function() {
                                exportMarketing(Ext.getCmp('expMarkArt').getValue(), Ext.getCmp('expMarkBtn'));
                            }
                        }
                    },{
                        text: '<<<Почистить кэш>>>',
                        listeners: {
                            click: function() {
                                clearCacheMark();
                            }
                        }
                    }
                    ]
                }]

            }]
        },{
            items: {
                id: 'pbarMark',
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
            contentEl: 'expMarkLogs',
            autoScroll: true
        }]
    }]
};

var echat = {

    xtype: 'tabpanel',
    id: 'eChat-panel',
    plain: true,
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:1000px;'
    },
    items:[{
        title: 'Типа чат...',
        autoScroll: true,
        items:[{
            bodyStyle: 'padding:7px; border: 1px solid #7EABCD; background-color:#fff;',
            contentEl: 'chat_id_ul'
        },{
            bodyStyle: 'padding:7px; border: 0; background-color:#e1e8ff;',
            html: '<br/>'
        },{
            layout:'column',
            bodyStyle: 'padding:7px; border: 1px solid #7EABCD; background-color:#fff;',
            items: [
            //                {
            //                html:'<h1>Ник:</h1>',
            //                style: {
            //                    marginTop: '4px',
            //                    marginRight: '7px'
            //                },
            //                bodyStyle: 'border: 0px'
            //            },{
            //                xtype: 'textfield',
            //                height:25,
            //                id:'chatNick',
            //                blankText:'Введите что-нибудь...',
            //                allowBlank:false,
            //                style: {
            //                    marginBottom: '7px'
            //                }
            //
            //            },{
            //                xtype: 'textarea',
            //                //width: 700,
            //                height:170,
            //                autoScroll:true,
            //                allowBlank:false,
            //                blankText:'Введите сообщение...',
            //                id:'chatData',
            //                // allowBlank:false,
            //                enableKeyEvents:true,
            //                style: {
            //                    width:'99%',
            //                    marginTop: '0px',
            //                    marginBottom: '0px'
            //                },
            //                listeners: {
            //                    specialkey: function(something,e){
            //                        if (e.getKey() == e.ENTER) {
            //                            sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
            //                        }
            //                    }
            //                }
            //
            //            },
            //            {
            //                xtype: 'button',
            //                text: '<<Отправить>>>',
            //                style: {
            //                    marginTop: '7px',
            //                    align: 'center'
            //                },
            //                bodyStyle: 'align:center',
            //                listeners: {
            //                    click: function() {
            //                        sendMessage(Ext.getCmp('chatData').getValue(), Ext.getCmp('chatNick').getValue());
            //                    }
            //                }
            //            }
            chatForm
            ]
        }]
    }]
};
var value4ovnerstatus = {

    xtype: 'tabpanel',
    id: 'vStat-panel',
    plain: true,
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:1000px;'
    },
    items:[{
        title: 'Смена автора',
        autoScroll: true,
        items:[{
            title: 'Смена автора',
            autoScroll: true,
            items: [{
                layout:'column',
                width: '100%',
                height: '100%',
                bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                buttonAlign: 'center',
                items: [{
                    bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                    items: [{
                        xtype: 'textarea',
                        fieldLabel: 'Message text',
                        width: 350,
                        height: 150,
                        hideLabel: true,
                        name: 'msg',
                        flex: 1,
                        id:'changeOwnArt'
                    }]
                },{
                    style: {
                        margin: '50px auto'
                    },
                    bodyStyle: 'padding:7px; border: 1px solid #B7C8D7; background-color:#E1E1E1;',

                    items: [
                    comboOwner,

                    {
                        xtype: 'button',
                        text: '<<<Запуск>>>',
                        id:'changeOwnBtn',
                        style: {
                            marginTop: '10px'
                        },
                        listeners: {
                            click: function() {
                                changeOwner(Ext.getCmp('changeOwnArt').getValue(), comboOwner.value, Ext.getCmp('changeOwnBtn'));
                            }
                        }
                    }
                    ]
                }]
            }]
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
        autoScroll: true,
        items:[{
            title: 'Смена статуса',
            autoScroll: true,
            items: [{
                layout:'column',
                width: '100%',
                height: '100%',
                bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                buttonAlign: 'center',
                items: [{
                    bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                    items: [{
                        xtype: 'textarea',
                        fieldLabel: 'Message text',
                        width: 350,
                        height: 150,
                        hideLabel: true,
                        name: 'msg',
                        flex: 1,
                        id:'changeStatArt'
                    }]
                },{
                    style: {
                        margin: '46px auto'
                    },
                    bodyStyle: 'padding:7px; border: 1px solid #B7C8D7; background-color:#E1E1E1;',

                    items: [{
                        xtype: 'radiogroup',
                        columns: 3,
                        width:250,
                        id:'radioData',

                        items: [
                        {
                            boxLabel: 'Research',
                            name:'radio1',
                            inputValue: 'Research',
                            checked: true
                        },

                        {
                            boxLabel: 'Control',
                            name:'radio1',
                            inputValue: 'Control'
                        },

                        {
                            boxLabel: 'Done',
                            name:'radio1',
                            inputValue: 'Done'
                        }
                        ]
                    },{
                        xtype: 'button',
                        text: '<<<Запуск>>>',
                        id:'changeStatBtn',
                        style: {
                            marginTop: '10px'
                        },
                        listeners: {
                            click: function() {
                                changeStatus(Ext.getCmp('changeStatArt').getValue(), Ext.getCmp('radioData').getValue().getGroupValue(), Ext.getCmp('changeStatBtn'));
                            }
                        }
                    }
                    ]
                }]
            }]
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
        autoScroll: true,
        items:[{
            title: 'Добавление ссылок',
            autoScroll: true,
            items:[{
                layout:'column',
                width: '100%',
                height: '100%',
                bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                buttonAlign: 'center',
                items: [{
                    bodyStyle: 'padding:10px; border:0; background-color:#E1E1E1;',
                    items: [{
                        xtype: 'textarea',
                        fieldLabel: 'Message text',
                        width: 700,
                        height: 150,
                        hideLabel: true,
                        flex: 1,
                        id:'LinkskArt'
                    }]
                },{
                    style: {
                        marginTop: '70px'
                    },
                    xtype: 'buttongroup',
                    bodyStyle: 'padding:1px; border:0; background-color:#E1E1E1;',
                    items: [{
                        text: '<<<Запуск>>>',
                        id:'LinksBtn',
                        listeners: {
                            click: function() {
                                addLink(Ext.getCmp('LinkskArt').getValue(), Ext.getCmp('LinksBtn'));
                            }
                        }
                    }
                    ]
                }]

            }]
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
    plain: true,
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Сброс сессии',
        autoScroll: true,
        items:[{
            title: 'Сброс сессии',
            contentEl: 'optSesInput',
            autoScroll: true
        }]
    }]
};

var egrabli = new Ext.TabPanel({
    id: 'eGrabli-panel',
    plain: true,  //remove the header border
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%;'
    },
    items:[{
        title: 'Продукт типы',
        autoScroll: true,
        items:[ptForm]
    //items:[isForm]
    },{
        title: 'Группы',
        autoScroll: true,
        items:[grpForm]
    },{
        title: 'Атрибуты',
        autoScroll: true,
        items:[atrForm]
    },//    },
    {
        title: 'Единицы измерения',
        autoScroll: true,
        items:[unitsForm]
    },{
        title: 'Связка ПТ -> Группа',
        autoScroll: true,
        items:[PT2GroupeForm]
    },{
        title: 'Связка Группа -> Атрибут',
        autoScroll: true,
        items:[Grp2AtrForm]
    },
    //    {
    //        title: 'Связка ПТ -> Атрибут',
    //        autoScroll: true,
    //        items:[Atr2PTForm]
    {
        title: 'Грабли',
        autoScroll: true,
        items:[grabliFile, grabliGrid, grabliPBar, gridToOut]
    }]
});

var ecsv = {
    id: 'eCsv-panel',
    title: 'Преобразование файла из форматов XLS и CSV(Excel) в нормальный CSV!',
    layout: 'fit',
    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
    contentEl: 'eCsv'
};

var fibasic = new Ext.ux.form.FileUploadField({
    width:350,
    id: 'matchFile',
    emptyText: 'Выберите файл...',
    style: {
        marginTop: '0px',
        marginBottom: '0px'
    },
    buttonText: 'Выбрать'
});

var p = new Ext.ux.form.FileUploadField();

var erow = {
    xtype: 'tabpanel',
    id: 'eRow-panel',
    plain: true,
    activeItem: 0,
    defaults: {
        bodyStyle: 'padding:7px; background-color:#e1e8ff; width:100%; height:100%'
    },
    items:[{
        title: 'Сравнение данных',
        autoScroll: true,
        items:[{
            title: 'Сравнение столбцов',
            autoScroll: true,
            bodyStyle: 'padding:7px; background-color:#ffffff',
            layout:'column',
            items:[fibasic,p,{
                html:'<h1>Разделитель:</h1>',
                style: {
                    marginTop: '4px',
                    marginLeft: '7px',
                    marginRight: '7px'
                },
                bodyStyle: 'border: 0px'
            },{
                xtype: 'textfield',
                hideLabel: true,
                //fieldLabel:'Разделитель:',
                //height:25,
                //width:25,
                regex:/[,]|[;]/,
                regexText:'Введите точку с запятой или точку!',
                //                maskRe:'[,;]',
                id:'matchSep',
                blankText:'Введите точку с запятой или точку...',
                allowBlank:false,
                style: {
                    marginTop: '1px'
                }
            },
            {
                xtype: 'button',
                text: '<<<Запуск>>>',
                id:'changeStatBtn',
                style: {
                    marginLeft: '5px'
                },
                listeners: {
                    click: function() {
                        var file = Ext.getDom('matchFile-file');
                        var file2 = dwr.util.getValue('matchFile-file');
                        if(Ext.getCmp('matchSep').isValid){
                            Ajax.matchData(file2, byId("matchFile-file").value, Ext.getCmp('matchSep').getValue(), function(data) {
                                //Ext.getCmp('matchFile').remove();
                                Ext.getCmp('matchFile').reset();


                                //Ext.getCmp('matchFile').createFileInput();
                                //.setRawValue(null)
                                //Ext.getCmp('matchFile').setRawValue(null);
                                //dwr.util.setValue('matchFile','');
                                if(data==null){
                                    Ext.Msg.show({
                                        title:'Неверный формат файла...',
                                        msg: 'Верный смотри в инфо...',
                                        buttons: Ext.Msg.OK,
                                        width:250,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                } else{
                                    dwr.engine.openInDownload(data);
                                    //fibasic.destroy();
                                    fibasic = new Ext.ux.form.FileUploadField({
                                        width:350,
                                        id: 'matchFile',
                                        emptyText: 'Выберите файл...',
                                        style: {
                                            marginTop: '0px',
                                            marginBottom: '0px'
                                        },
                                        buttonText: 'Выбрать'
                                    });
                                    Ext.QuickTips.init();
                                }
                            });
                        } else{
                            Ext.getCmp('matchSep').setValue("");
                        }

                    }
                }
            }
            //            ,{
            //                xtype: 'button',
            //                text: '<<<Посмареть>>>',
            //                id:'changeStatBtn2',
            //                style: {
            //                    marginLeft: '5px'
            //                },
            //                listeners: {
            //                    click: function() {
            //                        //                        var file = dwr.util.getValue('matchFile-file');
            //                        //                        Ajax.matchData(file, Ext.getCmp('matchFile').getValue(), function(data) {
            //                        //                            Ext.getCmp('matchFile').reset();
            //                        //                            dwr.engine.openInDownload(data);
            //                        //                        });
            //                        alert(Ext.getCmp('matchFile').getValue());
            //                    //                        matchData(Ext.getCmp('matchFile'), Ext.getCmp('matchFile').getValue());
            //                    }
            //                }
            //            }
            ]
        }]
    }
    ]
};

Ext.onReady(function(){

    updateMessage();
    updateNick();
    storeLanguages.load();
    Ext.QuickTips.init();

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
        egrabli,
        osession,
        ecsv,
        erow
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
        html: '<p class="details-info"><b style="color:red">Для правильной работы прогресс-баров и чата в IE8 включите режим совместимости с IE7. (Значок с разорванной страничкой справа от адресной строки.)</b><br/><br/>Выберите нужную функцию...</p>'
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
            width: 190,
            minSize: 100,
            maxSize: 500,
            items: [treePanel, detailsPanel]
        },
        contentPanel
        ],
        renderTo: Ext.getBody()
    });
    //comboLanguages.setValue('ru');
    //storeAtrs.load();
    storeLngs.load();
    storeCsvData.load();
    storeCsvColumnData.load();
    storeRegexpUsedData.load();
    //Ext.grabliGrid.getEl().hide();
    grabliGrid.hide();
    Ext.getCmp("proxyIP").setValue("localhost:8118");
//    grabliPBar.hide();
//gridToOut.hide();
//grabliGrid.hide();
//storeAtrAll.load();
});