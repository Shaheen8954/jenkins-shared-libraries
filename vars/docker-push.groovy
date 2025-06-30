def call(String DockerHubUser, String ProjectName, String ImageTag) {
  withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
}
