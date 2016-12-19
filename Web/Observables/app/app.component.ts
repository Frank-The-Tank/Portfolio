import {Component} from 'angular2/core';
import {ControlGroup, FormBuilder} from 'angular2/common';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';

@Component({
    selector: 'my-app',
    template: `
        <form [ngFormModel]="form">
            <input type="text" ngControl="search">
        </form>
        `
})
export class AppComponent {

    form: ControlGroup;

    constructor(fb: FormBuilder) {
        this.form = fb.group({
            search: [],
            time: []
        });

        // var search = this.form.find('search');
        // search.valueChanges
        //     .debounceTime(400)
        //     .map(str => (<string>str).replace(' ', '-'))
        //     .subscribe(x => console.log(x));
        //
        // var startDates = [];
        // var startDate = new Date();
        //
        // for (var day = -2; day <= 2; day++) {
        //     var date = new Date(
        //         startDate.getFullYear(),
        //         startDate.getMonth(),
        //         startDate.getDate() + day);
        //     startDates.push(date);
        // }
        //
        // Observable
        //     .fromArray(startDates)
        //     .map(date => {
        //         console.log("Getting deals for date " + date);
        //         return [1, 2, 3];
        //     })
        //     .subscribe(x =>	console.log(x));
        //
        // var observable = Observable.interval(1000);
        // observable
        //     .flatMap(x => {
        //         console.log("calling the server to get the latest news");
        //         return [1, 2, 3];
        //     })
        //     .subscribe(news => console.log(news));
        //
        // var userStream = Observable.of({
        //     userId: 1,
        //     username: 'mosh'
        // }).delay(2000);
        //
        // var tweetsStream = Observable.of([1, 2, 3]).delay(1500);
        //
        // Observable
        //     .forkJoin(userStream, tweetsStream)
        //     .map(joined =>
        //         new Object({user: joined[0], tweets: joined[1]}))
        //     .subscribe(result => console.log(result));




        // var observable = Observable.throw(new Error("Something failed."));
        //
        // observable.subscribe(
        //       x => console.log(x),
        //       error => console.error(error)
        // );
        //
        // observable.retry(3)
    }


}