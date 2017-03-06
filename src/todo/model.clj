(ns todo.model
   (:require [clojure.java.jdbc :as jdbc]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/todo"))

(defn display-for [todos]
  (map
    (fn [todo]
      {:id (:id todo)
      :body (:body todo)
      :completed (:completed todo)})
    todos))

(defn all []
  (display-for
    (into []
          (jdbc/query
            spec
            ["SELECT * FROM todos ORDER BY completed ASC, id ASC"]))))

(defn find_by [id]
  (display-for
    (jdbc/query spec ["SELECT * FROM todos WHERE id = ?" (read-string id)])))

(defn create [body]
  (jdbc/insert! spec :todos body)
  :success)

(defn update_complete [body]
  (let [{completed "completed", id "id"} body]
  (jdbc/update! spec :todos {"completed" completed} ["id = ?" id]))
  :success)

(defn delete [body]
  (let [{id "id"} body]
  (jdbc/delete! spec :todos ["id = ?" id]))
  :success)
