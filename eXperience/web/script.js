dojo.require("dijit.form.Textarea");
dojo.require("dijit.form.CheckBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.layout.BorderContainer");
dojo.require("dijit.layout.ContentPane");
dojo.require("dojox.form.FileInput");
dojo.require("dijit.Editor");
dojo.require("dijit._editor.plugins.AlwaysShowToolbar");
dojo.require("dojo.parser");
function sbm(tf){
    var reg=/\n/g
    var result=dojo.byId("texta").value.replace(reg, ",")
    dojo.byId("hvalue").value = result
    if (tf=="false")
    {
        dojo.byId('form1').action = "FeXport.jsp";
        dojo.byId('form1').submit();
    }
    else {
        dojo.byId("hvalue2").value = "Export";
        dojo.byId('form1').submit();
    }
}
function eXpStat (){
    window.open("https://cf.value4it.com/cf/export/stat.jsp?stat_RPP=500", "", config="");
}
function ClrCache1 (){
    window.open("https://cf.value4it.com/admin/long-name-to-clear-cache.jsp", "", config="");
}
function ClrCacheNew() {
    dwr.util.setValue('ansver', 'data');
  //var name = dwr.util.getValue("demoName");
  ClrCache.CleareCache(function(data) {
    dwr.util.setValue('ansver', data);
  });
}