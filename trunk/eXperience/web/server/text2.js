
function update2() {
  var name = dwr.util.getValue("demoName2");
  DemoNewNew.sayHello(name, function(data) {
    dwr.util.setValue("demoReply2", data);
  });
}
