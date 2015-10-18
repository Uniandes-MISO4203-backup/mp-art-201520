(function (ng) {
    //debugger;
    var mod = ng.module('blogModule');
    mod.service('blogService', ['CrudCreator', 'blogContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            //Para saber el rol del usuario que está haciendo el proceso...
            this.darRole = function()
            {
                return this.api.one('../users/currentUser').get();   
            };
            
            this.allEntrys = function(idArtist){
                //console.log("Llega a la funcion");
                return this.api.one('../resume/entryartist', idArtist).get();
            };
        }]);
    mod.service('newEntryService', ['CrudCreator', 'newEntryContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.saveEntry = function(data)
            {
                return this.api.one("../resume/newentry").customPOST(data);
                        /*.then(function(data) 
                {
                    console.log("Success", data);
                });*/
            };
            
            //Para saber el rol del usuario que está haciendo el proceso...
            /*this.darRole = function()
            {
                return this.api.one('../../users/currentUser').get();   
            };
            
            this.allEntrys = function(idArtist){
                console.log("Llega a la funcion");
                return this.api.one('../resume/entryartist', idArtist).get();
            };*/
            //console.log("Otro servicio...");
        }]);
    /*
    mod.service('checkoutService', ['CrudCreator', 'checkoutContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);

        }]);
    mod.service('shippingService', ['CrudCreator', 'shippingContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('creditCardService', ['CrudCreator', 'creditCardContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('userService', ['CrudCreator', 'userContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    */
})(window.angular);
