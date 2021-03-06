(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {
    "sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"
  }
  :dependencies [[org.clojure/clojurescript "0.0-2080"]
                 [org.clojure/core.async "0.1.256.0-1bf8cf-alpha"]
                 [parseapp-cljs "0.4.0"]]

  :source-paths ["src/clj"]
  :plugins [[lein-cljsbuild "0.3.2"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {
    :builds {
      :main {
        :source-paths ["src/cljs"]
             :compiler {:output-to "app/cloud/cljs.js"
                        :optimizations :whitespace
                        :pretty-print true}}}})
