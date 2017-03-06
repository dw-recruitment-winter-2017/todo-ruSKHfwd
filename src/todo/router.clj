(ns todo.router
  (:require [compojure.core :refer [context defroutes GET POST PATCH]]
            [todo.model :as model]
            [todo.views.json :as json]
            [todo.views.http :as http]))

(defn learnabout [body]
  (let [{b "body", completed "false"} body]
  (str b)))

(defn api-routes []
  (context "/api/todos" []
    (GET "/" [] (json/index (model/all)))
    (POST "/" {body :body} (json/new (model/create body)))
    (PATCH "/" {body :body} (json/new (model/update_complete body)))))

(defroutes routes
  (api-routes)
  (GET "/" [] (http/index (model/all)))
  (GET "/about" [] (http/about)))
