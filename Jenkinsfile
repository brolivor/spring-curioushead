pipeline {
    agent any
    tools {
        maven 'maven_v3'
        jdk 'openjdk-19'
    }
    environment {
        PATH="/opt/maven/bin:$PATH"
        def BUILDVERSION = sh(script: "echo `date +%s`", returnStdout: true).trim()
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
                sh 'docker build . -t madhurm54/curioushead-root-project:${BUILD_TIMESTAMP}'
            }
        }
        stage("Publish to Nexus") {
            steps {
                nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: '192.168.1.164',
                    groupId: 'com.curioushead',
                    version: "${BUILD_TIMESTAMP}",
                    repository: 'http://192.168.1.164:8081/repository/curioushead-root-project-repository/',
                    credentialsId: 'nexus',
                    artifacts: [
                        [artifactId: 'curioushead-root-project',
                         classifier: '',
                         file: 'target/*.jar,
                         type: 'jar']
                    ]
                )
            }
        }
        stage("Deploy to Kubernetes") {
            steps {
                sshagent(['k8s-control-1']) {
                    sh 'scp -o StrictHostKeyChecking=no curioushead-root-project-services.yaml control-1@192.168.1.154:/home/control-1'
                    script {
                        try {
                            sh 'ssh control-1@192.168.1.154 kubectl apply -f curioushead-root-project-services.yaml'
                        } catch (error) {
                            sh 'ssh control-1@192.168.1.154 kubectl create -f curioushead-root-project-services.yaml'
                        }
                    }
                }
                sshagent(['k8s-control-2']) {
                    sh 'scp -o StrictHostKeyChecking=no curioushead-root-project-services.yaml control-2@192.168.1.155:/home/control-2'
                    script {
                        try {
                            sh 'ssh control-2@192.168.1.155 kubectl apply -f curioushead-root-project-services.yaml'
                        } catch (error) {
                            sh 'ssh control-2@192.168.1.155 kubectl create -f curioushead-root-project-services.yaml'
                        }
                    }
                }
                sshagent(['k8s-control-3']) {
                    sh 'scp -o StrictHostKeyChecking=no curioushead-root-project-services.yaml control-3@192.168.1.156:/home/control-3'
                    script {
                        try {
                            sh 'ssh control-3@192.168.1.156 kubectl apply -f curioushead-root-project-services.yaml'
                        } catch (error) {
                            sh 'ssh control-3@192.168.1.156 kubectl create -f curioushead-root-project-services.yaml'
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