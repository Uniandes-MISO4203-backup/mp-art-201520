(function (ng) {
    var mod = ng.module('typeModule', ['ngCrud']);

    mod.constant('typeContext', 'types');

    mod.constant('typeModel', {
        fields: [{
                name: 'name',
                displayName: 'name',
                type: 'String',
                required: true
            }]});
})(window.angular);
