(defproject custom-clojure-ttt "0.1.0-SNAPSHOT"
  :description "Custom Tic Tac Toe written in Clojure"
  :url "https://github.com/bean00/custom-clojure-ttt.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [clojure-tic-tac-toe "0.1.0-SNAPSHOT"]]
  :profiles {:dev {:source-paths ["startup"]}
             :uberjar {:aot :all}}
  :target-path "target/%s"
  :main ^:skip-aot custom-clojure-ttt.core)
