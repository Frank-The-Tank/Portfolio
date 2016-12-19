% Frank Garcia
% Assignment 8
% 10/3/16

parent( pam, bob).  % Pam is a parent of Bob
parent( tom, bob).
parent( tom, liz).
parent( bob, ann).
parent( bob, pat).
parent( pat, jim).

female( pam).       % Pam is female
female( liz).
female( ann).
female( pat).
male( tom).         % Tom is male
male( bob).
male( jim).

mother( X, Y) :-    % X is the mother of Y if
  parent( X, Y),    % X is a parent of Y and
  female( X).       % X is female

grandparent( X, Z) :-   % X is a grandparent of Z if
  parent( X, Y),    % X is a parent of Y and
  parent( Y, Z).    % Y is a parent of Z

sister( X, Y) :-    % X is a sister of Y if
  parent( Z, X),
  parent( Z, Y),    % X and Y have the same parent and
  female( X),       % X is female and
  X \= Y.           % X and Y are different

ancestor( X, Z) :-  % Rule a1: X is ancestor of Z
  parent( X, Z).

ancestor( X, Z) :-  % Rule a2: X is ancestor of Z
  parent( X, Y),
  ancestor( Y, Z).

% End of Figure 1.8   The family program.

% Example of unused variable
% has_a_child( X) :- parent( X, Y).

% Preferred style, use anonymous variables
% has_a_child( X) :- parent( X, _).

% MY WORK

%1.4
grandchild( X, Y) :-  % X is the grandchild of Y if
  parent( Z, X),      % Z is the parent of X and
  parent( Y, Z).      % Y is the parent of Z

%1.5
aunt( X, Y) :-        % X is the aunt of Y if
  parent( Z, Y),      % Z is the parent of Y and
  sister( X, Z).      % X is the sister of Z




