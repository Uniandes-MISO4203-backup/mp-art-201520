(function (ng) {
    var mod = ng.module('blogModule');
    mod.controller('blogCtrl', ['CrudCreator', '$scope', '$location', 'blogService', 'newEntryService', 'authService', '$routeParams', 
        function (CrudCreator, $scope, $location, svcEntrys, svcNewEntry, authSvc, $routeParams)
        {
            var idArtist = $routeParams.id || authSvc.getCurrentUser().id;
            $("#save-entry").hide();
            if (authSvc.getCurrentUser())
            {
                svcEntrys.darRole().then(function(data)
                {
                    if(data.role === "Artist")
                    {
                        $("#save-entry").show();
                        $("#titleBlog").html(data.name);
                    }
                });
            }
          
            svcEntrys.allEntrys(idArtist).then(function (data)
            {
                 var txt = "";
                 if(data.length !== 0)
                 {
                    for(var i = 0; i < data.length; i++)
                    {
                       txt += "<div class = 'panel panel-primary'>" + 
                               "<div class='panel-heading'><h4>"+(data[i].title)+"</h4></div>" +
                               "<div class='panel-body'>"+(data[i].entry)+"</div>" + 
                              "</div>";
                    }
                }
                else
                {
                    txt = "<div class='alert alert-danger' role='alert'>" + 
                          "<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>" + 
                          "<span class='sr-only'>Error:</span> No existe ninguna entrada en el Blog</div>";
                }
                 $("#entrys").html(txt);
            });
           
            
            
            
           $("#formEntry").submit(function()
           {
               if (authSvc.getCurrentUser())
                {
                    if ($("#title").val().length !== 0)
                    {
                        svcNewEntry.saveEntry(
                        {
                            entry: $("#entry").val(),
                            title: $("#title").val(),
                            client_id: authSvc.getCurrentUser().id,
                            date: new Date().toISOString().substring(0, 10)
                        }).then(function (data) {
                            console.log("Llega", data);
                            $location.path('/blog');
                            swal({title: "Guardado!", text: "La entrada de tu blog se ha guardado correctamente",  timer: 2000, type: "success"});
                        });
                    }
                    else
                    {
                        sweetAlert("Campos Vacíos", "Por favor escribe tu entrada", "error");
                        //console.log("error campos");
                    }
                }
                else
                {
                    $location.path('/login');
                }
           }); 
            //Para traer las entradas de un blog...
            
            //Traer las entradas del artista...
            
            //CrudCreator.extendController(this, svc, $scope, model, 'blog', 'Blog');
            //'blogModel' model
            /*
            if (authSvc.getCurrentUser())
            {
                //var self = this;
                svc.darRole().then(function(data)
                {
                    if(data.role !== "Artist")
                    {
                        $location.path('/login');
                        //self.fetchRecords();
                        //console.log("Usuario válido")
                    }
                });
            }
            else
            {
                $location.path('/login');
            }
            */
           /*
            $scope.save = function ()
            {
                console.log("Ingresa acá");
                tmp2 = authSvc;
                //authSvc.getCurrentUser().id
                if($scope.record !=="undifined")
                {
                    
                    if(resume!=="undifined")
                    {
                        alert("Debe ingresar como artista");
                        $location.url('/login');
                    }
                    else
                    {
                        $location.url('/catalog');
                    }
                }  
            };
            */
           $scope.newEntry = function()
           {
                $location.url('/newentry');
           };
           
           $scope.cancel = function()
           {
                $location.url('/blog');
           };
        }]);
})(window.angular);
