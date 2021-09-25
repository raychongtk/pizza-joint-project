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

This design can be further improved by scaling the instances horizontally when there is high traffic coming to our system. As the image presented, we can scale our microservices to serve user traffic.
![replicate-instances](arch/replicate.png)

To achieve this, we can utilize `Kubernetes` to help us manage our containers and resources.
`Kubernetes` can provide our system scalability and monitor our resources.

If the bottleneck is database, we can do master-salve replication on database to increase the database performance. After we applied master-slave strategy, we can separate the read/write traffics and let the traffic distribute to different database instances. The date will be written to master and
sync to slaves and read request will go to slaves. It provides more availability characteristic to the system but we trade off the data consistency because when data synchronize to slaves, there is possible to have latency.

If there is lot of data in the database and the query become slow, we can do sharding on database like separating the order by month:

```
pizza-order-2021-09
pizza-order-2021-10
pizza-order-2021-11
...
etc.
```

after that, we can distribute our data horizontally and the query speed will be improved as we don't store numerous data inside one table.

But definitely, the architecture complexity will be increased if we do sharding on database, because we need to write our own hashing function to route the traffic to different table or different database. 
