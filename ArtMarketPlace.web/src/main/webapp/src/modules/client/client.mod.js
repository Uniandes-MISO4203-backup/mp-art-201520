(function (ng) {
    var mod = ng.module('clientModule', ['ngCrud']);

    mod.constant('clientContext', 'clients');

    mod.constant('clientModel', {
        fields: [{
                name: 'name',
                displayName: 'Username',
                type: 'String',
                required: true
            }, {
                name: 'firstName',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'lastname',
                displayName: 'LastName',
                type: 'String',
                required: true
            }, {
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true
            }],
        childs: [{
                name: 'cartItem',
                displayName: 'CartItem',
                //template: '', //override generic template
                ctrl: 'cartItemsCtrl'
            }]
    });
})(window.angular);
