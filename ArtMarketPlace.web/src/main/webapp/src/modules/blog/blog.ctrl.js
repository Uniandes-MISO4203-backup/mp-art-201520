(function (ng) {
    var mod = ng.module('blogModule');
    mod.controller('blogCtrl', ['CrudCreator', '$scope', '$location', 'blogService', 'newEntryService', 'authService', '$routeParams', 
        function (CrudCreator, $scope, $location, svcEntrys, svcNewEntry, authSvc, $routeParams){
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
            svcEntrys.allEntrys(idArtist).then(function (data){
                 var txt = "";
                 if(data.length !== 0){
                    for(var i = 0; i < data.length; i++){
                       txt += "<div class = 'panel panel-primary'><div class='panel-heading'><h4>"+(data[i].title)+"</h4></div><div class='panel-body'>"+(data[i].entry)+"</div></div>";
                    }
                }
                else
                {
                    txt = "<div class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span><span class='sr-only'>Error:</span> No existe ninguna entrada en el Blog</div>";
                }
                $("#entrys").html(txt);
            });
            //Guadar la entrada del Blog...
            $("#formEntry").submit(function(){
               if (authSvc.getCurrentUser()){
                    if ($("#title").val().length !== 0){
                        svcNewEntry.saveEntry({
                            entry: $("#entry").val(),
                            title: $("#title").val(),
                            client_id: authSvc.getCurrentUser().id,
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
        }]);
})(window.angular);
