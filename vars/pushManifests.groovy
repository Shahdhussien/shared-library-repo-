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

                # 🔄 تأكد إنك على فرع main
                git checkout main

                # ✅ احفظ أي تغييرات علشان pull يشتغل
                git add .
                git commit -m "Temp commit before pull" || echo "No changes"

                # 🧲 pull بـ rebase عشان ما يحصلش تعارض
                git pull --rebase origin main

                # ✅ اعمل التعديلات المطلوبة (لو في أي فرق)
                git add .
                git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"

                # ⬆️ Push للفرع الأصلي
                git push origin main
            '''
        }
    }
}


