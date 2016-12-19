import {Component} from 'angular2/core';
import {ControlGroup, Validators, FormBuilder} from "angular2/common";
import {UsernameValidators} from './usernameValidators'

@Component({
    selector: 'signup-form',
    templateUrl: 'app/signup-form.component.html',
    styles: ['.form-group {margin: 15px;} .btn-primary {margin: 15px;}']
})
export class SignUpFormComponent {

    form: ControlGroup;

    constructor(fb: FormBuilder) {
        this.form = fb.group({
            username: ['', Validators.compose([Validators.required, UsernameValidators.cannotContainSpace]), UsernameValidators.shouldBeUnique],
            password: ['', Validators.compose([Validators.required, UsernameValidators.cannotContainSpace])]
        })
    }

    signup() {
        // authService.login
        this.form.find('username').setErrors({
            invalidLogin: true
        });

        console.log(this.form.value);
    }
}