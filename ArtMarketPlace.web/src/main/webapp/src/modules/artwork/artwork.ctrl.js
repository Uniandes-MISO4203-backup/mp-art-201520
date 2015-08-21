(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('artworkCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'artwork', 'Artwork');

            this.searchByName = function (artworkName) {
                var search;
                if (artworkName) {
                    search = '?q=' + artworkName;
                }
                $location.url('/artwork' + search);
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