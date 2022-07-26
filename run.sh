#!/usr/bin/env bash

SOURCE_FILE=$1

cd ./target
cp  toy-robort-game-1.0-SNAPSHOT-jar-with-dependencies.jar ../
cd ..

java -jar toy-robort-game-1.0-SNAPSHOT-jar-with-dependencies.jar $SOURCE_FILE

rm  toy-robort-game-1.0-SNAPSHOT-jar-with-dependencies.jar