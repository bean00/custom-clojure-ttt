(ns custom-clojure-ttt.valid_move_handler_test
  (:require [clojure.set :as set]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.valid_move_handler :refer :all]))

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

