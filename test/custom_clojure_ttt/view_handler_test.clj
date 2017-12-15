(ns custom-clojure-ttt.view_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-tic-tac-toe.game_handler :as game_handler]
            [clojure-tic-tac-toe.utilities :refer [join-lines]]
            [custom-clojure-ttt.view_handler :refer :all]))

(deftest create-view-3x3-test
  (testing "when an empty board is passed in"
    (let [view (join-lines [" 1 | 2 | 3 "
                            "---+---+---"
                            " 4 | 5 | 6 "
                            "---+---+---"
                            " 7 | 8 | 9 "])]
      (is (= view
             (create-view-3x3 game_handler/empty-board))
          "it returns the formatted string for the example board")))
  (testing "when a game state with a board is passed in"
    (let [view (join-lines [" X | 2 | X "
                            "---+---+---"
                            " 4 | O | 6 "
                            "---+---+---"
                            " 7 | 8 | 9 " ])]
      (is (= view
             (create-view-3x3 {:board {:X #{:1 :3}, :O #{:5}}}))
          "it returns the formatted string for the board"))))

(deftest create-view-4x4-test
  (testing "when an empty board is passed in"
    (let [view (join-lines [" 1 | 2 | 3 | 4 "
                            "---+---+---+---"
                            " 5 | 6 | 7 | 8 "
                            "---+---+---+---"
                            " 9 | 10| 11| 12"
                            "---+---+---+---"
                            " 13| 14| 15| 16"])]
      (is (= view
             (create-view-4x4 game_handler/empty-board))
          "it returns the formatted string for the example board")))
  (testing "when a game state with a board is passed in"
    (let [view (join-lines [" X | 2 | X | 4 "
                            "---+---+---+---"
                            " O | 6 | 7 | 8 "
                            "---+---+---+---"
                            " 9 | 10| 11| 12"
                            "---+---+---+---"
                            " 13| 14| 15| 16"])]
      (is (= view
             (create-view-4x4 {:board {:X #{:1 :3}, :O #{:5}}}))
          "it returns the formatted string for the board"))))

(deftest get-create-view-test
  (testing "when choosing a side length of 3"
    (is (= create-view-3x3
           (get-create-view :3))
        "it returns create view for a 3x3 board"))
  (testing "when choosing a side length of 4"
    (is (= create-view-4x4
           (get-create-view :4))
        "it returns create view for a 4x4 board"))
  (testing "when choosing the default size"
    (is (= create-view-3x3
           (get-create-view :default-size))
        "it returns create view for a 3x3 board")))

