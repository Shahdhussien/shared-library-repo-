def call() {
    stage('Delete Image Locally') {
        echo ' Deleting local Docker image...'
        sh 'docker rmi shahd0/myimg:latest || true'
    }
}
