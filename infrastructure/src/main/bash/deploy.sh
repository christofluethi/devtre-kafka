#!/bin/bash
MICROSERVICES="data-producer data-consumer manual-data-transformer twitter-data-transformer"

for ms in $MICROSERVICES
do
  tkn pipeline start apply-and-build -r git-repo=data-consumer-repo -r image=$ms-image -p deployment-name=$ms -p docker-file=src/main/docker/Dockerfile.multistage.jvm -s pipeline
done


