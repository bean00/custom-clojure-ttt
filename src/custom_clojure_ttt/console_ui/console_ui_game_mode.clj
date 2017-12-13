(ns custom-clojure-ttt.console_ui.console_ui_game_mode
  (:require [custom-clojure-ttt.console_ui.input_output :as io]))

(def valid-game-modes #{:h :c})

(def valid-move-orders #{:1 :2})

(defn- is-input-invalid?
  [valid-input-values input]
  (not (contains? valid-input-values input)))

(defn get-valid-game-input
  [valid-input-values get-game-input]
  (loop [input (io/get-initial-input)]
    (if (is-input-invalid? valid-input-values input)
      (recur (get-game-input input))
      input)))

(defn get-valid-game-mode []
  (get-valid-game-input valid-game-modes io/get-game-mode))

(defn get-valid-move-order []
  (get-valid-game-input valid-move-orders io/get-move-order))

