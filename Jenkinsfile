
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
			    sh 'nohup ./mvnw spring-boot:run -Dserver.port=8002 &'
			}
		}
	}
}