@Library('my-shared-library') _

pipeline {
     agent { label 'jenkins-agent-1' }

        stages {
        stage('Pipeline Steps') {
            steps {
                buildImage()
                scanImage()
                pushImage()
                deleteImageLocally()
                updateManifests()
                pushManifests()
                echo 'Pushing updated manifests to Git repo...'
                sshagent(['github']) {
                    sh pushManifests()
            }
        }
    }
}
}