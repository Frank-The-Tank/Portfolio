% Frank Garcia
% Assignment 12
% 10/17/16


% conc( L1, L2, L3)
% L3 is the concatenation of L1 and L2.

conc( [], L, L).
conc( [X|L1], L2, [X|L3]) :-
   conc( L1, L2, L3).

% MY WORK

% 3.11
my_flatten([X|List], FlatList) :-
  my_flatten(X, FlatX1),
  my_flatten(List, FlatList1),
  conc(FlatX1, FlatList1, FlatList), !.
my_flatten([],[]).
my_flatten(X,[X]).

% 5.2
class(Number,positive) :-
  Number > 0, !.

class(Number,negative) :-
  Number < 0, !.

class(0,zero).

% 5.5
set_difference([], _, []).

set_difference([X|Set1],Set2,SetDifference) :-
  member(X, Set2), !,
  set_difference(Set1,Set2,SetDifference).

set_difference([X|Set1],Set2,[X|SetDifference]) :-
  set_difference(Set1,Set2,SetDifference).

% 5.6
unifiable([], Term, []).

unifiable([X|List1], Term, List2) :-
  \+ X = Term, !,
  unifiable(List1,Term,List2).

unifiable([X|List1], Term, [X|List2]) :-
  unifiable(List1,Term,List2).
