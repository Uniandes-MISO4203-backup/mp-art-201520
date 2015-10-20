(function (ng) {
    var mod = ng.module('resumeModule');
    mod.service('resumeService', ['CrudCreator', 'resumeContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.save = function (resume) {
                var self = this;
                self.saveRecord(resume);
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
            this.rateArtist = function(data){
                this.api.one(data['id']+"/rate/"+data['rate']).customPOST();
            };
        }]);
})(window.angular);
