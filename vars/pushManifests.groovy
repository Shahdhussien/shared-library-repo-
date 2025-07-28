def call() {
    stage('Push Manifests') {
        echo 'Pushing updated manifests to Git repo...'
        sh '''
            git config user.name "Jenkins"
            git config user.email "jenkins@example.com"
            git checkout main
            git add .
            git commit -m "Update manifests from Jenkins pipeline"
            git push origin main
        '''
    }
}
