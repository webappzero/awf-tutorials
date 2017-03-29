(ns myproj.core
  (:require [com.stuartsierra.component :as c]
           [arachne.log :as log]))

(defrecord Widget []
  c/Lifecycle
  (start [this]
    (log/info :msg "Hello, world!")
    this)
  (stop [this]
    (log/info :msg "Goodnight!")
    this))


(defn make-widget
  "Constructor for a Widget"
  []
  (->Widget))


(defn hello-handler
  [req]
  {:status 200
   :body "Hello, world!"})

(defn greeter
  [req]
  (let [name (get-in req [:path-params :name])]
    {:status 200
     :body (str "Hello, " name "!")}))
