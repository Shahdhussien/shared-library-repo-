def call() {
    stage('Build Image ') {
        echo ' Building Docker image...'
        sh """docker build -t shahd0/myimg:$BUILD_NUMBER ."""
        
    }
}