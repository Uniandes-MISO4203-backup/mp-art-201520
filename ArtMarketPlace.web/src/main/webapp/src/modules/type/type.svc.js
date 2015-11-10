(function (ng) {
    var mod = ng.module('typeModule');

    mod.service('typeService', ['CrudCreator','typeContext', function(CRUDBase, context){
            CRUDBase.extendService(this, context);
    }]);
})(window.angular);
