(function (ng) {
    var mod = ng.module('blogModule');
    mod.service('blogService', ['CrudCreator', 'blogContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            //Para saber el rol del usuario que está haciendo el proceso...
            this.darRole = function()
            {
                return this.api.one('../users/currentUser').get();   
            };
            
            //Trae todas las entradas del Blog dado el id del artista..
            this.allEntrys = function(idArtist){
                return this.api.one('../resume/entryartist', idArtist).get();
            };
        }]);
    
    //Para invocar el servcio de creación de una nueva entrada al Blog... 
    mod.service('newEntryService', ['CrudCreator', 'newEntryContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.saveEntry = function(data)
            {
                return this.api.one("../resume/newentry").customPOST(data);
            };
            
        }]);
})(window.angular);
