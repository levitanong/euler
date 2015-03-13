(ns lib.math-util
  (:gen-class))

(defn divisible?
  [x divisor]
  (= (mod x divisor) 0))