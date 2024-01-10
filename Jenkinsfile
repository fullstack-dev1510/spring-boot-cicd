pipeline {
    agent any
	
	  tools
    {
       maven 'maven-3.9.6'
    }
    
    
 stages {
      
      stage('Initialize'){
        def dockerHome = tool 'myDocker'
        env.PATH = "${dockerHome}/bin:${env.PATH}"
    }
      stage('checkout') {
           steps {             
                git branch: 'master', url: 'https://github.com/fullstack-dev1510/spring-boot-cicd.git'
             
          }
        }
	 stage('Execute Maven') {
           steps {             
                sh 'mvn clean install'             
          }
        }
        

  stage('Docker Build and Tag') {
           steps {
              
                sh 'docker build -t andrews/spring-boot-cicd:latest .' 
                sh 'docker tag spring-boot-cicd fullstack-dev1510/spring-boot-cicd:latest'
                //sh 'docker tag samplewebapp nikhilnidhi/samplewebapp:$BUILD_NUMBER'
               
          }
        }
     
  stage('Publish image to Docker Hub') {
          
            steps {
        withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
          sh  'docker push andrews37/spring-boot-cicd:latest'
        //  sh  'docker push nikhilnidhi/samplewebapp:$BUILD_NUMBER' 
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
			{
                sh "docker run -d -p 8003:8080 andrews/spring-boot-cicd" 
            }
        }
 
    }
	}
    