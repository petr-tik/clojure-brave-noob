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

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I am a little teapot")
  (solveMeFirst 5 10)
  (println (error-message :mild))
  (error-message :hard)
)

