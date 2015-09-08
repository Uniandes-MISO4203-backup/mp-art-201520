(function(ng){
    var mod = ng.module('artworkModule');
    
    mod.service('artworkService', ['CrudCreator','artworkContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.searchArtistWithCheapestArtwork = function(artworkName){
                return this.api.one("artistWithCheapestArtwork/"+ artworkName).get();
            };
            this.searchCheapestArtworkOfAnArtist = function(artistName){
                return this.api.one("cheapestArtworkOfAnArtist/"+ artistName).get();
            };
            this.postRemark = function(id, newRemark){
                return this.api.one("postRemark/"+ id + "/" + newRemark).get();
            };
    }]);
})(window.angular);
