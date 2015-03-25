(ns lib.proper-divisors
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math])
  (:use [lib.math-util]))

;(def memo-divisible? (memoize divisible?))

(defn proper-divisors-orig
  [n]
  (filter #(divisible? n %) (range 1 n)))

(defn d
  "The sum of divisors of n less than n. Inefficient but elegant"
  [n]
  (apply + (proper-divisors-orig n)))

;(def d (memoize d-orig))

(defn perfect?
  "The sum of divisors of n less than n is n. "
  [n]
  (= n (d n)))

(defn deficient?
  "d of n is less than n"
  [n]
  (< (d n) n))

(defn abundant?
  "d of n is greater than n"
  [n]
  (> (d n) n))

(def memo-abundant? (memoize abundant?))

(defn sum-of-two-abundants?
  [n]
  (if (>= n 24) 
    (let [abundants (filter memo-abundant? (range 12 (inc (/ n 2))))]
      (some? (some #(memo-abundant? (- n %)) abundants))))) 
; start with 24. if number is less than 24, false.
; 24 is the sum of 12 and 12. 12 is the smallest abundant number.
; make a list of abundant numbers less than n, get the difference. if the difference is abundant, true.       

;(time (sum-of-two-abundants? 28123))
;(time (sum-of-two-abundants? 20000))

; (time (sum-of-two-abundants? 20000))
(time (apply + (remove sum-of-two-abundants? (range 28123))))

; (time (apply + (remove sum-of-two-abundants? (range 28123 0 -1))))


; (defn not-sum-of-two-abundants [n]
;   (loop [acc 0 cnt n]
;     (if (zero? cnt)
;       acc
;       (if (sum-of-two-abundants? cnt)
;         (recur (+ acc cnt) (dec cnt))
;         (recur acc (dec cnt))))))

