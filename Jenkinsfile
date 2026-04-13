pipeline {
    agent any
    
    tools {
        maven 'Maven-3'
        jdk 'Java 21'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AMJ0h531/module_311_cicd.git'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

         stage('Code Quality') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging environment...'
                // In real life: bat 'deploy-script.bat staging'
            }
        }
        
        stage('Deploy to Production') {
            input {
                message 'Deploy to production?'
                ok 'Yes, deploy!'
            }
            steps {
                echo 'Deploying to production...'
                // In real life: bat 'deploy-script.bat production'
            }
        }
    }
    
     post {
        success {
            echo 'Full pipeline succeeded!'
            archiveArtifacts artifacts: 'target/*.jar'
        }
        failure {
            echo 'Pipeline failed — check logs.'
        }
    }
}
