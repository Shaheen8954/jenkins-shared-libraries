#!/usr/bin/env groovy

// Run the container

def call () {
  echo "running the container..."
  echo "Running Docker image: ${imageName}"
   sh "docker run -d -p 80:80 nginx-project"
}

