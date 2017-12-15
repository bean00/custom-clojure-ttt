(ns custom-clojure-ttt.winning_move_handler_test
  (:require [clojure.set :as set]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.winning_move_handler :refer :all]))

(defn- contains-set?
  [list-to-check set-to-check]
  (contains? (set list-to-check)
             set-to-check))

(deftest winning-moves-3x3-test
  (testing "when getting the winning moves for a 3x3 board"
    (is (= true
           (contains-set? winning-moves-3x3 #{:1 :2 :3}))
        "it returns the top row")
    (is (= true
           (contains-set? winning-moves-3x3 #{:4 :5 :6}))
        "it returns the middle row")
    (is (= true
           (contains-set? winning-moves-3x3 #{:7 :8 :9}))
        "it returns the bottom row")
    (is (= true
           (contains-set? winning-moves-3x3 #{:1 :4 :7}))
        "it returns the left column")
    (is (= true
           (contains-set? winning-moves-3x3 #{:2 :5 :8}))
        "it returns the middle column")
    (is (= true
           (contains-set? winning-moves-3x3 #{:3 :6 :9}))
        "it returns the right column")
    (is (= true
           (contains-set? winning-moves-3x3 #{:1 :5 :9}))
        "it returns the upper left diagonal")
    (is (= true
           (contains-set? winning-moves-3x3 #{:3 :5 :7}))
        "it returns the upper right diagonal")))

(deftest winning-moves-4x4-test
  (testing "when getting the winning moves for a 4x4 board"
    (is (= true
           (contains-set? winning-moves-4x4 #{:1 :2 :3 :4}))
        "it returns the 1st row")
    (is (= true
           (contains-set? winning-moves-4x4 #{:5 :6 :7 :8}))
        "it returns the 2nd row")
    (is (= true
           (contains-set? winning-moves-4x4 #{:9 :10 :11 :12}))
        "it returns the 3rd row")
    (is (= true
           (contains-set? winning-moves-4x4 #{:13 :14 :15 :16}))
        "it returns the 4th row")
    (is (= true
           (contains-set? winning-moves-4x4 #{:1 :5 :9 :13}))
        "it returns the 1st column")
    (is (= true
           (contains-set? winning-moves-4x4 #{:2 :6 :10 :14}))
        "it returns the 2nd column")
    (is (= true
           (contains-set? winning-moves-4x4 #{:3 :7 :11 :15}))
        "it returns the 3rd column")
    (is (= true
           (contains-set? winning-moves-4x4 #{:4 :8 :12 :16}))
        "it returns the 4th column")
    (is (= true
           (contains-set? winning-moves-4x4 #{:1 :6 :11 :16}))
        "it returns the upper left diagonal")
    (is (= true
           (contains-set? winning-moves-4x4 #{:4 :7 :10 :13}))
        "it returns the upper right diagonal")))

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

