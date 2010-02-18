/*!
 * Ext JS Library 3.1.1
 * Copyright(c) 2006-2010 Ext JS, LLC
 * licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){

    Ext.QuickTips.init();

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

var comboLanguages = new Ext.ux.form.MultiSelect({
    name: 'multiselect',
    width: 250,
    height: 200,
    allowBlank:false,
    //autoScroll: true,
    displayField:'lang',
    valueField: 'value',
    blankText:'Выберите язык!',
    bodyStyle: 'width:300px',
    store: storeLanguages,
    renderTo:'multiselect',
    tbar:[{
        text: 'Clear',
        handler: function(){
            comboLanguages.reset();
        }
    },{
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
        text: 'Default',
        handler: function(){
            comboLanguages.setValue('ru,en,bg,pl,hr,sl');
        }
    },{
        text:'Посмареть',
        handler: function(){
            if(comboLanguages.isValid()){
                Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
                    comboLanguages.getValue());
            }
        }
    }],
    ddReorder: true

});
storeLanguages.load();
});
