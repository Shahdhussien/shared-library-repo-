// def call() {
//     stage('Update Manifests') {
//         echo '📝 Updating Kubernetes manifests (YAML files) using sed...'
//         sh '''
//         cd $WORKSPACE
//                     sed -i 's|image:.*|image: shahd0/myimg:latest|' K8s/deployment.yaml
//         '''
// }
//      stage('DEBUG: Check Image Line After sed') {
//      steps {
//      sh "grep 'image:' K8s/deployment.yaml"
//   }
// }
   
//     }

def call() {
    stage('Update Manifests') {
        echo '📝 Updating Kubernetes manifests (YAML files) using sed...'
        sh '''
            grep 'image:' K8s/deployment.yaml || echo 'No image line found!'
            echo "llllllllllllllllllllllllllllllllllll"
            cd $WORKSPACE
            sed -i 's|image:.*|image: shahd0/myimg:latest|' K8s/deployment.yaml
        '''
    }

    stage('DEBUG: Check Image Line After sed') {
        echo '🔍 Checking updated image line...'
        sh "grep 'image:' K8s/deployment.yaml || echo 'No image line found!'"
    }
}
