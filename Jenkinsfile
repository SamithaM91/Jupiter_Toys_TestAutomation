pipeline {
    agent any

    environment {
    //Assuming all required environment variables have configured correctly
    //eg:  MAVEN_HOME = 'C:/Program Files/apache-maven-3.9.9'
        MAVEN_HOME = 'C:/Program Files/apache-maven-3.9.9'  //maven path
    }

    stages {
         stage('Checkout') {
                    steps {
                        //Getting sourcecode from main branch for this example
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

    //   post {
    //            Run any post test/pipeline tasks
    //     }
}
