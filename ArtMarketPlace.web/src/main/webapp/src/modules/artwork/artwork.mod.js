(function (ng) {
    var mod = ng.module('artworkModule', ['ngCrud']);

    mod.constant('artworkContext', 'artworks');

    mod.constant('artworkModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'picture',
                displayName: 'Picture',
                type: 'String',
                required: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true
            }]});
})(window.angular);
