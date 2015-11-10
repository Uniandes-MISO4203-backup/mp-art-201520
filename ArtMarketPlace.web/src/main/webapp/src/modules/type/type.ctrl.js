(function (ng) {
    var mod = ng.module('typeModule');

    mod.controller('typeCtrl', ['$scope', 'typeService', 'typeModel', 'CrudCreator', function ($scope, svc, model, crudCreator) {
            crudCreator.extendController(this, svc, $scope, model, 'type', 'Type');
            this.fetchRecords();
        }]);
})(window.angular);
