(function (ng) {
    var mod = ng.module('experienceModule', ['ngCrud']);

    mod.constant('experienceContext', 'experience');

    mod.constant('experienceModel', {
        fields: [{
                name: 'title',
                displayName: 'Title',
                type: 'String',
                required: true
            }, {
                name: 'place',
                displayName: 'Place',
                type: 'String',
                required: true
            }, {
                name: 'type',
                displayName: 'Type',
                type: 'String',
                required: true
            }, {
                name: 'startDate',
                displayName: 'Start Date',
                type: 'Integer',
                required: true
            }, {
                name: 'finishDate',
                displayName: 'Finish Date',
                type: 'Integer',
                required: true
            }]
        
    });
})(window.angular);


