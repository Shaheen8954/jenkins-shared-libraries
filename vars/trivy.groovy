def call() {
    sh """
    docker run --rm \
        -v /var/run/docker.sock:/var/run/docker.sock \
        aquasec/trivy:latest image --exit-code 1 --severity HIGH, CRITICAL
        --formate table --output trivy-repo.txt shaheen8954/nginx-project
        """
}  
