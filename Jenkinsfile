pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'dockerhub-credentials'  // Docker Hub credentials ID
        DOCKER_IMAGE_NAME = 'myapp'
        DOCKER_IMAGE_TAG = 'latest'
        REPO_URL = 'https://index.docker.io/v1/'         // Docker Hub URL
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git 'https://github.com/yourusername/your-repo.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                // Build the Maven project
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Log in to Docker Hub and push the image
                    docker.withRegistry("${REPO_URL}", "${DOCKER_CREDENTIALS_ID}") {
                        docker.image("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}").push("${DOCKER_IMAGE_TAG}")
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up Docker images
            sh 'docker system prune -f'
        }
    }
}
