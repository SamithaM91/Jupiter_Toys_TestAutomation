pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:/Program Files/apache-maven-3.9.9'  //maven path
    }

    stages {
        stage('Download source code') {
            steps {
                git 'https://github.com/SamithaM91/Jupiter_Toys_TestAutomation.git'  // repository URL
            }
        }

        stage('Setup Environment') {
            steps {
                bat 'mvn clean'  // Cleans the target directory
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'  // Runs TestNG tests
            }
        }

        stage('Publish Test Results') {
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'  // Publishes TestNG results
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
    }
}
