(function (ng) {
    var mod = ng.module('artworkGaleryItemModule');

    mod.service('artworkGaleryItemService', ['CrudCreator','artworkGaleryItemContext', function(CRUDBase, context){
            CRUDBase.extendService(this, context);
    }]);
})(window.angular);
