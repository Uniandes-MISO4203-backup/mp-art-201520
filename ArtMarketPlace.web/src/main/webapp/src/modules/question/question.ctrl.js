(function (ng) {
    var mod = ng.module('questionModule');

    mod.controller('questionCtrl', ['CrudCreator', '$scope', 'questionService', 'questionModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'question', 'Question');
            this.fetchRecords();
        }]);
})(window.angular);