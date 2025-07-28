// // def call() {
// //     return {
// //         stage('Push Manifests') {
// //             sshagent(['github']) {
// //                 sh '''
// //                     echo "hhhhhhhhhhh"
// //                     git config user.name "Jenkins"
// //                     git config user.email "jenkins@example.com"
// //                     git remote set-url origin git@github.com:Shahdhussien/shared-library-repo-.git
// //                     git checkout main
// //                     git add .
// //                     git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
// //                     git push origin main
// //                 '''
// //             }
// //         }
// //     }
// // }

// def call() {
//     stage('Push Manifests') {
//         withCredentials([usernamePassword(credentialsId: 'github-creds')]) {
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
    
//     }
// }

// def call() {
//     stage('Push Manifests') {
//         withCredentials([usernamePassword(
//             credentialsId: 'github-creds', 
//             usernameVariable: 'GIT_USER', 
//             passwordVariable: 'GIT_TOKEN'
//         )]) {
//             sh '''
//                 git config user.name "Jenkins"
//                 git config user.email "jenkins@example.com"
//                 git remote set-url origin https://${GIT_USER}:${GIT_TOKEN}@github.com/Shahdhussien/shared-library-repo-.git
//                 git checkout main
//                 git add .
//                 git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
//                 git push origin main
//             '''
//         }
//     }
// }

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
                git add .
                git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"
                git push origin main
            '''
        }
    }
}
