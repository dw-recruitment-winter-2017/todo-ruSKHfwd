(ns todo.migration
  (:require [clojure.java.jdbc :as jdbc]
            [todo.handler :as todo]))

(defn create_table []
    (jdbc/db-do-commands todo/spec
                         (jdbc/create-table-ddl
                           :todos
                           [:id :serial "PRIMARY KEY"]
                           [:completed :boolean]
                           [:body :varchar "NOT NULL"]
                           [:created_at :timestamp
                            "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn migrate []
  (create_table)
  (jdbc/insert! todo/spec :todos {:body "ToDo" :completed true}))
