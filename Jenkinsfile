#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                git branch: 'checkstyle', url: 'http://10.250.14.1:8929/root/spring-grade-test'
                sh "./gradlew clean test"
                sh "./gradlew check"
		configFileProvider(
			[configFile(fileId: 'gradle.properties-sonarqube', targetLocation: 'gradle.properties')]) {
			sh './gradlew sonarqube'
    		}
            }
            post {
                always {
                    junit 'build/test-results/test/TEST-*.xml'
                    //recordIssues (
                      //  enabledForFailure: true,
                        //tool: checkStyle(pattern: 'build/reports/checkstyle/*.xml')
                    //)
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
    }
}
