(ns custom-clojure-ttt.console_ui.console_ui
  (:require [custom-clojure-ttt.console_ui.console_ui_game_setup :as ui_game_setup]
            [custom-clojure-ttt.console_ui.input_output :as io]
            [clojure-tic-tac-toe.game_handler :as game_handler]))

(defn get-side-length
  [args]
  (first args))

(defn- play-round
  [game-state]
  (let [get-move (game_handler/get-move-strategy game-state)
        move (get-move game-state)
        next-game-state (game_handler/add-move game-state move)]
    (io/display-board next-game-state)
    next-game-state))

(defn- play-all-rounds
  [starting-game-state]
  (loop [updated-game-state (play-round starting-game-state)]
    (if (game_handler/finished? updated-game-state)
      updated-game-state
      (recur (play-round updated-game-state)))))

(defn play-game [& args]
  (println "-> DEBUG: Argument(s): " (flatten args))
  (let [; game-mode (ui_game_setup/get-game-mode
        game-mode (ui_game_setup/set-up-game) ; remove this line
        ; (ui_game_setup/display-instructions)
        move-strategies (ui_game_setup/decide-strategies game-mode)
        ; valid-moves (ui_game_setup/get-valid-moves
        starting-game-state (game_handler/create-game-state move-strategies)
        final-game-state (play-all-rounds starting-game-state)
        winner (game_handler/get-winner final-game-state)]
   (io/display-game-over-message winner)))

