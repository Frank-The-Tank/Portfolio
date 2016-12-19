import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';

import {NavbarComponent} from "./navbar.component";
import {HomeComponent} from "./home.component";
import {UsersComponent} from "./users.component";
import {PostsComponent} from "./posts.component";
import {AddUserComponent} from "./addUser.component";

@RouteConfig([
    {path: '/', name: 'Home', component: HomeComponent, useAsDefault: true},
    {path: '/users', name: 'Users', component: UsersComponent},
    {path: '/posts', name: 'Posts', component: PostsComponent},
    {path: '/addUser', name: 'AddUser', component: AddUserComponent},
    {path: '*other', name: 'Other', redirectTo: ['Home']}
])

@Component({
    selector: 'final-project',
    template: `
        <navbar></navbar>
        <div class="container">
            <router-outlet></router-outlet>
        </div>
    `,
    styles: ['.container {height: 100%; width: 100%;}'],
    directives: [NavbarComponent, ROUTER_DIRECTIVES]
})
export class AppComponent {}