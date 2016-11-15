(defproject job-crawler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]

                 ; http client
                 [clj-http "1.0.1"]

                 ; for benchmarking code
                 [criterium "0.4.3"]

                 ; scraping library
                 [enlive "1.1.5"]]

  :repl-options {:init-ns job-crawler.core}

  :main ^:skip-aot job-crawler.core

  :target-path "target/%s"

  :profiles {:uberjar {:aot :all}})