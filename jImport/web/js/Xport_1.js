dojo.require("dojo.parser");
dojo.require("dojo.fx");
dojo.require("dijit.TitlePane");
dojo.require("dijit.form.CheckBox");
dojo.require("dijit.form.DateTextBox");
dojo.require("dijit.form.Textarea");
dojo.require("dijit.form.Button");
dojo.require("dijit.Dialog");
dojo.require("dijit.form.FilteringSelect");

dojo.require("dojox.form.FileInput");
function SwitchLanguages () {
    if (dojo.byId("LangAll").checked == false)
    {
        for (i=1; i<7 ;i++ )
        {
            dijit.byId('Lang'+i).attr("disabled",false);
            dijit.byId('Lang'+i).attr("checked",false);

        }
        dijit.byId('Lang1').attr("checked",true);
        dijit.byId('Lang2').attr("checked",true);
    }
    if (dojo.byId("LangAll").checked == true) {
        for (i=1; i<7 ;i++ )
        {
            dijit.byId('Lang'+i).attr("checked",true);
            dijit.byId('Lang'+i).attr("disabled",true);
            
        }
    }
}

function SwitchStatus () {
    if (dojo.byId("StatusAll").checked == false)
    {
        for (i=1; i<4 ;i++ )
        {
            dijit.byId('Status'+i).attr("disabled",false);
            dijit.byId('Status'+i).attr("checked",false);

        }
        dijit.byId('Status1').attr("checked",true);
    }
    if (dojo.byId("StatusAll").checked == true) {
        for (i=1; i<4 ;i++ )
        {
            dijit.byId('Status'+i).attr("checked",true);
            dijit.byId('Status'+i).attr("disabled",true);
        }
    }
}

function InputValidation(){
    var boolVal;
    var boolLang;
    var boolStat;
    var alString="Предупреждения: ";
    bool1 = dojo.byId("Lang1").checked;
    bool2 = dojo.byId("Lang2").checked;
    bool3 = dojo.byId("Lang3").checked;
    bool4 = dojo.byId("Lang4").checked;
    bool5 = dojo.byId("Lang5").checked;
    bool6 = dojo.byId("Lang6").checked;
    bool7 = dojo.byId("Status1").checked;
    bool8 = dojo.byId("Status2").checked;
    bool9 = dojo.byId("Status3").checked;

    if(dojo.byId('TextArea').value==""){
        boolVal = true;
    } else {
        var regExpAll=/[а-яА-Я]/
        if(regExpAll.test(dojo.byId('SubmitString').value)){
            alert("Привет!");
            alString+="Артикли имеют русские символы в значениях, ";
            boolVal = true;
           
        } else {
            boolVal = false;
        }
    }
    if(bool1 == false&&bool2 == false&&bool3 == false&&bool4 == false&&bool5 == false&&bool6 == false){
        boolLang=true;
    } else {
        boolLang=false;
    }
    if(bool7 == false&&bool8 == false&&bool9 == false){
        boolStat=true;
    }else {
        boolStat=false;
    }
    if(boolVal){

        alString+="Article или ArticleID, ";
    }

    if(boolLang){
        alString+="хотя бы один язык, ";
    }
    if(boolStat){
        alString+="хотя бы один статус.";
    }
    var regExp=/,\s$/
    alString=alString.replace(regExp, ".")
    
    if(boolVal||boolLang||boolStat){
        alert(alString);
    }
    
    return (!boolVal&&!boolLang&&!boolStat);

}

function LangStatStringBuilder(){
    dojo.byId('AllStatus').value="";
    dojo.byId('AllLanguages').value="";
    bool1 = dojo.byId("Lang1").checked;
    bool2 = dojo.byId("Lang2").checked;
    bool3 = dojo.byId("Lang3").checked;
    bool4 = dojo.byId("Lang4").checked;
    bool5 = dojo.byId("Lang5").checked;
    bool6 = dojo.byId("Lang6").checked;
    bool6All = dojo.byId("LangAll").checked;
    bool7 = dojo.byId("Status1").checked;
    bool8 = dojo.byId("Status2").checked;
    bool9 = dojo.byId("Status3").checked;
    bool9All = dojo.byId("StatusAll").checked;

    if(bool6All){
        dojo.byId('AllLanguages').value +='All';
    } else {
        if(bool1){
            dojo.byId('AllLanguages').value +='English,';
        }
        if(bool2){
            dojo.byId('AllLanguages').value +='Russian,';
        }
        if(bool3){
            dojo.byId('AllLanguages').value +='Bulgarian,';
        }
        if(bool4){
            dojo.byId('AllLanguages').value +='Croatian,';
        }
        if(bool5){
            dojo.byId('AllLanguages').value +='Polish,';
        }
        if(bool6){
            dojo.byId('AllLanguages').value +='Slovenian';
        }
    }

    if(bool9All){
        dojo.byId('AllStatus').value +='All';
    } else {
        if(bool7){
            dojo.byId('AllStatus').value +='Done,';
        }
        if(bool8){
            dojo.byId('AllStatus').value +='Control,';
        }
        if(bool9){
            dojo.byId('AllStatus').value +='Research,';
        }
    }
    var reg=/,$/g
    dojo.byId("AllLanguages").value=dojo.byId("AllLanguages").value.replace(reg, "");
    dojo.byId("AllStatus").value=dojo.byId("AllStatus").value.replace(reg, "")
}

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

function Export(inter){

    if (InputValidation()){
        var SendString = '{"product":' + inter +'}';
        Export.Res(SendString, function(data) {
            dojo.byId("ShowField").innerHTML = data;
            Show("OutputField");
        });
    }
    
}

function Manufacturer(){
    ManufacturerAll.getAll("", function(data) {
        dojo.byId("Manufac").innerHTML = data;
        Show("Manufac");
    });   
}

function ManufacturerAdd(){
    ManufacturerAll.addNew(dojo.byId('manId').value, dojo.byId('manName').value, function(data) {
        dojo.byId("Manufac").innerHTML = data;
        Show("Manufac");
    });
}
function ManufacturerAllAdd(){
    Show("Updating");
    dojo.byId("Updating").innerHTML ="Updating <img src='images/loading-balls.gif'/>";
    ManufacturerAll.updateManPT(function(data) {
        dojo.byId("Updating").innerHTML = "Updating is " + data;
        Hide("Updating");
        ManufUpd();
    });
    
}

function ClrC(){
    ClrCache.CleareCache(function(data) {
        dwr.util.setValue("Clc", data);
    });
    Hide("Clc");
}
function uploadFile() {
    var file = dwr.util.getValue('uploadFile');
    var fileName = dojo.byId('uploadFile').value;
    UploadDownload.uploadFile(file, fileName, "Supplier", "", function(data) {
        alert(data);
        
    });
}

function uploadFileMatch() {
    var file = dwr.util.getValue('uploadFileMatch');
    var fileName = dojo.byId('uploadFileMatch').value;
    var SupplierName = dojo.byId('HiddenSupplier').value;
    alert(SupplierName);
    UploadDownload.uploadFile(file, fileName, "Matching", SupplierName, function(data) {
        alert(data);
        
    });
}

//dojo.addOnLoad( function() {
//    SuppUpd();
//    ManufUpd();
//    NixProcess();
//});


//function SuppUpd() {
//    SupplierAll.getAll(function(data) {
//        dojo.byId("SupplSelect").innerHTML = data;
//        var re = /selSuppl/;
//        var str = data;
//        data = str.replace(re, "selSupplMatch");
//
//        dojo.byId("SupplSelectMatch").innerHTML = data;
//    });
//}
function NixProcess() {
    Nix.getPTStatus(function(data) {
        dojo.byId("nixGrabPT_Process").innerHTML = data;
    });
}

function ManufUpd() {
    ManufacturerAll.getAll(function(data) {
        dojo.byId("ManSelect").innerHTML = data;
    });
}


function SupplierSelect(){

    dojo.byId("HiddenSupplier").value = dojo.byId("selSupplMatch").value;

}

function addNewSupplier() {
    if(dojo.byId('SupplNew').value == ""){
        alert("Поле пустое...");
        return;
    }
    SupplierAll.addNew(dojo.byId('SupplNew').value, function(data) {
        dojo.byId('SupplNew').value = "";
        alert(data);
        SuppUpd();
    });
}

function searchAllSuppliers(){
    dojo.byId('AllDialog_Suppliers_Out').innerHTML = "Loading <img src='images/loading-balls.gif'/>";
    SupplierAll.getPricesBySuppliersId(dojo.byId("selSuppl").value,dojo.byId("SupplArticle").value,function(data) {
        dojo.byId('AllDialog_Suppliers_Out').innerHTML = data;
    //        Show("AllDialog_Suppliers_Out");
    });

}

function UploadManPT(){
    var fileName = dojo.byId('uploadFileManPT').value;
    var file = dwr.util.getValue('uploadFileManPT');
    UploadDownload.setManPT(file, dojo.byId("ManPTCheck").checked, fileName, function(data) {
        alert(data);
    });
}

function UploadeCsv(){
    var fileName = dojo.byId('uploadFileeCsv').value;
    var checkSeparator = dojo.byId('eCsvSeparator').checked;
    var checkZip = dojo.byId('eCsvZip').checked;
    var file = dwr.util.getValue('uploadFileeCsv');
    var encoding = dojo.byId('eCsvEncoding').value;
    var engine = dojo.byId('eCsvEngine').value;

    dojo.byId('eCsvLoadingProcess').innerHTML = "<img src='images/loading-balls.gif'/>";
    CsvProcessing.convertXLSCSV(file, fileName, encoding, checkSeparator, checkZip, engine, function(data) {
        dwr.engine.openInDownload(data);
        dojo.byId('eCsvLoadingProcess').innerHTML = "";
        if(data==null){
            alert("Не верный формат файла. Поддерживаемые форматы: csv и xls.");
        }
    });
}

function FixProfitCsv(){
    var fileName = dojo.byId('uploadit4profitCsv').value;
    var file = dwr.util.getValue('uploadit4profitCsv');
    dojo.byId('it4profitCsvLoadingProcess').innerHTML = "<img src='images/loading-balls.gif'/>";
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
    dojo.byId('ulexpProdLog').innerHTML = "<center>Loading <img src='images/loading-balls.gif'/></center>";
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