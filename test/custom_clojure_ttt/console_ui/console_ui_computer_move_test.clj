(ns custom-clojure-ttt.console_ui.console_ui_computer_move_test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.console_ui.console_ui_computer_move :refer :all]))

(def valid-moves
  #{:1 :2 :3 :4 :5 :6 :7 :8 :9})

(deftest have-computer-move-test
  (testing "when having the computer move"
    (with-out-str
      (is (= :3
             (have-computer-move
               {:board {:X #{:1 :2 :8 :6}, :O #{:4 :5 :7 :9}}, :player :X,
                :moves valid-moves}))
          "it returns a move"))
    (is (= true
           (str/includes?
             (with-out-str
               (have-computer-move
                 {:board {:X #{:1 :2 :3 :4}, :O #{:5 :6 :7 :8}}, :player :X,
                  :moves valid-moves}))
             "computer moved"))
        "it displays that the computer moved")))

