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
                    var experience="";
                    for(i=0;i<$scope.record.experience.length;i++){
                        var exp = $scope.record.experience[i];
                        if(exp.type==="Education")
                            education += exp.title +"-"+exp.place+"-"+format(exp.startDate)+" to "+format(exp.finishDate)+" \n";
                        else
                            experience += exp.title +"-"+exp.place+"-"+format(exp.startDate)+" to "+format(exp.finishDate)+" \n";
                    }
                    $scope.listEducation = education;
                    $scope.listExperience = experience;
                });
                
            }
            //var idArtist = $routeParams.id;
            $scope.param1 = idArtist;
            $scope.save = function () {
                if($scope.record !=="undifined")
                {
                    var resume =svc.save({
                    lastName: $scope.record.lastname,
                    city: $scope.record.city,
                    country: $scope.record.country,
                    website: $scope.record.website,
                    photo: $scope.record.photo
                });
                if(resume!=="undifined")
                {
                    alert("Debe ingresar como artista");
                    $location.url('/login');
                }else
                    $location.url('/catalog');
                }
                
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
                   if(exp.type==="Education")
                        $scope.listEducation += data.title +" - "+data.place+" - "+format(data.startDate)+" to "+format(data.finishDate)+" \n";
                    else
                        $scope.listExperience += data.title +" - "+data.place+" - "+format(data.startDate)+" to "+format(data.finishDate)+" \n";
                });
            };
            var monthNames = [
                "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October",
                "November", "December"
              ];
            format = function(data){
                var date = new Date(data);
                var day = date.getDate();
                var monthIndex = date.getMonth();
                var year = date.getFullYear();
                return day + ' ' + monthNames[monthIndex] + ' ' + year;
            }
            
            if(idArtist !== "" || typeof idArtist !== "undefined"){
                svc.getResume(idArtist).then(function (result) {
                    $scope.prueba = result;
                    $scope.record = [];
                    $scope.record = result;
                });
            }
            
        }]);
})(window.angular);
