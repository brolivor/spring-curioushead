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
                    sh 'mvn clean package spring-boot:repackage sonar:sonar'
                }
            }
        }
        stage("Docker Build") {
            steps {
                sh 'if ![ z $(docker images -q) ]; then docker rmi $(docker images -q); fi'
                sh 'docker build . -t madhurm54/curioushead-projects:latest'
                sh 'echo $DOCKEHUB_CREDENTIALS_PSW | docker login -u $DOCKEHUB_CREDENTIALS_USR --password-stdin'
                sh 'docker push madhurm54/curioushead-projects:latest'
            }
        }
        stage("Publish to Nexus") {
            steps {
                nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: '192.168.1.164:8081',
                    groupId: 'com.curioushead',
                    version: '${BUILD_TIMESTAMP}',
                    repository: 'curioushead-root-project-repository',
                    credentialsId: 'nexus',
                    artifacts: [
                        [artifactId: 'curioushead-projects',
                         classifier: '',
                         file: 'profiles/target/profiles-0.0.1.jar',
                         type: 'jar']
                    ]
                )
            }
        }
        stage("Deploy to Kubernetes") {
            steps {
                sshagent(['k8s-control-1']) {
                    sh 'scp -o StrictHostKeyChecking=no scripts/*.yaml scripts/*.sh control-1@192.168.1.154:/home/control-1'
                    script {
                        try {
                            sh 'ssh control-1@192.168.1.154 ./refresh_deployment.sh'
                            sh 'ssh control-1@192.168.1.154 kubectl apply -f curioushead-root-project-services.yaml'
                        } catch (error) {
                            sh 'ssh control-1@192.168.1.154 kubectl create -f curioushead-root-project-services.yaml'
                        }
                    }
                }
                sshagent(['k8s-control-2']) {
                    sh 'scp -o StrictHostKeyChecking=no scripts/*.yaml scripts/*.sh control-2@192.168.1.155:/home/control-2'
                    script {
                        try {
                            sh 'ssh control-2@192.168.1.155 ./refresh_deployment.sh'
                            sh 'ssh control-2@192.168.1.155 kubectl apply -f curioushead-root-project-services.yaml'
                        } catch (error) {
                            sh 'ssh control-2@192.168.1.155 kubectl create -f curioushead-root-project-services.yaml'
                        }
                    }
                }
                sshagent(['k8s-control-3']) {
                    sh 'scp -o StrictHostKeyChecking=no scripts/*.yaml scripts/*.sh control-3@192.168.1.156:/home/control-3'
                    script {
                        try {
                            sh 'ssh control-3@192.168.1.156 ./refresh_deployment.sh'
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