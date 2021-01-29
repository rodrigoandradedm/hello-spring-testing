#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                git branch: 'master', url: 'http://10.250.14.1:8929/root/spring-grade-test'
                sh "./gradlew clean test"
            }
        }
        post {
            always {
                junit 'build/test-results/test/TEST-*.xml'
                }
            }
        stage('Build') {
            steps {
                sh "./gradlew assemble"
            }
        }
        post {
            success {
                archiveArtifacts 'build/libs/*.jar'
            }
        }

    }
}
