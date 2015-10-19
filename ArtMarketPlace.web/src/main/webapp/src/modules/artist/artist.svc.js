(function(ng){
    var mod = ng.module('artistModule');
    mod.service('artistService', ['CrudCreator','artistContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
                this.searchArtist = function(searchName){
                return this.api.one("searchArtist/"+ searchName).get();
            };
        }]);
})(window.angular);
