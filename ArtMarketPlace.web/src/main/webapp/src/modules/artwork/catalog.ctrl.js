(function (ng) {
    var mod = ng.module('artworkModule');

    mod.controller('catalogCtrl', ['CrudCreator', '$scope', 'artworkService', 'artworkModel', 'cartItemService', '$location', 'authService', 'artworkService', '$http'  , function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, artworkSvc,$http) {
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
             $scope.searchArtworksBetweenPrices = function (artworkMinPrice,artworkMaxPrice) {
                svc.searchArtworksBetweenPrices(artworkMinPrice,artworkMaxPrice).then(function (results) {
                    $scope.artworks = [];
                    $scope.artworks = results;
                });
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
            
            $scope.postRemark = function (id, newRemark) {
                artworkSvc.postRemark(id, newRemark).then(function (result) {
                    $scope.artworkRecord = [];
                    $scope.artworkRecord = result;
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
                },
                makeQuestion: {
                    name: 'question',
                    displayName: 'Question',
                    icon: 'question-sign',
                    class: 'info',
                    fn: function (record)
                    {
                        if (authSvc.getCurrentUser())
                        {
                            artworkSvc.api.get(record.id).then(function (data) {
                                $('#questionModal').modal('show');
                                $('#userQuestion').html("<b>User</b>: " + authSvc.getCurrentUser().name + "<br>");
                                $('#artworkRef').html("<b>Reference</b>: <label id=artRef>" + data.id + "</label><br>");
                                $('#artworkName').html("<b>Artwork's name</b>: " + data.name + "<br>");
                                $("#question").val("Escriba aquí su pregunta");
                            });
                        }
                        else
                        {
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
                }
            };

            this.saveQuestion = [
                {
                    fn: function ()
                    {
                        if (authSvc.getCurrentUser())
                        {
                            if ($("#question").val().length !== 0)
                            {
                                var artRef = $("#artRef").val();
                                console.log("Referencia de arte: " + artRef)
                                artworkSvc.api.get(artRef).then(function (data) {
                                    var question = {
                                        client: authSvc.getCurrentUser(),
                                        artwork: data,
                                        artistEmail: data.artist.name,
                                        question: $("#question").val()
                                    }
                                    console.log(question);
                                    svc.saveQuestion(question).then(function ()
                                    {
                                        alert("La pregunta ha sido enviada satisfactoriamente");
                                        $('#questionModal').modal('hide');
                                    });
                                });
                            }
                            else
                            {
                                alert("Advertencia: Por favor, escriba su pregunta.");
                            }
                        }
                        else
                        {
                            $location.path('/login');
                        }
                    }
                }];
            this.fetchRecords();
            
            $http.get($location.absUrl().replace("#"+$location.path(),"")+'webresources/users/currentUser').success(function(data){
                    var elem = document.getElementById("divAdmin");     
                    if(data.role === "Admin"){
                        elem.innerHTML = "<ul class=\"nav navbar-nav navbar-left\"><li> <a href=\"#/client\">Clients</a> </li><li> <a href=\"#/artist\">Artists</a></li></ul>";
                    }
                    else if(data.role === "Artist"){
                        elem.innerHTML = "<ul class=\"nav navbar-nav navbar-left\"><li class=\"active\"> <a href=\"#/artwork\"><span class=\"glyphicon glyphicon-cog\" ></span>Manage Artoworks</a> </li><li class=\"active\"> <a href=\"#/resume\"><span class=\"glyphicon glyphicon-cog\" ></span>Resume</a> </li></ul>";
                    }else{
                        elem.innerHTML = "";
                }        

             });
        }]);
})(window.angular);
