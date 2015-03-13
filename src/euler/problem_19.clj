(ns euler.problem-19
  (:gen-class)
  (:use [lib.math-util]))

(defn leap-year?
  [year]
  (if (divisible? year 100)
    (divisible? year 400) ; special case for century
    (divisible? year 4)))

(defn sunday?
  [day]
  (= (mod day 7) 6))

(defn days-in-month
  [year month]
  (case month
    (8 3 5 10) 30 ; September, April, June, November have 30 days
    1 (if (leap-year? year) 29 28) ; special case for February
    31)) ; The rest of the months have 31 days

(defn gen-years
  "return years between 1900 to 2000"
  []
  (flatten
    (for [year (range 1900 2001)]
      (for [month (range 12)]
        (range (days-in-month year month))))))

(defn main
  "Counting Sundays"
  []
  (count
    (filter
      (fn [[index item]] (and (sunday? index) (= item 0)))
      (subvec
        (vec (map-indexed #(vector %1 %2) (gen-years)))
        365))))
