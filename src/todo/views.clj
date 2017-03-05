 (ns todo.views
   (:use [hiccup core page]))

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

(defn display-todos [todos]
  [:table
   [:tr
    [:td "id"]
    [:td "body"]
    [:td "completed"]]
   (map
     (fn [todo] [:tr
                 [:td (h (:id todo))]
                 [:td (h (:body todo))]
                 [:td (h (:completed todo))]])
     todos)])

(defn index [todos]
  (html5
    [:head
      [:title "Index"]]
    [:body
      [:h1 "ToDo Index"]
      (display-todos todos)]))
