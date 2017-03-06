(ns todo.views.json
  (:require [cheshire.core :refer :all]))

(defn index [todos]
  (generate-string todos))
