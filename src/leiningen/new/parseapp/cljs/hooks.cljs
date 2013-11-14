(ns {{ns-name}}.hooks
  "Parse hooks

https://parse.com/docs/cloud_code_guide#functions-onsave
https://parse.com/docs/cloud_code_guide#functions-modifysave
https://parse.com/docs/cloud_code_guide#functions-aftersave
https://parse.com/docs/cloud_code_guide#functions-ondelete
https://parse.com/docs/cloud_code_guide#functions-afterdelete
"
  (:require [{{ns-name}}.domain :refer [Widget]])
  (:require-macros [parseapp-cljs.parse-macros :refer [defhook]]))

(defhook Widget beforeSave [request response]
  (let [widget (.-object request)]
    (if (.get widget "name")
      (.success response)
      (.error response "widget without a name, that's no good!"))))
