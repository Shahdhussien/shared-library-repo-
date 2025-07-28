def call() {
    stage('Update Manifests') {
        echo '📝 Updating Kubernetes manifests (YAML files) using sed...'
        sh '''
        cd $WORKSPACE
        find K8s/ -name '*.yaml' -exec sed -i 's|image: shahd0/myimg:latest:.*|image: mshahd0/myimg:latest|' {} +
        '''
    }
}
