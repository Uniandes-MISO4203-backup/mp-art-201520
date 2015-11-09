(function (ng) {
    var mod = ng.module('wishListModule', ['ngCrud']);

    mod.constant('wishListContext', 'wishList');

    mod.constant('wishListModel', {
        fields: [{
                name: 'artwork',
                displayName: 'Artwork',
                type: 'Reference',
                service: 'artworkService',
                options: [],
                required: true
            }]});
})(window.angular);
