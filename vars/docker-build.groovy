def call(string projectName, string imagetag, string dockerHubUser){
  sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
}
