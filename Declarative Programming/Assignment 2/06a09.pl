% Frank Garcia
% Assignment 9
% 10/6/16

% third_element( L, X)
% X is the third element of list L

third_element([_,_,X|_],X).

% my_member( X, L)
% X is a member of list L

my_member( X, [X|_]).
my_member( X, [_|Tail]) :-
   my_member( X, Tail).

% conc( L1, L2, L3)
% L3 is the concatenation of L1 and L2.

conc( [], L, L).
conc( [X|L1], L2, [X|L3]) :-
   conc( L1, L2, L3).

% member1( X, L)
% X is a member of list L
% A single rule with conc

member1( X, L) :-
   conc( _, [X|_], L).

% add( X, L, L1)
% L1 is L with X added at the beginning
% add( X, L, L1) is not really needed
% A single fact

add( X, L, [X|L]).

% del( X, L, L1)
% L1 is L with element X deleted
% A base case fact and a recursive rule

del( X, [X|Tail], Tail).
del( X, [Y|Tail], [Y|Tail1]) :-
   del( X, Tail, Tail1).

% insert( X, List, BiggerList)
% BiggerList is List with X inserted anywhere
% A single rule for insert using del

insert( X, List, BiggerList) :-
   del( X, BiggerList, List).

% member2( X, List)
% member defined in terms of del/3 with a single rule

member2( X, List) :-
   del( X, List, _).

% my_sublist( S, L)
% list S is a sublist of list L
% a single rule with two conc/3 goals

my_sublist( S, L) :-
   conc( _, L2, L),
   conc( S, _, L2).

% my_permutation( L, P)
% List P is a permutation of list L
% First version with insert
% A base case fact and a recursive rule with two conjuncts

my_permutation( [], []).
my_permutation( [X|L], P) :-
   my_permutation( L, L1),
   insert( X, L1, P).

% Second version with del
% A base case fact and a recursive rule with two conjuncts

my_permutation2( [], []).
my_permutation2( L, [X|P]) :-
   del( X, L, L1),
   my_permutation2( L1, P).

% gcd( X, Y, D)
% D is the greatest common divisor of X and Y

% (1) If X and Y are equal then D is equal to X.
% (2) If X < Y then D is equal to the gcd of X
%     and the difference Y - X.
% (3) If Y < X then do the same thing as in case (2)
%     with X and Y interchanged.

gcd( X, X, X).

gcd( X, Y, D) :-
   X < Y,
   Y1 is Y - X,
   gcd( X, Y1, D).

gcd( X, Y, D) :-
   Y < X,
   gcd( Y, X, D).

% my_length( List, N)
% N is the length of List
% Base case fact and recursive case rule

my_length( [], 0).
my_length( [_|Tail], N) :-
   my_length( Tail, N1),
   N is N1 + 1.

%MY WORK

%3.1(a)
delete_three( L, L1) :-  
   conc( L1, [_,_,_], L).

%3.1(b)
delete_six( L, L2) :-
   conc( [_,_,_|L2], [_,_,_], L).

%3.2(a)
my_last( List, Item) :-
   conc( _, [Item], List).

%3.2(b)
your_last([Item], Item).
your_last([Car|Cdr], Item) :-
   your_last(Cdr, Item).





