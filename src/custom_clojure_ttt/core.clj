(ns custom-clojure-ttt.core
  (:require [clojure-tic-tac-toe.console_ui.console_ui :as console_ui])
  (:gen-class))

(defn -main
  "Custom Tic Tac Toe program."
  [& args]
  (console_ui/play-game))
