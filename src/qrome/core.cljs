(ns qrome
  (:require-macros [enfocus.macros :as em])
  (:require [enfocus.core :as ef]
            [clojure.string :as c.s]
            [goog.string :as gstr]))

(defn start []
  (let [base-url "http://chart.apis.google.com/chart?cht=qr&chs=240x240&chld=L&choe=UTF-8&chl="]
    (.. js/chrome.tabs
        (getSelected
         nil
         (fn [tab]
           (em/at js/document ["p.loading"]
                  (em/set-attr :style "display: none"))
           (em/at js/document ["img.qrcode"]
                  (em/set-attr
                   :src (str base-url
                             (gstr/urlEncode (.-url tab))))))))))

(set! (.-onload js/window) start)