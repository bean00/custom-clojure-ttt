(ns custom-clojure-ttt.winning_move_handler
  (:require [clojure-tic-tac-toe.default_winning_moves :as default_winning_moves]))

(defn get-winning-moves
  [side-length]
  default_winning_moves/winning-moves)

