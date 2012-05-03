(ns qrome
  (:require-macros [enfocus.macros :as em])
  (:require [enfocus.core :as ef]
            [clojure.string :as c.s]
            [goog.string :as gstr]
            [cljs.reader :as reader]))

(defn start []
  (let [base-url "http://chart.apis.google.com/chart?cht=qr&chs=240x240&chld=L&choe=UTF-8&chl="
        tab-url (atom "http://holder.com")]
    (.. js/chrome.tabs (getSelected nil
                                    (fn [tab] (reset! tab-url (.-url tab)))))
    (js/setTimeout
     (fn []
       (em/at js/document ["p.loading"]
              (em/set-attr :style "display: none"))
       (em/at js/document ["img.qrcode"]
              (em/set-attr
               :src (str base-url (gstr/urlEncode @tab-url)))))
       1000)))

(set! (.-onload js/window) start)