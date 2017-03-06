(ns todo.views.json
  (:require [ring.util.response :refer :all]
            [cheshire.core :refer :all]))

(defn index [todos]
  (generate-string todos))

(defn new [arg]
  (when (= :success arg)
    (created "/" "ToDo created")))
