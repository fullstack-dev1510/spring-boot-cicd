pipeline {
	agent none
  stages {
  	stage('Maven Install') {
    	agent {
      	any {
        	image 'maven:3.5.0'
        }
      }
      steps {
      	sh 'mvn clean install'
      }
    }
    stage('Docker Build') {
    	agent any
      steps {
      	sh 'docker build -t andrew/spring-boot-cicd:latest .'
      }
    }
  }
}