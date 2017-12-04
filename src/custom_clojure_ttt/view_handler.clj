(ns custom-clojure-ttt.view_handler
  (:require [clojure-tic-tac-toe.default_view :as default_view]
            [clojure-tic-tac-toe.game_handler :as game_handler]
            [clojure-tic-tac-toe.utilities :refer [join-lines]]))

(def create-view
  default_view/create-view)

(defn get-create-view []
  default_view/create-view)

