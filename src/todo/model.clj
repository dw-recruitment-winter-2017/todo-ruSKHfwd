(ns todo.model
   (:require [clojure.java.jdbc :as jdbc]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/todo"))
(defn all []
   (into [] (jdbc/query spec ["SELECT * FROM todos ORDER BY completed ASC, id ASC"])))
