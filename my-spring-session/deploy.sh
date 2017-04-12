#!/bin/bash

./gradlew clean build buildDocker -x test

docker-compose -p slipp -f docker-compose-v1.yml up --build -d
