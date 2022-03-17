pipeline {
    parameters {
      string defaultValue: 'defaultValue', name: 'testArg'
    }

    agent any

    stages {

      stage('Hello') {
        steps {
           echo 'Hello World'
           sh 'echo $(testArg)'
           sh 'echo "Added from github generator"'
          }
        }
      stage('Execute shell'){
        
        agent{
          label 'built-in'
        }
        
        steps {
          sh 'ls'
          sh 'chmod +x HelloWorld.sh'
          sh './HelloWorld.sh'
      }
    }
        stage('Clean WS'){
        steps{
          cleanWs()
        }
      }
    }
  }
