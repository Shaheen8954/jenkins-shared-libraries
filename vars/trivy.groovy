def call(String DockerHubUser, String ProjectName, String ImageTag) {
    sh """
    docker run --rm \
        -v /var/run/docker.sock:/var/run/docker.sock \
        aquasec/trivy:latest image --exit-code 1 --severity HIGH,CRITICAL \
        --format table --output trivy-repo.txt ${DockerHubUser}/${ProjectName}:${ImageTag}
        """
}
