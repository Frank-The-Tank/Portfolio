;; Frank Garcia
;; 9/15/16
;; Assignment 4

; Exercise 2.12
(define exponent-of-two
  (lambda (i)
    (exponent-of-two-helper i 1)))

(define exponent-of-two-helper
  (lambda (i n)
    (if (odd? i)
        0
        (if (odd? (/ i (expt 2 n)))
            (if (= i (* (expt 2 n) (/ i (expt 2 n))))
                n
                (exponent-of-two-helper i (+ n 1)))
            (exponent-of-two-helper i (+ n 1))))))
        

; Exercise 5.1
(define together-copies-of
  (lambda (combine quantity thing)
    (together-copies-of-addr combine quantity thing 1)))

(define together-copies-of-addr
  (lambda (combine quantity thing n)
    (if (= quantity 0)
        quantity
        (if (= quantity 1)
            (combine thing n)
            (together-copies-of-addr combine (- quantity 1) thing (+ n 1))))))

(define power 
  (lambda (base exponent)
     (together-copies-of expt exponent base)))

; Exercise 5.4

(define num-digits-in-satisfying
  (lambda (n test?)
    (cond ((< n 0)
           (num-digits-in-satisfying (- n) test?))
          ((< n 10)
           (if (test? n) 1 0))
          ((test? (remainder n 10))
           (+ (num-digits-in-satisfying (quotient n 10) test?) 1))
          (else
           (num-digits-in-satisfying (quotient n 10) test?)))))

(define num-digits
  (lambda (n)
    (if (= n 0)
        0
        (+ (num-digits-in-satisfying n even?) (num-digits-in-satisfying n odd?)))))

; Exercise 5.7
(define make-exponentiater
  (lambda (e) ;make a repeated version of e
    (define raise-to-e
      (lambda (n) ;where n is raised to e
        (expt n e)))
    raise-to-e))