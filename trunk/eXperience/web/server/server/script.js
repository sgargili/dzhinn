
			function sbm(tf){
			var reg=/\n/g
			var result=dojo.byId("texta").value.replace(reg, ",")
			dojo.byId("hvalue").value = result
				if (tf=="false")
				{
					dojo.byId('hvalue2').value = "Export_Marketing";
					dojo.byId('form1').submit();}
					else {
							dojo.byId('hvalue2').value = "Export";
							dojo.byId('form1').submit();
						}
				}

function valid () {
if (dojo.byId("cb1").checked == false)
{ 
for (i=2; i<8 ;i++ )
{
dijit.byId('cb'+i).attr("disabled",false);
dijit.byId('cb'+i).attr("checked",false);

}
dijit.byId('cb2').attr("checked",true);
dijit.byId('cb3').attr("checked",true);
}
if (dojo.byId("cb1").checked == true) {
for (i=2; i<8 ;i++ )
{
dijit.byId('cb'+i).attr("checked",true);
dijit.byId('cb'+i).attr("disabled",true);
}
}
}
function qSend(){
var result;
var reg=/\n/g
			result=dojo.byId("texta").value.replace(reg, ",")
			//dojo.byId("foo12").value = result
dojo.toJson(arguments[0], false);
return result;

}