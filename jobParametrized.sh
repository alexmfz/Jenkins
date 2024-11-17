#!/bin/bash

# Empezar el loop
for a in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
do
    # Si a = 8 el loop "descansa"
    if [ "$a" -eq 8 ]
    then
        sleep 5
        echo "Descansando... $nombre"
    fi
    echo "Clase Nº $a"
done

sleep 3
echo "Bien $nombre. Terminamos la clase de $curso."
