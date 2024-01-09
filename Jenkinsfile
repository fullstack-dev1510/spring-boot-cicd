
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