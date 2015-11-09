(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'xeditable',
        'authModule',
        'artistModule',
        'artworkGaleryItemModule',
        'artworkModule',
        'cartItemModule',
        'clientModule',
        'paymentModule',
        'questionModule',
        'resumeModule',
        'experienceModule',
        'blogModule',
        'ngRoute',
        'ngCrud',
        'ui.bootstrap',
        'youtube-embed',
        'wishListModule'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                    .when('/artist', {
                        templateUrl: tplUrl,
                        controller: 'artistCtrl',
                        controllerAs: alias
                    })
                    .when('/payment', {
                        templateUrl: tplUrl,
                        controller: 'paymentCtrl',
                        controllerAs: alias
                    })
                    .when('/client', {
                        templateUrl: tplUrl,
                        controller: 'clientCtrl',
                        controllerAs: alias
                    })
                    .when('/catalog', {
                        templateUrl: 'src/modules/artwork/catalog.tpl.html',
                        controller: 'catalogCtrl',
                        controllerAs: alias
                    })
                    .when('/shoppingCart', {
                        templateUrl: 'src/modules/cartItem/shoppingCart.tpl.html',
                        controller: 'cartItemCtrl',
                        controllerAs: alias
                    })
                    .when('/wishList', {
                        templateUrl: 'src/modules/wishList/wishList.tpl.html',
                        controller: 'wishListCtrl',
                        controllerAs: alias
                    })
                    .when('/pay', {
                        templateUrl: 'src/modules/payment/pay.tpl.html',
                        controller: 'paymentViewCtrl',
                        controllerAs: alias
                    })
                    .when('/payf', {
                        templateUrl: 'src/modules/payment/paymentFinished.tpl.html',
                        controller: 'paymentViewCtrl',
                        controllerAs: alias
                    })
                    .when('/artwork', {
                        templateUrl: tplUrl,
                        controller: 'artworkCtrl',
                        controllerAs: alias
                    })
                    .when('/question', {
                        templateUrl: tplUrl,
                        controller: 'questionCtrl',
                        controllerAs: alias
                    })
                    .when('/search', {
                        templateUrl: 'src/modules/search/search.tpl.html',
                        controller: 'catalogCtrl',
                        controllerAs: alias
                    })
                    .when('/resume', {
                        templateUrl: 'src/modules/resume/resume.tpl.html',
                        controller: 'resumeCtrl',
                        controllerAs: alias
                    })
                    .when('/artistCatalog/:artistId', {
                        templateUrl: 'src/modules/artwork/artistCatalog.tpl.html',
                        controller: 'catalogCtrl',
                        controllerAs: alias
                    })
                    .when('/resume/:id', {
                        templateUrl: 'src/modules/resume/resumeView.tpl.html',
                        controller: 'resumeCtrl',
                        controllerAs: alias
                    })
                    .when('/blog/:id', {
                        templateUrl: 'src/modules/blog/templates/blog.tpl.html',
                        controller: 'blogCtrl',
                        controllerAs: alias
                    })
                    .when('/blog', {
                        templateUrl: 'src/modules/blog/templates/blog.tpl.html',
                        controller: 'blogCtrl',
                        controllerAs: alias
                    })
                    .when('/newentry', {
                        templateUrl: 'src/modules/blog/templates/newentry.tpl.html',
                        controller: 'blogCtrl',
                        controllerAs: alias
                    })
                    .when('/viewentry/:idBlog', {
                        templateUrl: 'src/modules/blog/templates/viewentry.tpl.html',
                        controller: 'blogCtrl',
                        controllerAs: alias
                    })
                    .otherwise('/catalog');
        }]);

    mainApp.config(['authServiceProvider', function (auth) {
            auth.setValues({
                apiUrl: 'users',
                successPath: '/catalog',
                loginPath: '/login',
                registerPath: '/register',
                logoutRedirect: '/login',
                loginURL: 'login',
                registerURL: 'register',
                logoutURL: 'logout',
                nameCookie: 'userCookie'
            });
            auth.setRoles({'user': 'Client', 'artists': 'Artist', 'admin': 'Admin'});
        }]);

    mainApp.run(function (editableOptions) {
        // bootstrap3 theme. For Xeditable plugin Angular
        editableOptions.theme = 'bs3';
    });
})(window.angular);
