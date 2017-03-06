(ns todo.app
  (:use [hiccup core page])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [todo.router :as router]
            [clojure.java.jdbc :as jdbc]
            [ring.middleware.json :refer :all]
            [ring.middleware.defaults :refer :all]))

(defroutes app-routes
  router/routes
  (route/not-found "Not Found"))

(defn handler [request]
  (prn (get-in request [:body "user"])))

(def app
  (-> app-routes
      (wrap-json-body handler)
      (wrap-defaults api-defaults)))
