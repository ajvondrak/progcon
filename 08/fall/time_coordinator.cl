(defun split (str &optional (sep " "))
  (let ((i (search sep str)))
    (if (not i)
	(list str)
	(cons (subseq str 0 i)
	      (split (subseq str (+ i (length sep)))
		     sep)))))

(defun hms->seconds (hours minutes seconds)
  (+ (* 60 60 hours) (* 60 minutes) seconds))

(defun offset-value (offset)
  (* (if (eq (char offset 0) #\-) -1 1)
     (hms->seconds (parse-integer (subseq offset 1 3))
		   (parse-integer (subseq offset 3 5))
		   0)))

(defun utc (time-string)
  (destructuring-bind (hms offset) (split time-string)
    (destructuring-bind (h m s) (mapcar #'parse-integer (split hms ":"))
      (- (hms->seconds h m s) (offset-value offset)))))

(mapcar #'write-line
	(sort (loop for line = (read-line nil nil) while line collect line)
	      #'(lambda (t1 t2) (if (= (utc t1) (utc t2))
				    (string< t1 t2)
				    (< (utc t1) (utc t2))))))
