(function (ng) {
    var mod = ng.module('resumeModule');

    mod.controller('resumeCtrl', ['CrudCreator', '$scope', '$location', 'resumeService', 'resumeModel','$routeParams', function (CrudCreator, $scope,$location, svc, model, $routeParams) {
            CrudCreator.extendController(this, svc, $scope, model, 'resume', 'Resume');
            if(typeof $routeParams.id !== "undefined"){
                var idArtist = $routeParams.id;
            }else{
                svc.getArtist().then(function (result) {
                    $scope.record = [];
                    $scope.record = result;
                    var education ="";
                    for(i=0;i<$scope.record.experience.length;i++){
                        var exp = $scope.record.experience[i];
                        education += exp.title +"-"+exp.place+"-"+exp.startDate+" to "+exp.finishDate+" \n";
                    }
                    $scope.listEducation = education;
                });
                
            }
            //var idArtist = $routeParams.id;
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
            };
            $scope.saveExperience =function() {
                svc.addExperience($scope.experience).then(function (data) {
                   $('#experienceModal').modal('hide');
                   $scope.record.experience.push(data);
                   $scope.listEducation = $scope.listEducation + data.title +"-"+data.place+"-"+data.startDate+" to "+data.finishDate+" \n";;
                });
            };
            
            
            if(idArtist !== "" || typeof idArtist !== "undefined"){
                svc.getResume(idArtist).then(function (result) {
                    $scope.prueba = result;
                    $scope.record = [];
                    $scope.record = result;
                });
            }
            
        }]);
})(window.angular);
