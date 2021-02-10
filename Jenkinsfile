#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                git branch: 'publish', url: 'http://10.250.14.1:8929/root/spring-grade-test'
                sh "./gradlew clean test"
                sh "./gradlew check"
		withSonarQubeEnv(credentialsId: '47355589-96b7-4a4d-a3e1-97f149f76f8e', installationName: 'local') {
    			sh './gradlew sonarqube'
		}
		sh './gradlew dependencyCheckAnalyze'
            }
            post {
                always {
                    junit 'build/test-results/test/TEST-*.xml'
                    //recordIssues (
                      //  enabledForFailure: true,
                        //tool: checkStyle(pattern: 'build/reports/checkstyle/*.xml')
                    //)
		    dependencyCheckPublisher pattern: 'build/reports/dependency-check-report.xml'
                    recordIssues enabledForFailure: true, tool: pmdParser(pattern: 'build/reports/pmd/*.xml')
                    recordIssues enabledForFailure: true, tool: spotBugs(pattern: 'build/reports/spotbugs/*.xml')
                }
            }
        }
        stage('Build') {
            steps {
                sh "./gradlew assemble"
            }
            post {
                success {
                    archiveArtifacts 'build/libs/*.jar'
                }
            }
        }
	stage('publish') {
	    steps {
		withCredentials([string(credentialsId: 'gitLabPrivateToken', variable: 'TOKEN')]) {
		    sh './gradlew publish'
  		}
	    }
	}
    }
}
