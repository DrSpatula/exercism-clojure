(ns phone-number)

(def invalid-number "0000000000")

(defn clean-number
  "Takes phone numbers string and returns only its digits"
  [pn]
  (apply str (re-seq #"\d+" pn)))

(defn number
  "Returns nine digit numbers from a phone number string"
  [pn]
  (let [cpn (clean-number pn)] 
    (cond
      (and 
        (= (count cpn) 11) 
        (= (first cpn) \1)) (apply str (rest cpn))
      (= (count cpn) 10) cpn
      :else invalid-number)))

(defn area-code
  "Returns the three digit area code from a phone number string"
  [pn]
  (-> pn 
      number 
      (subs 0 3)))

(defn pretty-print
  "Returns a nicely formatted phone number string"
  [pn]
  (let [phnum (number pn)
        ac (area-code pn)
        start (subs phnum 3 6)
        end (subs phnum 6)]
    (str "(" ac ") " start "-" end)))
