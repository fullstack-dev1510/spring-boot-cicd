pipeline {
    //agent {

        //label 'docker'

    //}
    tools
    {    
       maven 'maven-3.9.6'
       //'org.jenkinsci.plugins.docker.commons.tools.DockerTool' 'docker'
    }
    
  environment {
    dockerimagename = "andrews/spring-boot-cicd:latest"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps {
        git 'https://github.com/fullstack-dev1510/spring-boot-cicd.git'
      }
    }
    stage('Execute Maven') {
           steps {             
                bat 'mvn clean install'             
          }
    }
    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }
    stage('Deploying spring container to Kubernetes') {
      steps {
      		//bat 'kubectl apply -f deployment.yaml'
        script {
          kubernetesDeploy(configs: "deployment.yaml" ,kubeconfigId: "MINIKUBECONFIG")          
        }
      }
    }
  }
}