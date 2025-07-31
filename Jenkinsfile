// @Library('my-shared-library') _

// pipeline {
//      agent { label 'jenkins-agent-1' }

//         stages {
//         stage('Pipeline Steps') {
//             steps {
//                 buildImage()
//                 scanImage()
//                 pushImage()
//                 deleteImageLocally()
//                 updateManifests()
//                 pushManifests()
//             }
//         }
//    }
// }

@Library('my-shared-library') _

pipeline {
    agent { label 'jenkins-agent-1' }

    stages {
        stage('Build Docker Image') {
            steps {
                buildImage()
            }
        }
        // stage('Scan Docker Image') {
        //     steps {
        //         scanImage()
        //     }
        // }
        // stage('Push Docker Image') {
        //     steps {
        //         pushImage()
        //     }
        // }
        // stage('Delete Local Image') {
        //     steps {
        //         deleteImageLocally()
        //     }
        // }
        // stage('Update Kubernetes Manifests') {
        //     steps {
        //         updateManifests()
        //     }
        // }
        // stage('Push Kubernetes Manifests') {
        //     steps {
        //         pushManifests()
        //     }
        // }
    }
}
