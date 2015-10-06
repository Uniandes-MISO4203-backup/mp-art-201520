(function (ng) {
    var mod = ng.module('artistModule', ['ngCrud']);

    mod.constant('artistContext', 'artists');

    mod.constant('artistModel', {
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
                required: true}],
        childs: [{
                name: 'artwork',
                displayName: 'Artwork',
                //template: '', //override generic template
                ctrl: 'artworksCtrl'}]
    });
})(window.angular);
