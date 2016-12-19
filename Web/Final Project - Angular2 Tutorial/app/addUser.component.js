System.register(['angular2/core', 'angular2/common', 'angular2/router', './addUserValidators', './users.service', './user', "angular2/http"], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, common_1, router_1, addUserValidators_1, users_service_1, user_1, http_1;
    var AddUserComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (common_1_1) {
                common_1 = common_1_1;
            },
            function (router_1_1) {
                router_1 = router_1_1;
            },
            function (addUserValidators_1_1) {
                addUserValidators_1 = addUserValidators_1_1;
            },
            function (users_service_1_1) {
                users_service_1 = users_service_1_1;
            },
            function (user_1_1) {
                user_1 = user_1_1;
            },
            function (http_1_1) {
                http_1 = http_1_1;
            }],
        execute: function() {
            AddUserComponent = (function () {
                function AddUserComponent(fb, _router, _userService) {
                    this._router = _router;
                    this._userService = _userService;
                    this.user = new user_1.User();
                    this.form = fb.group({
                        name: ['', common_1.Validators.compose([common_1.Validators.required])],
                        email: ['', common_1.Validators.compose([addUserValidators_1.AddUserValidators.nonValidEmail])],
                        phone: [],
                        address: fb.group({
                            street: [],
                            suite: [],
                            city: [],
                            zipcode: []
                        })
                    });
                }
                AddUserComponent.prototype.routerCanDeactivate = function () {
                    if (this.form.dirty)
                        return confirm('You have unsaved changes. Are you sure you want to navigate away?');
                    return true;
                };
                AddUserComponent.prototype.save = function () {
                    var _this = this;
                    this._userService.addUser(this.form.value)
                        .subscribe(function (x) {
                        // Ideally, there we'd want: this.form.markAsPristine();
                        _this._router.navigate(['Users']);
                    });
                };
                AddUserComponent = __decorate([
                    core_1.Component({
                        templateUrl: 'app/addUser.component.html',
                        styles: ['.custom-form{width: 50%;}'],
                        providers: [users_service_1.UserService, http_1.HTTP_PROVIDERS]
                    }), 
                    __metadata('design:paramtypes', [common_1.FormBuilder, router_1.Router, users_service_1.UserService])
                ], AddUserComponent);
                return AddUserComponent;
            }());
            exports_1("AddUserComponent", AddUserComponent);
        }
    }
});
//# sourceMappingURL=addUser.component.js.map