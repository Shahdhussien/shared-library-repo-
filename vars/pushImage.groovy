def call() {
    stage('Push Image') {
        echo 'Pushing Docker image to registry...'
        withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            sh """
                echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                docker tag shahd0/myimg:latest $DOCKER_USER/myimg:latestt
                docker push $DOCKER_USER/myimg:"$$BUILD_NUMBER"
            """
        }
    }
}
