(ns speclj.report.unicornleap_spec
  (:require [speclj.core :refer :all]
            [speclj.reporting :refer [report-runs report-error]]
            [speclj.results :refer [pass-result pending-result fail-result error-result]]
            [speclj.report.unicornleap :as unicornleap]))

(describe "Unicornleap Reporter"
  (with reporter (unicornleap/new-unicornleap-reporter))
  (with executed-command (atom nil))

  (around [it]
    (with-redefs [unicornleap/execute (fn [command]
                                        (reset! @executed-command command))]
      (it)))

  (it "leaps a unicorn when nothing was reported"
    (report-runs @reporter [])
    (should= "unicornleap" @@executed-command))

  (it "leaps a unicorn when no failures or errors were reported"
    (report-runs @reporter [(pass-result nil 1)
                            (pending-result nil 1 nil)])
    (should= "unicornleap" @@executed-command))

  (it "leaps a troll when a failure was reported"
    (report-runs @reporter [(fail-result nil 1 nil)])
    (should= "trolleap" @@executed-command))

  (it "leaps a troll when an error was reported"
    (report-runs @reporter [(error-result nil)])
    (should= "trolleap" @@executed-command)))

