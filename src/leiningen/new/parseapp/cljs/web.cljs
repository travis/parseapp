(ns {{ns-name}}.web
  "Parse webapp

https://parse.com/docs/cloud_code_guide#webapp
"
  (:require [{{ns-name}}.domain :refer [Widget all-widgets]]
            [parseapp-cljs.web :refer [static render]]
            parseapp-cljs.async)
  (:require-macros [parseapp-cljs.async-macros :refer [<?]]
                   [cljs.core.async.macros :refer [go]]))

(def express (js/require "express"))
(def app (express))

(defn configure [app express]
  (.set app "views" "cloud/views")
  (.set app "view engine" "jade")
  (.use app (.bodyParser express))
  (.use app (.-router app)))

(configure app express)

(static app "terms")

(.get app "/widgets"
      (fn [request response]
        (go
         (let [widgets (map #(.get % "name") (<? (all-widgets)))]
           (render response "widgets" {:widgets widgets})))))

(.listen app)
