(function (ng) {
    var mod = ng.module('artworkModule');

    mod.service('artworkService', ['CrudCreator', 'artworkContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.searchArtworksBetweenPrices = function (artworkMinPrice, artworkMaxPrice) {
                return this.api.one("artworksBetweenPrices/" + artworkMinPrice + "/" + artworkMaxPrice).get();
            };
            this.searchArtistWithCheapestArtwork = function (artworkName) {
                return this.api.one("artistWithCheapestArtwork/" + artworkName).get();
            };
            this.searchCheapestArtworkOfAnArtist = function (artistName) {
                return this.api.one("cheapestArtworkOfAnArtist/" + artistName).get();
            };
            this.searchArtworksOfAnArtist = function (artistId) {
                return this.api.one("searchArtworksOfAnArtist/" + artistId).get();
            };
            this.searchArtworksByStyle = function (artworkStyle) {
                return this.api.one("searchArtworksByStyle/" + artworkStyle).get();
            };
            this.saveQuestion = function (data)
            {
                return this.api.one("questions/").customPOST(data).then(function ()
                {
                    //console.log("La pregunta fue exitosamente guardada");
                });
            };
            this.postRemark = function (id, newRemark) {
                return this.api.one("postRemark/" + id + "/" + newRemark).get();
            };

            this.rateArtwork = function (data) {
                this.api.one(data['id'] + "/rate/" + data['rate']).customPOST().then(function ()
                {
//                    console.log("El rating fue exitosamente guardada");
                });
            };
        }]);
})(window.angular);
