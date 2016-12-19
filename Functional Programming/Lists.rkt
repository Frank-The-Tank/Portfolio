;; Frank Garcia
;; 9/22/16
;; Assignment 6

;; Exercise 7.8(f)
(define largest-in
  (lambda (lst)
    (cond ((null? list)
           (display "list can not be empty"))
          ((null? (cdr lst))
           (car lst))
          ((> (car lst) (car (cdr lst)))
           (largest-in (cons (car lst) (cdr (cdr lst)))))
          (else
           (largest-in (cdr lst))))))

;; Exercise 7.9(a)
(define list-<
  (lambda (lst lst2)
    (cond ((null? (cdr lst))
           (if (null? (cdr lst2))
               #t
               #f))
          ((null? (cdr lst2))
           (if (null? (cdr lst))
               #t
               #f))
          ((< (car lst) (car lst2))
           (list-< (cdr lst) (cdr lst2)))
          (else
           #f))))

;; Exercise 7.14
(define my-map
  (lambda (func lst)
    (if (null? (cdr lst))
        (func (car lst))
        (cons (func (car lst)) (my-map func (cdr lst))))))

;; Exercise 7.42
(define apply-all
  (lambda (func-list num)
    (if (null? (cdr func-list))
        ((car func-list) num)
        (cons ((car func-list) num) (apply-all (cdr func-list) num)))))