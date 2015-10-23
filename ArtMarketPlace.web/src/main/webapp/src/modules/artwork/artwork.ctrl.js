(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('artworkCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'artwork', 'Artwork');
            this.asGallery = true;
            this.fetchRecords();
        }]);
    mod.controller('artworkGaleryItemsCtrl', ['CrudCreator', '$scope', 'artworkGaleryItemModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'artworkGaleryItems', 'artwork');
            this.loadRefOptions();
        }]);
})(window.angular);
