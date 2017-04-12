#!/bin/bash

PROJECT_NAME=slipp

docker-compose -p $PROJECT_NAME up -d nginx-proxy

# ./gradlew clean build buildDocker -x test
# docker tag my-spring-session:1.0.0 my-spring-session:latest

docker-compose -p $PROJECT_NAME up -d redis
docker-compose -p $PROJECT_NAME up -d my-slipp-blue

sleep 5

docker-compose -p $PROJECT_NAME -f docker-compose.yml up -d my-slipp-green