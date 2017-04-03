(ns nucleotide-count)

(def empty-count {\A 0 \T 0 \C 0 \G 0})

(defn nucleotide-counts
  "Returns a map containing the number of occurances of each base"
  [dna-string]
  (reduce #(assoc %1 %2 (inc (%1 %2))) empty-count dna-string))

(defn count
  "Returns the number of a supplied base in a supplied string"
  [base dna-string]
  (if (not (contains? empty-count base))
    (throw (Exception. "Invalid base!"))
    ((nucleotide-counts dna-string) base)))
