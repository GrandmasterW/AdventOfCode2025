(ns aoc2025.day1b-test
  (:require [clojure.test :refer :all]
            [aoc2025.day1util :as du]
            [aoc2025.day1b :as day]
            ))

;; --------------------------------------------------

(def sample-result-b 6)
(def result-b 6671)

;; --------------------------------------------------



;; --------------------------------------------------
;; part b
;; --------------------------------------------------
(deftest part-b-sample-test
  (testing "sample to result part b"
    (is (= (day/part-b-fn 50 du/sample-b) sample-result-b)))
  (testing "full input day 1 part b"
    (is (= (day/part-b-fn 50 du/data-a) result-b))))




