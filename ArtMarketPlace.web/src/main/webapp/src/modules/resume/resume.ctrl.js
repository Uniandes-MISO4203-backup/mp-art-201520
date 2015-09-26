(function (ng) {
    var mod = ng.module('resumeModule');

    mod.controller('resumeCtrl', ['CrudCreator', '$scope', '$location', 'resumeService', 'resumeModel', function (CrudCreator, $scope,$location, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'resume', 'Resume');
            $scope.save = function () {
                svc.save({
                    lastName: $scope.record.lastname,
                    city: $scope.record.city,
                    country: $scope.record.country,
                    website: $scope.record.website,
                    photo: $scope.record.photo
                });
                $location.url('/catalog');
            };
            
            $scope.cancel = function () {
                $location.url('/catalog');
            };
            
            
        }]);
})(window.angular);
