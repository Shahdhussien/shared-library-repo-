def call() {
    echo '📝 Updating Kubernetes manifests (YAML files)...'
    sh """
        cd ${WORKSPACE}
        sed -i "s|image:.*|image: shahd0/myimg:${BUILD_NUMBER}|" K8s/deployment.yaml
    """
}
