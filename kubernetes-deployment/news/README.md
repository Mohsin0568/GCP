# GCP

# Create cluster in GCP Kubernetes page from console.

# Run below command to connect to cluster
gcloud container clusters get-credentials news-cluster --zone us-central1-c --project computeproject-293903

# Run below command to create docker image in gcp container registry, make sure our command terminal is in directory where Dockerfile is present.
gcloud builds submit -t gcr.io/$DEVSHELL_PROJECT_ID/news . 

#After running above command, navigate to GCP Container registry and verify the docker image.

# Execute kubctl deployment
kubectl create -f deployment.yaml

# Create service for load balance
kubectl create -f deployment-service.yaml

# Copy ipaddress from services section and enter below url in browser
http://[ip_address:port]/news/feeds/test