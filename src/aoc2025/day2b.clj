;;
;; Day 2, but only part b
;;
(ns aoc2025.day2b
   (:require [clojure.string :as cs]
             [aoc2025.util :as util]
             [aoc2025.day2util :as du]
            ))

;; ----------------------------------------
;; helpers
;; ----------------------------------------
(defn is-match?
  "checks if the full-str matches the repeated substr. Hence the length must fit to the n times the substring without remainder."
  [full-str s-str]
  (let [fl (count full-str)
        sl (count s-str)
        num-rep (quot fl sl)
        c-str (apply str (take num-rep (repeat s-str)))
        ]
    (and (= (mod fl sl) 0)
         (= full-str c-str)))
  )

(defn is-2b?
  "convert a number into a seq of substrings from pos 1 to pos count / 2
  input - output
  11 - t
  12 - f
  123123 - t
  123123123 - t
  1010 - t
  11111 - t"
  [num-str]
  (let [l (count num-str)
        q (quot l 2)
        r-vec (mapv (partial subs num-str 0) (range 1 (inc q)))
        ]
    (some (partial is-match? num-str) r-vec)
  ))
;; ----------------------------------------
;; the day part function
;; ----------------------------------------

(defn day-fn
  "constructs the ranges and applies a sophisticated filter"
  [range-line]
  (->>
   (cs/split (cs/trim-newline range-line) #",")
   (du/filter-ranges is-2b?)
   (mapv util/str-to-long)
   (reduce +)
   ))

   

