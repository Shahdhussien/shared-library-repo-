def call() {
    stage('Update Manifests') {
        echo '📝 Updating Kubernetes manifests (YAML files) using sed...'
        sh '''
        find K8s/ -name '*.yaml' -exec sed -i 's|image: flask-final-app:.*|image: myimg:latest|' {} +
        '''
    }
}
