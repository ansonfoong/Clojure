(ns clj-test.destructure (:gen-class))

(defn -main "Main" [& args]
    (let [[color size] ["Blue" "Small"]] ; Blue gets assigned to color, and Small gets assigned to size.
        (println (str "The " color " dog is very " size))
    )
    ; This is not destructuring. 
    (let [v1 ["Joshua" "Ryan" "Tommy"] josh (first v1) ryan (nth v1 1) tommy (last v1)]
        (println josh)
        (println ryan)
        (println tommy)
    )

    ; Destructring example.
    (let [[color size] ["blue" ["small" "big"]]]
        (println (str "The " color " dog is very " size))
    )
    
    (let [[name age gender :as info] ["Anson" "21" "Male"]]
        (println (str "Info: " info))
        (println (str "Name: " name))
        (println (str "Age: " age))
        (println (str "Gender: " gender))
    )
    ; Destructuring maps.
    (let [{flower1 :flower1 flower2 :flower2} {:flower1 "red" :flower2 "blue"}]
        (println flower1)
        (println flower2)
    )

    (def people {:anson '("Anson Foong" 21 "Empire Commons") :mark '("Mark Mark" 19 "Liberty Terrace") :zoe '("Zoe Zoe" 21 "Empire Commons")})
    (println people)

    ; This destructures a map by specifying the keys to return the value from the map.
    (let [{:keys [anson mark zoe]} people]
        (println anson)
    )

    ; Destructuring a map using :or keyword if :joe is not found in the Map.
    (let [{person1 :anson person2 :mark person3 :zoe person4 :joe :or {person4 "Person 4 not in map"}} people]
        (println person1)
        (println person2)
        (println person3)
        (println person4)
    )

    ; Destructures the map and binds the initial data structure using :as keyword to all-people
    (let [{person1 :anson person2 :mark person3 :zoe :as all-people} people]
        (println person1)
        (println person2)
        (println person3)
        (println all-people)
    )

    ; Using :keys directive to get the keys and values of the people map.
    (let [{:keys [anson mark zoe] :as all-people} people]
        (println anson)
        (println mark)
        (println zoe)
        (println (str "All: " all-people)))

    ; Recall we can use a short-cut (:key map) to get the value of a key instead of using 'get'

    ; define a function called 'peoples' that takes in a map. We know it takes in a map just by looking at the function signature. 
    (defn peoples [{:keys [anson mark zoe]}]
        (println (str anson mark zoe)))
    (peoples people)
)