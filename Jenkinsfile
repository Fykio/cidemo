pipeline {
    agent any

    // environment {
    //     IMAGE_VERSION = sh 'read -p "Enter image version: " IMAGE_VERSION'
    // }

    stages {
        // Stage 1: Checkout code from GitHub using GitHub PAT
        stage('Checkout Code') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/Fykio/cidemo.git',
                        credentialsId: 'CI-Demo-GitHub-PAT' // Your GitHub credentials ID in Jenkins
                    ]]
                ])
            }
        }

        // Stage 2: Package the application using Maven
        stage('Package with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        // Stage 3: Build Docker image
        stage('Build Docker Image') {
            steps {
                sh 'read -p "Enter image version: " IMAGE_VERSION'
                sh 'docker build -t fykio/cidemo:v${IMAGE_VERSION} .'
            }
        }

        // Stage 4: Push Docker image to Docker Hub
        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: "DockerHub", url: ""]) {
                    sh 'docker push fykio/cidemo:v${IMAGE_VERSION}'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
