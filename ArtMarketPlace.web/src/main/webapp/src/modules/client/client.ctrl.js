(function (ng) {
    var mod = ng.module('clientModule');

    mod.controller('clientCtrl', ['CrudCreator', '$scope', 'clientService', 'clientModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'client', 'Client');
            this.fetchRecords();
        }]);

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'cartItem', 'client');
            this.loadRefOptions();
        }]);
})(window.angular);
