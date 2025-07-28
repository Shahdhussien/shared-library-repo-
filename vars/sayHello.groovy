stage('sayHello') {
  steps {
    sh '''
      pwd
      ls -l
      ls -l K8s || echo "No K8s folder"
      cat K8s/deployment.yaml || echo "No deployment.yaml"
    '''
  }
}