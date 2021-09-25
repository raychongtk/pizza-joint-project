.PHONY: build dockerize run-docker stop-docker

build:
	./gradlew clean build

dockerize:
	docker-compose build

run-docker:
	docker-compose up

stop-docker:
	docker-compose down
