(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'Shopping Cart');
            var self = this;

            var oldFetch = this.fetchRecords;
            this.fetchRecords = function () {
                return oldFetch.call(this).then(function (data) {
                    self.calcTotal();
                    return data;
                });
            };
            this.fetchRecords();
            this.readOnly = true;
            $scope.lastQuantity = 0;
            $scope.total = 0;
            $scope.taxes = 0;

            this.recordActions = {
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

            this.calcTotal = function () {
                $scope.total = 0;
                for (var i = 0; i < $scope.records.length; i++) {
                    if($scope.records[i].artwork.discount)
                    {
                        $scope.total += (1-$scope.records[i].artwork.discount/100)*$scope.records[i].artwork.price * $scope.records[i].quantity;
                    }else{
                        $scope.total += $scope.records[i].artwork.price * $scope.records[i].quantity;
                    }
                }
                $scope.taxes = $scope.total * 0.16;
            };

            //guarda la cantidad anterior
            $scope.verify = function (quantity) {
                $scope.lastQuantity = quantity;
            };

            $scope.postVerify = function (record) {
                var patron = /^\d*$/; //^[0-9]{3}$
                if (patron.test(record.quantity) && record.quantity > 0) {
                    self.calcTotal();
                } else {
                    self.showError("You must enter a valid quantity");
                    record.quantity = $scope.lastQuantity;
                    $scope.currentRecord = record;
                }
            };
            
            //Realiza la validacion de la nueva cantidad asignada.
            $scope.checkout = function () {
                self.showWarning("Not implemented yet");
            };
            
            $scope.subtotal = function (record) {
                if(record.artwork.discount)
                {
                    return (1-record.artwork.discount/100)*record.artwork.price * record.quantity;
                }else{
                    return record.artwork.price * record.quantity;
                }
            };
        }]);
})(window.angular);
