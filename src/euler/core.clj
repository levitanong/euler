; Problem 19

(ns euler.core
  (:gen-class))

(defn divisible?
  [x divisor]
  (= (mod x divisor) 0))

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

(defn gen-months
  [year]
  (for [month (range 12)]
    (range 1 (+ (days-in-month year month) 1))))

(defn gen-years
  "return years between 1900 to 2000"
  []
  (flatten (for [year (range 1900 2001)]
    (gen-months year))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println 
    (count (filter 
      (fn [[index item]] (and (sunday? index) (= item 1)))
      (subvec
        (vec (map-indexed #(vector %1 %2) (gen-years)))
        365)
    ))))
