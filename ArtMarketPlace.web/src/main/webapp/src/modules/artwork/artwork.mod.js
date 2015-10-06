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
                type: 'Image',
                required: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Currency',
                required: true
            }, {
                name: 'artist',
                displayName: 'Artist',
                type: 'Reference',
                required: true
            }, {
                name: 'discount',
                displayName: 'Special Discount',
                type: 'Integer',
                required: false}]
    });
})(window.angular);
