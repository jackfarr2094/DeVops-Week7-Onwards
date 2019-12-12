pipeline {
	agent any
	
	stages {
		stage('Test Environment') {
		steps {
			sh 'mvn test -Dtest=ControllerAndServiceSuite'
			sh 'mvn test -Dtest=IntegrateSuite'
			}
		}
	stage('Build') {
	steps {
		sh 'mvn package -DskipTests' {
		sh 'docker build --tag "jackfarr2094/project-site:latest"'
		echo "Build"
			}
		}
	}
	stage('Deploy') {
		steps {
			sh 'docker push jackfarr2094/project-site:latest'
			echo "Deploy"
				}
			}
		}
	}
