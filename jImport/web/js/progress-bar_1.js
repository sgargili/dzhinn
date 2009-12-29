function sendMessage() {
    Ajax.addMessage(dwr.util.getValue("text"));
}
function ImportTree(){
    Ajax.ImportTree();
}
function ImportAllProducts(){
    Ajax.ImportAllProducts(dojo.byId("productsAn").checked,dojo.byId("productsCd").checked);
}
function ImportProductsByArticles(){
    Ajax.ExportTree();
}

function CheckTreeStatus(){
    Ajax.checkTreeStatus(function(data) {
        if(data==true){
            dijit.byId("trees_import_button").setDisabled(true);
            dojo.byId("treeUpdateStatus").innerHTML = "Процесс обновления...";
            dojo.byId("treeUpdateStatus").style.color="red";
        } else {
            dojo.byId("treeUpdateStatus").innerHTML = "Готов к обновлению.";
            dojo.byId("treeUpdateStatus").style.color="green";
        }
    });
}
function CheckProductsStatus(){
    Ajax.checkProductsStatus(function(data) {
        if(data==true){
            dijit.byId("products_import_button").setDisabled(true);
            dojo.byId("productsUpdateStatus").innerHTML = "Процесс обновления...";
            dojo.byId("productsUpdateStatus").style.color="red";
        } else {
            dojo.byId("productsUpdateStatus").innerHTML = "Готов к обновлению.";
            dojo.byId("productsUpdateStatus").style.color="green";
        }
    });
}
function CheckTreesStatusButton(){
    if(dijit.byId("trees_import_button").disabled==true){
        dijit.byId("trees_import_button").setDisabled(false);
    } else {
        dijit.byId("trees_import_button").setDisabled(true);
    }
}
function CheckProductsStatusButton(){
    if(dijit.byId("products_import_button").disabled==true){
        dijit.byId("products_import_button").setDisabled(false);
    } else {
        dijit.byId("products_import_button").setDisabled(true);
    }
}

dojo.addOnLoad( function() {
    CheckTreeStatus();
    CheckProductsStatus();
});

function TreeServerLogView(){
    if(dojo.byId("treeSLC").checked){
        dojo.byId("logs_trees_import").style.visibility = "visible";
        dijit.byId("ulTreesLog").setDisabled(false);
    } else{
        dojo.byId("logs_trees_import").style.visibility = "hidden";
        dijit.byId("ulTreesLog").setDisabled(true);

    }

}
function ProductsServerLogView(){
    if(dojo.byId("productsSLC").checked){
        dojo.byId("logs_products_import").style.visibility = "visible";
        dijit.byId("ulProductsLog").setDisabled(false);
    } else{
        dojo.byId("logs_products_import").style.visibility = "hidden";
        dijit.byId("ulProductsLog").setDisabled(true);

    }

}