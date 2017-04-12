#!/bin/bash

export COMPOSE_PROJECT_NAME=slipp

docker-compose up -d nginx-proxy
docker-compose up -d redis

# COMMIT_HASH="$(git show-ref --head | grep -h HEAD | cut -d':' -f2 | head -n 1 | head -c 10)"
./gradlew clean build buildDocker -x test
docker tag my-spring-session:1.0.0 my-spring-session:latest

EXIST_BLUE=$(docker-compose ps | grep blue | grep Up)
EXIST_SCALE=$(docker ps | grep my-slipp | grep Up | wc -l | bc)
	
if [ -z "$EXIST_BLUE" ]; then
	echo "deploy blue"
	docker-compose up -d my-slipp-blue
	
	if [[ $EXIST_SCALE -gt 0 ]]; then
		docker-compose scale my-slipp-blue=$EXIST_SCALE		
	fi
	
	sleep 5
	docker-compose stop my-slipp-green
else
	echo "deploy green"
	docker-compose up -d my-slipp-green
	if [[ $EXIST_SCALE -gt 0 ]]; then
		docker-compose scale my-slipp-green=$EXIST_SCALE		
	fi
	
	sleep 5
	docker-compose stop my-slipp-blue
fi
