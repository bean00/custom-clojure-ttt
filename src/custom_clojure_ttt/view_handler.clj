(ns custom-clojure-ttt.view_handler
  (:require [clojure-tic-tac-toe.game_handler :as game_handler]
            [clojure-tic-tac-toe.utilities :refer [join-lines]]))

(def tokens-3x3 {:1 "1", :2 "2", :3 "3"
                 :4 "4", :5 "5", :6 "6"
                 :7 "7", :8 "8", :9 "9"
                 :X "X", :O "O"})

(defn- create-row-3x3
  [game-state token-key-1 token-key-2 token-key-3]
  (format " %s | %s | %s ",
          ((game_handler/token-at game-state token-key-1) tokens-3x3),
          ((game_handler/token-at game-state token-key-2) tokens-3x3),
          ((game_handler/token-at game-state token-key-3) tokens-3x3)))

(defn create-view-3x3
  [game-state]
  (join-lines [(create-row-3x3 game-state :1 :2 :3)
               "---+---+---"
               (create-row-3x3 game-state :4 :5 :6)
               "---+---+---"
               (create-row-3x3 game-state :7 :8 :9)]))


(def tokens-4x4 { :1 "1 ",  :2 "2 ",  :3 "3 ",  :4 "4 "
                  :5 "5 ",  :6 "6 ",  :7 "7 ",  :8 "8 "
                  :9 "9 ", :10 "10", :11 "11", :12 "12"
                 :13 "13", :14 "14", :15 "15", :16 "16"
                  :X "X ",  :O "O "})

(defn- create-row-4x4
  [game-state token-key-1 token-key-2 token-key-3 token-key-4]
  (format " %s| %s| %s| %s",
          ((game_handler/token-at game-state token-key-1) tokens-4x4),
          ((game_handler/token-at game-state token-key-2) tokens-4x4),
          ((game_handler/token-at game-state token-key-3) tokens-4x4),
          ((game_handler/token-at game-state token-key-4) tokens-4x4)))

(defn create-view-4x4
  [game-state]
  (join-lines [(create-row-4x4 game-state  :1  :2  :3  :4)
               "---+---+---+---"
               (create-row-4x4 game-state  :5  :6  :7  :8)
               "---+---+---+---"
               (create-row-4x4 game-state  :9 :10 :11 :12)
               "---+---+---+---"
               (create-row-4x4 game-state :13 :14 :15 :16)]))


(def create-view
  {:3 create-view-3x3
   :4 create-view-4x4})

(defn get-create-view
  [side-length]
  (if (not= side-length :default-size)
    (side-length create-view)
    (:3 create-view)))

