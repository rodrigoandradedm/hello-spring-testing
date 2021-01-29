#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git branch: 'main', url: 'http://10.250.14.1:8929/root/spring-grade-test'
                sh './gradlew assembllle'
            }
        }
        
    }
}
