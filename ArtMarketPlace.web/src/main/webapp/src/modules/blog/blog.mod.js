(function (ng) {
    var mod = ng.module('blogModule', ['ngCrud']);
    mod.constant('blogContext', 'listblog');
    mod.constant('newEntryContext', 'entry');
})(window.angular);