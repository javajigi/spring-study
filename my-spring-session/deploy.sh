#!/bin/bash

./gradlew clean build buildDocker -x test

docker-compose -p slipp up --build -d
