(ns leiningen.new.parseapp
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "parseapp"))

(defn parseapp
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]

             ["app/main.js" (render "app/main.js" data)]
             ["app/config/global.json" (render "app/global.json" data)]
             ["app/config/local.json" (render "app/local.json" data)]
             ["app/config/public/index.html" (render "app/index.html" data)]
             ["app/config/public/application.css" (render "app/application.css" data)]

             ["src/cljs/{{sanitized}}/domain.cljs" (render "cljs/domain.cljs" data)]
             ["src/cljs/{{sanitized}}/functions.cljs" (render "cljs/functions.cljs" data)]
             ["src/cljs/{{sanitized}}/jobs.cljs" (render "cljs/jobs.cljs" data)]
             ["src/cljs/{{sanitized}}/hooks.cljs" (render "cljs/hooks.cljs" data)]
             ["src/cljs/{{sanitized}}/web.cljs" (render "cljs/web.cljs" data)])))
