
/**
 *
 * @author APopov
 */

// Блок опрдеделений...

function byId(id){
    return Ext.getDom(id);
}


// Блок хранилищ...

// Хранилища ПТ.
// Все ПТ.
var storePts = new Ext.data.Store({
    url: 'ProductType.exml',
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
    width: 350,
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
        text: 'Показать ПТ',
        handler: function(){
            storePts.load();
        }
    },{
        text: 'Сохранить ПТ',
        handler: function(){
            Ajax.updateProductTypeAltName(ptMulti.getValue(), ptField.getValue(), function(data) {
                if(data=="MultiSelectInRequest"){
                    //ptField.setValue("");
                    Ext.Msg.show({
                        title: 'Предупреждение!!!',
                        msg: 'Выбирайте только одно значение!',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.INFO
                    });
                } else {
                    //                    ptField.setValue("");
                    Ext.Msg.show({
                        title: 'Выполненно!',
                        msg: 'Варианты ПТ добавлены.',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.INFO
                    });
                }
            });
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
    ,

    buttons: [{
        text: 'Save',
        handler: function(){
            if(ptForm.getForm().isValid()){
                updatePtAltName(ptMulti.getValue(), ptField.getValue());
            }
        }
    }]
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


var atrMulti = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 350,
    height: 200,
    allowBlank:true,
    //autoScroll: true,
    displayField:'atr',
    valueField: 'id',
    minSelections:1,
    minSelectionsText:'Нужно выбрать хотя бы {1} язык!',
    blankText:'Выберите язык!',
    style:{
        marginTop: '1px',
        marginBottom: '9px'
    },
    store: storeAtr,
    listeners: {
        click: function() {
            Ajax.getAttributeAltName(atrMulti.getValue(), function(data) {
                if(data=="MultiSelectInRequest"){
                    atrField.setValue("");
                    Ext.Msg.show({
                        title: 'Предупреждение!!!',
                        msg: 'Выбирайте только одно значение!',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.ERROR
                    });
                } else {
                    atrField.setValue(data);
                }
            });
        }
    },
    tbar:[{
        text: 'Показать Атрибуты',
        handler: function(){
            if(comboPT.getValue()==""){
                Ext.Msg.show({
                    title: 'Предупреждение!!!',
                    msg: 'Выбирайте ПТ!',
                    buttons: Ext.MessageBox.OK,
                    width: 300,
                    icon: Ext.MessageBox.ERROR
                });
                return;
            }
            storeAtrProxy.setUrl("Attribute.exml?ptId="+ comboPT.getValue());
            storeAtr.clearData();
            storeAtr.load();
            atrField.setValue("");
        }
    },{
        text: 'Сохранить Атрибут',
        handler: function(){
            Ajax.updateAttributeAltName(atrMulti.getValue(), atrField.getValue(), function(data) {
                if(data=="MultiSelectInRequest"){
                    //ptField.setValue("");
                    Ext.Msg.show({
                        title: 'Предупреждение!!!',
                        msg: 'Выбирайте только одно значение!',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.INFO
                    });
                } else {
                    //                    ptField.setValue("");
                    Ext.Msg.show({
                        title: 'Выполненно!',
                        msg: 'Варианты атрибута добавлены.',
                        buttons: Ext.MessageBox.OK,
                        width: 300,
                        icon: Ext.MessageBox.INFO
                    });
                }
            });
            storeAtrProxy.setUrl("Attribute.exml?ptId="+ comboPT.getValue());
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
                            } else {
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
        comboPT,{
            bodyStyle: 'border:0px;',
            layout:'column',
            items: [
            atrMulti,
            atrField

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
            storeAtr2ProdTypeProxy.setUrl("Attribute.exml?ptId="+ comboPts.getValue());
            storeAtr2ProdType.clearData();
            storeAtr2ProdType.load();
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
            labelWidth:'0',
            hideLabel: true,
            bodyStyle: 'padding:0px;',
            imagePath: 'images/ux',
            multiselects: [{
                width: 300,
                height: 250,
                store: storeAtrAll,
                displayField: 'atr',
                valueField: 'id',
                tbar:[{
                    text: 'Загрузить Атрибуты',
                    handler:function(){
                        storeAtrAllProxy.setUrl("Attribute.exml?template=" + Ext.get('atrTemplate').getValue());
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
                    }
                },{
                    text: 'clear',
                    handler:function(){
                        Atr2PTForm.getForm().findField('itemselector').reset();
                    }
                }]
            },{
                width: 300,
                height: 250,
                store: storeAtr2ProdType,
                displayField: 'atr',
                valueField: 'id',
                tbar:[{
                    text: 'clear',
                    handler:function(){
                        Atr2PTForm.getForm().findField('itemselector').reset();
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
        } else {
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

var egrabli = {
    xtype: 'tabpanel',
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
        title: 'Атрибуты',
        autoScroll: true,
        items:[atrForm]
    },
    //    {
    //        title: 'Значения атрибутов',
    //        autoScroll: true
    //    //items:[ptForm]
    //    },
    {
        title: 'Сборка контента',
        autoScroll: true,
        items:[Atr2PTForm]
    }]
};

var ecsv = {
    id: 'eCsv-panel',
    title: 'Преобразование файла из форматов XLS и CSV(Excel) в нормальный CSV!',
    layout: 'fit',
    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
    contentEl: 'eCsv'
};

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
            bodyStyle: 'padding:7px; background-color:#e1e8ff',
            layout:'column',
            items:[{
                xtype: 'fileuploadfield',
                width:350,
                id: 'matchFile',
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
                id:'changeStatBtn',
                style: {
                    marginLeft: '5px'
                },
                listeners: {
                    click: function() {
                        var file = Ext.getDom('matchFile-file');
                        var file2 = dwr.util.getValue('matchFile-file');
                        //                        alert(file.value);
                        //                        file.value='';
                        //                        alert(file.value);
                        Ajax.matchData(file, Ext.getCmp('matchFile').getValue(), function(data) {
                            Ext.getCmp('matchFile').reset();
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
                            }
                        });

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
    }]
//    id: 'eRow-panel',
//    title: 'Сравнение столбцов',
//    layout: 'column',
//    bodyStyle: 'padding:17px; background-color:#e1e8ff; width:100%; height:100%',
//    items:[{
//        xtype: 'fileuploadfield',
//        width:350,
//        style:{
//            width:'350px'
//        },
//        id: 'form-file',
//        emptyText: 'Выберите файл',
//        fieldLabel: 'Файл',
//        name: 'photo-path',
//        buttonText: 'Выбрать'
//    //        buttonCfg: {
//    //            iconCls: 'upload-icon'
//    //        }
//    }]
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
            width: 250,
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
//storeAtrAll.load();
});