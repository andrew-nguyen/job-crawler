(ns job-crawler.indeed
  (:require [clojure.string :refer [trim]]
            [net.cgrand.enlive-html :as html]

            [job-crawler.crawler :refer [Crawler]]))

(defrecord IndeedCrawler [base-url resource])

(declare extract)

(extend-type IndeedCrawler
  Crawler
  (fetch [c] "")

  (extract [c] (extract c)))

(defn text-or-content
  [e]
  (if (map? e)
    (first (:content e))
    e))

(defn text
  "Since indeed breaks down their results into individual resut div's, we use
  that to simplify the extraction process"
  [result selector]
  (apply str
    (mapv
      html/text
      (html/select result (concat selector [:> html/any-node])))))

(defn company
  [result]
  (text result [:.company]))

(defn title
  [result]
  (clojure.string/trim (text result [:.jobtitle])))

(defn link
  [result base-url]
  (str base-url
       (first
         (html/attr-values
           (first (html/select result [:a]))
           :href))))

(defn num-links
  [result]
  (count
    (html/attr-values
      (first (html/select result [:a]))
      :href)))

(defn job-map
  [base-url result]
  {:job-title (trim (title result))
   :company   (trim (company result))
   :link      (trim (link result base-url))
   :num-links (num-links result)
   })

(defn extract
  "extracts relevant info from provided html"
  [c]
  (let [resource (:resource c)
        base-url (:base-url c)
        dom-tree (html/html (html/html-resource resource))
        results (html/select dom-tree [:div.result])]
    (mapv (partial job-map base-url) results)))

(comment "sample/test code for use with repl"

  (extract (->IndeedCrawler "http://www.indeed.com"
                            (clojure.java.io/as-file "samples/q-health-informatics-jobs.html")))

  )
