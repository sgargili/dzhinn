var token = '924f4a86460d9b81a8042bc23ce41c48';

Ext.Ajax.extraParams = {token: token};
Ext.data.Connection.prototype.extraParams = {token: token};
Ext.data.ScriptTagProxy.prototype.extraParams = {token: token};

var tocCurrenciesFormatter = Ext.util.Format.CurrencyFactory(parseInt('2'), '.', ',', '$', '');

/*
 * Desktop configuration
 */
TocDesktop = new Ext.app.App({
    loader: 'http://test1.ru/admin/load.php',

    json: 'http://test1.ru/admin/json.php',

    init :function() {
        Ext.QuickTips.init();
    },

    // config for the start menu
    getStartConfig : function() {
        return {
            iconCls: 'user',
            title: 'root',
            toolItems: [
                {
                    text: TocLanguage.Logout,
                    iconCls: 'logout',
                    handler: function() {
                        Ext.Ajax.request({
                            url: Toc.CONF.CONN_URL,
                            params: {
                                module: 'login',
                                action: 'logoff'
                            },
                            callback: function(options, success, response) {
                                result = Ext.decode(response.responseText);

                                if (result.success == true) {
                                    window.location = "http://test1.ru/admin/index.php";
                                }
                            }
                        });
                    }
                }
            ],
            toolPanelWidth: 115
        };
    },

    /**
     * Return modules.
     */
    getModules: function() {
        return [new TocDesktop.ArticlesGroupWindow(),
            new TocDesktop.ArticlesCategoriesWindow(),
            new TocDesktop.ArticlesWindow(),
            new TocDesktop.FaqsWindow(),
            new TocDesktop.SlideImagesWindow(),
            new TocDesktop.GuestBookWindow(),
            new TocDesktop.PollsWindow(),
            new TocDesktop.ConfigurationGroupWindow(),
            new TocDesktop.ConfigurationWizardWindow(),
            new TocDesktop.HomepageInfoWindow(),
            new TocDesktop.ConfigurationSubGroupWindow(),
            new TocDesktop.ConfigurationWindow({id: 'configuration-1-win', title: 'My Store', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":1}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-2-win', title: 'Minimum Values', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":2}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-3-win', title: 'Maximum Values', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":3}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-4-win', title: 'Images', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":4}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-5-win', title: 'Customer Details', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":5}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-7-win', title: 'Shipping/Packaging', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":7}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-8-win', title: 'Product Listing Sort Order', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":8}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-9-win', title: 'Stock', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":9}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-10-win', title: 'Product Details', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":10}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-11-win', title: 'Order Settings', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":11}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-12-win', title: 'E-Mail Options', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":12}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-16-win', title: 'Regulations', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":16}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-17-win', title: 'Credit Cards', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":17}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-18-win', title: 'Program Locations', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":18}}),
            new TocDesktop.ConfigurationWindow({id: 'configuration-19-win', title: 'Content Management System', iconCls: 'icon-configuration-win', shortcutIconCls: 'icon-configuration-shortcut', params: {"gID":19}}),
            new TocDesktop.ContentGroupWindow(),
            new TocDesktop.CategoriesWindow(),
            new TocDesktop.ProductsSubGroupWindow(),
            new TocDesktop.ProductsWindow({id: 'products-win', title: 'Products', iconCls: 'icon-products-win', shortcutIconCls: 'icon-products-shortcut', params: null}),
            new TocDesktop.ProductsWindow({id: 'products-dialog-win', title: 'New Product', iconCls: 'icon-new-products-win', shortcutIconCls: 'icon-new-products-shortcut', params: null}),
            new TocDesktop.ProductsWindow({id: 'products_attachments-win', title: 'Product Attachments', iconCls: 'icon-products_attachments-win', shortcutIconCls: 'icon-products_attachments-shortcut', params: null}),
            new TocDesktop.ProductVariantsWindow(),
            new TocDesktop.ProductsAttributesWindow(),
            new TocDesktop.QuantityDiscountGroupsWindow(),
            new TocDesktop.ManufacturersWindow(),
            new TocDesktop.SpecialsWindow(),
            new TocDesktop.ReviewsSubGroupWindow(),
            new TocDesktop.ReviewsWindow({id: 'reviews-win', title: 'Reviews', iconCls: 'icon-reviews-win', shortcutIconCls: 'icon-reviews-shortcut', params: {"set":"reviews"}}),
            new TocDesktop.ReviewsWindow({id: 'ratings-win', title: 'Ratings', iconCls: 'icon-ratings-win', shortcutIconCls: 'icon-ratings-shortcut', params: {"set":"ratings"}}),
            new TocDesktop.ProductsExpectedWindow(),
            new TocDesktop.SearchTermsWindow(),
            new TocDesktop.FeatureProductsManagerWindow(),
            new TocDesktop.CustomersGroupWindow(),
            new TocDesktop.CustomersWindow(),
            new TocDesktop.CustomersGroupsWindow(),
            new TocDesktop.OrdersWindow(),
            new TocDesktop.InvoicesWindow(),
            new TocDesktop.CouponsWindow(),
            new TocDesktop.GiftCertificatesWindow(),
            new TocDesktop.PurchasedDownloadablesWindow(),
            new TocDesktop.OrdersReturnsWindow(),
            new TocDesktop.CreditsMemoWindow(),
            new TocDesktop.EmailWindow(),
            new TocDesktop.AbandonedCartWindow(),
            new TocDesktop.DefinitionsGroupWindow(),
            new TocDesktop.InformationWindow(),
            new TocDesktop.CurrenciesWindow(),
            new TocDesktop.CountriesWindow(),
            new TocDesktop.ZoneGroupsWindow(),
            new TocDesktop.TaxClassesWindow(),
            new TocDesktop.UnitClassesWindow(),
            new TocDesktop.CreditCardsWindow(),
            new TocDesktop.OrdersStatusWindow(),
            new TocDesktop.ImageGroupsWindow(),
            new TocDesktop.LanguagesWindow(),
            new TocDesktop.WeightClassesWindow(),
            new TocDesktop.ModulesGroupWindow(),
            new TocDesktop.ModulesPaymentWindow(),
            new TocDesktop.ModulesShippingWindow(),
            new TocDesktop.ModulesOrderTotalWindow(),
            new TocDesktop.ModulesGeoipWindow(),
            new TocDesktop.ServicesWindow(),
            new TocDesktop.ReportsGroupWindow(),
            new TocDesktop.ReportsProductsSubGroupWindow(),
            new TocDesktop.ReportsProductsWindow({id: 'reports_products-purchased-win', title: 'Products Purchased', iconCls: 'icon-reports-products-purchased-win', shortcutIconCls: 'icon-reports-products-purchased-shortcut', params: {"report":"products-purchased"}}),
            new TocDesktop.ReportsProductsWindow({id: 'reports_products-viewed-win', title: 'Products Viewed', iconCls: 'icon-reports-products-viewed-win', shortcutIconCls: 'icon-reports-products-viewed-shortcut', params: {"report":"products-viewed"}}),
            new TocDesktop.ReportsProductsWindow({id: 'reports_products-categories-purchased-win', title: 'Categories Purchased', iconCls: 'icon-reports-products-categories-win', shortcutIconCls: 'icon-reports-products-categories-shortcut', params: {"report":"categories-purchased"}}),
            new TocDesktop.ReportsProductsWindow({id: 'reports_products-low-stock-win', title: 'Low Stock', iconCls: 'icon-reports-products-low-stock-win', shortcutIconCls: 'icon-reports-products-low-stock-shortcut', params: {"report":"low-stock"}}),
            new TocDesktop.ReportsCustomersSubGroupWindow(),
            new TocDesktop.ReportsCustomersWindow({id: 'reports_customers-purchased-win', title: 'Best Orders', iconCls: 'icon-reports-customers-purchased-win', shortcutIconCls: 'icon-reports-customers-purchased-shortcut', params: {"report":"customers-purchased"}}),
            new TocDesktop.ReportsCustomersWindow({id: 'reports_customers-orders-total-win', title: 'Orders Total', iconCls: 'icon-reports-customers-orders-total-win', shortcutIconCls: 'icon-reports-customers-orders-total-shortcut', params: {"report":"orders-total"}}),
            new TocDesktop.ReportsWebSubGroupWindow(),
            new TocDesktop.ReportsWebWindow({id: 'reports_web-visits-summary-win', title: 'Visits Summary', iconCls: 'icon-reports-web-win', shortcutIconCls: 'icon-reports-web-shortcut', params: {"report":"visits-summary"}}),
            new TocDesktop.ReportsWebWindow({id: 'reports_web-traffic_source_summary-win', title: 'Traffic Source Summary', iconCls: 'icon-reports-web-win', shortcutIconCls: 'icon-reports-web-shortcut', params: {"report":"traffic_source_summary"}}),
            new TocDesktop.ReportsWebWindow({id: 'reports_web-visit_settings-win', title: 'Visit Settings', iconCls: 'icon-reports-web-win', shortcutIconCls: 'icon-reports-web-shortcut', params: {"report":"visit_settings"}}),
            new TocDesktop.ReportsWebWindow({id: 'reports_web-visit_location-win', title: 'Visit Location', iconCls: 'icon-reports-web-win', shortcutIconCls: 'icon-reports-web-shortcut', params: {"report":"visit_location"}}),
            new TocDesktop.ReportsWebWindow({id: 'reports_web-search_engines-win', title: 'Search Engines', iconCls: 'icon-reports-web-win', shortcutIconCls: 'icon-reports-web-shortcut', params: {"report":"search_engines"}}),
            new TocDesktop.ReportsWebWindow({id: 'reports_web-referer_websites-win', title: 'Referer Websites', iconCls: 'icon-reports-web-win', shortcutIconCls: 'icon-reports-web-shortcut', params: {"report":"referer_websites"}}),
            new TocDesktop.TemplatesGroupWindow(),
            new TocDesktop.LogoUploadWindow(),
            new TocDesktop.TemplatesWindow(),
            new TocDesktop.TemplatesModulesSubGroupWindow(),
            new TocDesktop.TemplatesModulesWindow({id: 'templates_modules-boxes-win', title: 'Boxes', iconCls: 'icon-templates-modules-boxes-win', shortcutIconCls: 'icon-templates-modules-boxes-shortcut', params: {"set":"boxes"}}),
            new TocDesktop.TemplatesModulesWindow({id: 'templates_modules-content-win', title: 'Content', iconCls: 'icon-templates-modules-content-win', shortcutIconCls: 'icon-templates-modules-content-shortcut', params: {"set":"content"}}),
            new TocDesktop.TemplatesModulesLayoutSubGroupWindow(),
            new TocDesktop.TemplatesModulesLayoutWindow({id: 'templates_modules_layout-boxes-win', title: 'Boxes', iconCls: 'icon-templates-modules-layout-boxes-win', shortcutIconCls: 'icon-templates-modules-layout-boxes-shortcut', params: {"set":"boxes"}}),
            new TocDesktop.TemplatesModulesLayoutWindow({id: 'templates_modules_layout-content-win', title: 'Content', iconCls: 'icon-templates-modules-layout-content-win', shortcutIconCls: 'icon-templates-modules-layout-content-shortcut', params: {"set":"content"}}),
            new TocDesktop.ToolsGroupWindow(),
            new TocDesktop.AdministratorsWindow(),
            new TocDesktop.AdministratorsLogWindow(),
            new TocDesktop.BannerManagerWindow(),
            new TocDesktop.CacheWindow(),
            new TocDesktop.DashboardWindow(),
            new TocDesktop.BackupWindow(),
            new TocDesktop.EmailTemplatesWindow(),
            new TocDesktop.FileManagerWindow(),
            new TocDesktop.GoogleSitemapWindow(),
            new TocDesktop.ImagesWindow(),
            new TocDesktop.NewslettersWindow(),
            new TocDesktop.ServerInfoWindow(),
            new TocDesktop.WhosOnlineWindow(),
            new TocDesktop.WatermarkWindow(),
            new TocDesktop.DepartmentsWindow(),
            new TocDesktop.ImportExportWindow(),
            new TocDesktop.LanguagesGroupWindow(),
            new TocDesktop.EnUsWindow()];
    },

    /**
     * Return the launchers object.
     */
    getLaunchers : function() {
        return {'autorun': ["dashboard-win"],
            'contextmenu': [],
            'quickstart': ["articles_categories-win","articles-win","faqs-win","slide_images-win","products-win","customers-win","orders-win","invoices-win","coupons-win","gift_certificates-win","dashboard-win"],
            'shortcut': ["articles_categories-win","articles-win","faqs-win","slide_images-win","products-win","customers-win","orders-win","invoices-win","coupons-win","gift_certificates-win","dashboard-win"]};
    },

    /**
     * Return the Styles object.
     */
    getStyles : function() {
        return {"backgroundcolor":"3A6EA5","fontcolor":"FFFFFF","theme":{"code":"vistablue","path":"templates\/default\/desktop\/themes\/xtheme-vistablue\/css\/xtheme-vistablue.css"},"transparency":"100","sidebartransparency":"5","sidebarbackgroundcolor":"FFFFFF","wallpaper":{"code":"blue-swirl","path":"templates\/default\/desktop\/wallpapers\/blue-swirl.jpg"},"wallpaperposition":"tile"};
    },

    /**
     * Return the gadgets in the sidebar.
     */
    getGadgets: function() {
        return ["clock","new_customers","new_orders"];
    },

    /***
     * Return the sidebar status.
     */
    isSidebarOpen: function() {
        return true;
    },

    /**
     * Check whether the configuration wizard is complete.
     */
    isWizardComplete : function() {
        return;
    }
});

TocDesktop.ArticlesGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'articles-grp',
    title : 'Content',
    menu : new Ext.menu.Menu(),
    items : ['articles_categories-win','articles-win','faqs-win','slide_images-win','guest_book-win','polls-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-articles-grp',
            menu: this.menu
        }
    }});

TocDesktop.ArticlesCategoriesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'articles_categories-win',
    title: 'Article Categories',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-articles_categories-win',
            shortcutIconCls: 'icon-articles_categories-shortcut',
            scope: this
        }
    }});

TocDesktop.ArticlesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'articles-win',
    title: 'Articles',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-articles-win',
            shortcutIconCls: 'icon-articles-shortcut',
            scope: this
        }
    }});

TocDesktop.FaqsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'faqs-win',
    title: 'FAQs',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-faqs-win',
            shortcutIconCls: 'icon-faqs-shortcut',
            scope: this
        }
    }});

TocDesktop.SlideImagesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'slide_images-win',
    title: 'Slide Images',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-slide_images-win',
            shortcutIconCls: 'icon-slide_images-shortcut',
            scope: this
        }
    }});

TocDesktop.GuestBookWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'guest_book-win',
    title: 'Guest Book',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-guest_book-win',
            shortcutIconCls: 'icon-guest_book-shortcut',
            scope: this
        }
    }});

TocDesktop.PollsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'polls-win',
    title: 'Polls',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-polls-win',
            shortcutIconCls: 'icon-polls-shortcut',
            scope: this
        }
    }});

TocDesktop.ConfigurationGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'configuration-grp',
    title : 'Configuration',
    menu : new Ext.menu.Menu(),
    items : ['configuration_wizard-win','homepage_info-win','configuration-subgroup'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-configuration-grp',
            menu: this.menu
        }
    }});

TocDesktop.ConfigurationWizardWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'configuration_wizard-win',
    title: 'Configuration Wizard',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-configuration_wizard-win',
            shortcutIconCls: 'icon-configuration_wizard-shortcut',
            scope: this
        }
    }});

TocDesktop.HomepageInfoWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'homepage_info-win',
    title: 'Homepage Info',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-homepage_info-win',
            shortcutIconCls: 'icon-homepage_info-shortcut',
            scope: this
        }
    }});

TocDesktop.ConfigurationSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'configuration-subgroup',
    title : 'Configuration',
    menu : new Ext.menu.Menu(),
    items : ['configuration-1-win','configuration-2-win','configuration-3-win','configuration-4-win','configuration-5-win','configuration-7-win','configuration-8-win','configuration-9-win','configuration-10-win','configuration-11-win','configuration-12-win','configuration-16-win','configuration-17-win','configuration-18-win','configuration-19-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-configuration-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.ConfigurationWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'configuration-win',
    title: 'Configuration',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.ContentGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'content-grp',
    title : 'Catalog',
    menu : new Ext.menu.Menu(),
    items : ['categories-win','products-subgroup','product_variants-win','products_attributes-win','quantity_discount_groups-win','manufacturers-win','specials-win','reviews-subgroup','products_expected-win','search_terms-win','feature_products_manager-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-content-grp',
            menu: this.menu
        }
    }});

TocDesktop.CategoriesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'categories-win',
    title: 'Categories',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-categories-win',
            shortcutIconCls: 'icon-categories-shortcut',
            scope: this
        }
    }});

TocDesktop.ProductsSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'products-subgroup',
    title : 'Products',
    menu : new Ext.menu.Menu(),
    items : ['products-win','products-dialog-win','products_attachments-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-products-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.ProductsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'products-win',
    title: 'Products',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.ProductVariantsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'product_variants-win',
    title: 'Product Variants',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-product_variants-win',
            shortcutIconCls: 'icon-product_variants-shortcut',
            scope: this
        }
    }});

TocDesktop.ProductsAttributesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'products_attributes-win',
    title: 'Product Attributes',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-products_attributes-win',
            shortcutIconCls: 'icon-products_attributes-shortcut',
            scope: this
        }
    }});

TocDesktop.QuantityDiscountGroupsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'quantity_discount_groups-win',
    title: 'Quantity Discount Groups',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-quantity_discount_groups-win',
            shortcutIconCls: 'icon-quantity_discount_groups-shortcut',
            scope: this
        }
    }});

TocDesktop.ManufacturersWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'manufacturers-win',
    title: 'Manufacturers',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-manufacturers-win',
            shortcutIconCls: 'icon-manufacturers-shortcut',
            scope: this
        }
    }});

TocDesktop.SpecialsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'specials-win',
    title: 'Specials',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-specials-win',
            shortcutIconCls: 'icon-specials-shortcut',
            scope: this
        }
    }});

TocDesktop.ReviewsSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'reviews-subgroup',
    title : 'Reviews &amp; Ratings',
    menu : new Ext.menu.Menu(),
    items : ['reviews-win','ratings-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-reviews-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.ReviewsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'reviews-win',
    title: 'Reviews &amp; Ratings',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.ProductsExpectedWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'products_expected-win',
    title: 'Products Expected',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-products_expected-win',
            shortcutIconCls: 'icon-products_expected-shortcut',
            scope: this
        }
    }});

TocDesktop.SearchTermsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'search_terms-win',
    title: 'Popular Search Terms',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-search_terms-win',
            shortcutIconCls: 'icon-search_terms-shortcut',
            scope: this
        }
    }});

TocDesktop.FeatureProductsManagerWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'feature_products_manager-win',
    title: 'Feature Products Manager',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-feature_products_manager-win',
            shortcutIconCls: 'icon-feature_products_manager-shortcut',
            scope: this
        }
    }});

TocDesktop.CustomersGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'customers-grp',
    title : 'Customers',
    menu : new Ext.menu.Menu(),
    items : ['customers-win','customers_groups-win','orders-win','invoices-win','coupons-win','gift_certificates-win','purchased_downloadables-win','orders_returns-win','credits_memo-win','email-win','abandoned_cart-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-customers-grp',
            menu: this.menu
        }
    }});

TocDesktop.CustomersWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'customers-win',
    title: 'Customers',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-customers-win',
            shortcutIconCls: 'icon-customers-shortcut',
            scope: this
        }
    }});

TocDesktop.CustomersGroupsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'customers_groups-win',
    title: 'Customer Groups',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-customers_groups-win',
            shortcutIconCls: 'icon-customers_groups-shortcut',
            scope: this
        }
    }});

TocDesktop.OrdersWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'orders-win',
    title: 'Orders',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-orders-win',
            shortcutIconCls: 'icon-orders-shortcut',
            scope: this
        }
    }});

TocDesktop.InvoicesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'invoices-win',
    title: 'Invoices',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-invoices-win',
            shortcutIconCls: 'icon-invoices-shortcut',
            scope: this
        }
    }});

TocDesktop.CouponsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'coupons-win',
    title: 'Coupons',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-coupons-win',
            shortcutIconCls: 'icon-coupons-shortcut',
            scope: this
        }
    }});

TocDesktop.GiftCertificatesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'gift_certificates-win',
    title: 'Gift Certificates',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-gift_certificates-win',
            shortcutIconCls: 'icon-gift_certificates-shortcut',
            scope: this
        }
    }});

TocDesktop.PurchasedDownloadablesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'purchased_downloadables-win',
    title: 'Purchased Downloadables',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-purchased_downloadables-win',
            shortcutIconCls: 'icon-purchased_downloadables-shortcut',
            scope: this
        }
    }});

TocDesktop.OrdersReturnsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'orders_returns-win',
    title: 'Return Requests',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-orders_returns-win',
            shortcutIconCls: 'icon-orders_returns-shortcut',
            scope: this
        }
    }});

TocDesktop.CreditsMemoWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'credits_memo-win',
    title: 'Credit Slips',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-credits_memo-win',
            shortcutIconCls: 'icon-credits_memo-shortcut',
            scope: this
        }
    }});

TocDesktop.EmailWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'email-win',
    title: 'Customer Emails',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-email-win',
            shortcutIconCls: 'icon-email-shortcut',
            scope: this
        }
    }});

TocDesktop.AbandonedCartWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'abandoned_cart-win',
    title: 'Abandoned Cart',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-abandoned_cart-win',
            shortcutIconCls: 'icon-abandoned_cart-shortcut',
            scope: this
        }
    }});

TocDesktop.DefinitionsGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'definitions-grp',
    title : 'Definitions',
    menu : new Ext.menu.Menu(),
    items : ['information-win','currencies-win','countries-win','zone_groups-win','tax_classes-win','unit_classes-win','credit_cards-win','orders_status-win','image_groups-win','languages-win','weight_classes-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-definitions-grp',
            menu: this.menu
        }
    }});

TocDesktop.InformationWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'information-win',
    title: 'Information',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-information-win',
            shortcutIconCls: 'icon-information-shortcut',
            scope: this
        }
    }});

TocDesktop.CurrenciesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'currencies-win',
    title: 'Currencies',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-currencies-win',
            shortcutIconCls: 'icon-currencies-shortcut',
            scope: this
        }
    }});

TocDesktop.CountriesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'countries-win',
    title: 'Countries',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-countries-win',
            shortcutIconCls: 'icon-countries-shortcut',
            scope: this
        }
    }});

TocDesktop.ZoneGroupsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'zone_groups-win',
    title: 'Zone Groups',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-zone_groups-win',
            shortcutIconCls: 'icon-zone_groups-shortcut',
            scope: this
        }
    }});

TocDesktop.TaxClassesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'tax_classes-win',
    title: 'Tax Classes',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-tax_classes-win',
            shortcutIconCls: 'icon-tax_classes-shortcut',
            scope: this
        }
    }});

TocDesktop.UnitClassesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'unit_classes-win',
    title: 'Product Quantity Units',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-unit_classes-win',
            shortcutIconCls: 'icon-unit_classes-shortcut',
            scope: this
        }
    }});

TocDesktop.CreditCardsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'credit_cards-win',
    title: 'Credit Cards',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-credit_cards-win',
            shortcutIconCls: 'icon-credit_cards-shortcut',
            scope: this
        }
    }});

TocDesktop.OrdersStatusWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'orders_status-win',
    title: 'Order Status',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-orders_status-win',
            shortcutIconCls: 'icon-orders_status-shortcut',
            scope: this
        }
    }});

TocDesktop.ImageGroupsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'image_groups-win',
    title: 'Image Groups',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-image_groups-win',
            shortcutIconCls: 'icon-image_groups-shortcut',
            scope: this
        }
    }});

TocDesktop.LanguagesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'languages-win',
    title: 'Languages',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-languages-win',
            shortcutIconCls: 'icon-languages-shortcut',
            scope: this
        }
    }});

TocDesktop.WeightClassesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'weight_classes-win',
    title: 'Weight Classes',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-weight_classes-win',
            shortcutIconCls: 'icon-weight_classes-shortcut',
            scope: this
        }
    }});

TocDesktop.ModulesGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'modules-grp',
    title : 'Modules',
    menu : new Ext.menu.Menu(),
    items : ['modules_payment-win','modules_shipping-win','modules_order_total-win','modules_geoip-win','services-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-modules-grp',
            menu: this.menu
        }
    }});

TocDesktop.ModulesPaymentWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'modules_payment-win',
    title: 'Payment Modules',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-modules_payment-win',
            shortcutIconCls: 'icon-modules_payment-shortcut',
            scope: this
        }
    }});

TocDesktop.ModulesShippingWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'modules_shipping-win',
    title: 'Shipping Modules',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-modules_shipping-win',
            shortcutIconCls: 'icon-modules_shipping-shortcut',
            scope: this
        }
    }});

TocDesktop.ModulesOrderTotalWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'modules_order_total-win',
    title: 'Order Total Modules',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-modules_order_total-win',
            shortcutIconCls: 'icon-modules_order_total-shortcut',
            scope: this
        }
    }});

TocDesktop.ModulesGeoipWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'modules_geoip-win',
    title: 'GeoIP Modules',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-modules_geoip-win',
            shortcutIconCls: 'icon-modules_geoip-shortcut',
            scope: this
        }
    }});

TocDesktop.ServicesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'services-win',
    title: 'Services',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-services-win',
            shortcutIconCls: 'icon-services-shortcut',
            scope: this
        }
    }});

TocDesktop.ReportsGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'reports-grp',
    title : 'Reports',
    menu : new Ext.menu.Menu(),
    items : ['reports_products-subgroup','reports_customers-subgroup','reports_web-subgroup'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-reports-grp',
            menu: this.menu
        }
    }});

TocDesktop.ReportsProductsSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'reports_products-subgroup',
    title : 'Products Report',
    menu : new Ext.menu.Menu(),
    items : ['reports_products-purchased-win','reports_products-viewed-win','reports_products-categories-purchased-win','reports_products-low-stock-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-reports_products-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.ReportsProductsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'reports_products-win',
    title: 'Products Report',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.ReportsCustomersSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'reports_customers-subgroup',
    title : 'Orders Report',
    menu : new Ext.menu.Menu(),
    items : ['reports_customers-purchased-win','reports_customers-orders-total-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-reports_customers-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.ReportsCustomersWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'reports_customers-win',
    title: 'Orders Report',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.ReportsWebSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'reports_web-subgroup',
    title : 'Web Analytics Report',
    menu : new Ext.menu.Menu(),
    items : ['reports_web-visits-summary-win','reports_web-traffic_source_summary-win','reports_web-visit_settings-win','reports_web-visit_location-win','reports_web-search_engines-win','reports_web-referer_websites-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-reports_web-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.ReportsWebWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'reports_web-win',
    title: 'Web Analytics Report',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.TemplatesGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'templates-grp',
    title : 'Templates',
    menu : new Ext.menu.Menu(),
    items : ['logo_upload-win','templates-win','templates_modules-subgroup','templates_modules_layout-subgroup'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-templates-grp',
            menu: this.menu
        }
    }});

TocDesktop.LogoUploadWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'logo_upload-win',
    title: 'Logo Upload',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-logo_upload-win',
            shortcutIconCls: 'icon-logo_upload-shortcut',
            scope: this
        }
    }});

TocDesktop.TemplatesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'templates-win',
    title: 'Templates',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-templates-win',
            shortcutIconCls: 'icon-templates-shortcut',
            scope: this
        }
    }});

TocDesktop.TemplatesModulesSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'templates_modules-subgroup',
    title : 'Template Modules',
    menu : new Ext.menu.Menu(),
    items : ['templates_modules-boxes-win','templates_modules-content-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-templates_modules-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.TemplatesModulesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'templates_modules-win',
    title: 'Template Modules',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.TemplatesModulesLayoutSubGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'subgroup',
    id : 'templates_modules_layout-subgroup',
    title : 'Template Modules Layout',
    menu : new Ext.menu.Menu(),
    items : ['templates_modules_layout-boxes-win','templates_modules_layout-content-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-templates_modules_layout-subgroup',
            menu: this.menu
        }
    }});

TocDesktop.TemplatesModulesLayoutWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'templates_modules_layout-win',
    title: 'Template Modules Layout',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: this.iconCls,
            shortcutIconCls: this.shortcutIconCls,
            scope: this
        }
    }});

TocDesktop.ToolsGroupWindow = Ext.extend(Ext.app.Module, {
    appType : 'group',
    id : 'tools-grp',
    title : 'Tools',
    menu : new Ext.menu.Menu(),
    items : ['administrators-win','administrators_log-win','banner_manager-win','cache-win','dashboard-win','backup-win','email_templates-win','file_manager-win','google_sitemap-win','images-win','newsletters-win','server_info-win','whos_online-win','watermark-win','departments-win','import_export-win'],
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-tools-grp',
            menu: this.menu
        }
    }});

TocDesktop.AdministratorsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'administrators-win',
    title: 'Administrators',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-administrators-win',
            shortcutIconCls: 'icon-administrators-shortcut',
            scope: this
        }
    }});

TocDesktop.AdministratorsLogWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'administrators_log-win',
    title: 'Administrators Log',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-administrators_log-win',
            shortcutIconCls: 'icon-administrators_log-shortcut',
            scope: this
        }
    }});

TocDesktop.BannerManagerWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'banner_manager-win',
    title: 'Banner Manager',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-banner_manager-win',
            shortcutIconCls: 'icon-banner_manager-shortcut',
            scope: this
        }
    }});

TocDesktop.CacheWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'cache-win',
    title: 'Cache Control',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-cache-win',
            shortcutIconCls: 'icon-cache-shortcut',
            scope: this
        }
    }});

TocDesktop.DashboardWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'dashboard-win',
    title: 'Dashboard',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-dashboard-win',
            shortcutIconCls: 'icon-dashboard-shortcut',
            scope: this
        }
    }});

TocDesktop.BackupWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'backup-win',
    title: 'Database Backup Manager',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-backup-win',
            shortcutIconCls: 'icon-backup-shortcut',
            scope: this
        }
    }});

TocDesktop.EmailTemplatesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'email_templates-win',
    title: 'Email Templates',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-email_templates-win',
            shortcutIconCls: 'icon-email_templates-shortcut',
            scope: this
        }
    }});

TocDesktop.FileManagerWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'file_manager-win',
    title: 'File Manager',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-file_manager-win',
            shortcutIconCls: 'icon-file_manager-shortcut',
            scope: this
        }
    }});

TocDesktop.GoogleSitemapWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'google_sitemap-win',
    title: 'Google Sitemaps',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-google_sitemap-win',
            shortcutIconCls: 'icon-google_sitemap-shortcut',
            scope: this
        }
    }});

TocDesktop.ImagesWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'images-win',
    title: 'Images',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-images-win',
            shortcutIconCls: 'icon-images-shortcut',
            scope: this
        }
    }});

TocDesktop.NewslettersWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'newsletters-win',
    title: 'Newsletter Manager',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-newsletters-win',
            shortcutIconCls: 'icon-newsletters-shortcut',
            scope: this
        }
    }});

TocDesktop.ServerInfoWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'server_info-win',
    title: 'Server Information',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-server_info-win',
            shortcutIconCls: 'icon-server_info-shortcut',
            scope: this
        }
    }});

TocDesktop.WhosOnlineWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'whos_online-win',
    title: 'Who\&#039;s Online',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-whos_online-win',
            shortcutIconCls: 'icon-whos_online-shortcut',
            scope: this
        }
    }});

TocDesktop.WatermarkWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'watermark-win',
    title: 'Watermark Tool',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-watermark-win',
            shortcutIconCls: 'icon-watermark-shortcut',
            scope: this
        }
    }});

TocDesktop.DepartmentsWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'departments-win',
    title: 'Departments Management',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-departments-win',
            shortcutIconCls: 'icon-departments-shortcut',
            scope: this
        }
    }});

TocDesktop.ImportExportWindow = Ext.extend(Ext.app.Module, {
    appType : 'win',
    id : 'import_export-win',
    title: 'Import / Export',
    init : function() {
        this.launcher = {
            text: this.title,
            iconCls: 'icon-import_export-win',
            shortcutIconCls: 'icon-import_export-shortcut',
            scope: this
        }
    }});

TocDesktop.LanguagesGroupWindow = Ext.extend(Ext.app.Module, {appType : 'group',id : 'languages-grp',menu : new Ext.menu.Menu(),items : ['lang-en_us-win'],init : function() {
    this.launcher = {text: 'Languages',iconCls: 'icon-languages-grp',menu: this.menu}
}});
TocDesktop.EnUsWindow = Ext.extend(Ext.app.Module, {appType : 'grid',id : 'lang-en_us-win',init : function() {
    this.launcher = {text: 'English',iconCls: 'icon-us-win',shortcutIconCls: 'icon-en_US-shortcut',handler: function() {
        window.location = "http://test1.ru/admin/index.php?admin_language=en_US";
    },scope: this}
}});