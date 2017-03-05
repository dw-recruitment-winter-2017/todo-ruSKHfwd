(ns todo.migration
  (:require [clojure.java.jdbc :as jdbc]
            [todo.handler :as todo]))

(defn migrated? []
  (-> (jdbc/query todo/spec
                 [(str "select count(*) from information_schema.tables "
                       "where table_name='todos'")])
      first :count pos?))

(defn drop_table []
  (jdbc/db-do-commands todo/spec
                       (jdbc/drop-table-ddl
                         :todos)))
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
  (when (migrated?)
    (drop_table))
  (create_table)
  (jdbc/insert! todo/spec :todos {:body "First ToDo" :completed true})
  (jdbc/insert! todo/spec :todos {:body "Second ToDo" :completed false})
  (jdbc/insert! todo/spec :todos {:body "Third ToDo" :completed false})
  (jdbc/insert! todo/spec :todos {:body "Fourth ToDo" :completed true}))
