(function (ng) {
    var mod = ng.module('resumeModule');

    mod.controller('resumeCtrl', ['CrudCreator', '$scope', '$location', 'resumeService', 'resumeModel', '$routeParams', function (CrudCreator, $scope, $location, svc, model, $routeParams,$route) {
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
            if (idArtist !== "") {
                svc.getResume(idArtist).then(function (result) {
                    $scope.prueba = result;
                    $scope.record = [];
                    $scope.record = result;
                });
            }

            this.modalRating = [
                {
                    fn: function ()
                    {
                        $('#ratingModal').modal('show');
                        return false;
                    }
                }];
            this.saveRating = [
                {
                    fn: function ()
                    {
                        var rating = $('input:radio[name=rating]:checked').val();
                        var artist = $routeParams.id;
                        var data = {
                            id: artist,
                            rate: rating
                        };
                        svc.rateArtist(data)
                        alert("Se realizado la calificacion.");
                        $('#ratingModal').modal('hide');
                        
                    }
                }];

        }]);
})(window.angular);
