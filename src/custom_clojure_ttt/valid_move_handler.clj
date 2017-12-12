(ns custom-clojure-ttt.valid_move_handler
  (:require [clojure-tic-tac-toe.default_valid_moves :as default_valid_moves]))

(def valid-moves
  { :3 default_valid_moves/valid-moves })

(defn get-valid-moves
  [side-length]
  (if-not (= side-length :default-size)
    (side-length valid-moves)
    (:3 valid-moves)))

