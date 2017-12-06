(ns custom-clojure-ttt.console_ui.console_ui_computer_move
  (:require [clojure-tic-tac-toe.computer_move :as computer_move]
            [custom-clojure-ttt.console_ui.input_output :as io]))

(defn have-computer-move
  [game-state]
  (io/display-computer-move-message)
  (computer_move/make-minimax-move game-state))

