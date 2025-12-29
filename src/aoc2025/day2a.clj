;;
;; Day 2, but only part a
;;
(ns aoc2025.day2a
   (:require [clojure.string :as cs]
             [aoc2025.util :as util]
             [aoc2025.day2util :as du]
            ))

;; ----------------------------------------
;; helpers
;; ----------------------------------------

(defn is-mirror-number?
  "true, if the given string matches the condition:
   split in two halfs, the first half must equal the second half.
   Make sure, that the string length is even! 
   '11': t
   '1000' f
   '1010' t"
  [s]
  (let [f (subs s 0 (/ (count s) 2))
        s (subs s (/ (count s) 2)) ]
    (= f s)))
;; ----------------------------------------
;; the day part function
;; ----------------------------------------

(defn day-fn
  ""
  [range-line]
  (->>
   (cs/split (cs/trim-newline range-line) #",")
   (du/filter-ranges (comp even? count))
   (filter is-mirror-number?)
   (mapv util/str-to-long)
   (reduce +)
   ))
