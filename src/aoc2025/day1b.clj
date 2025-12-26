;;
;; Day 1, this is part b
;;
(ns aoc2025.day1b
   (:require [clojure.string :as s]
             [aoc2025.util :as u]
             [aoc2025.day1util :as du]
            ))

;; --------------------------------------------------


(defn part-b-fn
  "splits the input into lines, converts each line into direction and steps, then computes the outcome with given start and sums up the spots where position is 0 or has crossed the 100 border"
  [start-position instructions]
  (->> instructions
       (clojure.string/split-lines)
       (mapv du/get-instruction)
       (du/process-steps start-position)
       (mapv second)
       (reduce +)
  ))


