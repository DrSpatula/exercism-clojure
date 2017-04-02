(ns word-count
  (:require [clojure.string :as s]))

(defn word-count 
  "Returns a map with words as keys and their number of occurances as values"
  [input-string]
  (let [wrds (re-seq #"[A-Za-z0-9']+" (s/lower-case input-string))]
    (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} wrds)))
