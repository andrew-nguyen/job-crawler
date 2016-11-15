(ns job-crawler.crawler)

(defprotocol Crawler
  (fetch [c] "slurps the specified crawler")
  (extract [c] "parses/extracts html"))
