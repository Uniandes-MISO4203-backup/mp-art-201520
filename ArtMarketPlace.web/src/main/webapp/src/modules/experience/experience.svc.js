(function(ng){
    var mod = ng.module('experienceModule');
    mod.service('experienceService', ['CrudCreator','experienceContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);