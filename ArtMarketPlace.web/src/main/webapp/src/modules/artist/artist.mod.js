(function (ng) {
    var mod = ng.module('artistModule', ['ngCrud']);

    mod.constant('artistContext', 'artists');

    mod.constant('artistModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'userId',
                displayName: 'UserId',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'artwork',
                displayName: 'Artwork',
                //template: '', //override generic template
                ctrl: 'artworkCtrl'            }        ]});
})(window.angular);
