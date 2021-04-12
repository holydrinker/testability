#!/bin/bash

CONTAINER_NAME="workshop"

# Create container if doesn't exist
docker kill $CONTAINER_NAME
docker rm $CONTAINER_NAME
docker run --name $CONTAINER_NAME -e POSTGRES_PASSWORD=password -e POSTGRES_USER=peppo -p 5432:5432 -d postgres
sleep 2

# Populate test database
psql -h localhost -p 5432 -U peppo -c 'DROP DATABASE IF EXISTS workshop'
psql -h localhost -p 5432 -U peppo -c 'CREATE DATABASE workshop'
psql -h localhost -p 5432 -U peppo -c 'CREATE TABLE IF NOT EXISTS tracks (trackId integer primary key, title varchar(50), artist varchar(50));'

psql -h localhost -p 5432 -U peppo -c "INSERT INTO tracks VALUES (1000, 'best of you', 'foo fighters');"
psql -h localhost -p 5432 -U peppo -c "INSERT INTO tracks VALUES (1001, 'enjoy the silence', 'depeche mode');"


