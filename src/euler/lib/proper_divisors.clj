(ns lib.proper-divisors
  (:gen-class)
  (:use [lib.math-util]))

(defn d
  "The sum of divisors of n less than n. Inefficient but elegant"
  [n]
  (apply + (filter (partial divisible? n) (range 1 n))))

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