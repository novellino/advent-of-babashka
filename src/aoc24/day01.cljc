(ns aoc24.day01
  (:require #?(:clj [clojure.java.io :as io]
               :cljs [nbb.core :refer [slurp await]])
            [clojure.string :as str]
            #?(:cljs [promesa.core :as p])))

;; #?(:clj
;;    (def input (->> (slurp (io/resource "aoc24/day01.txt"))
;;                    (str/split-lines)
;;                    (map parse-long)))
;;    :cljs
;;    (def input (await (p/->> (slurp "resources/aoc24/day01.txt")
;;                             (str/split-lines)
;;                             (map parse-long)))))

(def input
  (->> (slurp (io/resource "aoc24/day01.txt"))
       str/split-lines
       (map #(str/split % #"\s+"))  ; split on whitespace
       (map #(mapv parse-long %))))  ; convert strings to numbers

(defn part-1
  "Run with (n)bb -x aoc24.day01/part-1"
  [_]
  (let [x (sort (mapv first input))
        y (sort (mapv second input))]
    (->> (interleave x y)
         (partition 2)
         (map (fn [[x y]] (- y x)))
         (map abs)
         (apply +)
         prn)))

(defn part-2
  "Run with (n)bb -x aoc24.day02/part-2"
  [_]
  (->> input
       prn))

;; Test it:
(comment
  (first input)  ; should give you [77710 11556]
  (second input) ; should give you [22632 23674]
                                        ;
  (def ex (take 10 input)))
