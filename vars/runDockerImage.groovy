#!/usr/bin/env groovy

// Run the container

def call(String DockerHubUser, String ProjectName, String ImageTag) {
  echo "running the container..."
  echo "Running Docker image: ${DockerHubUser}/${ProjectName}:${ImageTag}"
  sh "docker stop ${ProjectName}
  sh "docker rm ${ProjectName}
  sh "docker run -d -p ${PortNumber}/ --name ${ProjectName}/${ProjectName}:${ImageTag}"
}
