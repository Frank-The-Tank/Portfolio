% Frank Garcia
% 10/14/16
% Assignment 11

% Exercise 4.1
/*
query4.1(a), families without children
family(person(_,Surname,_,_),_,[]).

query4.1(b), all employed children
child(person(Name, Surname, _, works(_,_))).

query4.1(c), employed wives and unemployed husbands
family(person(_, Surname, _, unemployed),person(_, Surname, _, works(_,_)),_).

query4.1(d), children whose parents differ in age by at least 15 years
family(person(_,_,date(_,_,_H1),_),person(_,_,date(_,_,_W1), _),AllChildren),(_H1 - _W1 >= 15; _W1 - _H1 >=15).

*/

% Exercise 4.2
twins(Child1, Child2) :-
  family(_,_,Children),
  del(Child1, Children, Temp),
  member(Child2, Temp),
  dateofbirth(Child1, DB),
  dateofbirth(Child2, DB).

% Exercise 4.3
nth_member(1, [X|_], X).
nth_member(N, [_|L], X) :-
  N1 is N - 1,
  nth_member(N1, L, X).


% Exercise Nondeterministic FSM
final(sm).

trans(si, plus, sf).
trans(si, minus, sf).
trans(sf, digit, sm).
trans(sm, digit, sm).

silent(si, sf).

% Finite state machine with backtracking
accepts( State, []) :-
   final( State).

accepts( State, [X|Rest]) :-
   trans( State, X, State1),
   accepts( State1, Rest).

accepts( State, Rest) :-
   silent( State, State1),
   accepts( State1, Rest).

% Figure 4.1
family(
   person( tom, fox, date( 7, may, 1960), works( bbc, 15200)),
   person( ann, fox, date( 9, may, 1961), unemployed),
   [person( pat, fox, date( 5, may, 1983), unemployed),
   person( jim, fox, date( 5, may, 1983), unemployed) ] ).

% Families without children
family(
   person( george, childless, date( 8, june, 1961), works( macys, 19000)),
   person( lynn, childless, date( 10, july, 1962), unemployed),
   [] ).

family(
   person( peter, nokids, date( 9, august, 1961), unemployed),
   person( sally, nokids, date( 11, september, 1977), works( macys, 18500)),
   [] ).

% Families with employed children,
family(
   person( henry, stern, date( 7, may, 1960), unemployed),
   person( beth, stern, date( 9, may, 1961), works( microsoft, 15200)),
   [person( joe, stern, date( 6, june, 1985), works( mcdonalds, 9000)),
   person( jeff, stern, date( 4, july, 1986), works( arbys, 10000)) ] ).

% this one with twins
family(
   person( john, workman, date( 10, june, 1959), works( apple, 40900)),
   person( beth, workman, date( 23, july, 1976), works( google, 35000)),
   [person( david, workman, date( 15, january, 1983), works( acme, 9700)),
   person( don, workman, date( 20, february, 1986), works( homedepot, 10100)),
   person( doug, workman, date( 20, february, 1986), works( taco_bell, 8500)) ] ).

% X is a husband
husband( X) :-
   family( X, _, _).

% X is a wife
wife( X) :-
   family( _, X, _).

% X is a child
child( X) :-
   family( _, _, Children),
   member( X, Children).

% Any person in the database
exists( Person) :-
   husband( Person)
   ;
   wife( Person)
   ;
   child( Person).

% Birthdate
dateofbirth( person( _, _, Date, _), Date).

% Salary of working person
salary( person( _, _, _, works( _, S) ), S).

% Salary of unemployed
salary( person( _, _, _, unemployed), 0).

% total( List_of_people, Sum_of_their_salaries)
total( [], 0).
total( [Person|List], Sum) :-
   salary( Person, S),
   total( List, Rest),
   Sum is S + Rest.

% del( X, L, L1)
% L1 is L with element X deleted
% A base case fact and a recursive rule

del( X, [X|Tail], Tail).
del( X, [Y|Tail], [Y|Tail1]) :-
  del( X, Tail, Tail1).
