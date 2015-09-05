(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;

            this.searchByName = function (artworkName) {
                var search;
                if (artworkName) {
                    search = '?q=' + artworkName;
                }
                $location.url('/catalog' + search);
            };
            $scope.searchArtistWithCheapestArtwork = function (artworkName) {
                svc.searchArtistWithCheapestArtwork(artworkName).then(function (results) {
                    $scope.artworks = [];
                    $scope.artworks = results;
                });
            };

            $scope.searchCheapestArtworkOfAnArtist = function (artistName) {
                svc.searchCheapestArtworkOfAnArtist(artistName).then(function (results) {
                    $scope.artworks = [];
                    $scope.artworks = results;
                });
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (artwork) {
                        return cartItemSvc.addItem({
                            artwork: artwork,
                            name: artwork.name,
                            quantity: 1});
                    },
                    show: function () {
                        return true;
                    }
                }];

            this.fetchRecords();
        }]);
})(window.angular);