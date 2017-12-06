(ns custom-clojure-ttt.valid_move_handler)

(def more_valid_moves
  { :3 #{:1 :2 :3
         :4 :5 :6
         :7 :8 :9} })

(defn set-valid-moves
  [side-length]
  (side-length more_valid_moves))

