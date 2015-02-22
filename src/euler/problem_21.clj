(ns euler.problem-21
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn divisible?
  [x divisor]
  (= (mod x divisor) 0))

(defn d
  "The sum of divisors of n less than n. Inefficient but elegant"
  [n]
  (apply + (filter (partial divisible? n) (range 1 n))))

(defn amicable?
  [n m]
  (and
   (not= n m)
   (= (d n) m)
   (= (d m) n)))

(defn amicable-numbers
  "Lists all amicable numbers from 1 to limit"
  [limit]
  (reduce
   (fn [acc head]
     (let [d-value (d head)]
       (if (and (< d-value limit) (amicable? d-value head))
         (conj acc head d-value)
         acc)))
   (set [])
   (range 1 limit)))

(defn main
  "Amicable Numbers"
  []
  (apply + (amicable-numbers 10000)))


(main)
(amicable? 220 284)
