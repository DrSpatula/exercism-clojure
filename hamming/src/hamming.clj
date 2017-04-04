(ns hamming)

(defn fold
  [dist [a,b]]
  (if (= a b) dist (inc dist)))

(defn distance
  "Computes the Hamming Distance between two DNA strings"
  [str-a str-b]
  (when (= (count str-a) (count str-b))
    (reduce fold 0 (map vector str-a str-b))))
