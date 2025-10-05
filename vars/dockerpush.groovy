def call(String DockerHubUser, String ProjectName, String ImageTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass} --password-stdin"
  }
  sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
}
