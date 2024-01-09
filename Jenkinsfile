
pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'jdk17.0'
	}

	stages {

		stage('Build'){
			steps {
				    sh "./mvnw clean install -DskipTests"
			}
		}

		stage('Deploy') {
			steps {
			    sh 'docker build -t andrew/spring-boot-cicd:latest .'
			}
		}
	}
}