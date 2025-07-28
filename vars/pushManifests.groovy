// def call() {
//     return {
//         stage('Push Manifests') {
//             sshagent(['github']) {
//                 sh '''
//                     echo "hhhhhhhhhhh"
//                     git config user.name "Jenkins"
//                     git config user.email "jenkins@example.com"
//                     git remote set-url origin git@github.com:Shahdhussien/shared-library-repo-.git
//                     git checkout main
//                     git add .
//                     git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
//                     git push origin main
//                 '''
//             }
//         }
//     }
// }

def call() {
    stage('Push Manifests') {
//         withCredentials([sshUserPrivateKey(credentialsId: 'github', keyFileVariable: 'SSH_KEY')]) {
//     sh '''
//         eval $(ssh-agent)
//         ssh-add $SSH_KEY
//         git config user.name "Jenkins"
//         git config user.email "jenkins@example.com"
//         git remote set-url origin git@github.com:Shahdhussien/shared-library-repo-.git
//         git checkout main
//         git add .
//         git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
//         git push origin main
//     '''
// }
        sshagent(['github']) {
            sh '''
             echo "hhhhhhhhhhh"
                echo "🚀 Committing updated manifests..."
                git config user.name "Jenkins"
                git config user.email "jenkins@example.com"
                git remote set-url origin git@github.com:Shahdhussien/shared-library-repo-.git
                git checkout main
                git add .
                git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
                git push origin main
            '''
        }
    }
}
