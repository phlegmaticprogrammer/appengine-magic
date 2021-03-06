(ns leiningen.appengine-clean
  "Cleans out appengine library area."
  (:require [lancet.core :as lancet])
  (:import java.io.File))


(defn appengine-clean [project]
  (let [prj-application (or (:appengine-application project) (:name project))
        war-dir (File. (or (:appengine-app-war-root project) "war"))
        web-inf-dir (File. war-dir "WEB-INF")
        target-lib-dir (File. web-inf-dir "lib")]
    (println "cleaning out App Engine application" prj-application)
    (lancet/delete {:dir (.getPath target-lib-dir)})))
