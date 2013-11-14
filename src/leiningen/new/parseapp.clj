(ns leiningen.new.parseapp
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files year]]))

(def render (renderer "parseapp"))

(defn parseapp
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)
              :year (year)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["bin/develop" (render "develop" data) :executable true]
             ["bin/deploy" (render "deploy" data) :executable true]

             ["app/cloud/main.js" (render "app/main.js" data)]
             ["app/cloud/views/terms.jade" (render "app/terms.jade" data)]
             ["app/cloud/views/widgets.jade" (render "app/widgets.jade" data)]
             ["app/config/global.json" (render "app/global.json" data)]
             ["app/config/local.json" (render "app/local.json" data)]
             ["app/public/index.html" (render "app/index.html" data)]
             ["app/public/application.css" (render "app/application.css" data)]

             ["src/cljs/{{sanitized}}/domain.cljs" (render "cljs/domain.cljs" data)]
             ["src/cljs/{{sanitized}}/functions.cljs" (render "cljs/functions.cljs" data)]
             ["src/cljs/{{sanitized}}/jobs.cljs" (render "cljs/jobs.cljs" data)]
             ["src/cljs/{{sanitized}}/hooks.cljs" (render "cljs/hooks.cljs" data)]
             ["src/cljs/{{sanitized}}/web.cljs" (render "cljs/web.cljs" data)])))
