(function (ng) {
    var mod = ng.module('resumeModule');

    mod.controller('resumeCtrl', ['CrudCreator', '$scope', '$location', 'resumeService',
        'resumeModel', '$routeParams',
        function (CrudCreator, $scope, $location, svc, model, $routeParams) {
            CrudCreator.extendController(this, svc, $scope, model, 'resume', 'Resume');
            var monthNames = [
                "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
            ];
            var format = function (data) {
                var date = new Date(data);
                var monthIndex = date.getMonth();
                return date.getDate() + ' ' + monthNames[monthIndex] + ' ' + date.getFullYear();
            };
            var idArtist;
            var education = "";
            var experience = "";
            function getArtistFunc() {
                svc.getArtist().then(function (result) {
                    $scope.record = [];
                    $scope.record = result;
                    experience = "";
                    education = "";
                    if ($scope.record) {
                        for (var i = 0; i < $scope.record.experience.length; i++) {
                            var exp = $scope.record.experience[i];
                            if (exp.type === "Education")
                                education += exp.title + "-" + exp.place + "-" + format(exp.startDate) + " to " + format(exp.finishDate) + " \n";
                            else
                                experience += exp.title + "-" + exp.place + "-" + format(exp.startDate) + " to " + format(exp.finishDate) + " \n";
                        }
                    }
                    $scope.listEducation = education;
                    $scope.listExperience = experience;
                });
            }
            if ($routeParams.id) {
                idArtist = $routeParams.id;
            } else {
                getArtistFunc();
            }
            $scope.param1 = idArtist;
            $scope.save = function () {
                if ($scope.record) {
                    var resume = svc.save({
                        lastName: $scope.record.lastname,
                        city: $scope.record.city,
                        country: $scope.record.country,
                        website: $scope.record.website,
                        photo: $scope.record.photo
                    });
                    if (resume) {
                        sweetAlert("Warning", "Please. Sign up like an artist.", "warning");
                        $location.url('/login');
                    } else
                        $location.url('/catalog');
                }
            };
            $scope.cancel = function () {
                $location.url('/catalog');
            };
            $scope.addExperience = function () {
                $('#experienceModal').modal('show');
            };
            $scope.saveExperience = function () {
                svc.addExperience($scope.experience).then(function (data) {
                    $('#experienceModal').modal('hide');
                    $scope.record.experience.push(data);
                    if (exp.type === "Education")
                        $scope.listEducation += data.title + " - " + data.place + " - " + format(data.startDate) + " to " + format(data.finishDate) + " \n";
                    else
                        $scope.listExperience += data.title + " - " + data.place + " - " + format(data.startDate) + " to " + format(data.finishDate) + " \n";
                });
            };
            $scope.addExhibition = function () {
                $('#exhibitionModal').modal('show');
            };
            $scope.saveExhibition= function () {
                svc.saveExhibition($scope.exhibition).then(function (){
                    swal("Sucess", "The exhibition was added successfully", "success");
                    $('#exhibitionModal').modal('hide');
                    location.reload();
                });
            };
            if (idArtist) {
                svc.getResume(idArtist).then(function (result) {
                    $scope.prueba = result;
                    $scope.record = [];
                    $scope.record = result;
                });
            }
            this.modalRating = [{
                    fn: function () {
                        $('#ratingModal').modal('show');
                        return false;
                    }
                }];
            this.saveRating = [{
                    fn: function () {
                        var rating = $('input:radio[name=rating]:checked').val();
                        var artist = $routeParams.id;
                        var data = {
                            id: artist,
                            rate: rating
                        };
                        svc.rateArtist(data);
                        swal("Sucess", "The artist was rated successfully", "success");
                        $('#ratingModal').modal('hide');
                    }
                }];
        }]);
})(window.angular);