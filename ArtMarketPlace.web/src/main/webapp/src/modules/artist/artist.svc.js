(function(ng){
    var mod = ng.module('artistModule');
    
    mod.service('artistService', ['CrudCreator','artistContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
