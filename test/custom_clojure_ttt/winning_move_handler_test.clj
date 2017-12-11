(ns custom-clojure-ttt.winning_move_handler_test
  (:require [clojure.test :refer [deftest testing is]]
            [custom-clojure-ttt.winning_move_handler :refer :all]))

(deftest get-winning-moves-test
  (testing "when the function is called"
    (is (= '(#{:1 :2 :3} #{:4 :5 :6} #{:7 :8 :9}
             #{:1 :4 :7} #{:2 :5 :8} #{:3 :6 :9}
             #{:1 :5 :9} #{:3 :5 :7})
           (get-winning-moves))
        "it returns the winning moves")))

