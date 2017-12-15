(ns custom-clojure-ttt.winning_move_handler_test
  (:require [clojure.set :as set]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.winning_move_handler :refer :all]))

(defn- list-contains-sets?
  [list-to-check list-of-sets]
  (every? (set list-to-check)
          list-of-sets))

(deftest get-winning-moves-test
  (testing "when choosing a side length of 3"
    (is (= true
           (list-contains-sets? (get-winning-moves :3)
                                '(#{:1 :2 :3} #{:7 :8 :9} #{:3 :5 :7})))
        "it returns the winning moves for a 3x3 board"))
  (testing "when choosing a side length of 4"
    (is (= true
           (list-contains-sets? (get-winning-moves :4)
                                '(#{:1 :5 :9 :13} #{:1 :6 :11 :16})))
        "it returns the winning moves for a 4x4 board"))
  (testing "when choosing the default size"
    (is (= winning-moves-3x3
           (get-winning-moves :default-size))
        "it returns the winning moves for a 3x3 board")))

