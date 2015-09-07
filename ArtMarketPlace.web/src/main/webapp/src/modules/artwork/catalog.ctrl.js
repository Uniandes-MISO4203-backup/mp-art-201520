(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', 'cartItemService', '$location', 'authService', 'artworkService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, artworkSvc) {
    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', 'cartItemService', '$location', 'authService', '$http', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, $http) {
            CrudCreator.extendController(this, svc, $scope, model, 'catalog', 'Catalog');
            this.asGallery = true;
            this.readOnly = true;
            this.detailsMode = false;

            this.searchByName = function (artworkName) {
                var search;
                if (artworkName) {
                    search = '?q=' + artworkName;
                }
                $location.url('/catalog' + search);
            };
            $scope.searchArtistWithCheapestArtwork = function (artworkName) {
                svc.searchArtistWithCheapestArtwork(artworkName).then(function (results) {
                    $scope.artworks = [];
                    $scope.artworks = results;
                });
            };

            $scope.searchCheapestArtworkOfAnArtist = function (artistName) {
                svc.searchCheapestArtworkOfAnArtist(artistName).then(function (results) {
                    $scope.artworks = [];
                    $scope.artworks = results;
                });
            };

            var self = this;
            this.recordActions = {
                    addToCart: {
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
                    },
                    remarks: {
                        displayName: 'Remarks',
                        icon: 'list',
                        class: 'info',
                        fn: function (record) {
                            artworkSvc.api.get(record.id).then(function (data) {
                                self.detailsMode = true;
                                $scope.artworkRecord = data;
                            });
                        },
                        show: function () {
                            return !self.detailsMode;
                        }
                    }};

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
