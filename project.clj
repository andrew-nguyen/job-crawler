(defproject job-crawler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]

                 ; http client
                 [clj-http "3.3.0"]

                 ; for benchmarking code
                 [criterium "0.4.4"]

                 ; scraping library
                 [enlive "1.1.6"]]

  :repl-options {:init-ns job-crawler.core}

  :main ^:skip-aot job-crawler.core

  :target-path "target/%s"

  :profiles {:uberjar {:aot :all}})
