(ns custom-clojure-ttt.console_ui.input_output
  (:require [clojure.string :as str]
            [clojure-tic-tac-toe.utilities :refer [join-lines]]
            [custom-clojure-ttt.view_handler :as view]))

(defn display-introduction []
  (println "This is a Tic Tac Toe program.\n"))

(defn display-game-mode-instructions []
  (println (join-lines ["Please enter one of the following:"
                        "- \"h\" to play another person"
                        "- \"c\" to play against a computer\n"])))


(defn- display-simple-prompt []
  (print "> "))

(defn- get-input []
  (flush)
  (keyword (str/trim (read-line))))

(defn get-initial-input []
  (display-simple-prompt)
  (get-input))


(defn- display-invalid-game-mode-message
  [mode]
  (printf "\n<!> Error: Game mode \"%s\" is invalid.", (name mode))
  (printf " Must be a choice from above."))

(defn- prompt-player-for-game-mode []
  (printf "\nPlease enter the game mode: "))

(defn get-game-mode
  [mode]
  (display-invalid-game-mode-message mode)
  (prompt-player-for-game-mode)
  (get-input))


(defn display-move-order-instructions []
  (println (join-lines ["\nPlease choose the move order:"
                        "- \"1\" to go first"
                        "- \"2\" to go second\n"])))


(defn- display-invalid-move-order-message
  [order]
  (printf "\n<!> Error: Move order \"%s\" is invalid.", (name order))
  (printf " Must be 1 or 2."))

(defn- prompt-player-for-move-order []
  (printf "\nPlease enter the move order: "))

(defn get-move-order
  [order]
  (display-invalid-move-order-message order)
  (prompt-player-for-move-order)
  (get-input))


(defn display-game-instructions []
  (println (join-lines ["\nTo enter a move, type a number."
                        "It will be added to the board based on"
                        "the following positions:\n"])))


(defn- prompt-player-for-move
  [player]
  (printf "\nPlayer %s, please enter your move: ", (name player)))

(defn get-move
  [player]
  (prompt-player-for-move player)
  (get-input))


(defn- display-invalid-move-message
  [move]
  (printf "\n<!> Error: Move \"%s\" is invalid. Must be from 1-9.", (name move)))

(defn get-move-if-move-is-invalid
  [move player]
  (display-invalid-move-message move)
  (get-move player))


(defn- display-move-taken-message
  [move]
  (printf
    "\n<!> Error: Move \"%s\" was already taken. Must move to an open position.",
    (name move)))

(defn get-move-if-move-was-taken
  [move player]
  (display-move-taken-message move)
  (get-move player))


(defn display-computer-move-message []
  (println "\nThe computer moved."))


(defn display-board
  [game-state create-view]
  (println (create-view game-state)))


(defn display-game-over-message
  [winner]
  (if (contains? #{:X :O} winner)
    (println (format "\nGame over. Player %s won." (name winner)))
    (println "\nGame over. Ended in a tie.")))

