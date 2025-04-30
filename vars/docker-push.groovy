def call(String Project, String ImageTag, String DockerHubUser){
  with Cridentails([userNamePassword(cridentailsId: 'docker', passwordVariable: 'dockerHubPass', UserNameVariable: 'dockerHubUser')]){
    sh "docker login -u ${dockerHubUser} _P ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${project}:${ImageTag}"
}    
