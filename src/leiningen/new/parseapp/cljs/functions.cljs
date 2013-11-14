(ns {{ns-name}}.functions
  "Parse DRPC function definitions

https://parse.com/docs/cloud_code_guide#functions
"
  (:require [{{ns-name}}.domain :refer [all-widgets]]
            parseapp-cljs.async)
  (:require-macros [parseapp-cljs.async-macros :refer [<?]]
                   [parseapp-cljs.parse-macros :refer [defdrpc]]
                   [cljs.core.async.macros :refer [go]]))

(defdrpc printAllTheWidgets [request response]
  (go
   (try
     (prn (<? (all-widgets)))
     (.success response)
     (catch js/Error e
       (.error response (.-message e))))))
