def call() {
    stage('Build Image') {
        echo ' Building Docker image...'
        sh '''
        docker build -t shahd0/myimg:latest .
        pwd
        ls -l
        ls -l K8s || echo "No K8s folder"
        cat K8s/deployment.yaml || echo "No deployment.yaml"
        '''

    }
}
