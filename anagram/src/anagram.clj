(ns anagram
  (:require [clojure.string :as s]))

(defn anagram-filter
  "Predicate for anagrams-for function"
  [werd anag]
  (let [lwerd (s/lower-case werd)
        lanag (s/lower-case anag)]
   (and (not= lwerd lanag)
        (= (sort lwerd) (sort lanag)))))

(defn anagrams-for 
  "Selects anagrams of a supplied word from a supplied collection"
  [werd coll]
  (filter (partial anagram-filter werd) coll))
