def call(String DockerHubUser, String ProjectName, String ImageTag) {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DockerHubUser', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "$DOCKER_PASS" | docker login -u "$DockerHubUser" --password-stdin
            docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} .
        """
    }
}
