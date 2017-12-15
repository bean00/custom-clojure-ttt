(ns custom-clojure-ttt.console_ui.console_ui_computer_move_test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.console_ui.console_ui_computer_move :refer :all]
            [custom-clojure-ttt.valid_move_handler :as valid_move_handler]))

(def valid-moves
  (valid_move_handler/get-valid-moves :3))

(def initial-data
  {:valid-moves valid-moves})

(deftest have-computer-move-test
  (testing "when having the computer move"
    (with-out-str
      (is (= :3
             (have-computer-move
               {:board {:X #{:1 :2 :8 :6}, :O #{:4 :5 :7 :9}}, :player :X}
               initial-data))
          "it returns a move"))
    (is (= true
           (str/includes?
             (with-out-str
               (have-computer-move
                 {:board {:X #{:1 :2 :8 :6}, :O #{:4 :5 :7 :9}}, :player :X}
                 initial-data))
             "computer moved"))
        "it displays that the computer moved")))

