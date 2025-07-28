def call() {
    stage('Push Manifests') {
        echo 'Pushing updated manifests to Git repo...'
        withCredentials([usernamePassword(credentialsId: 'github', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_TOKEN')]) {
        sh """
            git config user.name "Jenkins"
            git config user.email "jenkins@example.com"
            git remote set-url origin https:"$GIT_USER":"$GIT_TOKEN"@github.com/Shahdhussien/shared-library-repo-.git
            git checkout main
            git add .
            git commit -m "Update manifests from Jenkins pipeline"
            git push origin main
        """
    }
    }
}
