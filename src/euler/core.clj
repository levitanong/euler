(ns euler.core
  (:gen-class))

(defn divisible-by
  [x divisor]
  (= (mod x divisor) 0))

(defn is-leap-year
  [year]
  (if (divisible-by year 100)
    (divisible-by year 400) ; special case for century
    (divisible-by year 4)))

(defn days-in-month
  [year month]
  (case month
    (8 3 5 10) 30 ; September, April, June, November have 30 days
    1 (if (is-leap-year year) 29 28) ; special case for February
    31)) ; The rest of the months have 31 days

(defn gen-months
  [year]
  (for [month (range 12)]
    (days-in-month year month)))

(defn gen-years
  "return years between 1900 to 2000"
  []
  (for [year (range 1900 2001)]
    (gen-months year)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (gen-years)))
