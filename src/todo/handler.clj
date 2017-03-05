(ns todo.handler
  (:use [hiccup core page])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.java.jdbc :as jdbc]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/todo"))

(defn all-todos []
  (into [] (jdbc/query spec ["SELECT * FROM todos"])))

(defn about []
  (html5
    [:head
      [:title "About"]]
    [:body
      [:h1 "About"]
      [:p "This is an attempt to build something on the web in Clojure."]
      [:p "I'm not very good at it yet, but it seems interesting."]
      [:p "I'll try to add some more useful thoughts to the README."]
      [:img {:src "https://media.tenor.co/images/0ab463b889266a020b2e43272cdcfe4d/raw"}]]))

(defn index []
  (html5
    [:head
     [:title "Index"]]
    [:body
     [:h1 "Index"
      [:h2 (h (first (all-todos)))]]]))

(defroutes app-routes
  (GET "/" [] (index))
  (GET "/about" [] (about))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
