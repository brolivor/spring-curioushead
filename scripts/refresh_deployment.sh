#!/bin/sh

kubectl delete services spring-curioushead-miscellaneous-service > /dev/null 2>&1
kubectl delete services spring-curioushead-profiles-service > /dev/null 2>&1

kubectl delete deployment spring-curioushead-miscellaneous > /dev/null 2>&1
kubectl delete deployment spring-curioushead-profiles > /dev/null 2>&1