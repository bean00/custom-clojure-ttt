(ns custom-clojure-ttt.valid_move_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.valid_move_handler :refer :all]))

(deftest set-valid-moves-test
  (testing "when a side length is passed in"
    (is (= #{:1 :2 :3 :4 :5 :6 :7 :8 :9}
           (set-valid-moves :3))
        "it returns the valid moves")))

