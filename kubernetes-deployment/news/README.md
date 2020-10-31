# Deploy app to GKE

### Create cluster in GCP Kubernetes page from console.

### Run below command to connect to cluster
gcloud container clusters get-credentials news-cluster --zone us-central1-c --project computeproject-293903

### Run below command to create docker image in gcp container registry, make sure our command terminal is in directory where Dockerfile is present.
gcloud builds submit -t gcr.io/$DEVSHELL_PROJECT_ID/news . 

###After running above command, navigate to GCP Container registry and verify the docker image.

### Execute kubctl deployment
kubectl create -f deployment.yaml

### Create service for load balance
kubectl create -f deployment-service.yaml

### Copy ipaddress from services section and enter below url in browser
http://[ip_address:port]/news/feeds/test

### Run below command to scale pods
kubectl scale deployment news-service --replicas=3

Above service is running in 1 node with 3 pods.

### Run below command to scale number of nodes in a cluster.
gcloud container clusters resize [cluster-name] --num-nodes 2



# Building and pushing docker image using docker commands

### Run below command to build docker image
docker build -t gcr.io/[gpc-project-id]/news:1.0 .

### Create tag for docker image
docker tag [image_id] gcr.io/[gpc-project-id]/news:1.0

run docker image list to find image id.

### Enable docker container registry api from console.

### run below command to authorize gcp
gcloud auth configure-docker

### run below command to push docker image to google container registry api.
docker push gcr.io/[gpc-project-id]/news:1.0

Verify image by navigating to Container registry page in console.


# Pushing updates

Update project code and build project using maven.

Create and push new image to the repository by updating tag to newer version (update tag in Dockerfile).

### update deployment.yaml to pull latest image and run below command
kubectl apply -f deployment.yaml