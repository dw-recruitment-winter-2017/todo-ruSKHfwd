(ns todo.handler
  (:use [hiccup core page])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

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

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/about" [] (about))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
