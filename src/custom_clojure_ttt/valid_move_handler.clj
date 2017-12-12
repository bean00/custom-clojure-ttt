(ns custom-clojure-ttt.valid_move_handler
  (:require [clojure-tic-tac-toe.default_valid_moves :as default_valid_moves]))

(defn get-valid-moves
  [side-length]
  default_valid_moves/valid-moves)

