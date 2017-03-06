(defproject todo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler todo.app/app
         :init todo.migration/migrate}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [cheshire "5.7.0"]
                        [ring/ring-json "0.4.0"]
                        [ring/ring-mock "0.3.0"]]}})
