(ns speclj.report.unicornleap
  (:use [clojure.java.shell :only [sh]]
        [speclj.results :only [fail? error?]])
  (:import [speclj.reporting Reporter]))

(defn- execute [command]
  (.start (ProcessBuilder. [command])))

(defn- leap [failures]
  (if (= failures true)
    (execute "trolleap")
    (execute "unicornleap")))

(defn- is-failure? [result]
  (or (fail? result) (error? result)))

(defn- contains-failure? [collection]
  (= true (some is-failure? collection)))

(deftype UnicornleapReporter []
  Reporter
  (report-message [this message])
  (report-description [this description])
  (report-pass [this result])
  (report-pending [this result])
  (report-fail [this result])
  (report-runs [this results]
    (leap (contains-failure? results)))
  (report-error [this error]))

(defn new-unicornleap-reporter []
  (UnicornleapReporter.))

