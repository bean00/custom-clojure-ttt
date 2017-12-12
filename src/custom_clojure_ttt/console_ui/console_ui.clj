(ns custom-clojure-ttt.console_ui.console_ui
  (:require [custom-clojure-ttt.console_ui.console_ui_game_setup :as ui_game_setup]
            [custom-clojure-ttt.console_ui.input_output :as io]
            [clojure-tic-tac-toe.game_handler :as game_handler]))

(defn- int-to-keyword
  [number]
  (keyword (str number)))

(defn- get-side-length
  [args]
  (let [length (first args)]
    (if-not (nil? length)
      (int-to-keyword length)
      :default-size)))

(defn- create-starting-game-state
  [side-length]
  (let [game-mode (ui_game_setup/perform-setup)
        valid-moves (ui_game_setup/get-valid-moves side-length)
        winning-moves (ui_game_setup/get-winning-moves side-length)
        move-strategies (ui_game_setup/decide-strategies game-mode)
        starting-game-state (game_handler/create-game-state
                              game_handler/empty-board :X false
                              valid-moves winning-moves move-strategies)]
    starting-game-state))

(defn- create-initial-data []
  (let [create-view (ui_game_setup/get-create-view)
        initial-data (game_handler/create-initial-data create-view)]
    initial-data))

(defn- play-round
  [game-state initial-data]
  (let [get-move (game_handler/get-move-strategy game-state)
        move (get-move game-state)
        next-game-state (game_handler/add-move game-state move)
        create-view (game_handler/get-create-view initial-data)]
    (io/display-board next-game-state create-view)
    next-game-state))

(defn- play-all-rounds
  [starting-game-state initial-data]
  (loop [updated-game-state (play-round starting-game-state initial-data)]
    (if (game_handler/finished? updated-game-state)
      updated-game-state
      (recur (play-round updated-game-state initial-data)))))

(defn play-game [& args]
  (let [side-length (get-side-length (flatten args))
        starting-game-state (create-starting-game-state side-length)
        initial-data (create-initial-data)
        create-view (game_handler/get-create-view initial-data)
        _ (ui_game_setup/display-instructions create-view)
        final-game-state (play-all-rounds starting-game-state initial-data)
        winner (game_handler/get-winner final-game-state)]
   (io/display-game-over-message winner)))

