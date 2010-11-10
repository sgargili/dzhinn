/**
 *
 * @author Andrey Popov
 */

//public vars

var isUpdateMember = false;
var isUpdateCandidat = false;
var memberId;
var memberCardId;
var carCountByMember = 1;
var insuranceCountByMember = 1;
var isFirstLoadCarModels = true;
var isPaymentsSearch = false;
var buttonValue = "";
var callDuration = "";
var differentialCarBrand = "1";

Ext.util.Format.comboRenderer = function(combo) {

    //alert(combo.getName());
    if (combo.getStore().getCount() == 0 && combo.getName() == 'carBrand') {

        combo.getStore().load({
            callback: function (response, opts, success) {
            }
        });
    } else {
        combo.getStore().proxy.setUrl('rest/models');
        combo.getStore().load({
            callback: function (response, opts, success) {
            }
        });
    }
    return function(value) {
        differentialCarBrand = value;
        var record = combo.findRecord(combo.valueField || combo.displayField, value);
        return record ? record.get(combo.displayField) : combo.valueNotFoundText;
    }
}

// Native Objects...
function CarBrand() {

    this.setCarBrandId = function(id) {
        this.id = id;
    };
}

function CarModel() {

    this.setCarModelId = function(id) {
        this.id = id;
    };
}

function Car() {

    this.setRegistrationNumber = function(registrationNumber) {
        this.registrationNumber = registrationNumber;
    };

    this.setBuildDate = function(buildDate) {
        this.buildDate = buildDate;
    };

    this.setCarBrand = function(carBrand) {
        this.carBrand = carBrand;
    };

    this.setCarModel = function(carModel) {
        this.carModel = carModel;
    };
}

function InsuarancePolicy() {

    this.setInsuaranceCompany = function(insuaranceCompany) {
        this.insuaranceCompany = insuaranceCompany;
    };

    this.setPolicyEndDate = function(policyEndDate) {
        this.policyEndDate = policyEndDate;
    };
}

function Region() {
    this.setRegionID = function(regionID) {
        this.regionID = regionID;
    };

    this.setRegionName = function(regionName) {
        this.regionName = regionName;
    };
}

function MemberCard() {
    this.setId = function(id) {
        this.id = id;
    };
}

function Payment() {

    this.setId = function(id) {
        this.id = id;
    };

    this.setPaymentDate = function(paymentDate) {
        this.paymentDate = paymentDate;
    };

    this.setBic = function(bic) {
        this.bic = bic;
    };

    this.setTicketNumber = function(ticketNumber) {
        this.ticketNumber = ticketNumber;
    };

    this.setPaymentWay = function(paymentWay) {
        this.paymentWay = paymentWay;
    };

    this.setPaymentType = function(paymentType) {
        this.paymentType = paymentType;
    };

    this.setAmount = function(ammount) {
        this.ammount = ammount;
    };

    this.setPayStatus = function(payStatus) {
        this.payStatus = payStatus;
    };

    this.setPaymentDestination = function(paymentDestination) {
        this.paymentDestination = paymentDestination;
    };

    this.setMemberBankBook = function(memberBankBook) {
        this.memberBankBook = memberBankBook;
    };
    this.setMemberId = function(memberId) {
        this.memberId = memberId;
    };
}

function TechnicalRecourse() {

    this.setId = function(id) {
        this.id = id;
    };

    this.setMemberId = function(memberId) {
        this.memberId = memberId;
    };

    this.setPhoneNumber = function(phoneNumber) {
        this.phoneNumber = phoneNumber;
    };
    this.setAction = function(action) {
        this.action = action;
    };
    this.setRecourseDate = function(recourseDate) {
        this.recourseDate = recourseDate;
    };
    this.setRegionId = function(regionId) {
        this.regionId = regionId;
    };
    this.setAccidentPlace = function(accidentPlace) {
        this.accidentPlace = accidentPlace;
    };
    this.setComment = function(comment) {
        this.comment = comment;
    };
    this.setSupportServiceId = function(supportServiceId) {
        this.supportServiceId = supportServiceId;
    };
}


function Member() {

    this.setId = function(id) {
        this.id = id;
    };

    this.setName = function(name) {
        this.name = name;
    };

    this.setPatronymic = function(patronymic) {
        this.patronymic = patronymic;
    };

    this.setSurName = function(surName) {
        this.surName = surName;
    };

    this.setBirthDate = function(birthDate) {
        this.birthDate = birthDate;
    };

    this.setGender = function(gender) {
        this.gender = gender;
    };

    this.setCitizenship = function(citizenship) {
        this.citizenship = citizenship;
    };

    this.setRegion = function(region) {
        this.region = region;
    };

    this.setLocation = function(location) {
        this.location = location;
    };

    this.setPostCode = function(postCode) {
        this.postCode = postCode;
    };

    this.setStreet = function(street) {
        this.street = street;
    };

    this.setHouseNumber = function(houseNumber) {
        this.houseNumber = houseNumber;
    };

    this.setUnitNumber = function(unitNumber) {
        this.unitNumber = unitNumber;
    };

    this.setAppartmentNumber = function(appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    };

    this.setMobilePhone = function(mobilePhone) {
        this.mobilePhone = mobilePhone;
    };

    this.setWorkPhone = function(workPhone) {
        this.workPhone = workPhone;
    };

    this.setHomePhone = function(homePhone) {
        this.homePhone = homePhone;
    };

    this.setEmail = function(email) {
        this.email = email;
    };

    this.setQuestionnairyDate = function(questionnairyDate) {
        this.questionnairyDate = questionnairyDate;
    };

    this.setMembershipStatus = function(membershipStatus) {
        this.membershipStatus = membershipStatus;
    };

    this.setComment = function(comment) {
        this.comment = comment;
    };

    this.setMemberCar = function(memberCar) {
        this.memberCars = memberCar;
    };

    this.setMemberPolicies = function(memberPolicies) {
        this.memberPolicies = memberPolicies;
    };

    this.setMemberPays = function(memberPays) {
        this.memberPays = memberPays;
    };

    this.setMemberPays = function(memberPays) {
        this.memberPays = memberPays;
    };
    this.setMemberCard = function(memberCard) {
        this.memberCard = memberCard;
    };
}


var genders = [
    ['Мужской'],
    ['Женский']
];

var gendersStore = new Ext.data.ArrayStore({
    fields: ['id'],
    data : genders
});

var gendersCombo = new Ext.form.ComboBox({
    store: gendersStore,
    fieldLabel: '<div class="float-left">Пол</div><div class="icon-imp">*</div>',
    name: 'gender',
    anchor: '95%',
    displayField: 'id',
    valueField: 'id',
    maxLength: 10,
    typeAhead: false,
    mode: 'local',
    triggerAction: 'all',
    emptyText: 'Выберите пол...',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Пол должен быть указан'
});

var paymentDestination = [
    ['Базовый'],
    ['Вступительный']
];

var paymentDestinationStore = new Ext.data.ArrayStore({
    fields: ['id'],
    data : paymentDestination
});

var paymentDestinationCombo = new Ext.form.ComboBox({
    store: paymentDestinationStore,
    fieldLabel: '<div class="float-left">Назначение платежа</div><div class="icon-imp">*</div>',
    name: 'paymentDestination',
    anchor: '95%',
    displayField: 'id',
    valueField: 'id',
    maxLength: 15,
    typeAhead: false,
    mode: 'local',
    triggerAction: 'all',
    emptyText: 'Выберите назначение платежа...',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Назначение платежа должно быть указано'
});

var paymentWay = [
    ['Нал в РегОтд'],
    ['Б\\Н от РегОтд']
];

var paymentWayStore = new Ext.data.ArrayStore({
    fields: ['id'],
    data : paymentWay
});

var paymentWayCombo = new Ext.form.ComboBox({
    store: paymentWayStore,
    fieldLabel: '<div class="float-left">Способ оплаты</div><div class="icon-imp">*</div>',
    name: 'paymentWay',
    anchor: '95%',
    displayField: 'id',
    valueField: 'id',
    maxLength: 15,
    typeAhead: false,
    mode: 'local',
    triggerAction: 'all',
    emptyText: 'Выберите способ оплаты...',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Способ оплаты должен быть указан'
});

var start = {
    id: 'start-panel',
    title: 'Добро пожаловать!',
    layout: 'fit',
    bodyStyle: 'background: url(images/voa-logo.png) no-repeat center; background-color: #dfe8f6'
};


var infoReader = new Ext.data.JsonReader({
    idProperty: 'id',
    root: 'infos',
    fields: [
        {
            name: 'info'
        }
    ]
});

var infoStore = new Ext.data.Store({
    reader: infoReader,
    proxy: new Ext.data.HttpProxy({
        url: 'data/NodesInfo.json',
        method: 'GET'
    }),
    autoLoad: true
});

function isMemberInfoValid(fields) {
    var fieldsSize = fields.length;
    for (i = 0; i < fieldsSize; i++) {
        if (!fields[i].isValid()) {
            return false;
        }
    }
    return true;
}

function getAllCars(v, record) {
    var outData = '';
    var cars = record.memberCars;
    var carCount = cars.length;
    var car;
    var carBrand;
    var carModel;
    var carRegNumber;
    for (i = 0; i < carCount; i++) {
        car = cars[i];
        carBrand = car.carBrand.brandName;
        carModel = car.carModel.modelName;
        carRegNumber = car.registrationNumber;
        if (carRegNumber == null) {
            carRegNumber = ' - ';
        }
        outData += '<div style="background-color: #ccffcc"><b>Модель автомобиля:</b> ' + carBrand + ' ' + carModel + ' <b>Рег.номер:</b> ' + carRegNumber + '</div>';
    }
    if (outData == '') {
        outData = '<div style="background-color: #ffcccc"><b>Модель автомобиля:</b> Отсутствует.</div>';
    }
    return outData;
}

function getAllCarsNative(v, record) {
    var data = [];
    var car;
    var cars = record.memberCars;
    for (var i = 0; i < cars.length; i++) {
        car = cars[i];
        data.push({
            carBrand : car.carBrand.id,
            carModel : car.carModel.id,
            carDate: '',
            registrationNumber: car.registrationNumber
        });
    }

    return data;
    //
    //    var outData = '';
    //    var cars = record.memberCars;
    //    var carCount = cars.length;
    //    var car;
    //    var carBrand;
    //    var carModel;
    //    var carRegNumber;
    //    for (i = 0; i < carCount; i++) {
    //        car = cars[i];
    //        carBrand = car.carBrand.brandName;
    //        carModel = car.carModel.modelName;
    //        carRegNumber = car.registrationNumber;
    //        if (carRegNumber == null) {
    //            carRegNumber = ' - ';
    //        }
    //        outData += '<div style="background-color: #ccffcc"><b>Модель автомобиля:</b> ' + carBrand + ' ' + carModel + ' <b>Рег.номер:</b> ' + carRegNumber + '</div>';
    //    }
    //    if (outData == '') {
    //        outData = '<div style="background-color: #ffcccc"><b>Модель автомобиля:</b> Отсутствует.</div>';
    //    }
    //    return outData;
}

function getAllInsuranceNative(v, record) {
    var data = [];
    var ins;
    var inss = record.memberPolicies;
    for (var i = 0; i < inss.length; i++) {
        ins = inss[i];
        data.push({
            insuaranceCompany : ins.insuaranceCompany,
            policyEndDate : new Date(ins.policyEndDate)
        });
    }

    return data;
}

function getCarModel(v, record) {
    var cars = record.memberCars;
    var carCount = cars.length;
    var car;
    var carModel;
    for (i = 0; i < carCount; i++) {
        car = cars[i];
        carModel = car.carModel.id;
    }

    return carModel;
}

function getCarBrand(v, record) {
    var cars = record.memberCars;
    var carCount = cars.length;
    var car;
    var carBrand;
    for (i = 0; i < carCount; i++) {
        car = cars[i];
        carBrand = car.carBrand.id;
    }

    return carBrand;
}

function getRegNumber(v, record) {
    var cars = record.memberCars;
    var carCount = cars.length;
    var car;
    var carRegNumber;
    for (i = 0; i < carCount; i++) {
        car = cars[i];
        carRegNumber = car.registrationNumber;
    }

    return carRegNumber;
}

//function getAllPolicieses(v, record) {
//    return record.memberPays.length;
//}
//
//function getAllRegions(v, record) {
//    return record.memberPays.length;
//}
//
//function getAllCards(v, record) {
//    return record.memberPays.length;
//}
//
//function getAllPays(v, record) {
//    return record.memberPays.length;
//}


var memberReader = new Ext.data.JsonReader({
    idProperty: 'id',
    root: 'members',
    totalProperty: 'totalRows',
    fields: ['id',
        'name',
        'patronymic',
        'surName',
        'birthDate',
        'gender',
        'citizenship',
        {name: 'car', convert: getAllCars},
        {name: 'carNative', convert: getAllCarsNative},
        {name: 'carModel', convert: getCarModel},
        {name: 'carBrand', convert: getCarBrand},
        {name: 'carRegNumber', convert: getRegNumber},
        {name: 'region', mapping: 'region.regionID'},
        {name: 'insuranceNative', convert: getAllInsuranceNative},
        //{name: 'insuaranceCompany', mapping: 'memberPolicies.insuaranceCompany'},
        //{name: 'policyEndDate', mapping: 'memberPolicies.policyEndDate'},
        //{name: 'memberCardId', mapping: 'memberCard.id'},
        'location',
        'postCode',
        'street',
        'houseNumber',
        'unitNumber',
        'appartmentNumber',
        'mobilePhone',
        'workPhone',
        'homePhone',
        'email',
        'questionnairyDate',
        'membershipStatus',
        'comment',
        'memberCars',
        'memberPolicies',
        'documentDate',
        'documentSeries',
        'documentNumber',
        'documentPublisher',
        'documentType']
});

var memberStore = new Ext.data.Store({
    reader: memberReader,
    proxy: new Ext.data.HttpProxy({
        url: 'rest/members',
        method: 'GET',
        headers: {
            'Accept' : 'application/json'
        }
    }),
    paramNames: {
        start : 'firstRow',
        limit : 'listSize'
    },
    baseParams: {
        sortOrder: 'asc',
        sortColumn: 'id'
    }
});

var memberPaymentReader = new Ext.data.JsonReader({
    idProperty: 'id',
    root: 'members',
    totalProperty: 'totalRows',
    fields: ['id',
        'memberId',
        'ammount',
        'bic',
        'memberBankBook',
        'paymentDate',
        'paymentDestination',
        'paymentType',
        'paymentWay',
        'payStatus',
        'ticketNumber',
        'registrationDate',
        'id']
});

var memberPaymentProxy = new Ext.data.HttpProxy({
    url: 'rest/pays',
    method: 'GET',
    headers: {
        'Accept' : 'application/json'
    }
});

var memberPaymentStore = new Ext.data.Store({
    reader: memberPaymentReader,
    proxy: memberPaymentProxy,
    paramNames: {
        start : 'firstRow',
        limit : 'listSize'
    },
    baseParams: {
        sortOrder: 'asc',
        sortColumn: 'id'
    }
});

memberPaymentStore.on('beforeload', function () {
    if (isPaymentsSearch) {
        if (Ext.getCmp('paymentDateSearch').isValid()) {
            var date;
            if (Ext.getCmp('paymentDateSearch').getValue() == '') {
                date = null;
            } else {
                date = Ext.getCmp('paymentDateSearch').getValue().format("d.m.Y").toString();
            }
            memberPaymentStore.baseParams = {
                sortOrder: 'asc',
                sortColumn: 'id',
                date: date
            };
        } else {
            memberPaymentStore.baseParams = {
                sortOrder: 'asc',
                sortColumn: 'id',
                date: null
            };
        }
    } else {
        memberPaymentStore.baseParams = {
            sortOrder: 'asc',
            sortColumn: 'id',
            date: null
        };
    }

});


var regionReader = new Ext.data.JsonReader({
    idProperty: 'regionID',
    fields: ['regionID',
        'regionName']
});

var regionStore = new Ext.data.Store({
    reader: regionReader,
    proxy: new Ext.data.HttpProxy({
        url: 'rest/regions',
        method: 'GET',
        headers: {
            'Accept' : 'application/json'
        }
    })
});

var regionsCombo = new Ext.form.ComboBox({
    store: regionStore,
    name: 'region',
    fieldLabel: '<div class="float-left">Регион</div><div class="icon-imp">*</div>',
    anchor: '95%',
    displayField: 'regionName',
    valueField: 'regionID',
    typeAhead: false,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText: 'Выберите регион...',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Регион должен быть указан'
});

var regionsComboTech = new Ext.form.ComboBox({
    store: regionStore,
    name: 'region',
    fieldLabel: '<div class="float-left">Регион</div><div class="icon-imp">*</div>',
    anchor: '95%',
    displayField: 'regionName',
    valueField: 'regionID',
    typeAhead: false,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText: 'Выберите регион...',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Регион должен быть указан'
});


var candidatStore = new Ext.data.Store({
    reader: memberReader,
    proxy: new Ext.data.HttpProxy({
        url: 'rest/candidates',
        method: 'GET',
        headers: {
            'Accept' : 'application/json'
        }
    }),
    paramNames: {
        start : 'firstRow',
        limit : 'listSize'
    },
    baseParams: {
        sortOrder: 'asc',
        sortColumn: 'id'
    }
});


var carBrandReader = new Ext.data.JsonReader({
    idProperty: 'id',
    fields: ['id',
        'brandName']
});

var carBrandStore = new Ext.data.Store({
    reader: carBrandReader,
    proxy: new Ext.data.HttpProxy({
        url: 'rest/brands',
        method: 'GET',
        headers: {
            'Accept' : 'application/json'
        }
    })
});
var carBrandsCombo = new Ext.form.ComboBox({
    store: carBrandStore,
    name: 'carBrand',
    fieldLabel: '<div class="float-left">Марка автомобиля</div><div class="icon-imp">*</div>',
    anchor: '95%',
    displayField: 'brandName',
    valueField: 'id',
    typeAhead: false,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText: 'Выберите марку...',
    selectOnFocus: true,
    allowBlank: false,
    blankText: 'Марка автомобиля должна быть указана',
    listeners:{
        'select': function() {
            if (!isFirstLoadCarModels) {
                carModelStore.reload();
            } else {
                isFirstLoadCarModels = false;
            }
            carModelsCombo.setDisabled(false);

        }

    }
});

var carModelReader = new Ext.data.JsonReader({
    idProperty: 'id',
    fields: ['id',
        'modelName',
        'brandId'
    ]
});

var carModelProxy = new Ext.data.HttpProxy({
    url: 'rest/modelsByBrand?brandId=0',
    method: 'GET',
    headers: {
        'Accept' : 'application/json'
    }
});

var carModelStore = new Ext.data.Store({
    reader: carModelReader,
    proxy: carModelProxy,
    listeners:{
        'beforeload': function() {
            if (!isFirstLoadCarModels) {
                carModelProxy.setUrl('rest/modelsByBrand?brandId=' + carBrandsCombo.getValue());
            } else {
                isFirstLoadCarModels = false;
            }
        }

    }
});

var carModelsCombo = new Ext.form.ComboBox({
    store: carModelStore,
    name: 'carModel',
    fieldLabel: '<div class="float-left">Модель автомобиля</div><div class="icon-imp">*</div>',
    anchor: '95%',
    displayField: 'modelName',
    valueField: 'id',
    typeAhead: false,
    mode: 'remote',
    forceSelection: true,
    triggerAction: 'all',
    emptyText: 'Выберите модель...',
    selectOnFocus: true,
    allowBlank: false,
    disabled: true,
    blankText: 'Модель автомобиля должна быть указана'
});


function renderTitle(value, p, record) {
    return String.format('<b>{0}</b>', value);
}

var comboPerPageMember = new Ext.form.ComboBox({
    name : 'perpage',
    width: 60,
    store: new Ext.data.ArrayStore({
        fields: ['id'],
        data  : [
            ['15'],
            ['25'],
            ['50']
        ]
    }),
    mode : 'local',
    value: '25',
    listWidth     : 40,
    triggerAction : 'all',
    displayField  : 'id',
    valueField    : 'id',
    editable      : false,
    forceSelection: true
});


var bbarMember = new Ext.PagingToolbar({
    //store:       memberStore, //the store you use in your grid
    //displayInfo: true,
    pageSize: 25,
    store: memberStore,
    displayInfo: true,
    firstText: 'Первая страница',
    prevText: 'Предыдущая страница',
    nextText : 'Следующая страница',
    lastText : 'Последняя страница',
    refreshText : 'Обновить',
    displayMsg: 'Показ строк {0} - {1} из {2}',
    emptyMsg: "Нет строк для отображения...",
    beforePageText: 'Страница',
    afterPageText: 'из {0}',
    baseParams : {
        sortOrder: 'asc',
        sortColumn: 'id'
    },
    items   :    [
        '-',
        'Строк: ',
        comboPerPageMember,
        '-',
        {
            pressed: false,
            enableToggle: true,
            text: 'Дополнительная информация',
            style:{
                marginLeft: '40px'
            },
            cls: 'x-btn-text-icon details',
            toggleHandler: function (btn, pressed) {
                var view = memberGrid.getView();
                view.showPreview = pressed;
                view.refresh();
            }
        }
    ]
});

comboPerPageMember.on('select', function(combo, record) {
    bbarMember.pageSize = parseInt(record.get('id'), 10);
    bbarMember.doLoad(bbarMember.cursor);
}, this);

var mask = new Ext.LoadMask(Ext.getBody(), {
    msg:"Пожалуйста, подождите..."
});

var memberGrid = new Ext.grid.GridPanel({
    store: memberStore,
    loadMask: mask,
    sm: new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    columns: [
        new Ext.grid.RowNumberer(),
        {
            header: "Номер ЛС члена ВОА",
            dataIndex: 'id',
            //width: 110,
            renderer: renderTitle,
            sortable: true
        },
        {
            header: "Фамилия",
            dataIndex: 'surName',
            //width: 150,
            sortable: true
        },
        {
            header: "Имя",
            dataIndex: 'name',
            //width: 150,
            sortable: true,
            align: 'left'
        },
        {
            header: "Отчество",
            dataIndex: 'patronymic',
            //width: 150,
            sortable: true
        },
        {
            header: "Пол",
            dataIndex: 'gender',
            //width: 200,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Место жительства",
            dataIndex: 'location',
            //width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Сотовый телефон",
            dataIndex: 'mobilePhone',
            //width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "E-Mail",
            dataIndex: 'email',
            //width: 200,
            align: 'left',
            sortable: true,
            hidden: false
        }
    ],
    viewConfig: {
        forceFit: true,
        enableRowBody: true,
        showPreview: false,
        getRowClass: function (record, rowIndex, p, store) {
            if (this.showPreview) {
                p.body = record.data.car;
                return 'x-grid3-row-expanded';
            }
            return 'x-grid3-row-collapsed';
        }
    },
    bbar:  bbarMember,
    listeners: {
        rowdblclick: function (grid, rowIndex, e) {
            Ext.getCmp('name').setValue(memberGrid.getStore().getAt(rowIndex).get('name'));
            Ext.getCmp('surName').setValue(memberGrid.getStore().getAt(rowIndex).get('surName'));
            Ext.getCmp('patronymic').setValue(memberGrid.getStore().getAt(rowIndex).get('patronymic'));
            Ext.getCmp('birthDate').setValue(new Date(memberGrid.getStore().getAt(rowIndex).get('birthDate')));
            gendersCombo.setValue(memberGrid.getStore().getAt(rowIndex).get('gender'));
            Ext.getCmp('citizenship').setValue(memberGrid.getStore().getAt(rowIndex).get('citizenship'));
            Ext.getCmp('location').setValue(memberGrid.getStore().getAt(rowIndex).get('location'));
            Ext.getCmp('postCode').setValue(memberGrid.getStore().getAt(rowIndex).get('postCode'));
            Ext.getCmp('street').setValue(memberGrid.getStore().getAt(rowIndex).get('street'));
            Ext.getCmp('houseNumber').setValue(memberGrid.getStore().getAt(rowIndex).get('houseNumber'));
            Ext.getCmp('unitNumber').setValue(memberGrid.getStore().getAt(rowIndex).get('unitNumber'));
            Ext.getCmp('appartmentNumber').setValue(memberGrid.getStore().getAt(rowIndex).get('appartmentNumber'));
            Ext.getCmp('mobilePhone').setValue(memberGrid.getStore().getAt(rowIndex).get('mobilePhone'));
            Ext.getCmp('workPhone').setValue(memberGrid.getStore().getAt(rowIndex).get('workPhone'));
            Ext.getCmp('homePhone').setValue(memberGrid.getStore().getAt(rowIndex).get('homePhone'));
            Ext.getCmp('email').setValue(memberGrid.getStore().getAt(rowIndex).get('email'));
            //Ext.getCmp('questionnairyDate').setValue(new Date(memberGrid.getStore().getAt(rowIndex).get('questionnairyDate')));
            //Ext.getCmp('insuaranceCompany').setValue(memberGrid.getStore().getAt(rowIndex).get('insuaranceCompany'));
            //Ext.getCmp('policyEndDate').setValue(memberGrid.getStore().getAt(rowIndex).get('policyEndDate'));
            Ext.getCmp('comment').setValue(memberGrid.getStore().getAt(rowIndex).get('comment'));
            if (regionsCombo.getStore().getCount() == 0) {
                regionsCombo.getStore().load({
                    callback: function (response, opts, success) {
                        regionsCombo.setValue(memberGrid.getStore().getAt(rowIndex).get('region'));
                    }
                });
            } else {
                regionsCombo.setValue(memberGrid.getStore().getAt(rowIndex).get('region'));
            }

            //carModelsCombo.setValue(memberGrid.getStore().getAt(rowIndex).get('carModel'));


            //Ext.getCmp('registrationNumber').setValue(memberGrid.getStore().getAt(rowIndex).get('carRegNumber'));

            isUpdateMember = true;
            memberCarsStore.loadData(memberGrid.getStore().getAt(rowIndex).get('carNative'));
            memberInsuarancesStore.loadData(memberGrid.getStore().getAt(rowIndex).get('insuranceNative'));
            memberId = memberGrid.getStore().getAt(rowIndex).get('id');
            memberCardId = memberGrid.getStore().getAt(rowIndex).get('memberCardId');
            winAdd.show();
        }
    }
});

var comboPerPageCandidat = new Ext.form.ComboBox({
    name : 'perpage',
    width: 60,
    store: new Ext.data.ArrayStore({
        fields: ['id'],
        data  : [
            ['15'],
            ['25'],
            ['50']
        ]
    }),
    mode : 'local',
    value: '25',
    listWidth     : 40,
    triggerAction : 'all',
    displayField  : 'id',
    valueField    : 'id',
    editable      : false,
    forceSelection: true
});


var bbarCandidat = new Ext.PagingToolbar({
    //store:       memberStore, //the store you use in your grid
    //displayInfo: true,
    pageSize: 25,
    store: candidatStore,
    displayInfo: true,
    firstText: 'Первая страница',
    prevText: 'Предыдущая страница',
    nextText : 'Следующая страница',
    lastText : 'Последняя страница',
    refreshText : 'Обновить',
    displayMsg: 'Показ строк {0} - {1} из {2}',
    emptyMsg: "Нет строк для отображения...",
    beforePageText: 'Страница',
    afterPageText: 'из {0}',
    baseParams : {
        sortOrder: 'asc',
        sortColumn: 'id'
    },
    items   :    [
        '-',
        'Строк: ',
        comboPerPageCandidat,
        '-',
        {
            pressed: false,
            enableToggle: true,
            text: 'Дополнительная информация',
            cls: 'x-btn-text-icon details',
            style:{
                marginLeft: '40px'
            },
            toggleHandler: function (btn, pressed) {
                var view = candidatGrid.getView();
                view.showPreview = pressed;
                view.refresh();
            }
        }
    ]
});

comboPerPageCandidat.on('select', function(combo, record) {
    bbarCandidat.pageSize = parseInt(record.get('id'), 10);
    bbarCandidat.doLoad(bbarCandidat.cursor);
}, this);


var candidatGrid = new Ext.grid.GridPanel({
    store: candidatStore,
    loadMask: mask,
    sm: new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    columns: [
        new Ext.grid.RowNumberer(),
        {
            header: "Номер ЛС члена ВОА",
            dataIndex: 'id',
            // width: 110,
            renderer: renderTitle,
            sortable: true
        },
        {
            header: "Фамилия",
            dataIndex: 'surName',
            // width: 150,
            sortable: true
        },
        {
            header: "Имя",
            dataIndex: 'name',
            //width: 150,
            sortable: true,
            align: 'left'
        },
        {
            header: "Отчество",
            dataIndex: 'patronymic',
            // width: 150,
            sortable: true
        },
        {
            header: "Пол",
            dataIndex: 'gender',
            //width: 200,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Место жительства",
            dataIndex: 'location',
            //width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Сотовый телефон",
            dataIndex: 'mobilePhone',
            // width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "E-Mail",
            dataIndex: 'email',
            //width: 200,
            align: 'left',
            sortable: true,
            hidden: false
        }
    ],
    viewConfig: {
        forceFit: true,
        enableRowBody: true,
        showPreview: false,
        getRowClass: function (record, rowIndex, p, store) {
            if (this.showPreview) {
                p.body = record.data.car;
                return 'x-grid3-row-expanded';
            }
            return 'x-grid3-row-collapsed';
        }
    },
    tbar:[

        {
            text: 'Добавить',
            id: 'winAdd',
            iconCls: 'icon-add-record',
            handler: function () {
                isUpdateMember = false;
                Ext.getCmp('name').reset();
                Ext.getCmp('surName').reset();
                Ext.getCmp('patronymic').reset();
                Ext.getCmp('birthDate').reset();
                gendersCombo.reset();
                Ext.getCmp('citizenship').reset();
                Ext.getCmp('location').reset();
                Ext.getCmp('postCode').reset();
                Ext.getCmp('street').reset();
                Ext.getCmp('houseNumber').reset();
                Ext.getCmp('unitNumber').reset();
                Ext.getCmp('appartmentNumber').reset();
                Ext.getCmp('mobilePhone').reset();
                Ext.getCmp('workPhone').reset();
                Ext.getCmp('homePhone').reset();
                Ext.getCmp('email').reset();
                //Ext.getCmp('questionnairyDate').setValue();
                //Ext.getCmp('insuaranceCompany').reset();
                //Ext.getCmp('policyEndDate').reset();
                Ext.getCmp('comment').reset();
                regionsCombo.reset();
                carModelsCombo.reset();
                carBrandsCombo.reset();
                //Ext.getCmp('registrationNumber').reset();
                Ext.getCmp('memberTab').setActiveTab(0);
                memberCarsStore.removeAll();
                memberInsuarancesStore.removeAll();
                winAdd.show();
                isUpdateCandidat = true;
            }
        }
    ],
    bbar: bbarCandidat
    /*listeners: {
     rowdblclick: function (grid, rowIndex, e) {
     Ext.getCmp('name').setValue(candidatGrid.getStore().getAt(rowIndex).get('name'));
     Ext.getCmp('surName').setValue(candidatGrid.getStore().getAt(rowIndex).get('surName'));
     Ext.getCmp('patronymic').setValue(candidatGrid.getStore().getAt(rowIndex).get('patronymic'));
     Ext.getCmp('birthDate').setValue(new Date(candidatGrid.getStore().getAt(rowIndex).get('birthDate')));
     gendersCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('gender'));
     Ext.getCmp('citizenship').setValue(candidatGrid.getStore().getAt(rowIndex).get('citizenship'));
     Ext.getCmp('location').setValue(candidatGrid.getStore().getAt(rowIndex).get('location'));
     Ext.getCmp('postCode').setValue(candidatGrid.getStore().getAt(rowIndex).get('postCode'));
     Ext.getCmp('street').setValue(candidatGrid.getStore().getAt(rowIndex).get('street'));
     Ext.getCmp('houseNumber').setValue(candidatGrid.getStore().getAt(rowIndex).get('houseNumber'));
     Ext.getCmp('unitNumber').setValue(candidatGrid.getStore().getAt(rowIndex).get('unitNumber'));
     Ext.getCmp('appartmentNumber').setValue(candidatGrid.getStore().getAt(rowIndex).get('appartmentNumber'));
     Ext.getCmp('mobilePhone').setValue(candidatGrid.getStore().getAt(rowIndex).get('mobilePhone'));
     Ext.getCmp('workPhone').setValue(candidatGrid.getStore().getAt(rowIndex).get('workPhone'));
     Ext.getCmp('homePhone').setValue(candidatGrid.getStore().getAt(rowIndex).get('homePhone'));
     Ext.getCmp('email').setValue(candidatGrid.getStore().getAt(rowIndex).get('email'));
     //Ext.getCmp('questionnairyDate').setValue(new Date(memberGrid.getStore().getAt(rowIndex).get('questionnairyDate')));
     Ext.getCmp('insuaranceCompany').setValue(candidatGrid.getStore().getAt(rowIndex).get('insuaranceCompany'));
     Ext.getCmp('policyEndDate').setValue(candidatGrid.getStore().getAt(rowIndex).get('policyEndDate'));
     Ext.getCmp('comment').setValue(candidatGrid.getStore().getAt(rowIndex).get('comment'));
     if (regionsCombo.getStore().getCount() == 0) {
     regionsCombo.getStore().load({
     callback: function (response, opts, success) {
     regionsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('region'));
     }
     });
     } else {
     regionsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('region'));
     }

     carModelsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('carModel'));

     if (carBrandsCombo.getStore().getCount() == 0) {
     carBrandsCombo.getStore().load({
     callback: function (response, opts, success) {
     carBrandsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('carBrand'));
     carModelsCombo.getStore().load({
     callback: function (response, opts, success) {
     carModelsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('carModel'));
     carModelsCombo.setDisabled(false);
     }
     });
     }
     });
     } else {
     carBrandsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('carBrand'));
     carModelsCombo.getStore().load({
     callback: function (response, opts, success) {
     carModelsCombo.setValue(candidatGrid.getStore().getAt(rowIndex).get('carModel'));
     carModelsCombo.setDisabled(false);
     }
     });
     }


     Ext.getCmp('registrationNumber').setValue(candidatGrid.getStore().getAt(rowIndex).get('carRegNumber'));
     isUpdateCandidat = true;
     memberId = candidatGrid.getStore().getAt(rowIndex).get('id');
     memberCardId = candidatGrid.getStore().getAt(rowIndex).get('memberCardId');
     winAdd.show();
     }
     }*/
});


var comboPerPagePayment = new Ext.form.ComboBox({
    name : 'perpage',
    width: 60,
    store: new Ext.data.ArrayStore({
        fields: ['id'],
        data  : [
            ['15'],
            ['25'],
            ['50']
        ]
    }),
    mode : 'local',
    value: '25',
    listWidth     : 40,
    triggerAction : 'all',
    displayField  : 'id',
    valueField    : 'id',
    editable      : false,
    forceSelection: true
});


var bbarPayment = new Ext.PagingToolbar({
    //store:       memberStore, //the store you use in your grid
    //displayInfo: true,
    pageSize: 25,
    store: memberPaymentStore,
    displayInfo: true,
    firstText: 'Первая страница',
    prevText: 'Предыдущая страница',
    nextText : 'Следующая страница',
    lastText : 'Последняя страница',
    refreshText : 'Обновить',
    displayMsg: 'Показ строк {0} - {1} из {2}',
    emptyMsg: "Нет строк для отображения...",
    beforePageText: 'Страница',
    afterPageText: 'из {0}',
    baseParams : {
        sortOrder: 'asc',
        sortColumn: 'id'
    },
    items   :    [
        '-',
        'Строк: ',
        comboPerPagePayment
    ]
});

comboPerPagePayment.on('select', function(combo, record) {
    bbarPayment.pageSize = parseInt(record.get('id'), 10);
    bbarPayment.doLoad(bbarPayment.cursor);
}, this);


var paymentGrid = new Ext.grid.GridPanel({
    store: memberPaymentStore,
    loadMask: mask,
    sm: new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    columns: [
        new Ext.grid.RowNumberer(),
        {
            header: "Номер платежа",
            dataIndex: 'id',
            //width: 110,
            renderer: renderTitle,
            sortable: true
        },
        {
            header: "Номер ЛС члена ВОА",
            dataIndex: 'memberId',
            width: 115,
            sortable: true,
            align: 'left'
        },
        {
            header: "Дата рег. платежа",
            dataIndex: 'registrationDate',
            //            width: 110,
            renderer: dateRenderer,
            sortable: true,
            align: 'left'
        },
        {
            header: "БИК",
            dataIndex: 'bic',
            //width: 80,
            sortable: true
        },
        {
            header: "Номер квитанции",
            dataIndex: 'memberBankBook',
            sortable: true
        },
        {
            header: "Способ оплаты",
            dataIndex: 'paymentWay',
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Тип оплаты",
            dataIndex: 'paymentType',
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Сумма платежа",
            dataIndex: 'ammount',
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Статус платежа",
            dataIndex: 'payStatus',
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Назначение платежа",
            dataIndex: 'paymentDestination',
            //width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Номер л/с",
            dataIndex: 'ticketNumber',
            //width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        }
    ],
    viewConfig: {
        forceFit: true
    },
    tbar:[
        {
            text: 'Добавить платеж',
            id: 'winAddPayment',
            iconCls: 'icon-add-record',
            handler: function () {
                winAddPayment.show();
            }
        },
        {
            xtype: 'tbtext',
            text:'<b>Дата регистрации платежа:</b>',
            style: {
                marginRight: '5px',
                marginLeft: '5px'
            },
            bodyStyle: 'border: 0px'
        },
        new Ext.form.DateField({
            format: 'd.m.Y',
            preventMark: true,
            //value: new Date(),
            name: 'paymentDateSearch',
            id: 'paymentDateSearch',
            width: 220,
            style: {
                marginLeft: '0px',
                marginRight: '0px'
            },
            //allowBlank: false,
            blankText: 'Дата должна быть указана'
        }),
        {
            text: 'Поиск',
            iconCls: 'icon-find',
            style: {
                marginLeft: '211px',
                marginRight: '7px'
            },
            handler: function () {
                if (Ext.getCmp('paymentDateSearch').isValid()) {
                    isPaymentsSearch = true;
                    var date;
                    if (Ext.getCmp('paymentDateSearch').getValue() == '') {
                        date = null;
                    } else {
                        date = Ext.getCmp('paymentDateSearch').getValue().format("d.m.Y").toString();
                    }
                    memberPaymentStore.load({
                        params: {
                            firstRow: 0,
                            listSize: comboPerPagePayment.getValue(),
                            sortOrder: 'asc',
                            sortColumn: 'id',
                            date: date
                        }
                    });
                } else {
                    memberPaymentStore.load({
                        params: {
                            firstRow: 0,
                            listSize: comboPerPagePayment.getValue(),
                            sortOrder: 'asc',
                            sortColumn: 'id',
                            date: null
                        }
                    });
                }
            }
        }
    ],
    bbar: bbarPayment,
    listeners: {
        rowdblclick: function (grid, rowIndex, e) {
            Ext.getCmp('idUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('id'));
            Ext.getCmp('memberIdVOAUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('memberId'));
            Ext.getCmp('ammountUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('ammount'));
            Ext.getCmp('bicUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('bic'));
            Ext.getCmp('paymentDateUpdate').setValue(new Date(paymentGrid.getStore().getAt(rowIndex).get('paymentDate')));
            Ext.getCmp('registrationDateUpdate').setValue(new Date(paymentGrid.getStore().getAt(rowIndex).get('registrationDate')));
            Ext.getCmp('memberBankBookUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('memberBankBook'));
            Ext.getCmp('paymentDestinationUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('paymentDestination'));
            Ext.getCmp('paymentTypeUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('paymentType'));
            Ext.getCmp('paymentWayUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('paymentWay'));
            Ext.getCmp('payStatusUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('payStatus'));
            Ext.getCmp('ticketNumberUpdate').setValue(paymentGrid.getStore().getAt(rowIndex).get('ticketNumber'));
            winUpdatePayment.show();
        }
    }
});

//**
var techSupportReader = new Ext.data.JsonReader({
    idProperty: 'id',
    root: 'recourses',
    totalProperty: 'totalRows',
    fields: ['id',
        'memberId',
        'phoneNumber',
        'accidentPlace',
        'recourseDate',
        'regionId',
        'supportServiceId',
        'comment',
        'action']
});

var techSupportProxy = new Ext.data.HttpProxy({
    url: 'rest/getTechnicalRecourses',
    method: 'GET',
    headers: {
        'Accept' : 'application/json'
    }
});

var techSupportStore = new Ext.data.Store({
    reader: techSupportReader,
    proxy: techSupportProxy,
    paramNames: {
        start : 'firstRow',
        limit : 'listSize'
    },
    baseParams: {
        sortOrder: 'asc',
        sortColumn: 'id'
    }
});

techSupportStore.on('beforeload', function () {
    techSupportStore.baseParams = {
        sortOrder: 'asc',
        sortColumn: 'id',
        date: null
    };
});

var comboPerPageTechSupport = new Ext.form.ComboBox({
    name : 'perpage',
    width: 60,
    store: new Ext.data.ArrayStore({
        fields: ['id'],
        data  : [
            ['15'],
            ['25'],
            ['50']
        ]
    }),
    mode : 'local',
    value: '25',
    listWidth     : 40,
    triggerAction : 'all',
    displayField  : 'id',
    valueField    : 'id',
    editable      : false,
    forceSelection: true
});


var bbarTechSupport = new Ext.PagingToolbar({
    //store:       memberStore, //the store you use in your grid
    //displayInfo: true,
    pageSize: 25,
    store: techSupportStore,
    displayInfo: true,
    firstText: 'Первая страница',
    prevText: 'Предыдущая страница',
    nextText : 'Следующая страница',
    lastText : 'Последняя страница',
    refreshText : 'Обновить',
    displayMsg: 'Показ строк {0} - {1} из {2}',
    emptyMsg: "Нет строк для отображения...",
    beforePageText: 'Страница',
    afterPageText: 'из {0}',
    baseParams : {
        sortOrder: 'asc',
        sortColumn: 'id'
    },
    items   :    [
        '-',
        'Строк: ',
        comboPerPageTechSupport
    ]
});

comboPerPageTechSupport.on('select', function(combo, record) {
    bbarTechSupport.pageSize = parseInt(record.get('id'), 10);
    bbarTechSupport.doLoad(bbarTechSupport.cursor);
}, this);

function dateRenderer(value) {
    return new Date(value).format("d.m.Y").toString();
}

function regionRenderer(value) {
    var response = regionStore.getRange(0, regionStore.getCount());
    for (i = 0; i < response.length; i++) {
        if (response[i].data.regionID == value) {
            return response[i].data.regionName;
        }
    }
}

var techSupportGrid = new Ext.grid.GridPanel({
    store: techSupportStore,
    loadMask: mask,
    sm: new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    columns: [
        new Ext.grid.RowNumberer(),
        {
            header: "Номер ЛС члена ВОА",
            dataIndex: 'memberId',
            //width: 110,
            sortable: true,
            align: 'left'
        },
        {
            header: "Телефон",
            dataIndex: 'phoneNumber',
            //width: 80,
            sortable: true
        },
        {
            header: "Место аварии",
            dataIndex: 'accidentPlace',
            sortable: true
        },
        {
            header: "Дата обращения",
            dataIndex: 'recourseDate',
            align: 'left',
            sortable: true,
            renderer : dateRenderer,
            hidden: false
        },
        {
            header: "Регион",
            dataIndex: 'regionId',
            align: 'left',
            renderer : regionRenderer,
            sortable: true,
            hidden: false
        },
        {
            header: "Поддержка",
            dataIndex: 'supportServiceId',
            align: 'left',
            sortable: true,
            hidden: true
        },
        {
            header: "Комментарий",
            dataIndex: 'comment',
            align: 'left',
            sortable: true,
            hidden: false
        },
        {
            header: "Действие",
            dataIndex: 'action',
            //width: 150,
            align: 'left',
            sortable: true,
            hidden: false
        }
    ],
    viewConfig: {
        forceFit: true
    },
    tbar:[
        //        {
        //            text: 'Добавить заявку',
        //            iconCls: 'icon-add-record',
        //            handler: function () {
        //                winAddTechSupport.show();
        //            }
        //        },
        {
            text: '1',
            id: 'winBut1',
            //iconCls: 'icon-add-record',
            handler: function () {
                win1.show();
            }
        },
        {
            text: '2',
            id: 'winBut2',
            //iconCls: 'icon-add-record',
            handler: function () {
                grid3.hide();
                memberHistoryGrid1.hide();
                Ext.getCmp('memberIdSearch').setValue('');
                Ext.getCmp('TechSupportRadioFake22').setValue('TechSupportRadioFake22', 'Не член ВОА');
                win2.show();
            }
        }
    ],
    bbar: bbarTechSupport
});


var memberCarFields = [
    {name: 'id', mapping : 'id'},
    {name: 'carBrand', mapping : 'carBrand'},
    {name: 'carModel', mapping : 'carModel'},
    {name: 'carDate', mapping : 'carDate'},
    {name: 'registrationNumber', mapping : 'registrationNumber'},
    {name: 'memberCar', mapping : 'memberCar'}
];

var memberCarsStore = new Ext.data.JsonStore({
    idProperty: 'id',
    fields : memberCarFields
});

var memberCarRecord = Ext.data.Record.create(memberCarFields);

var editor = new Ext.ux.grid.RowEditor({
    errorSummary: true,
    errorText: 'Необходимые поля:',
    saveText: 'Обновить',
    cancelText: 'Отмена',
    commitChangesText: 'Вы должны нажать обновить или отменить Ваши изменения...'
});


var empGrid = new Ext.grid.GridPanel({
    store: memberCarsStore,
    border: false,
    height: 247,
    plugins: [editor],
    viewConfig: {
        forceFit: true
    },
    tbar: [
        {
            iconCls: 'icon-add-entity',
            text: 'Добавить автомобиль',
            handler: function() {
                var car = new memberCarRecord();
                editor.stopEditing();
                memberCarsStore.insert(0, car);
                empGrid.getView().refresh();
                empGrid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        },
        {
            ref: '../removeBtnTop',
            iconCls: 'icon-remove-entity',
            text: 'Удалить автомобиль',
            disabled: true,
            handler: function() {
                editor.stopEditing();
                var s = empGrid.getSelectionModel().getSelections();
                for (var i = 0, r; r = s[i]; i++) {
                    memberCarsStore.remove(r);
                }
            }
        }
    ],
    bbar: [
        {
            iconCls: 'icon-add-entity',
            text: 'Добавить автомобиль',
            handler: function() {
                var car = new memberCarRecord();
                editor.stopEditing();
                memberCarsStore.insert(0, car);
                empGrid.getView().refresh();
                empGrid.getSelectionModel().selectRow(0);
                editor.startEditing(0);
            }
        },
        {
            ref: '../removeBtnBottom',
            iconCls: 'icon-remove-entity',
            text: 'Удалить автомобиль',
            disabled: true,
            handler: function() {
                editor.stopEditing();
                var s = empGrid.getSelectionModel().getSelections();
                for (var i = 0, r; r = s[i]; i++) {
                    memberCarsStore.remove(r);
                }
            }
        }
    ],

    columns: [
        new Ext.grid.RowNumberer(),
        {
            id: 'carBrand',
            header: 'Модель автомобиля',
            dataIndex: 'carBrand',
            sortable: true,
            editor: carBrandsCombo,
            renderer: Ext.util.Format.comboRenderer(carBrandsCombo)
        },{
            header: 'Марка автомобиля',
            dataIndex: 'carModel',
            sortable: true,
            editor: carModelsCombo,
            renderer: Ext.util.Format.comboRenderer(carModelsCombo)
        },{
            header: 'Рег.номер',
            dataIndex: 'registrationNumber',
            sortable: true,
            emptyText: 'Введите рег.номер...',
            editor: {
                xtype: 'textfield',
                emptyText: 'Введите рег.номер...',
                blankText: 'Рег.номер должен быть указан...',
                allowBlank: false
            }
        },{
            xtype: 'datecolumn',
            header: 'Дата производства',
            dataIndex: 'carDate',
            format: 'm.Y',
            sortable: true,
            editor: {
                xtype: 'datefield',
                allowBlank: true,
                blankText: 'Дата производства должна быть указана...',
                minText: 'Машина не может быть произведена позже чем сегодня...'
            }
        }]
});

empGrid.getSelectionModel().on('selectionchange', function(sm) {
    empGrid.removeBtnTop.setDisabled(sm.getCount() < 1);
    empGrid.removeBtnBottom.setDisabled(sm.getCount() < 1);
});

var memberInsuaranceFields = [
    {name: 'id', mapping : 'id'},
    {name: 'insuaranceCompany', mapping : 'insuaranceCompany'},
    {name: 'policyEndDate', mapping : 'policyEndDate'},
    {name: 'memberInsuarance', mapping : 'memberInsuarance'}
];

var memberInsuarancesStore = new Ext.data.JsonStore({
    idProperty: 'id',
    fields : memberInsuaranceFields
});

var memberInsuaranceRecord = Ext.data.Record.create(memberInsuaranceFields);

var editorIns = new Ext.ux.grid.RowEditor({
    errorSummary: true,
    errorText: 'Необходимые поля:',
    saveText: 'Обновить',
    cancelText: 'Отмена',
    commitChangesText: 'Вы должны нажать обновить или отменить Ваши изменения...'
});

var insGrid = new Ext.grid.GridPanel({
    store: memberInsuarancesStore,
    border: false,
    height: 247,
    plugins: [editorIns],
    viewConfig: {
        forceFit: true
    },
    tbar: [
        {
            iconCls: 'icon-add-entity',
            text: 'Добавить полис',
            handler: function() {
                var ins = new memberInsuaranceRecord();
                editorIns.stopEditing();
                memberInsuarancesStore.insert(0, ins);
                insGrid.getView().refresh();
                insGrid.getSelectionModel().selectRow(0);
                editorIns.startEditing(0);
            }
        },
        {
            ref: '../removeBtnTop',
            iconCls: 'icon-remove-entity',
            text: 'Удалить полис',
            disabled: true,
            handler: function() {
                editorIns.stopEditing();
                var s = insGrid.getSelectionModel().getSelections();
                for (var i = 0, r; r = s[i]; i++) {
                    memberInsuarancesStore.remove(r);
                }
            }
        }
    ],
    bbar: [
        {
            iconCls: 'icon-add-entity',
            text: 'Добавить полис',
            handler: function() {
                var ins = new memberInsuaranceRecord();
                editorIns.stopEditing();
                memberInsuarancesStore.insert(0, ins);
                insGrid.getView().refresh();
                insGrid.getSelectionModel().selectRow(0);
                editorIns.startEditing(0);
            }
        },
        {
            ref: '../removeBtnBottom',
            iconCls: 'icon-remove-entity',
            text: 'Удалить полис',
            disabled: true,
            handler: function() {
                editorIns.stopEditing();
                var s = insGrid.getSelectionModel().getSelections();
                for (var i = 0, r; r = s[i]; i++) {
                    memberInsuarancesStore.remove(r);
                }
            }
        }
    ],

    columns: [
        new Ext.grid.RowNumberer(),
        {
            id: 'insuaranceCompany',
            header: 'Страховая компания',
            dataIndex: 'insuaranceCompany',
            sortable: true,
            emptyText: 'Введите имя компании...',
            editor: {
                xtype: 'textfield',
                emptyText: 'Введите имя компании...',
                blankText: 'Страховая компания должна быть указана...',
                allowBlank: false
            }
        },
        {
            xtype: 'datecolumn',
            header: 'Дата окончания действия',
            dataIndex: 'policyEndDate',
            format: 'd.m.Y',
            sortable: true,
            editor: {
                xtype: 'datefield',
                allowBlank: true,
                blankText: 'Дата окончания действия должна быть указана...'
            }
        }
    ]
});

insGrid.getSelectionModel().on('selectionchange', function(sm) {
    insGrid.removeBtnTop.setDisabled(sm.getCount() < 1);
    insGrid.removeBtnBottom.setDisabled(sm.getCount() < 1);
});

function setRequired(value) {
    return '<div class="float-left">' + value + '</div><div class="icon-imp">*</div>';
}

var panelAdd = new Ext.FormPanel({
    labelAlign: 'top',
    //title: 'Добавление/Обновление кандидата ВОА',
    width: 700,
    items: [
        {
            xtype:'tabpanel',
            id: 'memberTab',
            plain:true,
            activeTab: 0,
            height:400,
            deferredRender: false,
            defaults:{bodyStyle:'padding:10px'},
            autoScroll: true,
            items:[
                {
                    title:'Персональные данные члена общества',
                    autoScroll: true,
                    items: [
                        {
                            layout:'column',
                            border:false,
                            items:[
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Фамилия'),
                                            allowBlank: false,
                                            blankText: 'Фамилия члена общества должна быть указана',
                                            maxLength: 100,
                                            maxLengthText: 'Фамилия может содержать до 100 символов включительно...',
                                            name: 'surName',
                                            id: 'surName',
                                            anchor:'95%'
                                        },
                                        new Ext.form.DateField({
                                            fieldLabel: setRequired('Дата рождения'),
                                            format: 'd.m.Y',
                                            name: 'birthDate',
                                            id: 'birthDate',
                                            allowBlank: false,
                                            blankText: 'Дата рождения члена общества должна быть указана',
                                            anchor:'95%'
                                        }),
                                        regionsCombo,
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Название улицы'),
                                            name: 'street',
                                            id: 'street',
                                            maxLength: 40,
                                            maxLengthText: 'Название улицы может содержать до 40 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Название улицы должно быть указано',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'Квартира',
                                            maxLength: 15,
                                            maxLengthText: 'Номер квартиры может содержать до 15 символов включительно...',
                                            name: 'appartmentNumber',
                                            id: 'appartmentNumber',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'Домашний телефон',
                                            name: 'homePhone',
                                            id: 'homePhone',
                                            maxLength: 20,
                                            maxLengthText: 'Домашний телефон может содержать до 20 символов включительно...',
                                            anchor:'95%'
                                        }
                                    ]
                                },
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Имя'),
                                            name: 'name',
                                            id: 'name',
                                            maxLength: 100,
                                            maxLengthText: 'Имя может содержать до 100 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Имя должно быть указано',
                                            anchor:'95%'
                                        },
                                        gendersCombo,
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Населенный пункт/Город/Регион'),
                                            name: 'location',
                                            id: 'location',
                                            maxLength: 100,
                                            maxLengthText: 'Населенный пункт/Город/Регион может содержать до 100 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Населенный пункт/Город/Регион должен быть указан',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Дом'),
                                            name: 'houseNumber',
                                            id: 'houseNumber',
                                            maxLength: 15,
                                            maxLengthText: 'Номер дома может содержать до 15 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Дом должен быть указан',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Мобильный телефон'),
                                            name: 'mobilePhone',
                                            id: 'mobilePhone',
                                            maxLength: 20,
                                            maxLengthText: 'Номер мобильного телефона может содержать до 20 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Мобильный телефон должен быть указан',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'E-mail',
                                            vtype: 'email',
                                            name: 'email',
                                            id: 'email',
                                            anchor:'95%'
                                        }
                                    ]
                                },
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Отчество'),
                                            name: 'patronymic',
                                            id: 'patronymic',
                                            maxLength: 100,
                                            maxLengthText: 'Отчество может содержать до 100 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Отчество должно быть указано',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Гражданство'),
                                            name: 'citizenship',
                                            id: 'citizenship',
                                            maxLength: 100,
                                            maxLengthText: 'Гражданство может содержать до 100 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Гражданство должно быть указано',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'Индекс',
                                            name: 'postCode',
                                            id: 'postCode',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'Корпус',
                                            name: 'unitNumber',
                                            id: 'unitNumber',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'Рабочий телефон',
                                            name: 'workPhone',
                                            id: 'workPhone',
                                            maxLength: 25,
                                            maxLengthText: 'Рабочий телефон может содержать до 25 символов включительно...',
                                            anchor:'95%'
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    title:'Данные по автомобилю заявителя',
                    layout:'form',
                    bodyStyle:'padding:0',
                    autoScroll: true,
                    items: [
                        /*{
                         layout:'column',
                         border:false,
                         items:[
                         {
                         columnWidth:.2,
                         layout: 'form',
                         border:false,
                         items: [
                         carBrandsCombo
                         ]
                         },
                         {
                         columnWidth:.2,
                         layout: 'form',
                         border:false,
                         items: [
                         carModelsCombo
                         ]
                         },
                         {
                         columnWidth:.2,
                         layout: 'form',
                         border:false,
                         items: [
                         {
                         xtype:'textfield',
                         fieldLabel: setRequired('Госномер'),
                         name: 'registrationNumber',
                         id: 'registrationNumber',
                         allowBlank: false,
                         blankText: 'Госномер автомобиля должен быть указан',
                         maxLength: 10,
                         maxLengthText: 'Госномер автомобиля может содержать до 10 символов включительно...',
                         anchor:'95%'
                         }
                         ]
                         },
                         {
                         columnWidth:.2,
                         layout: 'form',
                         border:false,
                         items: [
                         new Ext.form.DateField({
                         format: 'F Y',
                         fieldLabel: 'Месяц и год выпуска',
                         name: 'buildDate',
                         id: 'buildDate',
                         anchor:'95%'
                         })
                         ]
                         },
                         {
                         columnWidth:.2,
                         layout: 'form',
                         border:false,
                         items: [
                         {
                         xtype:'button',
                         text: 'Добавить',
                         style: {
                         marginLeft: '5px',
                         marginTop: '17px'
                         },
                         listeners: {
                         'click' : function() {
                         var fields = new Array();
                         fields[0] = carBrandsCombo;
                         fields[1] = carModelsCombo;
                         fields[2] = Ext.getCmp('registrationNumber');
                         if (isMemberInfoValid(fields)) {
                         var carRecord = new memberCarRecord(
                         {
                         "id":carCountByMember++,
                         "carBrand":fields[0].getValue(),
                         "carModel":fields[1].getValue(),
                         "carDate":"",
                         "registrationNumber":fields[2].getValue(),
                         "memberCar":fields[0].getStore().getById(fields[0].getValue()).get('brandName')
                         + " "
                         + fields[1].getStore().getById(fields[1].getValue()).get('modelName')
                         + ": "
                         + fields[2].getValue()
                         }, carCountByMember);
                         memberCarsStore.add(carRecord);
                         }
                         }
                         }
                         }
                         ]
                         }
                         ]
                         },
                         {
                         xtype: 'grid',
                         id: 'allMemberCars',
                         fieldLabel: 'Автомобили',
                         hideLabel: true,
                         name: 'allMemberCars',
                         width: 413,
                         height: 150,
                         allowBlank:true,
                         store: memberCarsStore,
                         anchor:'95%',
                         viewConfig: {
                         forceFit: true
                         },
                         columns: [ new Ext.grid.RowNumberer(),
                         {
                         header: "Автомобили",
                         width: 380,
                         dataIndex: 'memberCar',
                         sortable: true
                         }
                         ],
                         tbar:[
                         {
                         text: 'Добавить',
                         iconCls: 'icon-add-entity',
                         handler: function() {
                         var fields = new Array();
                         fields[0] = carBrandsCombo;
                         fields[1] = carModelsCombo;
                         fields[2] = Ext.getCmp('registrationNumber');
                         if (isMemberInfoValid(fields)) {
                         var carRecord = new memberCarRecord(
                         {
                         "id":carCountByMember++,
                         "carBrand":fields[0].getValue(),
                         "carModel":fields[1].getValue(),
                         "carDate":"",
                         "registrationNumber":fields[2].getValue(),
                         "memberCar":fields[0].getStore().getById(fields[0].getValue()).get('brandName')
                         + " "
                         + fields[1].getStore().getById(fields[1].getValue()).get('modelName')
                         + ": "
                         + fields[2].getValue()
                         }, carCountByMember);
                         memberCarsStore.add(carRecord);
                         }
                         //                                                        carBrandsCombo.reset();
                         //                                                        carModelsCombo.reset()
                         //                                                        Ext.getCmp('registrationNumber').reset();
                         }
                         },
                         {
                         text: 'Удалить',
                         iconCls: 'icon-remove-entity',
                         handler: function() {
                         memberCarsStore.removeAll();
                         }
                         }
                         ]
                         //ddReorder: true
                         }*/
                        empGrid
                    ]
                },
                {
                    title:'Данные по страховому полису',
                    layout:'form',
                    autoScroll: true,
                    bodyStyle:'padding:0',
                    items: [
                        /*{
                         layout:'column',
                         border:false,
                         items:[
                         {
                         columnWidth:.5,
                         layout: 'form',
                         border:false,
                         items: [
                         {
                         xtype:'textfield',
                         fieldLabel: 'Наименование страховой компании',
                         name: 'insuaranceCompany',
                         id: 'insuaranceCompany',
                         maxLength: 100,
                         maxLengthText: 'Наименование страховой компании может содержать до 100 символов включительно...',
                         anchor:'95%'
                         },
                         {
                         xtype: 'grid',
                         id: 'allMemberInsuarance',
                         fieldLabel: 'Полисы',
                         hideLabel: true,
                         name: 'allMemberInsuarance',
                         viewConfig: {
                         forceFit: true
                         },
                         columns: [
                         new Ext.grid.RowNumberer(),
                         {
                         header: "Полисы",
                         width: 380,
                         dataIndex: 'memberInsuarance',
                         sortable: true
                         }
                         ],
                         width: 413,
                         height: 150,
                         allowBlank:true,
                         store: memberInsuarancesStore,
                         tbar:[
                         {
                         text: 'Добавить',
                         iconCls: 'icon-add-entity',
                         handler: function() {
                         if (Ext.getCmp('insuaranceCompany').getValue() != ""
                         && Ext.getCmp('policyEndDate').getValue() != "") {
                         var insuaranceRecord = new memberInsuaranceRecord(
                         {
                         "id":insuranceCountByMember++,
                         "insuaranceCompany":Ext.getCmp('insuaranceCompany').getValue(),
                         "policyEndDate":Ext.getCmp('policyEndDate').getValue(),
                         "memberInsuarance":Ext.getCmp('insuaranceCompany').getValue()
                         + ": "
                         + Ext.getCmp('policyEndDate').getValue().format("d.m.Y").toString()
                         }, insuranceCountByMember);
                         memberInsuarancesStore.add(insuaranceRecord);
                         }
                         }
                         },
                         {
                         text: 'Удалить',
                         iconCls: 'icon-remove-entity',
                         handler: function() {
                         memberInsuarancesStore.removeAll();
                         }
                         }
                         ]
                         //ddReorder: true
                         }
                         ]
                         },
                         {
                         columnWidth:.5,
                         layout: 'form',
                         border:false,
                         items: [
                         new Ext.form.DateField({
                         format: 'd.m.Y',
                         fieldLabel: 'Дата окончания действия полиса',
                         name: 'policyEndDate',
                         id: 'policyEndDate',
                         anchor:'95%'
                         })
                         ]
                         }
                         ]
                         }*/
                        insGrid
                    ]
                },
                {
                    title:'Комментарии',
                    layout:'fit',
                    bodyStyle: 'padding: 0',
                    items: {
                        xtype:'textarea',
                        name:'comment',
                        id:'comment',
                        fieldLabel:'Комментарии'
                    }
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            handler: function () {
                if (panelAdd.getForm().isValid()) {
                    if (memberCarsStore.getCount() == 0) {
                        //                        var carRecord = new memberCarRecord(
                        //                        {
                        //                            "id":carCountByMember++,
                        //                            "carBrand":carBrandsCombo.getValue(),
                        //                            "carModel":carModelsCombo.getValue(),
                        //                            "carDate":"",
                        //                            "registrationNumber":Ext.getCmp('registrationNumber').getValue(),
                        //                            "memberCar":carBrandsCombo.getStore().getById(carBrandsCombo.getValue()).get('brandName')
                        //                                    + " "
                        //                                    + carModelsCombo.getStore().getById(carModelsCombo.getValue()).get('modelName')
                        //                                    + ": "
                        //                                    + Ext.getCmp('registrationNumber').getValue()
                        //                        }, carCountByMember);
                        //                        memberCarsStore.add(carRecord);
                        Ext.getCmp('memberTab').setActiveTab(1);
                        return;
                    }

                    if (memberInsuarancesStore.getCount() == 0) {
                        if (Ext.getCmp('insuaranceCompany').getValue() != ""
                                && Ext.getCmp('policyEndDate').getValue() != "") {
                            var insuaranceRecord = new memberInsuaranceRecord(
                            {
                                "id":insuranceCountByMember++,
                                "insuaranceCompany":Ext.getCmp('insuaranceCompany').getValue(),
                                "policyEndDate":Ext.getCmp('policyEndDate').getValue(),
                                "memberInsuarance":Ext.getCmp('insuaranceCompany').getValue()
                                        + ": "
                                        + Ext.getCmp('policyEndDate').getValue().format("d.m.Y").toString()
                            }, insuranceCountByMember);
                            memberInsuarancesStore.add(insuaranceRecord);
                        }
                    }

                    var carBrand;
                    var carModel;
                    var car;
                    var insuarancePolicy;
                    var region = new Region();
                    var member = new Member();
                    var cars = new Array();
                    var insuarancePolicyes = new Array();
                    var payment = new Payment();
                    var memberCard = new MemberCard();
                    //memberCard.setId(1);
                    //payment.setId(1);
                    //payment.setAmount(123.1);
                    var memberPays = new Array();
                    //memberPays[0] = payment;

                    var carRecords = memberCarsStore.getRange(0, memberCarsStore.getCount());
                    for (i = 0; i < carRecords.length; i++) {

                        carBrand = new CarBrand();
                        carModel = new CarModel();
                        car = new Car();

                        carBrand.setCarBrandId(carRecords[i].get('carBrand'));
                        carModel.setCarModelId(carRecords[i].get('carModel'));
                        car.setCarBrand(carBrand);
                        car.setCarModel(carModel);
                        //car.setBuildDate(Ext.getCmp('buildDate').getValue());
                        car.setRegistrationNumber(carRecords[i].get('registrationNumber'));
                        cars[i] = car;
                    }

                    var insuranceRecords = memberInsuarancesStore.getRange(0, memberInsuarancesStore.getCount());
                    for (i = 0; i < insuranceRecords.length; i++) {

                        insuarancePolicy = new InsuarancePolicy();

                        insuarancePolicy.setInsuaranceCompany(insuranceRecords[i].get('insuaranceCompany'));
                        insuarancePolicy.setPolicyEndDate(insuranceRecords[i].get('policyEndDate'));
                        insuarancePolicyes[i] = insuarancePolicy;

                    }
                    region.setRegionID(regionsCombo.getValue());
                    member.setName(Ext.getCmp('name').getValue());
                    member.setPatronymic(Ext.getCmp('patronymic').getValue());
                    member.setSurName(Ext.getCmp('surName').getValue());
                    member.setBirthDate(Ext.getCmp('birthDate').getValue());
                    member.setGender(gendersCombo.getValue());
                    member.setCitizenship(Ext.getCmp('citizenship').getValue());
                    member.setRegion(region);
                    member.setLocation(Ext.getCmp('location').getValue());
                    member.setPostCode(Ext.getCmp('postCode').getValue());
                    member.setStreet(Ext.getCmp('street').getValue());
                    member.setHouseNumber(Ext.getCmp('houseNumber').getValue());
                    member.setUnitNumber(Ext.getCmp('unitNumber').getValue());
                    member.setAppartmentNumber(Ext.getCmp('appartmentNumber').getValue());
                    member.setMobilePhone(Ext.getCmp('mobilePhone').getValue());
                    member.setWorkPhone(Ext.getCmp('workPhone').getValue());
                    member.setHomePhone(Ext.getCmp('homePhone').getValue());
                    member.setEmail(Ext.getCmp('email').getValue());
                    //member.setQuestionnairyDate(Ext.getCmp('questionnairyDate').getValue());
                    member.setComment(Ext.getCmp('comment').getValue());
                    member.setMemberCar(cars);
                    member.setMemberPolicies(insuarancePolicyes);
                    member.setMemberPays(memberPays);
                    member.setMemberCard(memberCard);

                    if (isUpdateMember) {
                        member.setMembershipStatus('Член ВОА');
                        member.setId(memberId);
                        memberCard.setId(100);
                        member.setMemberCard(memberCard);
                    } else if (isUpdateCandidat) {
                        member.setMembershipStatus('Кандидат в члены ВОА');
                        member.setId(memberId);
                        memberCard.setId(100);
                        member.setMemberCard(memberCard);
                    }

                    Ext.Ajax.request({
                        url: 'rest/saveMember',
                        headers: {
                            'Accept' : 'application/json',
                            'Content-Type' : 'application/json'
                        },
                        params: Ext.encode(member),
                        method: 'POST',
                        success: function (response, opts) {
                            if (isUpdateMember) {
                                memberStore.reload();
                            } else if (isUpdateCandidat) {
                                candidatStore.reload();
                            }
                            //                            Ext.Msg.show({
                            //                                title: 'Выполненно!',
                            //                                msg: 'Кандидат добавлен/обновлен. Номер карты: ' + response.responseText,
                            //                                buttons: Ext.MessageBox.OK,
                            //                                width: 300,
                            //                                icon: Ext.MessageBox.INFO
                            //                            });
                            panelAdd.getForm().reset();
                            winAdd.hide();
                        },
                        failure: function (response, opts) {
                            if (isUpdateMember) {
                                memberStore.reload();
                            } else if (isUpdateCandidat) {
                                candidatStore.reload();
                            }
                            //                            Ext.Msg.show({
                            //                                title: 'Выполненно!',
                            //                                msg: 'Кандидат добавлен/обновлен. Номер карты: ' + response.responseText,
                            //                                buttons: Ext.MessageBox.OK,
                            //                                width: 300,
                            //                                icon: Ext.MessageBox.INFO
                            //                            });
                            panelAdd.getForm().reset();
                            winAdd.hide();
                        }
                    });

                } else {
                    var fields = new Array();
                    fields[0] = Ext.getCmp('name');
                    fields[1] = Ext.getCmp('patronymic');
                    fields[2] = Ext.getCmp('surName');
                    fields[3] = Ext.getCmp('birthDate');
                    fields[4] = Ext.getCmp('citizenship');
                    fields[5] = Ext.getCmp('location');
                    fields[6] = Ext.getCmp('street');
                    fields[7] = Ext.getCmp('houseNumber');
                    fields[8] = Ext.getCmp('mobilePhone');
                    fields[9] = regionsCombo;
                    fields[10] = gendersCombo;
                    fields[11] = Ext.getCmp('email');
                    if (isMemberInfoValid(fields)) {
                        Ext.getCmp('memberTab').setActiveTab(1);
                    } else {
                        Ext.getCmp('memberTab').setActiveTab(0);
                    }
                }

            }
        },
        {
            text: 'Отменить',
            handler: function () {
                panelAdd.getForm().reset();
                winAdd.hide();
            }
        }
    ]
});

var panelAddPayment = new Ext.FormPanel({
    labelAlign: 'top',
    //    title: 'Добавление платежа',
    width: 700,
    items: [
        {
            xtype:'tabpanel',
            plain:true,
            activeTab: 0,
            height:400,
            deferredRender: false,
            defaults:{bodyStyle:'padding:10px'},
            items:[
                {
                    title:'Платеж',
                    autoScroll: true,
                    items: [
                        {
                            layout:'column',
                            border:false,
                            items:[
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Номер ЛС'),
                                            allowBlank: false,
                                            blankText: 'Номер ЛС должен быть указан',
                                            name: 'memberIdVOA',
                                            id: 'memberIdVOA',
                                            anchor:'95%'
                                        },
                                        new Ext.form.DateField({
                                            fieldLabel: setRequired('Дата платежа'),
                                            format: 'd.m.Y',
                                            name: 'paymentDate',
                                            id: 'paymentDate',
                                            allowBlank: false,
                                            blankText: 'Дата платежа должна быть указана',
                                            anchor:'95%'
                                        }),
                                        paymentWayCombo,
                                        //                                        {
                                        //                                            xtype:'textfield',
                                        //                                            fieldLabel: setRequired('Способ оплаты'),
                                        //                                            allowBlank: false,
                                        //                                            blankText: 'Способ оплаты должен быть указан',
                                        //                                            name: 'paymentWay',
                                        //                                            id: 'paymentWay',
                                        //                                            anchor:'95%'
                                        //                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Статус платежа'),
                                            name: 'payStatus',
                                            id: 'payStatus',
                                            maxLength: 20,
                                            maxLengthText: 'Статус платежа может содержать до 20 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Статус платежа должен быть указан',
                                            anchor:'95%'
                                        }
                                    ]
                                },
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('БИК Банка Плательщика'),
                                            name: 'bic',
                                            id: 'bic',
                                            maxLength: 9,
                                            maxLengthText: 'БИК содержать до 9 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'БИК должен быть указан',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Тип оплаты'),
                                            name: 'paymentType',
                                            id: 'paymentType',
                                            maxLength: 100,
                                            maxLengthText: 'Тип оплаты может содержать до 100 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Тип оплаты должен быть указан',
                                            anchor:'95%'
                                        },
                                        paymentDestinationCombo
                                        //                                        {
                                        //                                            xtype:'textfield',
                                        //                                            fieldLabel: 'Назначение платежа',
                                        //                                            name: 'paymentDestination',
                                        //                                            id: 'paymentDestination',
                                        //                                            maxLength: 500,
                                        //                                            maxLengthText: 'Назначение платежа может содержать до 500 символов включительно...',
                                        //                                            anchor:'95%'
                                        //                                        }
                                    ]
                                },
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Номер л/с члена общества'),
                                            name: 'ticketNumber',
                                            id: 'ticketNumber',
                                            maxLength: 20,
                                            maxLengthText: 'Номер квитанции может содержать до 20 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Номер квитанции должен быть указан',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'numberfield',
                                            fieldLabel: setRequired('Сумма платежа'),
                                            name: 'ammount',
                                            id: 'ammount',
                                            allowBlank: false,
                                            blankText: 'Сумма платежа должна быть указана',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype:'textfield',
                                            fieldLabel: 'Номер квитанции',
                                            name: 'memberBankBook',
                                            id: 'memberBankBook',
                                            maxLength: 100,
                                            maxLengthText: 'Номер л/с члена общества может содержать до 100 символов включительно...',
                                            anchor:'95%'
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            handler: function () {
                if (panelAddPayment.getForm().isValid()) {
                    var payment = new Payment();
                    payment.setPaymentDate(Ext.getCmp('paymentDate').getValue());
                    payment.setBic(Ext.getCmp('bic').getValue());
                    payment.setTicketNumber(Ext.getCmp('ticketNumber').getValue());
                    payment.setPaymentWay(paymentWayCombo.getValue());
                    payment.setPaymentType(Ext.getCmp('paymentType').getValue());
                    payment.setAmount(Ext.getCmp('ammount').getValue());
                    payment.setPayStatus(Ext.getCmp('payStatus').getValue());
                    payment.setPaymentDestination(paymentDestinationCombo.getValue());
                    payment.setMemberBankBook(Ext.getCmp('memberBankBook').getValue());
                    payment.setMemberId(Ext.getCmp('memberIdVOA').getValue());
                    Ext.Ajax.request({
                        url: 'rest/addPayment',
                        headers: {
                            'Accept' : 'application/json',
                            'Content-Type' : 'application/json'
                        },
                        params: Ext.encode(payment),
                        method: 'POST',
                        success: function (response, opts) {
                            memberPaymentStore.reload();
                            //                            Ext.Msg.show({
                            //                                title: 'Выполненно!',
                            //                                msg:  'Платеж добавлен для члена ВОА с номером: ' + response.responseText,
                            //                                buttons: Ext.MessageBox.OK,
                            //                                width: 300,
                            //                                icon: Ext.MessageBox.INFO
                            //                            });
                            panelAddPayment.getForm().reset();
                            winAddPayment.hide();
                        },
                        failure: function (response, opts) {
                            memberPaymentStore.reload();
                            //                            Ext.Msg.show({
                            //                                title: 'Выполненно!',
                            //                                msg: 'Платеж добавлен для члена ВОА с номеро: ' + response.responseText,
                            //                                buttons: Ext.MessageBox.OK,
                            //                                width: 300,
                            //                                icon: Ext.MessageBox.INFO
                            //                            });
                            panelAddPayment.getForm().reset();
                            winAddPayment.hide();
                        }
                    });
                }

            }
        },
        {
            text: 'Отменить',
            handler: function () {
                panelAddPayment.getForm().reset();
                winAddPayment.hide();
            }
        }
    ]
});

var panelUpdatePayment = new Ext.FormPanel({
    labelAlign: 'top',
    //    title: 'Добавление платежа',
    width: 700,
    items: [
        /*{
         xtype:'tabpanel',
         plain:true,
         activeTab: 0,
         height:400,
         deferredRender: false,
         defaults:{bodyStyle:'padding:10px'},
         items:[*/
        {
            //title:'Платеж',
            autoScroll: true,
            border: false,
            bodyStyle:'padding:10px',
            items: [
                {
                    layout:'column',
                    border:false,
                    items:[
                        {
                            columnWidth:.3,
                            layout: 'form',
                            border:false,
                            items: [
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Номер ЛС',
                                    allowBlank: false,
                                    blankText: 'Номер ЛС должен быть указан',
                                    name: 'memberIdVOA',
                                    id: 'memberIdVOAUpdate',
                                    anchor:'95%'
                                },
                                new Ext.form.DateField({
                                    fieldLabel: 'Дата платежа',
                                    format: 'd.m.Y',
                                    name: 'paymentDate',
                                    id: 'paymentDateUpdate',
                                    allowBlank: false,
                                    blankText: 'Дата платежа должна быть указана',
                                    anchor:'95%'
                                }),
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Способ оплаты',
                                    allowBlank: false,
                                    blankText: 'Способ оплаты должен быть указан',
                                    name: 'paymentWay',
                                    id: 'paymentWayUpdate',
                                    anchor:'95%'
                                },
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Статус платежа',
                                    name: 'payStatus',
                                    id: 'payStatusUpdate',
                                    maxLength: 20,
                                    maxLengthText: 'Статус платежа может содержать до 20 символов включительно...',
                                    allowBlank: false,
                                    blankText: 'Статус платежа должен быть указан',
                                    anchor:'95%'
                                }
                            ]
                        },
                        {
                            columnWidth:.3,
                            layout: 'form',
                            border:false,
                            items: [
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'БИК Банка Плательщика',
                                    name: 'bic',
                                    id: 'bicUpdate',
                                    maxLength: 9,
                                    maxLengthText: 'БИК содержать до 9 символов включительно...',
                                    allowBlank: false,
                                    blankText: 'БИК должен быть указан',
                                    anchor:'95%'
                                },
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Тип оплаты',
                                    name: 'paymentType',
                                    id: 'paymentTypeUpdate',
                                    maxLength: 100,
                                    maxLengthText: 'Тип оплаты может содержать до 100 символов включительно...',
                                    allowBlank: false,
                                    blankText: 'Тип оплаты должен быть указан',
                                    anchor:'95%'
                                },
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Назначение платежа',
                                    name: 'paymentDestination',
                                    id: 'paymentDestinationUpdate',
                                    maxLength: 500,
                                    maxLengthText: 'Назначение платежа может содержать до 500 символов включительно...',
                                    anchor:'95%'
                                },
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Номер платежа',
                                    allowBlank: false,
                                    blankText: 'Номер платежа должен быть указан',
                                    name: 'idUpdate',
                                    id: 'idUpdate',
                                    anchor:'95%'
                                }
                            ]
                        },
                        {
                            columnWidth:.3,
                            layout: 'form',
                            border:false,
                            items: [
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Номер л/с члена общества',
                                    name: 'ticketNumber',
                                    id: 'ticketNumberUpdate',
                                    maxLength: 20,
                                    maxLengthText: 'Номер квитанции может содержать до 20 символов включительно...',
                                    allowBlank: false,
                                    blankText: 'Номер квитанции должен быть указан',
                                    anchor:'95%'
                                },
                                {
                                    xtype:'numberfield',
                                    fieldLabel: 'Сумма платежа',
                                    name: 'ammount',
                                    id: 'ammountUpdate',
                                    allowBlank: false,
                                    blankText: 'Сумма платежа должна быть указана',
                                    anchor:'95%'
                                },
                                {
                                    xtype:'textfield',
                                    fieldLabel: 'Номер квитанции',
                                    name: 'memberBankBook',
                                    id: 'memberBankBookUpdate',
                                    maxLength: 100,
                                    maxLengthText: 'Номер л/с члена общества может содержать до 100 символов включительно...',
                                    anchor:'95%'
                                },
                                new Ext.form.DateField({
                                    fieldLabel: 'Дата регистрации платежа',
                                    format: 'd.m.Y',
                                    name: 'registrationDate',
                                    id: 'registrationDateUpdate',
                                    allowBlank: false,
                                    blankText: 'Дата платежа должна быть указана',
                                    anchor:'95%'
                                })
                            ]
                        }
                    ]
                }
            ]
        }
        //            ]
        //        }
    ],

    buttons: [
        {
            text: 'Закрыть',
            handler: function () {
                panelUpdatePayment.getForm().reset();
                winUpdatePayment.hide();
            }
        }
    ]
});

// Fake данные начало...
var myData = [
    ['Василий Иванович Петров', 'Член ВОА', 'Рязанская область']
];

var myData1 = [
    ['Иван Иванович Иванов', 'Член ВОА', 'Рязанская область']
];

var store = new Ext.data.ArrayStore({
    fields: [
        {name: 'fio'},
        {name: 'status'},
        {name: 'region'}
    ]
});

store.loadData(myData);

var store1 = new Ext.data.ArrayStore({
    fields: [
        {name: 'fio'},
        {name: 'status'},
        {name: 'region'}
    ]
});

var grid = new Ext.grid.GridPanel({
    store: store,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 360,
            sortable : true,
            dataIndex: 'fio'
        },
        {
            header   : 'Регион',
            width    : 275,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Статус',
            width    : 207,
            sortable : true,
            dataIndex: 'status'
        }
    ],
    title: 'Клиент'
});
var grid1 = new Ext.grid.GridPanel({
    store: store,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 360,
            sortable : true,
            dataIndex: 'fio'
        },
        {
            header   : 'Регион',
            width    : 275,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Статус',
            width    : 207,
            sortable : true,
            dataIndex: 'status'
        }
    ],
    title: 'Клиент'
});
var grid2 = new Ext.grid.GridPanel({
    store: store,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 360,
            sortable : true,
            dataIndex: 'fio'
        },
        {
            header   : 'Регион',
            width    : 275,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Статус',
            width    : 207,
            sortable : true,
            dataIndex: 'status'
        }
    ],
    title: 'Клиент'
});

var grid3 = new Ext.grid.GridPanel({
    store: store1,
    hidden: true,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 360,
            sortable : true,
            dataIndex: 'fio'
        },
        {
            header   : 'Регион',
            width    : 275,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Статус',
            width    : 207,
            sortable : true,
            dataIndex: 'status'
        }
    ],
    title: 'Клиент'
});
var grid4 = new Ext.grid.GridPanel({
    store: store1,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 360,
            sortable : true,
            dataIndex: 'fio'
        },
        {
            header   : 'Регион',
            width    : 275,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Статус',
            width    : 207,
            sortable : true,
            dataIndex: 'status'
        }
    ],
    title: 'Клиент'
});
var grid5 = new Ext.grid.GridPanel({
    store: store1,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 360,
            sortable : true,
            dataIndex: 'fio'
        },
        {
            header   : 'Регион',
            width    : 275,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Статус',
            width    : 207,
            sortable : true,
            dataIndex: 'status'
        }
    ],
    title: 'Клиент'
});

var memberHistoryReader = new Ext.data.JsonReader({
    idProperty: 'id',
    fields: ['id',
        'memberFio',
        'accidentPlace',
        'recourseDate',
        'region',
        'action']
});

var memberHistoryProxy = new Ext.data.HttpProxy({
    url: 'data/fakeMember.json',
    method: 'GET',
    headers: {
        'Accept' : 'application/json'
    }
});

var memberHistoryStore = new Ext.data.Store({
    reader: memberHistoryReader,
    proxy: memberHistoryProxy,
    autoLoad: true
});


var memberHistoryGrid = new Ext.grid.GridPanel({
    store: memberHistoryStore,
    //    height: 100,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 185,
            sortable : true,
            dataIndex: 'memberFio'
        },
        {
            header   : 'Дата',
            width    : 155,
            sortable : true,
            renderer: dateRenderer,
            dataIndex: 'recourseDate'
        },
        {
            header   : 'Регион',
            width    : 155,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Место аварии',
            width    : 175,
            sortable : true,
            dataIndex: 'accidentPlace'
        },
        {
            header   : 'Статус звонка',
            width    : 155,
            sortable : true,
            dataIndex: 'action'
        }
    ],
    title: 'История клиента'
});

var memberHistoryProxy1 = new Ext.data.HttpProxy({
    url: 'data/fakeMember1.json',
    method: 'GET',
    headers: {
        'Accept' : 'application/json'
    }
});

var memberHistoryStore1 = new Ext.data.Store({
    reader: memberHistoryReader,
    proxy: memberHistoryProxy1/*,
     autoLoad: true*/
});

var memberHistoryGrid1 = new Ext.grid.GridPanel({
    store: memberHistoryStore1,
    hidden: true,
    viewConfig: {
        forceFit: true
    },
    columns: [
        new Ext.grid.RowNumberer(),
        {
            id       :'fio',
            header   : 'Ф.И.О.',
            width    : 185,
            sortable : true,
            dataIndex: 'memberFio'
        },
        {
            header   : 'Дата',
            width    : 155,
            sortable : true,
            renderer: dateRenderer,
            dataIndex: 'recourseDate'
        },
        {
            header   : 'Регион',
            width    : 155,
            sortable : true,
            dataIndex: 'region'
        },
        {
            header   : 'Место аварии',
            width    : 175,
            sortable : true,
            dataIndex: 'accidentPlace'
        },
        {
            header   : 'Статус звонка',
            width    : 155,
            sortable : true,
            dataIndex: 'action'
        }
    ],
    title: 'История клиента'
});

var timerStart;

var task = {
    run: function() {
        win1.setTitle('Регистрация звонка <span style="color:red"> Время звонка: </span><span style="color:green">' + new Date(new Date().getTime() - timerStart).format('i:s') + '</span>');
    },
    interval: 1000 //1 second
}

var taskWinHide = {
    run: function() {
        if ((new Date().getTime() - timerStart) > 3000) {
            Ext.TaskMgr.stop(taskWinHide);
            var tech = new TechnicalRecourse();
            tech.setMemberId('446');
            tech.setPhoneNumber('8-910-909-5874');
            tech.setAction(buttonValue.substring(0, 20));
            tech.setRecourseDate(new Date());
            tech.setRegionId(1);
            tech.setAccidentPlace('Дорога...');
            tech.setComment('Время разговора: ' + callDuration);
            tech.setSupportServiceId(1);

            Ext.Ajax.request({
                url: 'rest/saveTechnicalRecourse',
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                params: Ext.encode(tech),
                method: 'POST',
                success: function (response, opts) {
                    Ext.getCmp('techServiceResult').setDisabled(true);
                    Ext.getCmp('techSupportBut').setDisabled(true);
                    Ext.getCmp('techServiceBut').setDisabled(true);
                    Ext.getCmp('panelTechSupport').setActiveTab(0);
                    techSupportStore.reload();
                    win1.hide();

                },
                failure: function (response, opts) {
                    Ext.getCmp('techServiceResult').setDisabled(true);
                    Ext.getCmp('techSupportBut').setDisabled(true);
                    Ext.getCmp('techServiceBut').setDisabled(true);
                    Ext.getCmp('panelTechSupport').setActiveTab(0);
                    techSupportStore.reload();
                    win1.hide();

                }
            });

        }
    },
    interval: 1000 //1 second
}

// Fake данные конец...

var panelTechSupport = new Ext.FormPanel({
    labelAlign: 'top',
    //    title: 'Добавление платежа',
    width: 700,
    items: [
        {
            xtype:'tabpanel',
            id: 'panelTechSupport',
            plain:true,
            activeTab: 0,
            height:420,
            deferredRender: false,
            defaults:{bodyStyle:'padding:10px;'},
            items:[
                {
                    title:'Входящий звонок',
                    autoScroll: true,
                    border: false,
                    items: [
                        {
                            html:'<span>Звонок с номера: <h1 style="color:green">8-910-909-5874</h1></span>',
                            style: {
                                textAlign: 'center',
                                fontSize: '25px'
                            },
                            border: false
                        },
                        grid,
                        {
                            html: '<b>Статус Клиента:</b>',
                            border: false,
                            style: {
                                marginTop: '10px'
                            }
                        },
                        {
                            xtype: 'radiogroup',
                            id: 'TechSupportRadioFake',
                            width: 195,
                            items: [
                                {boxLabel: 'Член ВОА', name: 'TechSupportRadioFake', inputValue: 'Член ВОА', checked: true},
                                {boxLabel: 'Не член ВОА', name: 'TechSupportRadioFake', inputValue: 'Не член ВОА'}
                            ]
                        },
                        memberHistoryGrid,
                        {
                            border: false,
                            buttons: [
                                {
                                    text: 'Ответить на звонок',
                                    id: 'answerButton',
                                    handler: function () {
                                        if (Ext.getCmp('answerButton').getText() == "Ответить на звонок") {
                                            Ext.getCmp('answerButton').setText("Завершить звонок");
                                            timerStart = new Date().getTime();
                                            Ext.TaskMgr.start(task);
                                            Ext.getCmp('techSupportBut').setDisabled(false);
                                            Ext.getCmp('techServiceBut').setDisabled(false);
                                        } else {
                                            Ext.TaskMgr.stop(task);
                                            win1.setTitle('Регистрация звонка');
                                            Ext.getCmp('answerButton').setText("Ответить на звонок");
                                            Ext.getCmp('techSupportBut').setDisabled(true);
                                            Ext.getCmp('techServiceBut').setDisabled(true);
                                            Ext.getCmp('techSupportPan').setDisabled(true);
                                            Ext.getCmp('techServicePan').setDisabled(true);
                                            callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                            buttonValue = this.text;
                                            Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                            Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                            Ext.getCmp('techServiceResult').setDisabled(false);
                                            Ext.getCmp('panelTechSupport').setActiveTab(3);
                                            timerStart = new Date().getTime();
                                            Ext.TaskMgr.start(taskWinHide);
                                        }


                                    }
                                },
                                {
                                    text: 'Требуется экстренная помощь',
                                    id: 'techSupportBut',
                                    disabled: true,
                                    handler: function () {
                                        Ext.getCmp('techSupportPan').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(1);
                                    }
                                },
                                {
                                    text: 'Требуются услуги',
                                    id: 'techServiceBut',
                                    disabled: true,
                                    handler: function () {
                                        Ext.getCmp('techServicePan').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(2);

                                    }
                                },
                                {
                                    text: 'Отмена',
                                    handler: function () {
                                        win1.hide();
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        win1.setTitle('Регистрация звонка');
                                    }
                                }
                            ]
                        }

                    ]
                },
                {
                    title:'Экстренная помощь',
                    id: 'techSupportPan',
                    autoScroll: true,
                    disabled: true,
                    border: false,
                    items: [
                        {
                            html:'<span>Звонок с номера: <h1 style="color:green">8-910-909-5874</h1></span>',
                            style: {
                                textAlign: 'center',
                                fontSize: '25px'
                            },
                            border: false
                        },
                        grid1,
                        {
                            html: '<b>Статус Клиента:</b>',
                            border: false,
                            style: {
                                marginTop: '10px'
                            }
                        },
                        {
                            xtype: 'radiogroup',
                            id: 'TechSupportRadioFake1',
                            width: 195,
                            items: [
                                {boxLabel: 'Член ВОА', name: 'TechSupportRadioFake1', inputValue: 'Член ВОА', checked: true},
                                {boxLabel: 'Не член ВОА', name: 'TechSupportRadioFake1', inputValue: 'Не член ВОА'}
                            ]
                        },
                        {
                            border: false,
                            style: {
                                paddingTop: '140px'
                            },
                            buttons: [
                                {
                                    text: 'Перевод на 112',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                },
                                {
                                    text: 'Перевод на 01-Пожарная',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                },
                                {
                                    text: 'Перевод на 02-Полиция',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                },
                                {
                                    text: 'Перевод на 03-Скорая',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    title:'Услуги',
                    id: 'techServicePan',
                    autoScroll: true,
                    disabled: true,
                    border: false,
                    items: [
                        {
                            html:'<span>Звонок с номера: <h1 style="color:green">8-910-909-5874</h1></span>',
                            style: {
                                textAlign: 'center',
                                fontSize: '25px'
                            },
                            border: false
                        },
                        grid2,
                        {
                            html: '<b>Статус Клиента:</b>',
                            border: false,
                            style: {
                                marginTop: '10px'
                            }
                        },
                        {
                            xtype: 'radiogroup',
                            id: 'TechSupportRadioFake2',
                            width: 195,
                            items: [
                                {boxLabel: 'Член ВОА', name: 'TechSupportRadioFake2', inputValue: 'Член ВОА', checked: true},
                                {boxLabel: 'Не член ВОА', name: 'TechSupportRadioFake2', inputValue: 'Не член ВОА'}
                            ]
                        },
                        {
                            border: false,
                            style: {
                                paddingTop: '140px'
                            },
                            buttons: [
                                {
                                    text: 'Перевод на ТехПомощь, Эвакуатор',
                                    handler: function () {
                                        //window.open("order.html", "");
                                        var url = 'order.html';
                                        var wname = 'Hello';
                                        var wfeatures = '';
                                        var myWindow = window.open(url, wname, wfeatures);
                                                
                                        //newwin.show();

                                        /*('order.html', 'Hello!!!', 'menubar=yes,resizable=yes,scrollbars=yes,status=yes,location=yes');*/
                                        //                                        newwin.show();
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                },
                                {
                                    text: 'Перевод на Юрид. помощь',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                },
                                {
                                    text: 'Перевод на ADAC',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult').setDisabled(false);
                                        Ext.getCmp('panelTechSupport').setActiveTab(3);
                                        Ext.getCmp('answerButton').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan').setDisabled(true);
                                        Ext.getCmp('techServicePan').setDisabled(true);
                                        timerStart = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide);
                                    }
                                }/*,
                                 {
                                 text: 'Перевод звонка на 03-Скорая',
                                 handler: function () {
                                 Ext.TaskMgr.stopAll();
                                 win1.setTitle('Регистрация звонка');
                                 callDuration = new Date(new Date().getTime() - timerStart).format('i:s');
                                 buttonValue = this.text;
                                 Ext.fly('callDurationResult').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                 Ext.fly('buttonValueResult').update('<h1>Результат: ' + buttonValue + '</h1>');
                                 Ext.getCmp('techServiceResult').setDisabled(false);
                                 Ext.getCmp('panelTechSupport').setActiveTab(3);
                                 Ext.getCmp('answerButton').setText("Ответить на звонок");
                                 Ext.getCmp('techSupportPan').setDisabled(true);
                                 Ext.getCmp('techServicePan').setDisabled(true);
                                 }
                                 }*/
                            ]
                        }
                    ]
                },
                {
                    title:'Результат',
                    id: 'techServiceResult',
                    disabled: true,
                    autoScroll: true,
                    border: false,
                    items: [

                        {
                            html:'<h1>Разговор с ' + grid.getStore().getAt(0).get('fio') + ' завершен. </h1>',
                            id: 'fioResult',
                            style: {

                            },
                            border: false
                        },
                        {
                            html:'',
                            id: 'callDurationResult',
                            style: {
                                //                                textAlign: 'center',
                                //                                fontSize: '25px'
                            },
                            border: false
                        },
                        {
                            html:'',
                            id: 'buttonValueResult',
                            style: {
                                //                                textAlign: 'center',
                                //                                fontSize: '25px'
                            },
                            border: false
                        },
                        {
                            border: false,
                            style: {
                                paddingTop: '280px'
                            },
                            buttons: [
                                {
                                    text: 'Закрыть',
                                    handler: function () {
                                        Ext.TaskMgr.stop(taskWinHide);
                                        var tech = new TechnicalRecourse();
                                        tech.setMemberId('446');
                                        tech.setPhoneNumber('8-910-909-5874');
                                        tech.setAction(buttonValue.substring(0, 20));
                                        tech.setRecourseDate(new Date());
                                        tech.setRegionId(1);
                                        tech.setAccidentPlace('Дорога...');
                                        tech.setComment('Время разговора: ' + callDuration);
                                        tech.setSupportServiceId(1);

                                        Ext.Ajax.request({
                                            url: 'rest/saveTechnicalRecourse',
                                            headers: {
                                                'Accept' : 'application/json',
                                                'Content-Type' : 'application/json'
                                            },
                                            params: Ext.encode(tech),
                                            method: 'POST',
                                            success: function (response, opts) {
                                                Ext.getCmp('techServiceResult').setDisabled(true);
                                                Ext.getCmp('techSupportBut').setDisabled(true);
                                                Ext.getCmp('techServiceBut').setDisabled(true);
                                                Ext.getCmp('panelTechSupport').setActiveTab(0);
                                                techSupportStore.reload();
                                                win1.hide();


                                            },
                                            failure: function (response, opts) {
                                                Ext.getCmp('techServiceResult').setDisabled(true);
                                                Ext.getCmp('techSupportBut').setDisabled(true);
                                                Ext.getCmp('techServiceBut').setDisabled(true);
                                                Ext.getCmp('panelTechSupport').setActiveTab(0);
                                                techSupportStore.reload();
                                                win1.hide();
                                            }
                                        });
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
});

var timerStart2;

var task2 = {
    run: function() {
        win2.setTitle('Регистрация звонка <span style="color:red"> Время звонка: </span><span style="color:green">' + new Date(new Date().getTime() - timerStart2).format('i:s') + '</span>');
    },
    interval: 1000 //1 second
}

var taskWinHide2 = {
    run: function() {
        if ((new Date().getTime() - timerStart2) > 3000) {
            Ext.TaskMgr.stop(taskWinHide2);
            var tech = new TechnicalRecourse();
            tech.setMemberId(Ext.getCmp('memberIdSearch').getValue());
            tech.setPhoneNumber('8-903-125-1542');
            tech.setAction(buttonValue.substring(0, 20));
            tech.setRecourseDate(new Date());
            tech.setRegionId(1);
            tech.setAccidentPlace('Перекресток...');
            tech.setComment('Время разговора: ' + callDuration);
            tech.setSupportServiceId(1);

            Ext.Ajax.request({
                url: 'rest/saveTechnicalRecourse',
                headers: {
                    'Accept' : 'application/json',
                    'Content-Type' : 'application/json'
                },
                params: Ext.encode(tech),
                method: 'POST',
                success: function (response, opts) {
                    Ext.getCmp('techServiceResult2').setDisabled(true);
                    Ext.getCmp('techSupportBut2').setDisabled(true);
                    Ext.getCmp('techServiceBut2').setDisabled(true);
                    Ext.getCmp('panelTechSupport2').setActiveTab(0);
                    techSupportStore.reload();
                    win2.hide();

                },
                failure: function (response, opts) {
                    Ext.getCmp('techServiceResult2').setDisabled(true);
                    Ext.getCmp('techSupportBut2').setDisabled(true);
                    Ext.getCmp('techServiceBut2').setDisabled(true);
                    Ext.getCmp('panelTechSupport2').setActiveTab(0);
                    techSupportStore.reload();
                    win2.hide();

                }
            });

        }
    },
    interval: 1000 //1 second
}

// Fake данные конец...

var panelTechSupport2 = new Ext.FormPanel({
    labelAlign: 'top',
    //    title: 'Добавление платежа',
    width: 700,
    items: [
        {
            xtype:'tabpanel',
            id: 'panelTechSupport2',
            plain:true,
            activeTab: 0,
            height:420,
            deferredRender: false,
            defaults:{bodyStyle:'padding:10px;'},
            items:[
                {
                    title:'Входящий звонок',
                    autoScroll: true,
                    border: false,
                    items: [
                        {
                            html:'<span>Звонок с номера: <h1 style="color:green">8-903-125-1542</h1></span>',
                            style: {
                                textAlign: 'center',
                                fontSize: '25px'
                            },
                            border: false
                        },
                        grid3,
                        {
                            html: '<b>Статус Клиента:</b>',
                            border: false,
                            style: {
                                marginTop: '10px'
                            }
                        },
                        new Ext.Panel({
                            border: false,
                            layout:'column',
                            items: [
                                {
                                    xtype: 'radiogroup',
                                    id: 'TechSupportRadioFake22',
                                    width: 195,
                                    items: [
                                        {boxLabel: 'Член ВОА', name: 'TechSupportRadioFake22', inputValue: 'Член ВОА'},
                                        {boxLabel: 'Не член ВОА', name: 'TechSupportRadioFake22', inputValue: 'Не член ВОА', checked: true}
                                    ],
                                    listeners: {
                                        'change' : function() {
                                            if (this.getValue().getGroupValue() == 'Член ВОА') {
                                                Ext.getCmp('memberIdSearch').show();
                                                Ext.getCmp('memberIdSearchBut').show();
                                                Ext.getCmp('memberIdSearchTitle').show();
                                            } else {
                                                Ext.getCmp('memberIdSearch').hide();
                                                Ext.getCmp('memberIdSearchBut').hide();
                                                Ext.getCmp('memberIdSearchTitle').hide();
                                            }
                                        }
                                    }
                                },
                                {
                                    border: false,
                                    hidden: true,
                                    id: 'memberIdSearchTitle',
                                    style: {
                                        marginLeft: '3px',
                                        marginTop: '6px'
                                    },
                                    html: '<h1>Введите номер ЛС члена ВОА: </h1>'
                                },
                                {
                                    xtype:'textfield',
                                    label: 'dddd',
                                    title: 'qqq',
                                    width: 220,
                                    hidden: true,
                                    allowBlank: false,
                                    style: {
                                        marginLeft: '5px',
                                        marginTop: '2px'
                                    },
                                    blankText: 'Номер ЛС должен быть указан',
                                    id: 'memberIdSearch',
                                    regex: /\d+/,
                                    regexText: 'Номер ЛС должен быть числовым значением'
                                },
                                {
                                    xtype:'button',
                                    text: 'Поиск',
                                    style: {
                                        marginLeft: '5px',
                                        marginTop: '2px'
                                    },
                                    hidden: true,
                                    id: 'memberIdSearchBut',
                                    listeners: {
                                        'click' : function() {
                                            if (Ext.getCmp('memberIdSearch').isValid()) {
                                                Ext.getCmp('memberIdSearch').hide();
                                                Ext.getCmp('memberIdSearchBut').hide();
                                                Ext.getCmp('memberIdSearchTitle').hide();
                                                store1.loadData(myData1);
                                                grid3.show();
                                                memberHistoryStore1.load();
                                                memberHistoryGrid1.show();
                                            }
                                        }
                                    }
                                }
                            ]
                        }),
                        memberHistoryGrid1,
                        {
                            border: false,
                            buttons: [
                                {
                                    text: 'Ответить на звонок',
                                    id: 'answerButton2',
                                    handler: function () {
                                        if (Ext.getCmp('answerButton2').getText() == "Ответить на звонок") {
                                            Ext.getCmp('answerButton2').setText("Завершить звонок");
                                            timerStart2 = new Date().getTime();
                                            Ext.TaskMgr.start(task2);
                                            Ext.getCmp('techSupportBut2').setDisabled(false);
                                            Ext.getCmp('techServiceBut2').setDisabled(false);
                                        } else {
                                            Ext.TaskMgr.stopAll();
                                            win2.setTitle('Регистрация звонка');
                                            Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                            Ext.getCmp('techSupportBut2').setDisabled(true);
                                            Ext.getCmp('techServiceBut2').setDisabled(true);
                                            Ext.getCmp('techSupportPan2').setDisabled(true);
                                            Ext.getCmp('techServicePan2').setDisabled(true);
                                            callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                            buttonValue = this.text;
                                            Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                            Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                            Ext.getCmp('techServiceResult2').setDisabled(false);
                                            Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                            timerStart2 = new Date().getTime();
                                            Ext.TaskMgr.start(taskWinHide2);
                                        }


                                    }
                                },
                                {
                                    text: 'Требуется экстренная помощь',
                                    id: 'techSupportBut2',
                                    disabled: true,
                                    handler: function () {
                                        Ext.getCmp('techSupportPan2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(1);
                                    }
                                },
                                {
                                    text: 'Требуются услуги',
                                    id: 'techServiceBut2',
                                    disabled: true,
                                    handler: function () {
                                        Ext.getCmp('techServicePan2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(2);

                                    }
                                },
                                {
                                    text: 'Отмена',
                                    handler: function () {
                                        win2.hide();
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        win2.setTitle('Регистрация звонка');
                                    }
                                }
                            ]
                        }

                    ]
                },
                {
                    title:'Экстренная помощь',
                    id: 'techSupportPan2',
                    autoScroll: true,
                    disabled: true,
                    border: false,
                    items: [
                        {
                            html:'<span>Звонок с номера: <h1 style="color:green">8-903-125-1542</h1></span>',
                            style: {
                                textAlign: 'center',
                                fontSize: '25px'
                            },
                            border: false
                        },
                        grid4,
                        {
                            html: '<b>Статус Клиента:</b>',
                            border: false,
                            style: {
                                marginTop: '10px'
                            }
                        },
                        {
                            xtype: 'radiogroup',
                            id: 'TechSupportRadioFake12',
                            width: 195,
                            items: [
                                {boxLabel: 'Член ВОА', name: 'TechSupportRadioFake12', inputValue: 'Член ВОА', checked: true},
                                {boxLabel: 'Не член ВОА', name: 'TechSupportRadioFake12', inputValue: 'Не член ВОА'}
                            ]
                        },
                        {
                            border: false,
                            style: {
                                paddingTop: '140px'
                            },
                            buttons: [
                                {
                                    text: 'Перевод на 112',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                },
                                {
                                    text: 'Перевод на 01-Пожарная',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                },
                                {
                                    text: 'Перевод на 02-Полиция',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                },
                                {
                                    text: 'Перевод на 03-Скорая',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    title:'Услуги',
                    id: 'techServicePan2',
                    autoScroll: true,
                    disabled: true,
                    border: false,
                    items: [
                        {
                            html:'<span>Звонок с номера: <h1 style="color:green">8-903-125-1542</h1></span>',
                            style: {
                                textAlign: 'center',
                                fontSize: '25px'
                            },
                            border: false
                        },
                        grid5,
                        {
                            html: '<b>Статус Клиента:</b>',
                            border: false,
                            style: {
                                marginTop: '10px'
                            }
                        },
                        {
                            xtype: 'radiogroup',
                            id: 'TechSupportRadioFake222',
                            width: 195,
                            items: [
                                {boxLabel: 'Член ВОА', name: 'TechSupportRadioFake222', inputValue: 'Член ВОА', checked: true},
                                {boxLabel: 'Не член ВОА', name: 'TechSupportRadioFake222', inputValue: 'Не член ВОА'}
                            ]
                        },
                        {
                            border: false,
                            style: {
                                paddingTop: '140px'
                            },
                            buttons: [
                                {
                                    text: 'Перевод на ТехПомощь, Эвакуатор',
                                    handler: function () {
                                        window.open("order.html", "");
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                },
                                {
                                    text: 'Перевод на Юрид. помощь',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win1.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                },
                                {
                                    text: 'Перевод на ADAC',
                                    handler: function () {
                                        Ext.TaskMgr.stopAll();
                                        win2.setTitle('Регистрация звонка');
                                        callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                        buttonValue = this.text;
                                        Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                        Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                        Ext.getCmp('techServiceResult2').setDisabled(false);
                                        Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                        Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                        Ext.getCmp('techSupportPan2').setDisabled(true);
                                        Ext.getCmp('techServicePan2').setDisabled(true);
                                        timerStart2 = new Date().getTime();
                                        Ext.TaskMgr.start(taskWinHide2);
                                    }
                                }/*,
                                 {
                                 text: 'Перевод звонка на 03-Скорая',
                                 handler: function () {
                                 Ext.TaskMgr.stopAll();
                                 win2.setTitle('Регистрация звонка');
                                 callDuration = new Date(new Date().getTime() - timerStart2).format('i:s');
                                 buttonValue = this.text;
                                 Ext.fly('callDurationResult2').update('<h1>Продолжительность: ' + callDuration + '</h1>');
                                 Ext.fly('buttonValueResult2').update('<h1>Результат: ' + buttonValue + '</h1>');
                                 Ext.getCmp('techServiceResult2').setDisabled(false);
                                 Ext.getCmp('panelTechSupport2').setActiveTab(3);
                                 Ext.getCmp('answerButton2').setText("Ответить на звонок");
                                 Ext.getCmp('techSupportPan2').setDisabled(true);
                                 Ext.getCmp('techServicePan2').setDisabled(true);
                                 }
                                 }*/
                            ]
                        }
                    ]
                },
                {
                    title:'Результат',
                    id: 'techServiceResult2',
                    disabled: true,
                    autoScroll: true,
                    border: false,
                    items: [

                        {
                            html:'<h1>Разговор с ' + grid.getStore().getAt(0).get('fio') + ' завершен. </h1>',
                            id: 'fioResult2',
                            style: {

                            },
                            border: false
                        },
                        {
                            html:'',
                            id: 'callDurationResult2',
                            style: {
                                //                                textAlign: 'center',
                                //                                fontSize: '25px'
                            },
                            border: false
                        },
                        {
                            html:'',
                            id: 'buttonValueResult2',
                            style: {
                                //                                textAlign: 'center',
                                //                                fontSize: '25px'
                            },
                            border: false
                        },
                        {
                            border: false,
                            style: {
                                paddingTop: '280px'
                            },
                            buttons: [
                                {
                                    text: 'Закрыть',
                                    handler: function () {
                                        Ext.TaskMgr.stop(taskWinHide);
                                        var tech = new TechnicalRecourse();
                                        tech.setMemberId(Ext.getCmp('memberIdSearch').getValue());
                                        tech.setPhoneNumber('8-903-125-1542');
                                        tech.setAction(buttonValue.substring(0, 20));
                                        tech.setRecourseDate(new Date());
                                        tech.setRegionId(1);
                                        tech.setAccidentPlace('Перекресток...');
                                        tech.setComment('Время разговора: ' + callDuration);
                                        tech.setSupportServiceId(1);

                                        Ext.Ajax.request({
                                            url: 'rest/saveTechnicalRecourse',
                                            headers: {
                                                'Accept' : 'application/json',
                                                'Content-Type' : 'application/json'
                                            },
                                            params: Ext.encode(tech),
                                            method: 'POST',
                                            success: function (response, opts) {
                                                Ext.getCmp('techServiceResult2').setDisabled(true);
                                                Ext.getCmp('techSupportBut2').setDisabled(true);
                                                Ext.getCmp('techServiceBut2').setDisabled(true);
                                                Ext.getCmp('panelTechSupport2').setActiveTab(0);
                                                techSupportStore.reload();
                                                win2.hide();


                                            },
                                            failure: function (response, opts) {
                                                Ext.getCmp('techServiceResult2').setDisabled(true);
                                                Ext.getCmp('techSupportBut2').setDisabled(true);
                                                Ext.getCmp('techServiceBut2').setDisabled(true);
                                                Ext.getCmp('panelTechSupport2').setActiveTab(0);
                                                techSupportStore.reload();
                                                win2.hide();
                                            }
                                        });
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
});


var panelAddTechSupport = new Ext.FormPanel({
    labelAlign: 'top',
    //    title: 'Добавление платежа',
    width: 700,
    items: [
        {
            xtype:'tabpanel',
            plain:true,
            activeTab: 0,
            height:400,
            deferredRender: false,
            defaults:{bodyStyle:'padding:10px'},
            items:[
                {
                    title:'Заявка',
                    autoScroll: true,
                    items: [
                        {
                            layout:'column',
                            border:false,
                            items:[
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Номер ЛС'),
                                            allowBlank: false,
                                            blankText: 'Номер ЛС должен быть указан',
                                            name: 'memberIdTechSupport',
                                            id: 'memberIdTechSupport',
                                            anchor:'95%'
                                        },
                                        new Ext.form.DateField({
                                            fieldLabel: setRequired('Дата обращения'),
                                            format: 'd.m.Y',
                                            name: 'TechSupportDate',
                                            id: 'TechSupportDate',
                                            allowBlank: false,
                                            value: new Date(),
                                            blankText: 'Дата обращения должна быть указана',

                                            anchor:'95%'
                                        }),
                                        {
                                            xtype:'textarea',
                                            fieldLabel: 'Комментарий',
                                            name: 'commentTechSupport',
                                            id: 'commentTechSupport',
                                            height: 200,
                                            anchor:'95%'
                                        }
                                    ]
                                },
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Телефон'),
                                            name: 'phoneTechSupport',
                                            id: 'phoneTechSupport',
                                            allowBlank: false,
                                            blankText: 'Телефон должен быть указан',
                                            value: '909-905-2365',
                                            anchor:'95%'
                                        },
                                        regionsComboTech
                                    ]
                                },
                                {
                                    columnWidth:.3,
                                    layout: 'form',
                                    border:false,
                                    items: [
                                        {
                                            xtype:'textfield',
                                            fieldLabel: setRequired('Место аварии'),
                                            name: 'accidentPlace',
                                            id: 'accidentPlace',
                                            maxLength: 20,
                                            maxLengthText: 'Номер квитанции может содержать до 20 символов включительно...',
                                            allowBlank: false,
                                            blankText: 'Номер квитанции должен быть указан',
                                            anchor:'95%'
                                        },
                                        {
                                            xtype: 'radiogroup',
                                            fieldLabel: setRequired('Действие со звонком'),
                                            itemCls: 'x-check-group-alt',
                                            id: 'TechSupportRadio',
                                            //columns: 1,
                                            items: [
                                                {boxLabel: 'Перевести', name: 'TechSupportRadio', inputValue: 'Перевели звонок', checked: true},
                                                {boxLabel: 'Ответить', name: 'TechSupportRadio', inputValue: 'Ответили на звонок'}
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            handler: function () {
                if (panelAddTechSupport.getForm().isValid()) {
                    var tech = new TechnicalRecourse();
                    tech.setMemberId(Ext.getCmp('memberIdTechSupport').getValue());
                    tech.setPhoneNumber(Ext.getCmp('phoneTechSupport').getValue());
                    tech.setAction(Ext.getCmp('TechSupportRadio').getValue().getGroupValue());
                    tech.setRecourseDate(Ext.getCmp('TechSupportDate').getValue());
                    tech.setRegionId(regionsComboTech.getValue());
                    tech.setAccidentPlace(Ext.getCmp('accidentPlace').getValue());
                    tech.setComment(Ext.getCmp('commentTechSupport').getValue());
                    tech.setSupportServiceId(1);
                    Ext.Ajax.request({
                        url: 'rest/saveTechnicalRecourse',
                        headers: {
                            'Accept' : 'application/json',
                            'Content-Type' : 'application/json'
                        },
                        params: Ext.encode(tech),
                        method: 'POST',
                        success: function (response, opts) {
                            techSupportStore.reload();
                            //                            Ext.Msg.show({
                            //                                title: 'Выполненно!',
                            //                                msg:  'Платеж добавлен для члена ВОА с номером: ' + response.responseText,
                            //                                buttons: Ext.MessageBox.OK,
                            //                                width: 300,
                            //                                icon: Ext.MessageBox.INFO
                            //                            });
                            panelAddTechSupport.getForm().reset();
                            winAddTechSupport.hide();
                        },
                        failure: function (response, opts) {
                            techSupportStore.reload();
                            //                            Ext.Msg.show({
                            //                                title: 'Выполненно!',
                            //                                msg: 'Платеж добавлен для члена ВОА с номеро: ' + response.responseText,
                            //                                buttons: Ext.MessageBox.OK,
                            //                                width: 300,
                            //                                icon: Ext.MessageBox.INFO
                            //                            });
                            panelAddTechSupport.getForm().reset();
                            winAddTechSupport.hide();
                        }
                    });
                }

            }
        },
        {
            text: 'Отменить',
            handler: function () {
                panelAddTechSupport.getForm().reset();
                winAddTechSupport.hide();
            }
        }
    ]
});

var winAdd = new Ext.Window({
    layout: 'fit',
    showAnimDuration: 0.2,
    hideAnimDuration: 0.2,
    animateTarget: 'winAdd',
    title: 'Добавление/Обновление кандидата ВОА',
    width: 910,
    height: 400,
    closeAction: 'hide',
    plain: true,
    items: panelAdd
});

var winAddPayment = new Ext.Window({
    layout: 'fit',
    showAnimDuration: 0.2,
    hideAnimDuration: 0.2,
    animateTarget: 'winAddPayment',
    title: 'Добавление платежа',
    width: 910,
    height: 310,
    closeAction: 'hide',
    plain: true,
    items: panelAddPayment
});

var winUpdatePayment = new Ext.Window({
    layout: 'fit',
    title: 'Платеж',
    showAnimDuration: 0.2,
    hideAnimDuration: 0.2,
    animateTarget: 'winAddPayment',
    width: 910,
    height: 285,
    closeAction: 'hide',
    plain: true,
    items: panelUpdatePayment
});

var win1 = new Ext.Window({
    layout: 'fit',
    showAnimDuration: 0.2,
    hideAnimDuration: 0.2,
    animateTarget: 'winBut1',
    title: 'Регистрация звонка',
    width: 910,
    height: 450,
    closeAction: 'hide',
    plain: true,
    items: panelTechSupport
});

var win2 = new Ext.Window({
    layout: 'fit',
    showAnimDuration: 0.2,
    hideAnimDuration: 0.2,
    title: 'Регистрация звонка',
    width: 910,
    height: 450,
    closeAction: 'hide',
    plain: true,
    animateTarget: 'winBut2',
    items: panelTechSupport2
});

var winAddTechSupport = new Ext.Window({
    layout: 'fit',
    title: 'Регистрация звонка',
    width: 910,
    height: 450,
    closeAction: 'hide',
    plain: true,
    items: panelAddTechSupport
});

var allMembers = {
    id: 'allMembers-panel',
    name: 'allMembers-panel',
    title: 'Просмотр членов ВОА',
    layout: 'fit',
    bodyStyle: 'background-color:#e1e8ff; width:100%; height:100%; border:0',
    items:[
        memberGrid
    ]
};

var allCandidats = {
    id: 'allCandidats-panel',
    title: 'Просмотр кандидатов ВОА',
    layout: 'fit',
    bodyStyle: 'background-color:#e1e8ff; width:100%; height:100%; border:0',
    items:[
        candidatGrid
    ]
};

var allPayments = {
    id: 'allPayments-panel',
    title: 'Платежи',
    layout: 'fit',
    bodyStyle: 'background-color:#e1e8ff; width:100%; height:100%; border:0',
    items:[
        paymentGrid
    ]
};

var allTechSupport = {
    id: 'allTechSupport-panel',
    title: 'Экстренная помощь',
    layout: 'fit',
    bodyStyle: 'background-color:#e1e8ff; width:100%; height:100%; border:0',
    items:[
        techSupportGrid
    ]
};

Ext.ns('Ext.ux');
Ext.ux.FadeInWindow = Ext.extend(Ext.Window, {
    animateTarget : true,
    setAnimateTarget : Ext.emptyFn,
    animShow : function() {
        this.el.fadeIn({
            duration: .25,
            callback: this.afterShow.createDelegate(this, [true], false),
            scope: this
        });
    },
    animHide : function() {
        if (this.el.shadow) {
            this.el.shadow.hide();
        }
        this.el.fadeOut({
            duration: .25,
            callback: this.afterHide,
            scope: this
        });
    }
});

Ext.onReady(function() {

    Ext.QuickTips.init();

    var detailEl;

    var contentPanel = {
        id: 'content-panel',
        region: 'center',
        layout: 'card',
        margins: '0 0 0 0',
        activeItem: 0,
        border: false,
        width:'100%',
        items: [
            start,
            allMembers,
            allCandidats,
            allPayments,
            allTechSupport
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
        bodyStyle: 'background-color:#eee;',
        listeners: {
            click: function(n) {
                if (!n.leaf) {
                    if (!n.expanded) {
                        n.expand(n.getPath);
                    } else {
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

    treePanel.on('click', function(n) {
        var sn = this.selModel.selNode || {};
        if (n.leaf && n.id != sn.id) {
            Ext.getCmp('content-panel').layout.setActiveItem(n.id + '-panel');
            if (!detailEl) {
                var bd = Ext.getCmp('details-panel').body;
                bd.update('').setStyle('background', '#eee');
                detailEl = bd.createChild();
                detailEl.update('').setStyle('margin', '15px');
                detailEl.update('').setStyle('padding', '15px');
                detailEl.update('').setStyle('border', '1px dotted #999');
                detailEl.update('').setStyle('color', '#555');
                detailEl.update('').setStyle('background', '#f9f9f9');
            }
            detailEl.hide().update(infoStore.getById(n.id).get('info')).slideIn('l', {
                stopFx:true,
                duration:.2
            });
            if (n.id == "allMembers") {
                if (memberStore.getCount() == 0) {
                    memberStore.load({ params: { firstRow: 0, listSize: 25, sortOrder: 'asc', sortColumn: 'id'} });
                }
            }
            if (n.id == "allCandidats") {
                if (candidatStore.getCount() == 0) {
                    candidatStore.load({ params: { firstRow: 0, listSize: 25, sortOrder: 'asc', sortColumn: 'id'} });
                }
            }
            if (n.id == "allPayments") {
                if (memberPaymentStore.getCount() == 0) {
                    memberPaymentStore.load({ params: { firstRow: 0, listSize: 25, sortOrder: 'asc', sortColumn: 'id'} });
                }
            }

            if (n.id == "allTechSupport") {
                if (techSupportStore.getCount() == 0) {
                    regionStore.load({
                        callback: function (response, opts, success) {
                            techSupportStore.load({ params: { firstRow: 0, listSize: 25, sortOrder: 'asc', sortColumn: 'id'} });
                        }
                    });
                }
            }
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
        html: '<p class="details-info">' +
                '<b>Справочная информация</b>' +
                '<br/>' +
                '<br/>Выберите нужную функцию...</p>'
    };

    new Ext.Viewport({
        layout: 'border',
        items: [
            {
                region: 'north',
                height: 0,
                title: 'Система администрироваия для ВОА',
                bodyStyle: 'border: 0'
            },
            {
                layout: 'border',
                id: 'layout-browser',
                region:'west',
                border: false,
                split:true,
                margins: '0 0 0 0',
                width: 220,
                minSize: 100,
                maxSize: 500,
                items: [treePanel, detailsPanel]
            },
            contentPanel
        ],
        renderTo: Ext.getBody()
    });
});