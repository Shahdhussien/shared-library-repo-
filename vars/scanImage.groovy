def call() {
    stage('Scan Image') {
        echo ' Scanning Docker image...'
        sh 'trivy image $DOCKER_USER/my-app:latest'
    }
}
