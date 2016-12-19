System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var AddUserValidators;
    return {
        setters:[],
        execute: function() {
            AddUserValidators = (function () {
                function AddUserValidators() {
                }
                AddUserValidators.nonValidEmail = function (control) {
                    var EMAIL_REGEXP = /^[a-z0-9!#$%&'*+\/=?^_`{|}~.-]+@[a-z0-9]([a-z0-9-]*[a-z0-9])?(\.[a-z0-9]([a-z0-9-]*[a-z0-9])?)*$/i;
                    if (!EMAIL_REGEXP.test(control.value)) {
                        return { nonValidEmail: true };
                    }
                    return null;
                };
                return AddUserValidators;
            }());
            exports_1("AddUserValidators", AddUserValidators);
        }
    }
});
//# sourceMappingURL=addUserValidators.js.map