(ns {{ns-name}}.domain
  "Domain definitions

Define your objects here.
"
  (:require [parseapp-cljs.parse :as parse])
  (:require-macros [parseapp-cljs.parse-macros :refer [defparsetype]]
                   [parseapp-cljs.async-macros :refer [<?]]
                   [cljs.core.async.macros :refer [go]]))

(defparsetype Widget)

(defn all-widgets []
  (parse/find-all Widget))
