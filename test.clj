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

((complement empty?) [])
;; false

(for [a [1 2] b [\a \b]]
  (str a \, b))
;; ("1,a" "1,b" "2,a" "2,b")

(for [n '(0 1 2 3 4)
  :let [x (* n n)]
  :when (odd? n)] x)
;; (1 9)

(into (sorted-map) {3 4, 2 3})
;; {2 3, 3 4}

(partition 2 (take 5 (range)))
;; ((0 1) (2 3))

(partition-all 2 (take 5 (range)))
;; ((0 1) (2 3) (4))

(partition-by #(= (mod % 3) 0) (take 10 (range)))
;; ((0) (1 2) (3) (4 5) (6) (7 8) (9))

(def an-atom (atom 0))
(swap! an-atom #(+ 1 %))
(swap! an-atom #(+ 1 %))
@an-atom
;; 2