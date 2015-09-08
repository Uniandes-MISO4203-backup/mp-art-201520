(function (ng) {
    var mod = ng.module('paymentModule');
    mod.service('paymentService', ['CrudCreator', 'paymentContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.createItem = function (record) {
                var self = this;
                self.saveRecord(record);
            };
        }]);
})(window.angular);