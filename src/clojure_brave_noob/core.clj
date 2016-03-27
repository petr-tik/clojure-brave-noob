(ns clojure-brave-noob.core
  (:gen-class))

(defn solveMeFirst [x y]
    (println (+ x y)))

(defn error-message 
    [severity]
    (str "OH MY GOD! "
        (if (= severity :mild)
        "This is a minor inconvinience"
        "This shit is getting serious")))

(defn element-print 
    [times elements]
    (println))

(defn dec-maker
  "takes a value and returns a function that decreases any new number by value"
  [value]
  ;; returns a anonymous function that takes takes input instead of % 
  #(- % value))


(defn mapset
  "takes a sequence and returns a set of unique values"
  [coll]
  (map set coll))


(def vampire-database
{
    0 {:makes-blood-puns? false, :has-pulse? true :name "lad"}
    1 {:makes-blood-puns? false, :has-pulse? true :name "bob"}
    2 {:makes-blood-puns? true, :has-pulse? false :name "john"}
    3 {:makes-blood-puns? true, :has-pulse? true :name "Petr"}})

(defn vampire-related-details
    [social-security-number]
    (Thread/sleep 1000)
    (get vampire-database social-security-number))

(defn vampire?
    [suspect]
    (and (:makes-blood-puns? suspect)
            (not (:has-pulse? suspect))
        suspect))

(defn identify-vampire
    [social-security-numbers]
    (first (filter vampire?
        (map vampire-related-details social-security-numbers)))
    )


(def filename "suspects.csv")

;; vector of keys needed to create a vampire own map
(def vamp-keys [:name :glitter-index])

;; conversts string to integer
(defn str->int
  [str]
  (Integer. str))

;; associates a function with each vamp key - 
;; leave name intact, convert numbers to string
(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows and columns"
  [string] ;; csv slurped as string
  (map #(clojure.string/split % #",")
    (clojure.string/split string #"\n")))

(defn mapify 
  "Return a seq of maps in form
  {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
      (reduce (fn [row-map [vamp-key value]]
        (assoc row-map vamp-key (convert vamp-key value)))
      {}
      (map vector vamp-keys unmapped-row)))
  rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn glitter-names
  "returns a list of names given a hashmap of records and minimum glitter level"
  [minimum-glitter records]
  (map :name (glitter-filter minimum-glitter records)))

(defn validate
  [record]
  (if (map (fn [x] (contains? record x)) vamp-keys)
    record 
    "Doesn't validate"))

(defn append
  "Adds a new map to a seq of maps"
  [new-suspect old-suspects]
  (conj old-suspects (map identity new-suspect)))


(defn -main
  [& args]
  println "hello"

  )