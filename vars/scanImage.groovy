// def call() {
//     stage('Scan Image ') {
//         echo ' Scanning Docker image...'
//         withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
//         sh """
//         pwd
//         trivy image $DOCKER_USER/myimg:$BUILD_NUMBER
//         """
//         }
//     }
// }

def call() {
    echo ' Scanning Docker image...'
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-creds',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh "trivy image $DOCKER_USER/myimg:${BUILD_NUMBER}"
    }
}

