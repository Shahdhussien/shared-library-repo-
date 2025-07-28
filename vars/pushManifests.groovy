def call() {
    steps.stage('Push Manifests') {
        steps.echo 'Pushing updated manifests to Git repo...'
        steps.sshagent(['github']) {
            steps.sh """
                git config user.name "Jenkins"
                git config user.email "jenkins@example.com"
                git remote set-url origin git@github.com:Shahdhussien/shared-library-repo-.git
                git checkout main
                git add .
                git commit -m "Update manifests from Jenkins pipeline" || echo "No changes to commit"
                git push origin main
            """
        }
    }
}

// def call() {
//     steps.sshagent(['github']) {
//         steps.sh '''
//             git config user.name "Jenkins"
//             git config user.email "jenkins@example.com"
//             git remote set-url origin git@github.com:Shahdhussien/shared-library-repo-.git
//             git checkout main || git checkout -b main
//             git add .
//             git commit -m "Update manifests from Jenkins pipeline" || echo "No changes to commit"
//             git push origin main
//         '''
//     }
// }

