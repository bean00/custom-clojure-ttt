(ns custom-clojure-ttt.valid_move_handler)

(def valid-moves-on-3x3
  #{:1 :2 :3
    :4 :5 :6
    :7 :8 :9})

(def valid-moves-on-4x4
  #{ :1  :2  :3  :4
     :5  :6  :7  :8
     :9 :10 :11 :12
    :13 :14 :15 :16})

(def valid-moves
  {:3 valid-moves-on-3x3
   :4 valid-moves-on-4x4})

(defn get-valid-moves
  [side-length]
  (if (not= side-length :default-size)
    (side-length valid-moves)
    (:3 valid-moves)))

