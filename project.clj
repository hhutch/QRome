(defproject qrome "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [enfocus "0.9.1-SNAPSHOT"]
                 [jayq "0.1.0-alpha2"]
                 [core.logic "0.7.0"]]
  :plugins [[lein-cljsbuild "0.1.8"]]
  :cljsbuild {
              :builds [{:source-path "src/qrome"
                        :compiler {:output-to "resources/qrome.js"
                                   :optimizations :simple
                                   :pretty-print true}}]})
