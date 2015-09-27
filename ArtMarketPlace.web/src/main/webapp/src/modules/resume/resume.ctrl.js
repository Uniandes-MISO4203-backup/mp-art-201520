(function (ng) {
    var mod = ng.module('resumeModule');

    mod.controller('resumeCtrl', ['CrudCreator', '$scope', '$location', 'resumeService', 'resumeModel','$routeParams', function (CrudCreator, $scope,$location, svc, model, $routeParams) {
            CrudCreator.extendController(this, svc, $scope, model, 'resume', 'Resume');
            var idArtist = $routeParams.id;
            $scope.param1 = idArtist;
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
            $scope.addExperience =function() {
                $('#experienceModal').modal('show');
            }
            $scope.saveExperience =function() {
                svc.addExperience($scope.experience).then(function () {
                   $('#experienceModal').modal('hide');
                   
                });
            }
            
            if(idArtist !== ""){
                svc.getResume(idArtist).then(function (result) {
                    $scope.prueba = result;
                    $scope.record = [];
                    $scope.record = result;
                });
            }
            
        }]);
})(window.angular);
