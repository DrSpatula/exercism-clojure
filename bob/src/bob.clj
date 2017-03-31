(ns bob
  (:require [clojure.string :as s]))

(defn extract-alpha
  "Removes all non-alphabetical characters from a string"
  [input]
  (apply str (re-seq #"[a-zA-Z]+" input)))

(defn shouting?
  "Is someone shouting at Bob?"
  [input]
  (let [text (extract-alpha input)]
    (and (not (= text "")) (= text (s/upper-case text)))))

(defn question?
  "Is Bob being asked a question?"
  [input]
  (= \? (last (s/trim input))))

(defn silence?
  "Is Bob being given the silent treatment?"
  [input]
  (= "" (s/trim input)))

(defn response-for
  "Get Bob's response"
  [input]
  (cond
    (shouting? input) "Whoa, chill out!"
    (question? input) "Sure."
    (silence?  input) "Fine. Be that way!"
    :else "Whatever."))


