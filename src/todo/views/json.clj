(ns todo.views.json
  (:require [ring.util.response :refer :all]
            [cheshire.core :refer :all]))

(defn index [todos]
  (generate-string todos))

(defn show [todo]
  (generate-string todo))

(defn create [arg]
  (when (= :success arg)
    (created "/" "ToDo created")))

(defn update_complete [arg]
  (when (= :success arg)
    (status (response "ToDo updated") 204)))

(defn delete [arg]
  (when (= :success arg)
    (status (response "ToDo deleted") 204)))
