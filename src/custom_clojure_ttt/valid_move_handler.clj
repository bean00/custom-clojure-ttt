(ns custom-clojure-ttt.valid_move_handler)

(def valid-moves
  #{:1 :2 :3
    :4 :5 :6
    :7 :8 :9})

(defn get-valid-moves
  [side-length]
  valid-moves)

