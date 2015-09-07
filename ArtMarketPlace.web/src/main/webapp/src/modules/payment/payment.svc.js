(function (ng) {
    var mod = ng.module('paymentModule');
    mod.service('paymentService', ['CrudCreator', 'paymentContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.createItem = function (record) {
                var self = this;
                var nuevo = self.saveRecord(record);
                console.log(record);
                console.log(nuevo.getId());
                console.log(nuevo);
                console.log(Object);
            };
        }]);
})(window.angular);