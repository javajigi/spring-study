#!/bin/bash

export COMPOSE_PROJECT_NAME=slipp

docker-compose up -d nginx-proxy
docker-compose up -d redis

EXIST_BLUE=$(docker-compose ps | grep blue | grep Up)

if [ -z "$EXIST_BLUE" ]; then
	echo "deploy blue"
	docker-compose up -d my-slipp-blue
	
	sleep 5
	docker-compose stop my-slipp-green
else
	echo "deploy green"
	docker-compose up -d my-slipp-green
	
	sleep 5
	docker-compose stop my-slipp-blue
fi