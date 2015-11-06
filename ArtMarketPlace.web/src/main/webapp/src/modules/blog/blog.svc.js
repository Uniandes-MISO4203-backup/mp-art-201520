(function (ng) {
    var mod = ng.module('blogModule');
    mod.service('blogService', ['CrudCreator', 'blogContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            //Para saber el rol del usuario que está haciendo el proceso...
            this.darRole = function(){
                return this.api.one('../users/currentUser').get();
            };
            //Trae todas las entradas del Blog dado el id del artista..
            this.allEntrys = function(idArtist){
                return this.api.one('../resume/entryartist', idArtist).get();
            };
        }]);
    //Para invocar el servcio de creación de una nueva entrada al Blog.
    mod.service('newEntryService', ['CrudCreator', 'newEntryContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.saveEntry = function(data){
                return this.api.one("../resume/newentry").customPOST(data);
            };
        }]);
    //Para invocar el servcio de comentarios en un blog...
    mod.service('viewEntryService', ['CrudCreator', 'viewEntryContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            //Para mostrar sólo una entrada...
            this.showEntry = function(idBlog){
                return this.api.one('../resume/getentry', idBlog).get();
            };
            //Para guardar el comentario...
            this.saveComment = function(data){
                return this.api.one("../resume/newcomment").customPOST(data);
            };
            //Para mostrar los comentarios...
            this.showComment = function(idBlog){
                return this.api.one('../resume/getcomment', idBlog).get();
            };
        }]);
})(window.angular);
