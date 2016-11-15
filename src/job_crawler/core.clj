(ns job-crawler.core
  (:require [clojure.java.io :refer [as-url]]
    
            [job-crawler.crawler :as c]
            [job-crawler.indeed :refer [->IndeedCrawler]])
  (:gen-class))

(defn -main
  "Fetches, and parses job info - currently only supports Indeed.com"
  [& args]
  (let [c (->IndeedCrawler "http://www.indeed.com"
                           (as-url "http://www.indeed.com/jobs?q=health+informatics&start=0"))]))
