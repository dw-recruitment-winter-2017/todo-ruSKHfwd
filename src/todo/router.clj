(ns todo.router
  (:require [compojure.core :refer [defroutes GET POST]]
            [todo.model :as model]
            [todo.views :as views]))


(defroutes routes
  (GET "/" [] (views/index (model/all)))
  (GET "/about" [] (views/about)))
