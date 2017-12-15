(ns custom-clojure-ttt.valid_move_handler_test
  (:require [clojure.set :as set]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.valid_move_handler :refer :all]))

(deftest valid-moves-3x3-test
  (testing "when getting the valid moves for a 3x3 board"
    (is (= #{:1 :2 :3
             :4 :5 :6
             :7 :8 :9}
           valid-moves-3x3)
        "it returns all the valid moves")))

(deftest valid-moves-4x4-test
  (testing "when getting the valid moves for a 4x4 board"
    (is (= #{  :1  :2  :3  :4
               :5  :6  :7  :8
               :9 :10 :11 :12
              :13 :14 :15 :16}
           valid-moves-4x4)
        "it returns all the valid moves")))

(deftest get-valid-moves-test
  (testing "when choosing a side length of 3"
    (is (= true
           (set/subset? #{:1 :3 :5 :9}
                        (get-valid-moves :3)))
        "it returns the valid moves for a 3x3 board"))
  (testing "when choosing a side length of 4"
    (is (= true
           (set/subset? #{:1 :4 :6 :9 :16}
                        (get-valid-moves :4)))
        "it returns the valid moves for a 4x4 board"))
  (testing "when choosing the default size"
    (is (= valid-moves-3x3
           (get-valid-moves :default-size))
        "it returns the valid moves for a 3x3 board")))

