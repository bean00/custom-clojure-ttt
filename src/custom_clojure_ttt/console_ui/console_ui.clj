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

(defn- get-starting-player
  [game-mode move-order]
  (if (and (= game-mode :computer)
           (= move-order :2))
    :O
    :X))

(defn- perform-setup
  [args]
  (let [side-length (get-side-length (flatten args))
        _ (io/display-introduction)
        game-mode (ui_game_setup/get-game-mode)
        move-order (ui_game_setup/get-move-order game-mode)
        starting-player (get-starting-player game-mode move-order)]
    { :side-length side-length
      :game-mode game-mode
      :starting-player starting-player }))


(defn- create-initial-data
  [{:keys [side-length game-mode]}]
  (let [valid-moves (ui_game_setup/get-valid-moves side-length)
        winning-moves (ui_game_setup/get-winning-moves side-length)
        move-strategies (ui_game_setup/decide-strategies game-mode)
        create-view (ui_game_setup/get-create-view side-length)
        initial-data (game_handler/create-initial-data
                       valid-moves winning-moves move-strategies create-view)]
    initial-data))


(defn- create-starting-game-state
  [{:keys [starting-player]}]
  (game_handler/create-game-state game_handler/empty-board starting-player false))


(defn- display-board
  [game-state {:keys [create-view]}]
  (io/display-board game-state create-view))

(defn- play-round
  [game-state initial-data]
  (let [get-move (game_handler/get-move-strategy game-state initial-data)
        move (get-move game-state initial-data)
        next-game-state (game_handler/add-move game-state initial-data move)
        _ (display-board next-game-state initial-data)]
    next-game-state))

(defn- play-all-rounds
  [starting-game-state initial-data]
  (loop [updated-game-state (play-round starting-game-state initial-data)]
    (if (:finished? updated-game-state)
      updated-game-state
      (recur (play-round updated-game-state initial-data)))))


(defn- display-instructions
  [{:keys [create-view]}]
  (ui_game_setup/display-instructions create-view))

(defn- display-game-over-message
  [game-state {:keys [winning-moves]}]
  (let [winner (game_handler/get-winner game-state winning-moves)]
    (io/display-game-over-message winner)))

(defn play-game
  [& args]
  (let [setup-data (perform-setup args)
        initial-data (create-initial-data setup-data)
        starting-game-state (create-starting-game-state setup-data)
        _ (display-instructions initial-data)
        final-game-state (play-all-rounds starting-game-state initial-data)
        _ (display-game-over-message final-game-state initial-data)]))

