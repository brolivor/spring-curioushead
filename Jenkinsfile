pipeline {
    agent any
    tools {
        maven 'maven_v3'
        jdk 'openjdk-19'
    }
    environment {
        PATH="/opt/maven/bin:$PATH"
        DOCKEHUB_CREDENTIALS = credentials('dockerhub')
    }
    stages {
        stage("Build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('SonarQube Server') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
        stage("Docker Build") {
            steps {
                sh 'docker image prune -a -y'
                sh 'docker container prune -a -y'
                sh 'docker build . -t madhurm54/curioushead-root-project:latest'
                sh 'echo $DOCKEHUB_CREDENTIALS_PSW | docker login -u $DOCKEHUB_CREDENTIALS_USR --password-stdin'
                sh 'docker push madhurm54/curioushead-root-project:latest'
            }
        }
        stage("Deploy to Kubernetes") {
            steps {
                sshagent(['k8s-control-1']) {
                    sh 'scp -o StrictHostKeyChecking=no services.yaml control-1@192.168.1.154:/home/control-1'
                    script {
                        try {
                            sh 'ssh control-1@192.168.1.154 kubectl apply -f services.yaml'
                        } catch (error) {
                            sh 'ssh control-1@192.168.1.154 kubectl create -f services.yaml'
                        }
                    }
                }
                sshagent(['k8s-control-2']) {
                    sh 'scp -o StrictHostKeyChecking=no services.yaml control-2@192.168.1.155:/home/control-2'
                    script {
                        try {
                            sh 'ssh control-2@192.168.1.155 kubectl apply -f services.yaml'
                        } catch (error) {
                            sh 'ssh control-2@192.168.1.155 kubectl create -f services.yaml'
                        }
                    }
                }
                sshagent(['k8s-control-3']) {
                    sh 'scp -o StrictHostKeyChecking=no services.yaml control-3@192.168.1.156:/home/control-3'
                    script {
                        try {
                            sh 'ssh control-3@192.168.1.156 kubectl apply -f services.yaml'
                        } catch (error) {
                            sh 'ssh control-3@192.168.1.156 kubectl create -f services.yaml'
                        }
                    }
                }
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}