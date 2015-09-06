(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.service('cartItemService', ['CrudCreator', 'cartItemContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.addItem = function (record) {
                var self = this;
                var newId = 0;
                this.fetchRecords().then(function (data) {
                    for (var i = 0; i < data.length; i++) {
                        if (record.artwork.id === data[i].artwork.id) {
                            record = data[i];
                            record.quantity = data[i].quantity + 1;
                            break;
                        }
                    }
                    newId = self.saveRecord(record);
                });
                return newId;
            };
            this.payItem = function (record) {
                var self = this;
                record.state = 'P';
                self.saveRecord(record);
            };
        }]);
})(window.angular);
