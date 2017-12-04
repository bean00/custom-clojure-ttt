(ns custom-clojure-ttt.winning_move_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-tic-tac-toe.default_winning_moves :as default_winning_moves]
            [custom-clojure-ttt.winning_move_handler :refer :all]))

(def winning-moves-on-3x3
  default_winning_moves/winning-moves)

(deftest get-winning-moves-test
  (testing "when choosing a side length of 3"
    (is (= winning-moves-on-3x3
           (get-winning-moves :3))
        "it returns the winning moves for a 3x3 board"))
  (testing "when choosing the default size"
    (is (= winning-moves-on-3x3
           (get-winning-moves :default-size))
        "it returns the winning moves for a 3x3 board")))

