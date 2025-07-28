def call() {
    stage('Update Manifests') {
        echo '📝 Updating Kubernetes manifests (YAML files) using sed...'
        sh '''
        cd $WORKSPACE
                    sed -i  's|image: .*|image: shahd0/myimg:latest|' K8s/deployment.yaml
        '''
    }
}
