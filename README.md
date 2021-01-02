[![Build Status](https://travis-ci.com/aprabhat/springboot-restful-sample.svg?branch=master)](https://travis-ci.com/aprabhat/springboot-restful-sample)

Command to create docker image with tag

```docker build -t aprabhat/springboot-restful-sample:v1.0 .```

command to run

```docker run -d -p 8080:8080 aprabhat/springboot-restful-sample:v1.0```

To run this application using k8s, setup a local development environment by following the steps available at k8s official site

https://kubernetes.io/docs/tasks/tools/

Here we are using minikube to run a single node k8s cluster on local machine

```minikube version: v1.15.1```

Steps to follow
1. Run the below command to start a single node k8s cluster

      ```minikube start```

2. Open a termical in the project working directory and run

      ```kubectl apply -f deployment```

This will create a deployment and service object in kubernetes. You can modify the configuration related to replicas, memory and cpu in [springboot-restful-sample-deployment.yml](deployment/springboot-restful-sample-deployment.yml) file.

Now run the below command to return and opn the kubernetes URL for the service in your local cluster.

```minikube service springboot-restful-sample-service```
