(function (ng) {
    var mod = ng.module('resumeModule', ['ngCrud']);

    mod.constant('resumeContext', 'resume');

    mod.constant('resumeModel', {
        fields: [{
                name: 'lastname',
                displayName: 'Last Name',
                type: 'String',
                required: true
            }, {
                name: 'city',
                displayName: 'City',
                type: 'String',
                required: true
            }, {
                name: 'country',
                displayName: 'Country',
                type: 'String',
                required: true
            }, {
                name: 'website',
                displayName: 'Website',
                type: 'String',
                required: true
            }, {
                name: 'photo',
                displayName: 'Photo',
                type: 'Image',
                required: false
            }, {
                name: 'ratingSum',
                displayName: 'ratingSum',
                type: 'Number',
                required: false
            }, {
                name: 'ratingVotes',
                displayName: 'ratingVotes',
                type: 'Number',
                required: false
            }, {
                name: 'artist',
                displayName: 'Artist',
                type: 'Reference',
                required: false
            }]
    });
})(window.angular);
