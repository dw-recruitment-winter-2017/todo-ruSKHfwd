(ns todo.migration
  (:require [clojure.java.jdbc :as jdbc]
            [todo.model :as model]))

(defn migrated? []
  (-> (jdbc/query model/spec
                 [(str "select count(*) from information_schema.tables "
                       "where table_name='todos'")])
      first :count pos?))

(defn drop_table []
  (jdbc/db-do-commands model/spec
                       (jdbc/drop-table-ddl
                         :todos)))
(defn create_table []
    (jdbc/db-do-commands model/spec
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
  (jdbc/insert! model/spec :todos {:body "First ToDo" :completed true})
  (jdbc/insert! model/spec :todos {:body "Second ToDo" :completed false})
  (jdbc/insert! model/spec :todos {:body "Third ToDo" :completed false})
  (jdbc/insert! model/spec :todos {:body "Fourth ToDo" :completed true}))
