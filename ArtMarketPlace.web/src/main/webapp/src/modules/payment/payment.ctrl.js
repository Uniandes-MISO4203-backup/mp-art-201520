(function (ng) {
    var mod = ng.module('paymentModule');

    mod.controller('paymentViewCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel', 'paymentService', '$location',
        function (CrudCreator, $scope, svc, model, paymentSvc, $location) {
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
                    if($scope.records[i].artwork.discount)
                    {
                        $scope.total += (1-$scope.records[i].artwork.discount/100)*$scope.records[i].artwork.price * $scope.records[i].quantity;
                    }else{
                        $scope.total += $scope.records[i].artwork.price * $scope.records[i].quantity;
                    }
                }
                $scope.taxes = $scope.total * 0.16;
                $scope.totalandtaxes = $scope.taxes + $scope.total;
            };
            $scope.endPayment = function () {
                var error = "";
                var valide = true;
                var re  = "";
                if($scope.paymentMethod === '1' || $scope.paymentMethod === '3'){
                    re = /^(?:4[0-9]{12}(?:[0-9]{3})?)/.exec($scope.cardNumber);
                    if(re === null){   
                        valide = false;
                        error = "Please insert a validad card number. Example: 4512345678912345";
                    }
                }
                if($scope.paymentMethod === '2' || $scope.paymentMethod === '4'){
                    re = /^5[1-5][0-9]{14}/.exec($scope.cardNumber);
                    if(re === null){   
                        valide = false;
                        error = "Please insert a validad card number. Example: 5156345678912345";
                    }
                }
                if($scope.paymentMethod === '5'){
                    re = /^3[47][0-9]{13}/.exec($scope.cardNumber);
                    if(re === null){   
                        valide = false;
                        error = "Please insert a validad card number.  Example: 341234567891234";
                    }
                }
                if(valide){
                    paymentSvc.createItem({
                        method: $scope.paymentMethod,
                        subtotal: $scope.total,
                        taxes: $scope.taxes,
                        total: $scope.totalandtaxes,
                        cardNumber: $scope.cardNumber
                    });
                    for (var i = 0; i < $scope.records.length; i++) {
                        svc.payItem($scope.records[i]);
                    }
                    $scope.paymentMethod = '1';
                    $scope.cardNumber = '';
                    $location.path('payf');
                }
                else{
                    $scope.cardNumber = '';
                    $scope.validationError = "error";
                    self.showError(error);
                }
            };
            $scope.reset = function () {
                $scope.paymentMethod = '1';
                $scope.cardNumber = '';
            };
        }]);

    mod.controller('paymentCtrl', ['CrudCreator', '$scope', 'paymentService', 'paymentModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'payment', 'Payment');
            this.fetchRecords();
        }]);

})(window.angular);
