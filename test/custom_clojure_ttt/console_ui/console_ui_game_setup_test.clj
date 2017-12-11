(ns custom-clojure-ttt.console_ui.console_ui_game_setup_test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.console_ui.console_ui_computer_move :as ui_comp_move]
            [custom-clojure-ttt.console_ui.console_ui_human_move :as ui_human_move]
            [custom-clojure-ttt.console_ui.console_ui_game_setup :refer :all]))

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
    (is (= #{:1 :2 :3 :4 :5 :6 :7 :8 :9}
           (get-valid-moves :3))
        "it returns the valid moves")))

(deftest get-winning-moves-test
  (testing "when the function is called"
    (is (= '(#{:1 :2 :3} #{:4 :5 :6} #{:7 :8 :9}
             #{:1 :4 :7} #{:2 :5 :8} #{:3 :6 :9}
             #{:1 :5 :9} #{:3 :5 :7}) 
           (get-winning-moves))
        "it returns the winning moves")))

(deftest display-instructions-test
  (testing "when the game is set up"
    (is (= true
           (str/includes?
             (with-out-str
               (display-instructions))
             "type a number"))
        "it displays the instructions")
    (is (= true
           (str/includes?
             (with-out-str
               (display-instructions))
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

