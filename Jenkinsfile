pipeline {
    agent any
    
    tools {
        maven 'Maven-3'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/abendall-perscholas/module_311_cicd.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
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
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging environment...'
                // In real life: sh 'deploy-script.sh staging'
            }
        }
        
        stage('Deploy to Production') {
            input {
                message 'Deploy to production?'
                ok 'Yes, deploy!'
            }
            steps {
                echo 'Deploying to production...'
                // In real life: sh 'deploy-script.sh production'
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