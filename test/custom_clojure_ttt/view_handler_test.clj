(ns custom-clojure-ttt.view_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-tic-tac-toe.game_handler :as game_handler]
            [clojure-tic-tac-toe.utilities :refer [join-lines]]
            [custom-clojure-ttt.view_handler :refer :all]))

(deftest create-view-test
  (testing "when an empty board is passed in"
    (let [view (join-lines [" 1 | 2 | 3 "
                            "---+---+---"
                            " 4 | 5 | 6 "
                            "---+---+---"
                            " 7 | 8 | 9 "])]
      (is (= view
             (create-view game_handler/empty-board))
          "it returns the formatted string for the example board")))
  (testing "when a game state with a board is passed in"
    (let [view (join-lines [" X | 2 | X "
                            "---+---+---"
                            " 4 | O | 6 "
                            "---+---+---"
                            " 7 | 8 | 9 " ])]
      (is (= view
             (create-view {:board {:X #{:1 :3}, :O #{:5}}}))
          "it returns the formatted string for the board"))))

(deftest get-create-view-test
  (testing "when getting the create view function"
    (is (= create-view
           (get-create-view))
        "it returns the function")))

