import {Component} from 'angular2/core';
import {ControlGroup, Validators, FormBuilder} from 'angular2/common';
import {CanDeactivate, Router} from 'angular2/router';

import {AddUserValidators} from './addUserValidators';
import {UserService} from './users.service';
import {User} from './user';
import {HTTP_PROVIDERS} from "angular2/http";

@Component({
    templateUrl: 'app/addUser.component.html',
    styles: ['.custom-form{width: 50%;}'],
    providers: [UserService, HTTP_PROVIDERS]
})

export class AddUserComponent implements CanDeactivate {
    form: ControlGroup;
    user = new User();

    constructor(fb: FormBuilder, private _router: Router, private _userService: UserService) {
            this.form = fb.group({
                name: ['', Validators.compose([Validators.required])],
                email: ['', Validators .compose([AddUserValidators.nonValidEmail])],
                phone: [],
                address: fb.group({
                    street: [],
                    suite: [],
                    city: [],
                    zipcode: []
                })
            });
    }

    routerCanDeactivate(){
        if (this.form.dirty)
            return confirm('You have unsaved changes. Are you sure you want to navigate away?');

        return true;
    }

    save(){
        this._userService.addUser(this.form.value)
            .subscribe(x => {
                // Ideally, there we'd want: this.form.markAsPristine();
                this._router.navigate(['Users']);
            });
    }
}