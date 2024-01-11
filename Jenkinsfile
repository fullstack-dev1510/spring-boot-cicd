pipeline {
    agent any
	
	  tools
    {
       maven 'maven-3.9.6'
    }
    
    
 stages {
     
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
                //sh 'docker tag spring-boot-cicd andrews37/spring-boot-cicd:latest'
                //sh 'docker tag samplewebapp nikhilnidhi/samplewebapp:$BUILD_NUMBER'
               
          }
        }
     
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
			{
                //sh "docker run -d -p 8003:8083 andrews/spring-boot-cicd"
                sh "docker run --publish 8003:8080 andrews/spring-boot-cicd" 
                
            }
        }
 
    }
	}
    