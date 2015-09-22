(if-let [n1 (first [1])] (str "it was " n1) "it was nothing")
;; "it was1"

(every? #(< % 10) '(1 2 3 4))
;; true

(some nil? #{1 2 3 4 nil})
;; true

(def uno-sobre (partial / 1))
(uno-sobre 2)
;; 1/2

(def reverse-upper (comp reverse clojure.string/upper-case))
(reverse-upper "asd")
;; (\D \S \A)

(let [[one two :as original] [1 2 3 4]] (str one \, two \: original))
;; "1,2:[1 2 3 4]"

(take 10 (rest (range)))
;; (1 2 3 4 5 6 7 8 9 10)

(defn factorial [n]
  (loop [x n acum 1]
    (if (= x 0) acum
      (recur (dec x) (* x acum)))))
(factorial 3)
;; 6
(factorial 4)
;; 24

(map #(str %1 \, %2) [\a \b \c] (range))
;; ("a,0" "b,1" "c,2")

(reduce str (take 4 (range)))
;; "0123"

((complement empty?) [])
;; false

(remove even? [1 2 3 4 5 6])
;; (1 3 5)

(filter even? [1 2 3 4 5 6])
;; (2 4 6)

(filter (complement nil?) [1 2 nil 3 4])
;; (1 2 3 4)


(for [a [1 2] b [\a]]
  (str a \, b))
;; ("1,a" "2,a")

(for [n '(0 1 2 3 4)
  :let [x (* n n)]
  :when (odd? n)] x)
;; (1 9)

(vec '(1 2 3))
;; [1 2 3]

(into (sorted-map) {3 4, 2 3})
;; {2 3, 3 4}

(into (sorted-map) [[3 4] [2 3]])
;; {2 3, 3 4}

(partition 2 (take 5 (range)))
;; ((0 1) (2 3))

(partition-all 2 (take 5 (range)))
;; ((0 1) (2 3) (4))

(partition-by #(= (mod % 3) 0) (take 10 (range)))
;; ((0) (1 2) (3) (4 5) (6) (7 8) (9))

(def an-atom (atom 0))
(swap! an-atom #(+ 1 %))
(swap! an-atom inc)
@an-atom
;; 2

(dotimes [i 6] (print i))
;; stdout = 012345

