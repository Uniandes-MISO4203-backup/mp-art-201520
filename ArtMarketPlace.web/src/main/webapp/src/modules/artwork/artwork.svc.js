(function(ng){
    var mod = ng.module('artworkModule');
    
    mod.service('artworkService', ['CrudCreator','artworkContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
