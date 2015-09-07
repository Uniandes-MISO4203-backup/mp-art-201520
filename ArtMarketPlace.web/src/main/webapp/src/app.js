(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'xeditable',
        'authModule',
        'artistModule',
        'artworkModule',
        'cartItemModule',
        'clientModule',
        'ngRoute',
        'ngCrud'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                    .when('/artist', {
                        templateUrl: tplUrl,
                        controller: 'artistCtrl',
                        controllerAs: alias
                    })
                    .when('/client', {
                        templateUrl: tplUrl,
                        controller: 'clientCtrl',
                        controllerAs: alias
                    })
                    .when('/catalog', {
                        templateUrl: tplUrl,
                        controller: 'catalogCtrl',
                        controllerAs: alias
                    })
                    .when('/shoppingCart', {
                        templateUrl: 'src/modules/cartItem/shoppingCart.tpl.html',
                        controller: 'cartItemCtrl',
                        controllerAs: alias
                    })
                    .when('/artwork', {
                        templateUrl: tplUrl,
                        controller: 'artworkCtrl',
                        controllerAs: alias
                    })
                    .when('/search', {
                        templateUrl: 'src/modules/search/search.tpl.html',
                        controller: 'catalogCtrl',
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
            auth.setRoles({'user': 'Client', 'artists': 'Artist'});
        }]);

    mainApp.run(function (editableOptions) {
        editableOptions.theme = 'bs3'; // bootstrap3 theme. For Xeditable plugin Angular
    });
})(window.angular);
