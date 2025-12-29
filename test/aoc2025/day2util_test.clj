(ns aoc2025.day2util-test
  (:require [clojure.test :refer :all]
            [aoc2025.day2util :as du]
            ))

;; --------------------------------------------------
(deftest make-range-test
  (testing "range conversion"
    (is (= (du/make-range ["11" "22"]) ["11" "12" "13" "14" "15" "16" "17" "18" "19" "20" "21" "22"]))
    (is (= (du/make-range ["123456789" "123456790"]) ["123456789" "123456790" ]))))
        
(deftest filter-ranges-test
  (testing "two simple ranges"
    (is (= (du/filter-ranges (comp even? count) ["11-12" "99-102"]) ["11" "12" "99"]))))


 
