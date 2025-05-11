def call() {
//(String ProjectName, String ImageTag, String DockerHubUser) {
//  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
  sh "docker build -t ${DOCKER_IMAGE_NAME} ."
}
