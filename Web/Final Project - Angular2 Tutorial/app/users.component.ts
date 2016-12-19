import {Component, OnInit} from 'angular2/core';

import {RouterLink} from 'angular2/router';

import {UserService} from "./users.service";
import {HTTP_PROVIDERS} from 'angular2/http';

@Component({
    templateUrl: 'app/users.component.html',
    providers: [UserService, HTTP_PROVIDERS],
    directives: [RouterLink]
})

export class UsersComponent implements OnInit{
    users: any[];

    constructor(private _service: UserService) {}

    ngOnInit(){
        this._service.getUsers()
            .subscribe(users => this.users = users);
    }
}