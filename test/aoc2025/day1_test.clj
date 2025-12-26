(ns aoc2025.day1-test
  (:require [clojure.test :refer :all]
            [aoc2025.day1util :as du]
            [aoc2025.day1 :as day]
            ))

;; --------------------------------------------------

(def sample-result-a 3)
(def result-a 1152)

;; --------------------------------------------------

(deftest part-a-fn-test
  (testing "simple chain"
    (is (= (day/part-a-fn 50 "L45\nR5\nL20\n")
           0)) ;; no zeros in [50 5 10 90]
    (is (= (day/part-a-fn 50 "L45\nR5\nL10\n")
           1)))
  (testing "3 times 0"
    (is (= (day/part-a-fn 50 "L50\nR98\nR2\nR2\nL2")
           3)))
  (testing "overrun 500"
    (is (= (day/part-a-fn 50 "L500\nR50")
           1)))
  (testing "example input day 1 part a"
    (is (= (day/part-a-fn 50 du/sample-a)
           3)))
  (testing "full input day 1 part a"
    (is (= (day/part-a-fn 50 du/data-a)
           1152))))
  
