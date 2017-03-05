(ns todo.app
  (:use [hiccup core page])
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [todo.router :as router]
            [clojure.java.jdbc :as jdbc]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  router/routes
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
