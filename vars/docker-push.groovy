def call(String Project, String ImageTag, String DockerHubUser) {
  withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}