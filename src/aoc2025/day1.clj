;;
;; Day 1, but only part a
;;
(ns aoc2025.day1
   (:require [clojure.string :as s]
             [aoc2025.util :as u]
             [aoc2025.day1util :as du]
            ))


(defn part-a-fn "splits the input into lines, converts each line into direction and steps, then computes the outcome with given start and sums up the 0-value-spots"
  [start-position instructions]
  (->> instructions
       (clojure.string/split-lines)
       (mapv du/get-instruction)
       (du/process-steps start-position)
       (mapv first)
       (filter zero?)
       (count)
  ))
   

