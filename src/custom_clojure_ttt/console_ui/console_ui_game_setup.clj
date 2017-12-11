(ns custom-clojure-ttt.console_ui.console_ui_game_setup
  (:require [custom-clojure-ttt.console_ui.console_ui_computer_move :as ui_comp_move]
            [custom-clojure-ttt.console_ui.console_ui_game_mode :as ui_game_mode]
            [custom-clojure-ttt.console_ui.console_ui_human_move :as ui_human_move]
            [custom-clojure-ttt.console_ui.input_output :as io]
            [clojure-tic-tac-toe.game_handler :as game_handler]
            [custom-clojure-ttt.valid_move_handler :as valid_move_handler]
            [custom-clojure-ttt.winning_move_handler :as winning_move_handler]))

(def game-mode-mapping
  { :h :human,
    :c :computer })

(defn- convert-game-mode
  [user-game-mode]
  (user-game-mode game-mode-mapping))

(defn perform-setup []
  (io/display-introduction)
  (io/display-game-mode-instructions)
  (let [user-game-mode (ui_game_mode/get-valid-game-mode)
        internal-game-mode (convert-game-mode user-game-mode)]
    (io/display-result-of-game-mode-choice internal-game-mode)
    internal-game-mode))


(defn get-valid-moves
  [side-length]
  (valid_move_handler/get-valid-moves side-length))


(defn get-winning-moves []
  (winning_move_handler/get-winning-moves))


(defn display-instructions []
  (io/display-game-instructions)
  (io/display-board game_handler/empty-board))


(defn decide-strategies
  [game-mode]
  (cond
    (= game-mode :human)
       {:X ui_human_move/get-human-move, :O ui_human_move/get-human-move}
    (= game-mode :computer)
       {:X ui_human_move/get-human-move, :O ui_comp_move/have-computer-move}))

