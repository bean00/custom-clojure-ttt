(ns custom-clojure-ttt.console_ui.console_ui_game_mode
  (:require [custom-clojure-ttt.console_ui.input_output :as io]))

(def valid-game-modes #{:h :c})

(defn- is-input-invalid?
  [valid-input-values input]
  (not (contains? valid-input-values input)))

(defn get-valid-game-mode []
  (loop [mode (io/get-initial-input)]
    (if (is-input-invalid? valid-game-modes mode)
      (recur (io/get-game-mode mode))
      mode)))

