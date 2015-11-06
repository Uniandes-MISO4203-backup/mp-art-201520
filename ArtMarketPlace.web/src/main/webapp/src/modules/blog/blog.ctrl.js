(function (ng) {
    var mod = ng.module('blogModule');
    mod.controller('blogCtrl', ['$scope', '$location', 'blogService',
        'newEntryService', 'viewEntryService', 'authService', '$routeParams',
        function ($scope, $location, svcEntrys, svcNewEntry, svcViewEntry, authSvc, $routeParams){
            var idArtist = $routeParams.id || authSvc.getCurrentUser().id;
            $("#save-entry").hide();
            if (authSvc.getCurrentUser()){
                svcEntrys.darRole().then(function(data){
                    if(data.role === "Artist"){
                        $("#save-entry").show();
                        $("#titleBlog").html(data.name);
                    }
                });
            }
            
            //var idArtist = $routeParams.id || authSvc.getCurrentUser().id;
            if($routeParams.idBlog)
            {
                //Traer la entrada...
                var idBlog = $routeParams.idBlog;
                svcViewEntry.showEntry(idBlog).then(function (data){
                    //console.log("UNO", data);
                    $("#title").html(data.title);
                    $("#entry").html(data.entry);
                    $("#label").html("Comentarios: "+ data.title);
                    commentBlog();
                });
                
                //Para guardar los comentarios de un blog..
                $("#formComment").submit(function(){
                    if (authSvc.getCurrentUser()){
                        if ($("#comment").val().length !== 0){
                            svcViewEntry.saveComment({
                                comment: $("#comment").val(),
                                blogId: idBlog,
                                clientId: authSvc.getCurrentUser().id
                            }).then(function () {
                                //$location.path('/blog');
                                //console.log(data);
                                swal({title: "Guardado!", text: "Comentario Guardado",  timer: 2000, type: "success"});
                            });
                        }
                        else
                        {
                            sweetAlert("Campos Vacíos", "Por favor escribe tu comentario", "error");
                        }
                    }
                    else
                    {
                        $location.path('/login');
                    }
                });
                
                //Para traer los comentarios que pertenecen a la entrada...
                var commentBlog = function ()
                {
                    svcViewEntry.showComment(idBlog).then(function (data){
                        console.log(data);
                    });
                };
            }
            else
            {
            svcEntrys.allEntrys(idArtist).then(function (data){
                 var txt = "";
                 //var entryBlog = "";
                 
                 console.log("DOS", data);
                 if(data.length !== 0){
                    for(var i = 0; i < data.length; i++){
                        //data[i].entry
                        //jQuery(html).text();
                        //style = 'white-space: nowrap; width: 20em; overflow: hidden; text-overflow:ellipsis;'
                       //entryBlog = "<div class='panel-body'>"+(data[i].entry)+"<hr>Ver todo</div>";
                       //entryBlog = "<div class='panel-body'>Ver entrada de Blog</div>";
                       //txt += "<div class = 'panel panel-primary'><div class='panel-heading'><h4>"+(data[i].title)+"</h4></div>"+(entryBlog)+"</div>";
                       txt += "<a href='#/viewentry/"+(data[i].id)+"' class='list-group-item'><h3 class='list-group-item-heading'>"+(data[i].title)+"</h3><p class='list-group-item-text'>Ingresar al artículo</p></a>";
                    }
                    txt = "<div class='list-group'>" + txt + "</div>";
                }
                else
                {
                    txt = "<div class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span><span class='sr-only'>Error:</span> No existe ninguna entrada en el Blog</div>";
                }
                $("#entrys").html(txt);
            });
        }
            //Guadar la entrada del Blog...
            $("#formEntry").submit(function(){
               if (authSvc.getCurrentUser()){
                    if ($("#title").val().length !== 0){
                        svcNewEntry.saveEntry({
                            entry: $("#entry").val(),
                            title: $("#title").val(),
                            clientId: authSvc.getCurrentUser().id,
                            date: new Date().toISOString().substring(0, 10)
                        }).then(function () {
                            $location.path('/blog');
                            swal({title: "Guardado!", text: "La entrada de tu blog se ha guardado correctamente",  timer: 2000, type: "success"});
                        });
                    }
                    else
                    {
                        sweetAlert("Campos Vacíos", "Por favor escribe tu entrada", "error");
                    }
                }
                else
                {
                    $location.path('/login');
                }
            });
            $scope.newEntry = function(){
                $location.url('/newentry');
            };
            $scope.cancel = function(){
                $location.url('/blog');
            };
            
            $scope.backBlog = function(){
                $location.url('/blog');
            };
        }]);
})(window.angular);
