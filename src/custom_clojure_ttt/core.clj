(ns custom-clojure-ttt.core
  (:require [clojure-tic-tac-toe.console_ui.console_ui :as console_ui])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (console_ui/play-game))
