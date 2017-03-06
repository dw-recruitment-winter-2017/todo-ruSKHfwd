(ns todo.router
  (:require [compojure.core :refer [context defroutes GET POST PATCH DELETE]]
            [todo.model :as model]
            [todo.views.json :as json]
            [todo.views.http :as http]))

(defn learnabout [body]
  (let [{b "body", completed "false"} body]
  (str b)))

(defn api-routes []
  (context "/api/todos" []
    (GET "/" [] (json/index (model/all)))
    (POST "/" {body :body} (json/create (model/create body)))
    (PATCH "/" {body :body} (json/update_complete (model/update_complete body)))
    (DELETE "/" {body :body} (json/delete (model/delete body)))))

(defroutes routes
  (api-routes)
  (GET "/" [] (http/index (model/all)))
  (GET "/about" [] (http/about)))
