(ns job-crawler.http
  (:require [clj.http-client :as client]))

(def user-agent "Mozilla/5.0 (Windows NT 6.1;) Gecko/20100101 Firefox/13.0.1")

(def default-headers {"User-Agent" user-agent})

(defn follow-link
  [url & [headers]]
  (client/get url {:headers (merge default-headers headers)}))
