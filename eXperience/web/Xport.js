dojo.require("dojo.parser");
dojo.require("dojo.fx");
dojo.require("dijit.TitlePane");
dojo.require("dijit.form.CheckBox");
dojo.require("dijit.form.Textarea");
dojo.require("dijit.form.Button");
dojo.require("dijit.Dialog");

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
        duration: 2000
    });
    var f = dojo.fadeOut({
        node: id,
        duration: 2000
    });
    var a = dojo.fx.chain([w, f]);

    dojo.byId(id).style.height = "0px";
    var w3 = dojo.fx.wipeIn({
        node: id,
        duration: 2000
    });
    var f3 = dojo.fadeIn({
        node: id,
        duration: 2000
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

function ClrC(){
    ClrCache.CleareCache(function(data) {
        dwr.util.setValue("Clc", data);
    });
    Hide("Clc");
}