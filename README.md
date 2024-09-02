# Load Balancer

## Overview

The Load Balancer is a microservice application built with Spring Boot. It provides an endpoint to check the status of the service and is deployed in a Kubernetes cluster. This service interacts with other microservices and is designed to be simple and efficient.

## Features

- **Status Endpoint**: Returns a message including the hostname of the pod serving the request.
- **Kubernetes Deployment**: Deployed as a LoadBalancer service in a Kubernetes cluster.

## Getting Started

### Prerequisites

- Docker
- Kubernetes (Minikube)
- Maven (JDK 17)

### Building the Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/mikailakar/LoadBalancer.git
   cd LoadBalancer/order-service
   ```

2. **Start Minikube**

   ```bash
   minikube start
   ```

3. **Build the Application**

   ```bash
   mvn clean package
   ```

4. **Build the Docker Image**

   ```bash
   docker build -t order-service:1.0.0 .
   ```

5. **Deploy the Application**

   ```bash
   kubectl apply -f k8s/order-service.yaml
   ```

6. **Deploy using Skaffold**
   
   ```bash
   skaffold run
   ```

7. **Verify Deployment**
   
   ```bash
   kubectl get pods
   ```

8. **Create a Tunnel**

   ```bash
   minikube tunnel
   ```

9. **Verify the Service**

    ```bash
    kubectl get svc
    ```

10. **Test the Load Balancer**
    
    Open Postman, create one GET end-point at http://127.0.0.1:8080/status and uncheck Connection(keep-alive). You should see a message indicating the hostname of the pod.
