% Frank Garcia
% OCTOBER 24, 2016
% Assignment 14

conc( [], L, L).
conc( [X|L1], L2, [X|L3]) :-
   conc( L1, L2, L3).


% Exercise 6.11
% see('myfile.pl'), findallterms(Term), seen.

findallterms(Term) :-
  read(CurrentTerm),
  process(CurrentTerm,Term).

process(end_of_file, _) :- !.

process(CurrentTerm, Term) :-
  \+(CurrentTerm = Term), !
  ;
  write(CurrentTerm), nl,
  findallterms(Term).

% 6.13
starts(Atom, Character) :-
  name(Atom, [Character|_]).

% 6.14
plural(Word, Plural) :-
  name(Word, A),
  name(s, B),
  conc(A, B, C),
  name(Plural, C).
