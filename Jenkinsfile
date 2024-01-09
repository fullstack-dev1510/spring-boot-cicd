
pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'java-17'
	}

	stages {

		stage('Build'){
			steps {
				bat 'mvn clean install -DskipTests'
			}
		}

		stage('Deploy') {
			steps {
			    bat 'docker build -t andrew/spring-boot-cicd:latest .'
			}
		}
	}
}