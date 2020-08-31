;;	Paige Forsha
;;	2/25/2020
;; 	SCHEME HW 1


;; problem 1
(define (yourname)
	'"Paige Forsha")

;;problem 2
(define (a+bx a b x)
	(+ a (* b x)))

;;problem 3
(define (hypotenuse a b)
	(sqrt (+ (* a a) (* b b))))

;;problem 4
(define (polar-to-rect radius theta)
	(list
		(* radius (cos theta))
		(* radius (sin theta))))
		
;;problem 5
(define dotproduct
  (lambda (a b)
    (apply + 
    (map * a b))))

;;problem 6
(define (threshold min lst)
  (filter (lambda(x) (>= x min))
  lst))

;;problem 7
(define (diff z lst)
	(map (lambda(x) (abs(- x z))) 
	lst))

;;problem 8
(define (build-list start end)
  (if (<= end start) '()
  (cons start (build-list (+ start 1) end))))
  
;;problem 9
(define (convert command arg)
(cond ((eq? command 'upper) (string-upcase arg))
      ((eq? command 'lower) (string-downcase arg))
      ((eq? command 'reverse) 
        (if (string? arg) 
          (list->string (reverse (string->list arg)))
        (if (list? arg) 
          (reverse arg))))
      ((eq? command 'square) (* arg arg))
      (else 'not-implemented)
)) 

;;problem 10 
(define (strip-spaces string)
  (list->string 
    (filter (lambda(x) (not(equal? x #\space)))
   (string->list string)))) 

