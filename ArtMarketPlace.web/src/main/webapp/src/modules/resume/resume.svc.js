(function (ng) {
    var mod = ng.module('resumeModule');
    mod.service('resumeService', ['CrudCreator', 'resumeContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.save = function (resume) {
                var self = this;
                self.saveRecord(resume);
            };
            this.searchArtistsBetweenRatings = function (artistMinRating, artistMaxRating) {
                return this.api.one("searchArtistsBetweenRatings/" + artistMinRating + "/" + artistMaxRating).get();
            };
            this.searchArtistByName = function (searchName) {
                return this.api.one("searchArtistByName/" + searchName).get();
            };
            this.getResume = function (id) {
                return this.api.one(id).get();
            };
            this.addExperience = function (data)
            {
                return this.api.one("experience/").customPOST(data);
            };
            this.getArtist = function ()
            {
                return this.api.one("artist/").get();
            };
            this.rateArtist = function (data) {
                this.api.one(data['id'] + "/rate/" + data['rate']).customPOST();
            };
            this.saveExhibition = function (data)
            {
                return this.api.one("exhibition/").customPOST(data);
            };
        }]);
})(window.angular);
