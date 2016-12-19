% Frank Garcia
% Assignment 6
% 10/20/16


% 6.3
my_ground(Term) :-
  nonvar(Term),
  Element =.. [_|E],
  my_ground_helper(Term).

my_ground_helper([]).

my_ground_helper([H|T]) :-
  my_ground(H),
  my_ground_helper(T).

% 6.7
my_copy_term(Term, Copy) :-
  asserta(blahblah(Term)),
  retract(blahblah(Copy)).

% 6.8
subsets_with_backtracking(_,[]).

subsets_with_backtracking([H|T], [HS|TS]) :-
  member(HS, [H|T]),
  subsets_with_backtracking(T, TS),
  \+ member(HS, TS).
