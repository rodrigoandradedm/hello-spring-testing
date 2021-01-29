#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                git branch: 'master', url: 'http://10.250.14.1:8929/root/spring-grade-test'
                sh "./gradlew clean test"
            }
            post {
                always{
                    junit 'build/test-result/test/TEST-*.xml'
                }
            }
        }
        stage('Build') {
            steps {
                sh "./gradlew assemble"
            }
        }
        post {
            sucess{
                archiveArtifacts 'build/libs/*.jar'
            }
        }

    }
}
