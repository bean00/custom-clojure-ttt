(ns custom-clojure-ttt.valid_move_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.valid_move_handler :refer :all]))

(deftest get-valid-moves-test
  (testing "when a side length is passed in"
    (is (= #{:1 :2 :3 :4 :5 :6 :7 :8 :9}
           (get-valid-moves :3))
        "it returns the valid moves"))
  (testing "when nil is passed in"
    (is (= #{:1 :2 :3 :4 :5 :6 :7 :8 :9}
           (get-valid-moves nil))
        "it returns the moves for a 3x3 board")))

