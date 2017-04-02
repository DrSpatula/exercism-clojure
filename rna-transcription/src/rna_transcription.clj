(ns rna-transcription)

(def valid-bases #{\A \T \G \C})

(def valid-dna?
  "Tests a DNA string for invalid bases"
  (partial every? (partial contains? valid-bases)))

(defn convert-base
  "Converts a single DNA base to its RNA counterpart"
  [dna-base]
  (case dna-base
    \G \C
    \C \G
    \T \A
    \A \U))

(defn to-rna 
  "Transcribe a DNA string to RNA"
  [dna-string]
  (if (not (valid-dna? dna-string))
    (throw (AssertionError. "Invalid DNA String"))
    (apply str (map convert-base dna-string))))
