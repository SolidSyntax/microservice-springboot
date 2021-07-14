#!/bin/bash
if ! docker ps --format '{{.Names}}' | grep -w rabbitmq &> /dev/null; then
    docker run -d --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
fi

./eureka-server/gradlew bootRun &
./configuration-server/gradlew bootRun &
./warehouse/gradlew bootRun &
./product-factory/gradlew bootRun &
./store/gradlew bootRun &
./reporting/gradlew bootRun &
