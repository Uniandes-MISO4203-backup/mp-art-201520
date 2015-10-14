(function (ng) {
    //debugger;
    var mod = ng.module('blogModule');
    console.log("Ingresa");
    mod.controller('blogCtrl', ['CrudCreator', '$scope', '$location', 'blogService', 'newEntryService', 'authService', '$routeParams', 
        function (CrudCreator, $scope, $location, svcEntrys, svcNewEntry, authSvc, $routeParams)
        {
            console.log("Llega el valor", $routeParams.id);
            svcEntrys.allEntrys(1).then(function (data) {
                 console.log(data);
                 tmp3 = data;
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
        }]);
})(window.angular);
