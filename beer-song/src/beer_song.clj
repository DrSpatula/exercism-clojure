(ns beer-song
  (:require [clojure.string :as s]))

(defn bottle
  "Gives correct phrase for the supplied number of bottles"
  [num-bottles]
  (cond
    (= num-bottles 1) "1 bottle"
    (= num-bottles 0) "no more bottles"
    :else (str num-bottles " bottles")))

(defn first-line
  [num-bottles]
  "Returns the first line of a beer song stanza for the given number of bottles"
  (let [bottles (bottle num-bottles)]
    (str bottles " of beer on the wall, " bottles " of beer.\n")))

(defn second-line
  "Returns the second line of a beer song stanza for the given number of bottles"
  [num-bottles]
  (let [pronoun (if (= num-bottles 1) "it" "one")]
    (str "Take " pronoun " down and pass it around, " (bottle (dec num-bottles)) " of beer on the wall.\n")))

(defn stanza
  "Returns a complete stanza for one or more bottles"
  [num-bottles]
  (str (first-line num-bottles) (second-line num-bottles)))

(defn final-stanza
  "Returns the stanza for zero bottles"
  []
  (let [line (first-line 0)
        fline (str (s/upper-case (str (first line))) (apply str (rest line)))]
    (str fline "Go to the store and buy some more, 99 bottles of beer on the wall.\n")))

(defn verse
  "Returns verse for the supplied number of bottles"
  [num-bottles]
  (cond
    (= num-bottles 0) (final-stanza)
    :else (stanza num-bottles)))

(defn sing
  "Returns the specified range of verses"
  ([start] (sing start 0))
  ([start end]
   (let [vnums (range start (dec end) -1)]
    (s/join "\n" (map verse vnums)))))
