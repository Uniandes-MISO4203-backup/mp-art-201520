(function (ng) {
    var mod = ng.module('paymentModule', ['ngCrud']);

    mod.constant('paymentContext', 'payments');

    mod.constant('paymentModel', {
        fields: [{
                name: 'method',
                displayName: 'Method',
                type: 'String',
                required: true
            }, {
                name: 'subtotal',
                displayName: 'Subtotal',
                type: 'Integer',
                required: true
            }, {
                name: 'taxes',
                displayName: 'Taxes',
                type: 'Integer',
                required: true
            }, {
                name: 'total',
                displayName: 'Total',
                type: 'Integer',
                required: true
            }, {
                name: 'reference',
                displayName: 'Reference',
                type: 'String',
                required: true
            }, {
                name: 'client',
                displayName: 'Client',
                type: 'Reference',
                required: true
            }]
    });
})(window.angular);
