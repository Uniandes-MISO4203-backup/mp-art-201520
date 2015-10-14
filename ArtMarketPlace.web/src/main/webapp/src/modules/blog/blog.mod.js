(function (ng) {
    var mod = ng.module('blogModule', ['ngCrud']);
    //debugger;
    mod.constant('blogContext', 'listblog');
    mod.constant('newEntryContext', 'entry');
    /*
    
    mod.constant('shippingContext', 'ship');
    mod.constant('creditCardContext', 'payment_method');
    */
    /*mod.constant('blogModel', {
        fields: [{
                name: 'title',
                displayName: 'Title',
                type: 'String',
                required: true
            }, {
                name: 'entry',
                displayName: 'entry',
                type: 'String',
                required: true
            }]});
            */
})(window.angular);
