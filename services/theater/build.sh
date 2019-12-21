#!/usr/bin/env bash

./mvnw package && java -jar target/$1
