#!/usr/bin/env groovy

// Run the container

def call () {
  echo "running the container..."
  sh "
  docker run -d -p 80:80 ${IMAGE_NAME}"
}
