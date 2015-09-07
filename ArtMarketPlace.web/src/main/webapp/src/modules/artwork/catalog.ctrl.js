(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', 'cartItemService', '$location', 'authService', '$http', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, $http) {
            CrudCreator.extendController(this, svc, $scope, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;

            this.searchByName = function (artworkName) {
                var search;
                if (artworkName) {
                    search = '?q=' + artworkName;
                }
                $location.url('/catalog' + search);
            };
            
            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (artwork) {
                        return cartItemSvc.addItem({
                            artwork: artwork,
                            name: artwork.name,
                            quantity: 1});
                    },
                    show: function () {
                        return true;
                    }
                }];

            this.fetchRecords();
            

            $http.get($location.absUrl().replace("#"+$location.path(),"")+'webresources/users/currentUser').success(function(data){
                    var elem = document.getElementById("divAdmin");     
                    if(data.role === "Admin"){
                        elem.innerHTML = "<ul class=\"nav navbar-nav navbar-left\"><li> <a href=\"#/client\">Clients</a> </li><li> <a href=\"#/artist\">Artists</a></li></ul>";
                    }else{
                        elem.innerHTML = "";
                }        

             });

        }]);
})(window.angular);