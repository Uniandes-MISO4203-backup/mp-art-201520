(function (ng) {
    var mod = ng.module('wishListModule');

    mod.controller('wishListCtrl', ['CrudCreator', '$scope', 'wishListService', 'cartItemService', 'wishListModel', function (CrudCreator, $scope, svc, cartItemSvc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'wishList', 'WishList');
            var self = this;
            self.fetchRecords();
            this.recordActions = {
                addToCart: {
                    displayName: 'Add to cart',
                    icon: 'check',
                    class: 'primary',
                    fn: function (record) {
                        cartItemSvc.addItem({
                            artwork: record.artwork,
                            name: record.artwork.name,
                            quantity: 1
                        });
                        svc.deleteRecord(record).then(function () {
                            self.fetchRecords();
                        });
                    },
                    show: function () {
                        return true;
                    }
                },
                delete: {
                    displayName: ' ',
                    icon: 'trash',
                    class: 'primary',
                    fn: function (record) {
                        svc.deleteRecord(record).then(function () {
                            self.fetchRecords();
                        });
                    },
                    show: function () {
                        return true;
                    }
                }};
        }]);
})(window.angular);
