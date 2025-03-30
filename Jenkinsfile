pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:/Program Files/apache-maven-3.9.9'  //maven path
    }

    stages {
         stage('Checkout') {
                    steps {
                        git branch: 'main', url: 'https://github.com/SamithaM91/Jupiter_Toys_TestAutomation.git'
                    }
         }

        stage('Setup Environment') {
            steps {
                bat 'mvn clean'  // Cleans the target directory
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'  // Runs TestNG tests. If bash is using sh 'mvn clean test'
            }
        }
    }

//     post {
//         always {
//             archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
//         }
//     }
}
