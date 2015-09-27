(function (ng) {
    var mod = ng.module('experienceModule');

    mod.controller('experienceCtrl', ['CrudCreator', '$scope', 'experienceService', 'experienceModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'experience', 'Experience');
            //this.fetchRecords();
        }]);
})(window.angular);