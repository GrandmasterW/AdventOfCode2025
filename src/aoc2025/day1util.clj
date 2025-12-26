;;
;; Day 1 utils 
;;
(ns aoc2025.day1util
   (:require [clojure.string :as s]
             [aoc2025.util :as u]
            ))
;; ----------------------------------------
;; ----------------------------------------
;; puzzle examples
;; ----------------------------------------

(def example-input-a "src/aoc2025/day1-example-input-a.txt")
(def example-input-b "src/aoc2025/day1-example-input-b.txt")
(def sample-a (slurp example-input-a))
(def sample-b (slurp example-input-b))

;; ----------------------------------------
;; puzzle input
;; ----------------------------------------
(def puzzle-input "src/aoc2025/day1-input.txt")
(def data-a (slurp puzzle-input))

;; ----------------------------------------
;; helpers
;; ----------------------------------------

(defn get-instruction
  "from a line with instruction in form of L45 return L and 45 as a vector"
  [line]
  [(subs line 0 1)
   ;; we better do not assume how long the numeric part may become
   (u/str-to-long (subs line 1))])

;; --------------------------------------------------

(defn turn-dial
  "simulate exactly the turning of the dial.
   Returns a vector of the new position in 0..99 and
   the number, how often 0 has been touched throughout the turning."
  [position dir offset]
  (let [op (case dir
             "L" -
             "R" +)
        new-pos (op position offset)
        ad-new-pos (abs (mod new-pos 100))
        q (+
           (abs (quot new-pos 100))
           (if (and (or (zero? new-pos)(neg? new-pos)) (> position 0)) 1 0))
        ]
       [ad-new-pos q]))
      
;; --------------------------------------------------

(defn process-steps
  "Processes the first step of the given sequence,
  each step results in a vector of position and number of zero-crossings. 
  Returns the resulting vectors of positions and zero-crossings. "
  ([last-position instructions]
   ;; intro to avoid internal parameter
   (process-steps [] last-position instructions))
  
  ([positionsvec last-position instructions]
   ;; the full monty here: with positionvec at beginning

   (if (empty? instructions) positionsvec ;; done
       (let [one-instruction (first instructions)
             dir             (first one-instruction)
             offset          (second one-instruction)
             new-pos-vec     (turn-dial last-position dir offset)
             new-pos         (first new-pos-vec) ]
         (recur (conj positionsvec new-pos-vec)
                new-pos
                (rest instructions))))))



