pipeline {
    agent any
    tools{
        maven "maven"
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/shivamjaiswal424/calculator.git']])
                sh 'mvn clean install'
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t shivam424/calculator .'
                }
            }
        }
        stage('push image to docker'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub', variable: 'shivam')]) {
                    sh 'docker login -u shivam424 -p ${shivam}'
                    }
                    sh 'docker push shivam424/calculator'
                }
            }
        }
        stage('Remove existing container') {
            steps {
                script {
                    // Stop and remove the existing container named "calc"
                    sh 'docker stop calculator || true'
                    sh 'docker rm calculator || true'
                }
            }
        }
        stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                     )
                }
            }
        }
        
    }
}
