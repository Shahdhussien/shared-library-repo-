

def call() {
    stage('Push Manifests') {
        withCredentials([usernamePassword(
            credentialsId: 'github-creds', 
            usernameVariable: 'GIT_USER', 
            passwordVariable: 'GIT_TOKEN'
        )]) {
            sh '''
                git config user.name "Jenkins"
                git config user.email "jenkins@example.com"
                git remote set-url origin https://${GIT_USER}:${GIT_TOKEN}@github.com/Shahdhussien/shared-library-repo-.git
                git fetch origin
                git checkout -B main origin/main
                git add -A
                git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
                git push origin main
            '''

        }
    }
}




