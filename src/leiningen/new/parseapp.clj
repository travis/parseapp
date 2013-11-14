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
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
