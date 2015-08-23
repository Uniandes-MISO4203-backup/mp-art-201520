(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'Shopping Cart');
            this.fetchRecords();
        }]);
})(window.angular);
