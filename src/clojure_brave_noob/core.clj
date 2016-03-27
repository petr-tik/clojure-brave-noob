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


(defn -main
  [& args]
  println "hello"
  )