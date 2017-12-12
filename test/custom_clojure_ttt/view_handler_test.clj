(ns custom-clojure-ttt.view_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure-tic-tac-toe.default_view :as default_view]
            [clojure-tic-tac-toe.game_handler :as game_handler]
            [clojure-tic-tac-toe.utilities :refer [join-lines]]
            [custom-clojure-ttt.view_handler :refer :all]))

(deftest get-create-view-test
  (testing "when getting the create view function"
    (is (= default_view/create-view
           (get-create-view))
        "it returns the function")))

