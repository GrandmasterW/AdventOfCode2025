(ns aoc2025.day1util-test
  (:require [clojure.test :refer :all]
            [aoc2025.day1util :as du]))

;; --------------------------------------------------

(deftest get-instruction-test
  (testing "simple file line separation"
    (is (=
         (du/get-instruction "L45")
         ["L" 45]))
    (is (=
         (du/get-instruction "R1")
         ["R" 1]))
    ))

;; --------------------------------------------------


(deftest turn-dial-test
  (testing "to the right between 0..99"
    (is (= (du/turn-dial 0 "R" 99) [99 0]))
    (is (= (du/turn-dial 50 "R" 10) [60 0]))
    )
  (testing "to the right, but exceeding 100"
    (is (= (du/turn-dial 0 "R" 100) [0 1]))
    (is (= (du/turn-dial 50 "R" 100) [50 1]))
    (is (= (du/turn-dial 50 "R" 150) [0 2]))
    (is (= (du/turn-dial 50 "R" 410) [60 4]))
    (is (= (du/turn-dial 0 "R" 1000) [0 10]))
    )
  (testing "to the left between 99..0"
    (is (= (du/turn-dial 0 "L" 22) [78 0]))
    (is (= (du/turn-dial 0 "L" 100) [0 1]))
    )
  (testing "to the left exceeding limits"
    (is (= (du/turn-dial 0 "L" 200) [0 2]))
    (is (= (du/turn-dial 50 "L" 68) [82 1]))
    (is (= (du/turn-dial 0 "L" 150) [50 1]))
    (is (= (du/turn-dial 0 "L" 222) [78 2]))
    ))


;; --------------------------------------------------

(deftest process-steps-b-test
  (testing "should convert instructions and positions into a vec of [pos crossings]"
    (is (= (du/process-steps
            50
            [["L" 45]["R" 150]["R" 450]])
            [[5 0] [55 1] [5 5]]))
    (is (= (du/process-steps
            50
            [["L" 68]["L" 30]["R" 48]["L" 5]["R" 60]])
           [[82 1] [52 0]   [0 1]   [95 0] [55 1] ]))
    )
  (testing "example-input replicated"
    (is (= (du/process-steps
            50
            [["L" 68]
             ["L" 30]
             ["R" 48]
             ["L" 5]
             ["R" 60]
             ["L" 55]
             ["L" 1]
             ["L" 99]
             ["R" 14]
             ["L" 82]])
           [[82 1] [52 0][0 1][95 0][55 1][0 1][99 0][0 1][14 0][32 1]]))))


