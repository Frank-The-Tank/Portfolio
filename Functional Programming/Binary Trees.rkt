;; Frank Garcia
;; 9/26/16
;; Assignment 7


(define my-tree '(4 (2 (1 () ()) (3 () ())) (6 (5 () ()) (7 () ()))))

;(4
; (2
;  (1 () ())
;  (3 () ()))
; (6
;  (5 () ())
;  (7 () ())))

(define empty-tree?
  null?)
(define root
  car)
(define left-subtree
  cadr)
(define right-subtree
  caddr)
(define make-empty-tree
  (lambda ()
    '()))
(define make-nonempty-tree
  (lambda (root left-subtree right-subtree)
    (list root left-subtree right-subtree)))


;; Exercise 7.15
(define count-combos
  (lambda (prize-list amount)
    (cond ((= amount 0) 1)
          ((< amount 0) 0)
          ((null? prize-list) 0)
          (else
            (+ (count-combos prize-list (- amount (car prize-list)))
               (count-combos (cdr prize-list) amount))))))

;; Exercise 8.1
(define minimum
  (lambda (tree)
    (if (empty-tree? (left-subtree tree))
        (root tree)
        (minimum (left-subtree tree)))))

;; Exercise 8.4
(define inorder
  (lambda (tree)
    (inorder-onto tree '())))

(define inorder-onto
  (lambda (tree lst)
    (if (null? tree)
        lst
        (flatten
         (cons (inorder-onto (cadr tree) lst)
               (cons (car tree)
                     (inorder-onto (caddr tree) lst)))))))
             

;; Exercise 8.6
(define insert
  (lambda (num tree)
    (cond ((empty-tree? tree)
           num)
          ((< num (root tree))
           (cons (insert num (left-subtree tree)) tree))
          (else
           (cons tree (insert num (right-subtree tree)))))))
               

;; Exercise Flatten
(define flatten
  (lambda (lst)
    (cond ((not (list? lst)) (display "parameter not in list"))
          ((null? lst) lst)
          ((list? (car lst)) (append (flatten (car lst)) (flatten (cdr lst))))
          ((not (list? (car lst))) (append (list (car lst)) (flatten (cdr lst))))
          (else
           (flatten (cdr lst))))))
  

