(function (ng) {
    var mod = ng.module('wishListModule');

    mod.service('wishListService', ['CrudCreator', 'wishListContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.addItem = function (record) {
                var self = this;
                var newId = 0;
                newId = self.saveRecord(record);
                return newId;
            };
        }]);
})(window.angular);