(ns todo.router
  (:require [compojure.core :refer [context defroutes GET POST]]
            [todo.model :as model]
            [todo.views.json :as json]
            [todo.views.http :as http]))

(defn api-routes []
  (context "/api/todos" []
    (GET "/" [] (json/index (model/all)))))

(defroutes routes
  (api-routes)
  (GET "/" [] (http/index (model/all)))
  (GET "/about" [] (http/about)))
