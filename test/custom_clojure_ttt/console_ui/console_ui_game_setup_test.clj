(ns custom-clojure-ttt.console_ui.console_ui_game_setup_test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest testing is]]
            [clojure-tic-tac-toe.default_valid_moves :as default_valid_moves]
            [clojure-tic-tac-toe.default_winning_moves :as default_winning_moves]
            [custom-clojure-ttt.console_ui.console_ui_computer_move :as ui_comp_move]
            [custom-clojure-ttt.console_ui.console_ui_human_move :as ui_human_move]
            [custom-clojure-ttt.console_ui.console_ui_game_setup :refer :all]
            [custom-clojure-ttt.view_handler :as view_handler]))

(defn- perform-setup-output []
  (with-out-str
    (with-in-str "h\n"
      (perform-setup))))

(deftest perform-setup-test
  (testing "when the player chooses to play another person"
    (is (= true
           (str/includes?
             (perform-setup-output)
             "Tic Tac Toe"))
        "it displays the introduction")
    (is (= true
           (str/includes?
             (perform-setup-output)
             "\"h\" to play"))
        "it displays the game mode instructions")
    (is (= true
           (str/includes?
             (perform-setup-output)
             "chose to play another person"))
        "it displays the 'playing person' message")
    (with-out-str
      (is (= :human
             (with-in-str "h\n"
               (perform-setup)))
          "it returns the internal keyword for playing a person"))))

(deftest get-valid-moves-test
  (testing "when a side length is passed in"
    (is (= default_valid_moves/valid-moves
           (get-valid-moves :3))
        "it returns the valid moves")))

(deftest get-winning-moves-test
  (testing "when the function is called"
    (is (= default_winning_moves/winning-moves
           (get-winning-moves :3))
        "it returns the winning moves")))

(deftest get-create-view-function-test
  (testing "when getting the create view function"
    (is (= view_handler/create-view
           (get-create-view-function))
        "it returns the function")))

(deftest display-instructions-test
  (testing "when the game is set up"
    (is (= true
           (str/includes?
             (with-out-str
               (display-instructions view_handler/create-view))
             "type a number"))
        "it displays the instructions")
    (is (= true
           (str/includes?
             (with-out-str
               (display-instructions view_handler/create-view))
             " 4 | 5 | 6 "))
        "it displays the example board")))

(deftest decide-strategies-test
  (testing "when the game is Human vs. Human"
    (is (= {:X ui_human_move/get-human-move, :O ui_human_move/get-human-move}
           (decide-strategies :human))
        "it returns the strategies for 2 human players"))
  (testing "when the game is Human vs. Computer"
    (is (= {:X ui_human_move/get-human-move, :O ui_comp_move/have-computer-move}
           (decide-strategies :computer))
        "it returns strategies for a human and a computer")))

