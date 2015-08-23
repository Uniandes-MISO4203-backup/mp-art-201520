(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('artworkCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'artwork', 'Artwork');
            this.asGallery = true;
            this.fetchRecords();
        }]);
})(window.angular);
