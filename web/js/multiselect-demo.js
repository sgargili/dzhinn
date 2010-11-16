/*!
 * Ext JS Library 3.1.1
 * Copyright(c) 2006-2010 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){

    Ext.QuickTips.init();

    var axm = '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:mem="http://bk.org/memberservice/">   <soapenv:Header/>   <soapenv:Body>      <mem:MemberDetailsRequest>         <mem:id>Привет!</mem:id>      </mem:MemberDetailsRequest>   </soapenv:Body></soapenv:Envelope>';



   // var xmlData = '<users total="2">' +
//    '<user><firstname>Jack</firstname><lastname>Jobs</lastname><phone>1234567890</phone></user>' +
//    '<user><firstname>Jenn</firstname><lastname>Syms</lastname><phone>4561230789</phone></user>' +
//    '</users>';
var xmlData = '<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">        <SOAP-ENV:Header/>        <SOAP-ENV:Body>            <ms:MemberDetailsResponse xmlns:ms="http://bk.org/memberservice/">                <memberdetail>                    <name>John Doe</name>                    <city>New York</city>                    <phone>Привет!</phone>                    <state>NY</state>                </memberdetail>            </ms:MemberDetailsResponse>        </SOAP-ENV:Body>    </SOAP-ENV:Envelope>';
//    Ext.Ajax.request({
//        //                    url: 'http://localhost:8070/memberservice/MemberDetailsRequest.wsdl',
//        url: 'http://localhost:8070/memberservice/services/MemberDetailsRequest',
//        //url: 'http://localhost:8070/memberservice/x.xml',
//        method: "POST",
//        async: false,
//        //                    success: function(a, b){
//        //                        //Ext.Msg.alert('Submitted Values', a.responseXML);
//        //                        reader.read(a.responseText);
//        //                        Ext.Msg.alert('Submitted Values', a.responseText);
//        //                        alert(a.responseText);
//        //                    },
//        //                    failure: function(a, b){
//        //                        alert("Not okay");
//        //                    }
//        callback: function(options, success, response){
//            if (success){
//                //console.log(response);
//                var xml = response.responseText;
//                xmlData = xml;
//            //                            Ext.Msg.alert('Submitted Values', xml);
//            //                            reader.read(response);
//            }
//        },
//        //                    headers: {
//        //                        'my-header': 'foo'
//        //                    },
//        //                    params: {
//        //                        foo: 'bar'
//        //                    }
//        xmlData: '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:mem="http://bk.org/memberservice/">   <soapenv:Header/>   <soapenv:Body>      <mem:MemberDetailsRequest>         <mem:id>Hi!</mem:id>      </mem:MemberDetailsRequest>   </soapenv:Body></soapenv:Envelope>'
//    });
    var doc;
    if(window.ActiveXObject){
        doc = new ActiveXObject("Microsoft.XMLDOM");
        doc.async = "false";
        doc.loadXML(xmlData);
        alert("1");
    }else{
        doc = new DOMParser().parseFromString(xmlData,"text/xml");
        alert("2");
    }

    var xmlReader = new Ext.data.XmlReader({
        //        record: 'user',
        //        id: 'firstname',
        //        totalRecords: '@total',
        //        fields: ['firstname', 'lastname', 'phone']}

        record: 'memberdetail',
        restful:true,
        id: 'phone'
    }, [
    {
        name: 'name',
        mapping: 'name'
    }, {
        name:'phone',
        mapping:'phone'
    }
    ]
    );


    //            <ms:memberdetail>
    //                <ms:name>John Doe</ms:name>
    //                <ms:city>New York</ms:city>
    //                <ms:phone>Привет!</ms:phone>
    //                <ms:state>NY</ms:state>
    //            </ms:memberdetail>



    var store = new Ext.data.Store({
        reader: xmlReader,
        restful:true,
        data: doc
    // proxy: new Ext.data.MemoryProxy(xmlData)
    });




    var reader = new Ext.data.XmlReader({
        record: 'ms:memberdetail',
        id: 'ms:name'
    }, [
    {
        name: 'name',
        mapping: 'ms:name'
    }, {
        name:'city',
        mapping:'ms:city'
    }, {
        name:'phone',
        mapping:'ms:phone'
    }, {
        name:'state',
        mapping:'ms:state'
    }
    ]);

    var storeLanguages2 = new Ext.data.Store({
        //url:axm,
        reader: reader
    });

    //    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    //    <SOAP-ENV:Header/>
    //    <SOAP-ENV:Body>
    //        <ms:MemberDetailsResponse xmlns:ms="http://bk.org/memberservice/">
    //            <ms:memberdetail>
    //                <ms:name>John Doe</ms:name>
    //                <ms:city>New York</ms:city>
    //                <ms:phone>Привет!</ms:phone>
    //                <ms:state>NY</ms:state>
    //            </ms:memberdetail>
    //        </ms:MemberDetailsResponse>
    //    </SOAP-ENV:Body>
    //</SOAP-ENV:Envelope>





    //    var storeLanguages = new Ext.data.Store({
    //        url: 'data/Languages.xml',
    //        reader: new Ext.data.XmlReader({
    //            record: 'Language',
    //            id: 'Value'
    //        }, [
    //        {
    //            name: 'lang',
    //            mapping: 'Name'
    //        }, {
    //            name:'value',
    //            mapping:'Value'
    //        }
    //        ])
    //    });
    //
    //    var comboLanguages = new Ext.ux.form.MultiSelect({
    //        name: 'multiselect',
    //        width: 250,
    //        height: 200,
    //        allowBlank:false,
    //        //autoScroll: true,
    //        displayField:'lang',
    //        valueField: 'value',
    //        blankText:'Выберите язык!',
    //        bodyStyle: 'width:300px',
    //        store: storeLanguages,
    //        renderTo:'multiselect',
    //        tbar:[{
    //            text: 'Clear',
    //            handler: function(){
    //                comboLanguages.reset();
    //            }
    //        },{
    //            text: 'Ru/En only',
    //            handler: function(){
    //                comboLanguages.setValue('ru,en');
    //            }
    //        },{
    //            text: 'En only',
    //            handler: function(){
    //                comboLanguages.setValue('en');
    //            }
    //        },{
    //            text: 'Default',
    //            handler: function(){
    //                comboLanguages.setValue('ru,en,bg,pl,hr,sl');
    //            }
    //        },{
    //            text:'Посмареть',
    //            handler: function(){
    //                //            if(comboLanguages.isValid()){
    //                //                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
    //                //                    comboLanguages.getValue());
    //                //            }http://localhost:8070/memberservice/x.xml
    //                Ext.Ajax.request({
    //                    //                    url: 'http://localhost:8070/memberservice/MemberDetailsRequest.wsdl',
    //                    url: 'http://localhost:8070/memberservice/services/MemberDetailsRequest',
    //                    //url: 'http://localhost:8070/memberservice/x.xml',
    //                    method: "POST",
    //                    //                    success: function(a, b){
    //                    //                        //Ext.Msg.alert('Submitted Values', a.responseXML);
    //                    //                        reader.read(a.responseText);
    //                    //                        Ext.Msg.alert('Submitted Values', a.responseText);
    //                    //                        alert(a.responseText);
    //                    //                    },
    //                    //                    failure: function(a, b){
    //                    //                        alert("Not okay");
    //                    //                    }
    //                    callback: function(options, success, response){
    //                        if (success){
    //                            var xml = response.responseXML;
    //                            Ext.Msg.alert('Submitted Values', xml);
    //                            reader.read(response);
    //                        }
    //                    },
    //                    //                    headers: {
    //                    //                        'my-header': 'foo'
    //                    //                    },
    //                    //                    params: {
    //                    //                        foo: 'bar'
    //                    //                    }
    //                    xmlData: '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:mem="http://bk.org/memberservice/">   <soapenv:Header/>   <soapenv:Body>      <mem:MemberDetailsRequest>         <mem:id>' + comboLanguages.getValue() + '</mem:id>      </mem:MemberDetailsRequest>   </soapenv:Body></soapenv:Envelope>'
    //                });
    //
    //
    //                Ext.Msg.alert('Submitted Values', reader.xmlData);
    //            }
    //        }],
    //        ddReorder: true
    //
    //    });
    var comboLanguages2 = new Ext.ux.form.MultiSelect({
        name: 'multiselect',
        width: 250,
        height: 200,
        allowBlank:false,
        //autoScroll: true,
        displayField:'name',
        valueField: 'phone',
        blankText:'Выберите язык!',
        bodyStyle: 'width:300px',
        store: store,
        renderTo:'multiselect',
        tbar:[{
            text:'Посмареть',
            handler: function(){
                Ext.Msg.alert('Submitted Values', reader.xmlData);
            }
        }],
        ddReorder: true

    });
//storeLanguages.load();
//store.load();
});
