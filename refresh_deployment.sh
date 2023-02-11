#!/bin/sh

kubectl delete services spring-curioushead-root-project-service > /dev/null 2>&1
kubectl delete deployment spring-curioushead-root-project > /dev/null 2>&1