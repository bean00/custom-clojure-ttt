(ns custom-clojure-ttt.winning_move_handler)

(def winning-rows-3x3
  (list #{:1 :2 :3}
        #{:4 :5 :6}
        #{:7 :8 :9}))

(def winning-columns-3x3
  (list #{:1 :4 :7}
        #{:2 :5 :8}
        #{:3 :6 :9}))

(def winning-diagonals-3x3
  (list #{:1 :5 :9}
        #{:3 :5 :7}))

(def winning-moves-3x3
  (concat winning-rows-3x3 winning-columns-3x3 winning-diagonals-3x3))


(def winning-rows-4x4
  (list #{ :1  :2  :3  :4}
        #{ :5  :6  :7  :8}
        #{ :9 :10 :11 :12}
        #{:13 :14 :15 :16}))

(def winning-columns-4x4
  (list #{:1 :5  :9 :13}
        #{:2 :6 :10 :14}
        #{:3 :7 :11 :15}
        #{:4 :8 :12 :16}))

(def winning-diagonals-4x4
  (list #{:1 :6 :11 :16}
        #{:4 :7 :10 :13}))

(def winning-moves-4x4
  (concat winning-rows-4x4 winning-columns-4x4 winning-diagonals-4x4))


(def winning-moves
  {:3 winning-moves-3x3
   :4 winning-moves-4x4})

(defn get-winning-moves
  [side-length]
  (if (not= side-length :default-size)
    (side-length winning-moves)
    (:3 winning-moves)))

