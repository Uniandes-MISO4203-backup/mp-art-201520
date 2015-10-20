(function (ng) {
    var mod = ng.module('artworkGaleryItemModule', ['ngCrud']);

    mod.constant('artworkGaleryItemContext', 'artworkGaleryItems');

    mod.constant('artworkGaleryItemModel', {
        fields: [{
                name: 'type',
                displayName: 'Type',
                type: 'String',
                required: true
            },{
                name: 'link',
                displayName: 'Link',
                type: 'String',
                required: true
            }]});
})(window.angular);
