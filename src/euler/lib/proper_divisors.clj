(ns lib.proper-divisors
  (:gen-class)
  (:use [lib.math-util]))

(defn d
  "The sum of divisors of n less than n. Inefficient but elegant"
  [n]
  (apply + (filter (partial divisible? n) (range 1 n))))
