(ns custom-clojure-ttt.console_ui.console_ui_game_setup_test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.console_ui.console_ui_computer_move :as ui_comp_move]
            [custom-clojure-ttt.console_ui.console_ui_human_move :as ui_human_move]
            [custom-clojure-ttt.console_ui.console_ui_game_setup :refer :all]
            [custom-clojure-ttt.valid_move_handler :as valid_move_handler]
            [custom-clojure-ttt.view_handler :as view_handler]
            [custom-clojure-ttt.winning_move_handler :as winning_move_handler]))

(deftest get-game-mode-test
  (testing "when getting the game mode"
    (is (= true
           (str/includes?
             (with-out-str
               (with-in-str "h\n"
                 (get-game-mode)))
             "\"h\" to play"))
        "it displays the game mode instructions")
    (with-out-str
      (is (= :human
             (with-in-str "h\n"
               (get-game-mode)))
          "it returns the game mode"))))

(deftest get-move-order-test
  (testing "when getting the move order, while playing a computer"
    (is (= true
           (str/includes?
             (with-out-str
               (with-in-str "1\n"
                 (get-move-order :computer)))
             "\"1\" to go first"))
        "it displays the move order instructions")
    (with-out-str
      (is (= :1
             (with-in-str "1\n"
               (get-move-order :computer)))
          "it returns the move order")))
  (testing "when not playing a computer"
    (with-out-str
      (is (= nil
             (with-in-str "1\n"
               (get-move-order :human)))
          "it returns nil"))))

(deftest get-valid-moves-test
  (testing "when a side length is passed in"
    (is (= valid_move_handler/valid-moves-on-3x3
           (get-valid-moves :3))
        "it returns the valid moves")))

(deftest get-winning-moves-test
  (testing "when the function is called"
    (is (= winning_move_handler/winning-moves
           (get-winning-moves :3))
        "it returns the winning moves")))

(deftest decide-strategies-test
  (testing "when the game is Human vs. Human"
    (is (= {:X ui_human_move/get-human-move, :O ui_human_move/get-human-move}
           (decide-strategies :human))
        "it returns the strategies for 2 human players"))
  (testing "when the game is Human vs. Computer"
    (is (= {:X ui_human_move/get-human-move, :O ui_comp_move/have-computer-move}
           (decide-strategies :computer))
        "it returns strategies for a human and a computer")))

(deftest get-create-view-test
  (testing "when getting the create view function"
    (is (= view_handler/create-view
           (get-create-view))
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

