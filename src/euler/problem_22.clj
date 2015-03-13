(ns euler.problem-22
  (:gen-class)
  (:require [euler.problem-22-data :as data]))

(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(def char-val (zipmap (seq "ABCDEFGHIJKLMNOPQRSTUVWXYZ") (range 1 27)))

(defn main []
  (apply + (map-indexed 
             (fn [index name] 
               (* (inc index) (apply + (map char-val name)))) 
             (sort data/data))))