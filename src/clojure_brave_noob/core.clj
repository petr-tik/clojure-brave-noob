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


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I am a little teapot")
  (solveMeFirst 5 10)
  (println (error-message :mild))
  (error-message :hard)
  (time (vampire-related-details 0)))