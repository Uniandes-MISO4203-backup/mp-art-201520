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
                required: false
            }, {
                name: 'artworkStyle',
                displayName: 'Artwork Style',
                type: 'String',
                required: true
            }
            , {
                name: 'ratingSum',
                displayName: 'ratingSum',
                type: 'Number',
                required: false
            }
            , {
                name: 'ratingVotes',
                displayName: 'ratingVotes',
                type: 'Number',
                required: false
            }
        ],
        childs: [{
                name: 'artworkGaleryItems',
                displayName: 'Artwork Galery',
                type: 'Child',
                ctrl: 'artworkGaleryItemsCtrl'
            }]
    });
})(window.angular);
