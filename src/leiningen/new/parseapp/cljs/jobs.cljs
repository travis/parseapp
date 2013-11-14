(ns {{ns-name}}.jobs
  "Parse background jobs

https://parse.com/docs/cloud_code_guide#jobs
"
  (:require [{{ns-name}}.domain :refer [all-widgets]]
            parseapp-cljs.async)
  (:require-macros [parseapp-cljs.async-macros :refer [<?]]
                   [parseapp-cljs.parse-macros :refer [defjob]]
                   [cljs.core.async.macros :refer [go]]))

(defjob printAllTheWidgetsConstantly [request result]
  (go
   (<? (all-widgets))
   (.success result "Every minute jobs complete")))
