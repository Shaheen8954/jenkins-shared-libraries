#!/usr/bin/env groovy

// Run the container

def call(String DockerHubUser, String ProjectName, String ImageTag) {
  echo "running the container..."
  echo "Running Docker image: ${DockerHubUser}/${ProjectName}:${ImageTag}"
  sh "docker run -d -p 80:80 ${DockerHubUser}/${ProjectName}:${ImageTag}"
}
