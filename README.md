# Pizza Joint Project

In this project, I use `docker-compose` to create services within same network and the services can communicate with each others internally.

# How to run?

There is a `Makefile` for handling the tasks of building project and dockerization.

```
1. make build
2. make dockerize
3. make run-docker
```

if you want to stop docker services, you can run `make stop-docker`.

Entrypoint: POST `http://localhost/pizza`

# High Level Design

`pizza-api` acts as a gateway for user to call the api in frontend, after the traffic coming to our app, pizza-api will then forward it to `order-service`. After that, `order-service` creates pizza order and save it to `MySQL`.

![flow-chart](arch/flow.png)

# Security

# Scaling

