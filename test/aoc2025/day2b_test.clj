(ns aoc2025.day2b-test
  (:require [clojure.test :refer :all]
            [aoc2025.day2b :as day]
            [aoc2025.day2util :as du]
            ))

;; --------------------------------------------------

(def sample-result 4174379265)
(def result 41823587546)

;; --------------------------------------------------
(deftest is-match?-test
  (testing "simple matches true"
    (is (= (day/is-match? "123123123" "123")))
    (is (= (day/is-match? "123123" "123")))
    (is (= (day/is-match? "1010" "1010")))
    (is (= (day/is-match? "11111" "1")))
    (is (= (day/is-match? "98769876" "9876")))
    )
  (testing "simple non-matches"
    (is (= (day/is-match? "1234567" "1")))
    (is (= (day/is-match? "1234567" "12")))
    (is (= (day/is-match? "1234567" "123")))
    (is (= (day/is-match? "1234567" "1234")))
    ))

(deftest is-2b?-test
  (testing "simple matches true"
    (is (day/is-2b? "11"))
    (is (day/is-2b? "22"))
    (is (day/is-2b? "11111111111"))
    (is (day/is-2b? "1010"))
    (is (day/is-2b? "123123123"))
    (is (day/is-2b? "123456789123456789123456789123456789123456789"))
    )
  (testing "sets"
    (is (every? day/is-2b?
                 ["11"
                  "22"
                  "99"
                  "111"
                  "999"
                  "1010"
                  "1188511885"
                  "222222"
                  "446446"
                  "38593859"
                  "565565"
                  "824824824"
                  "2121212121"
                  ])))
  (testing "simple non-matches"
    (is (not (day/is-2b? "12")))
    (is (not (day/is-2b? "1234567890")))
    (is (not (day/is-2b? "4711")))
    (is (not (day/is-2b? "1012")))
    (is (not (day/is-2b? "1")))
    (is (not (day/is-2b? "345245245234566")))
    (is (not (day/is-2b? "42")))
    ))
;; --------------------------------------------------

;; --------------------------------------------------

;; --------------------------------------------------

;; --------------------------------------------------

;; --------------------------------------------------
(deftest day-fn-test
  (testing "example input day 1 part b"
    (is (= (day/day-fn du/sample)
           sample-result)))
  (testing "full input day 1 part b"
    (is (= (day/day-fn du/data)
           result)))
  )

 
