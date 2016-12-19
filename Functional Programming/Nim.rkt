;; Name: Frank Garcia
;; Date: 9/19/16
;; Assignment: 5

;; This file contains excerpts from the textbook Concrete
;; Abstractions: An Introduction to Computer Science Using Scheme, by
;; Max Hailperin, Barbara Kaiser, and Karl Knight, Copyright (c) 1998
;; by Brooks/Cole Publishing Company. This file may not be reproduced
;; or redistributed other than for use with that textbook.

;; Nim Program

(define play-with-turns
  (lambda (game-state player)
    (display-game-state game-state)
    (cond ((over? game-state) 
           (announce-winner player))
          ((equal? player 'human)  
           (play-with-turns (human-move game-state) 'computer))
          ((equal? player 'computer)  
           (play-with-turns (computer-move game-state) 'human))
          (else  
           (error "player wasn't human or computer:" player)))))

(define computer-move
  (lambda (game-state)
    (let ((pile
           (if (> (size-of-pile game-state 1) 0)
               1
               (if (> (size-of-pile game-state 2) 0)
                   2
                   3))))
    (display "I take 1 coin from pile ")
    (display pile)
    (newline)
    (remove-coins-from-pile game-state 1 pile))))

(define prompt
  (lambda (prompt-string)
    (newline)
    (display prompt-string)
    (newline)
    (read)))

(define human-move
  (lambda (game-state)
    (let ((p (prompt "Which pile will you remove from?")))
      (let ((n (prompt "How many coins do you want to remove?")))
        (remove-coins-from-pile game-state n p)))))

(define over?
  (lambda (game-state)
    (= (total-size game-state) 0)))

(define announce-winner
  (lambda (player)
    (if (equal? player 'human) 
        (display "You lose. Better luck next time.")
        (display "You win. Congratulations."))))

(define remove-coins-from-pile
  (lambda (game-state num-coins pile-number)
    (cond ((= pile-number 1)
           (make-game-state (- (size-of-pile game-state 1) num-coins)
                            (size-of-pile game-state 2)
                            (size-of-pile game-state 3)))
          ((= pile-number 2)
           (make-game-state (size-of-pile game-state 1)
                            (- (size-of-pile game-state 2) num-coins)
                            (size-of-pile game-state 3)))
          ((= pile-number 3)
           (make-game-state (size-of-pile game-state 1)
                            (size-of-pile game-state 2)
                            (- (size-of-pile game-state 3) num-coins)))
          (else
           (display "Coins are being subtracted from an invalid pile number")))))

;; Implementation
;; The state is a n-digit integer where
; n is how many times 2 divides the number
; m is how many times 3 divides the number
; k is how many times 5 divides the number

(define make-game-state
  ;Returns a game state with n coins in the first pile
  ;and m coins in the second pile.
  ;and k coins in the thrid pile.
  (lambda (n m k)
    (* (* (expt 2 n) (expt 3 m)) (expt 5 k))))

(define size-of-pile
  ;Returns an integer equal to the number of coins in
  ;pile pile-number of the game-state.
  (lambda (game-state pile-number)
    (cond ((= pile-number 1)
           (if (= (remainder game-state 2) 0)
               (+ (size-of-pile (/ game-state 2) pile-number) 1)
               0))
          ((= pile-number 2)
           (if (= (remainder game-state 3) 0)
               (+ (size-of-pile (/ game-state 3) pile-number) 1)
               0))
          ((= pile-number 3)
           (if (= (remainder game-state 5) 0)
               (+ (size-of-pile (/ game-state 5) pile-number) 1)
               0))
          (else
           (display "Something went wrong with number calculations")))))

(define exponent-of-in
  (lambda (b n)
    (exponent-of-in-helper 0 b n)))

(define exponenet-of-in-helper
  (lambda (a b n)
    (if (< n b)
        a
        (exponent-of-in-helper (+ a 1) b (quotient n b)))))

;; Utilities

(define display-game-state
  (lambda (game-state)
    (newline)
    (display "    Pile 1: ")
    (display (size-of-pile game-state 1))
    (newline)
    (display "    Pile 2: ")
    (display (size-of-pile game-state 2))
    (newline)
    (display "    Pile 3: ")
    (display (size-of-pile game-state 3))
    (newline)
    (newline)))

(define total-size
  (lambda (game-state)
    (+ (+(size-of-pile game-state 1)
       (size-of-pile game-state 2))
       (size-of-pile game-state 3))))
