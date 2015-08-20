(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
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
                .otherwise('/');
        }]);
})(window.angular);
