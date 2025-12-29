(ns aoc2025.day2a-test
  (:require [clojure.test :refer :all]
            [aoc2025.day2a :as day]
            [aoc2025.day2util :as du]
            ))

;; --------------------------------------------------

(def sample-result 1227775554)
(def result 31210613313)

;; --------------------------------------------------

(deftest is-mirror-number?
  (testing "simple examples"
    (is (every? true?
         [(day/is-mirror-number? "11")
          (day/is-mirror-number? "1010")
          (day/is-mirror-number? "10101010")
          (day/is-mirror-number? "123456789123456789")]))    )
  (testing "non valid"
    (is (not-any? true?
         [(day/is-mirror-number? "12")
          (day/is-mirror-number? "1020")
          (day/is-mirror-number? "10101020")
          (day/is-mirror-number? "123456780123456789")]))    )  )

;; --------------------------------------------------
(deftest day-fn-test
  (testing "example input day 1 part a"
    (is (= (day/day-fn du/sample)
           sample-result)))
  (testing "full input day 1 part a"
    (is (= (day/day-fn du/data)
           result)))
  )

 
