(ns custom-clojure-ttt.valid_move_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-tic-tac-toe.default_valid_moves :as default_valid_moves]
            [custom-clojure-ttt.valid_move_handler :refer :all]))

(def valid-moves-on-3x3
  default_valid_moves/valid-moves)

(deftest get-valid-moves-test
  (testing "when choosing a side length of 3"
    (is (= valid-moves-on-3x3
           (get-valid-moves :3))
        "it returns the valid moves for a 3x3 board"))
  (testing "when choosing the default size"
    (is (= valid-moves-on-3x3
           (get-valid-moves :default-size))
        "it returns the valid moves for a 3x3 board")))

