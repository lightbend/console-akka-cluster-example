# This product is EOL in favor of using grafana or another monitoring utility directly

# Lightbend Console Akka Cluster Example

This project is an example for [Lightbend Console](https://developer.lightbend.com/docs/console/current/index.html) integration in an existing app.

This is a very simple [Akka Cluster](https://doc.akka.io/docs/akka/snapshot/cluster-usage.html) and 
[Akka HTTP](https://doc.akka.io/docs/akka-http/current/scala/http/) application. Its main purpose is to show how you 
can build a similar application and take advantage of the [Lightbend Platform](https://developer.lightbend.com/docs/lightbend-platform/introduction/)
to easily and safely deploy to [Kubernetes](https://kubernetes.io/) with minimal configuration required.

### Deployment

Prerequisites:

* [SBT](https://www.scala-sbt.org/release/docs/Setup.html)
* [Minikube](https://github.com/kubernetes/minikube#installation)

> If you already have a Minikube and wish to start fresh, run `minikube delete` to remove your existing Minikube.

1) Start minikube

```bash
minikube start

eval $(minikube docker-env)
```

2) Build and Deploy project

There's two ways to deploy this project. You can do it from within SBT or from the command line.

### Build project

```bash
sbt docker:publishLocal
```

### Inspect images

```bash
docker images
```

### Deploy project

Follow instructions in [Lightbend Console](https://developer.lightbend.com/docs/console/current/tutorial/index.html) docs.
