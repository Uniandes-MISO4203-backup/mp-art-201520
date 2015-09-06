(function (ng) {
    var mod = ng.module('paymentModule');

    mod.controller('paymentViewCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel','paymentService','$location', 
                function (CrudCreator, $scope, svc, model,paymentSvc,$location) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'Payment');
            var self = this;
            $scope.paymentMethod = '1';
            $scope.cardNumber = '';
            $scope.readonly = false;

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
            this.calcTotal = function () {
                $scope.total = 0;
                for (var i = 0; i < $scope.records.length; i++) {
                    $scope.total += $scope.records[i].artwork.price * $scope.records[i].quantity;
                }
                $scope.taxes = $scope.total * 0.16;
                $scope.totalandtaxes = $scope.taxes + $scope.total;
            };
            $scope.endPayment = function(){
                if($scope.cardNumber === ''){
                    self.showWarning("Card Number is necessary.");
                }
                else{
                    paymentSvc.createItem({
                    method: $scope.paymentMethod,
                    subtotal: $scope.total,
                    taxes: $scope.taxes,
                    total: $scope.totalandtaxes,
                    cardNumber: $scope.cardNumber
                    });
                    $scope.paymentMethod = '1';
                    $scope.cardNumber = '';
                    $location.path('payf');
                }
            };
            $scope.reset = function() {
               $scope.paymentMethod = '1';
                $scope.cardNumber = '';
             };
        }]);
    
    mod.controller('paymentCtrl', ['CrudCreator', '$scope', 'paymentService', 'paymentModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'payment', 'Payment');
            this.fetchRecords();
        }]);
    
})(window.angular);
