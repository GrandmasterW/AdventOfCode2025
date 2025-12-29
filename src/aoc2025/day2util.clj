;;
;; Day 2 utils
;;
(ns aoc2025.day2util
   (:require [clojure.string :as cs]
             [aoc2025.util :as util]
            ))

;; ----------------------------------------
;; puzzle examples
;; ----------------------------------------

(def example-input "src/aoc2025/day2-example-input-a.txt")
(def sample (slurp example-input))

;; ----------------------------------------
;; puzzle input
;; ----------------------------------------
(def puzzle-input "src/aoc2025/day2-input.txt")
(def data (slurp puzzle-input))

;; ----------------------------------------
;; helpers
;; ----------------------------------------
(defn make-range
  "convert lower and upper value strings to numbers and compute the range and convert it into strings: ['11' '22'] results in a vec of strings: ['11' '12' .. '22']"
  [range-vec]
  (let [lower (util/str-to-long (first range-vec))
        upper (inc (util/str-to-long (second range-vec)))]
    (mapv str (range lower upper))))

(defn filter-ranges
  "for each range-string '11-22' or '100-200' in the sequence:
  derive lower and upper values, join everything in one vec, 
  filter the strings with even length" 
  [filter-fn ranges-seq]
  (->> ranges-seq
       (mapv #(cs/split %1 #"-"))
       (mapv make-range)
       (flatten)
       (filter filter-fn)))
