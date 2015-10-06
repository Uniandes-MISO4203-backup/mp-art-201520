(function (ng) {
    var mod = ng.module('questionModule', ['ngCrud']);

    mod.constant('questionContext', 'questions');

    mod.constant('questionModel', {
        fields: [{
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true
            }, {
                name: 'question',
                displayName: 'Question',
                type: 'String',
                required: true
            }]
    });
})(window.angular);


