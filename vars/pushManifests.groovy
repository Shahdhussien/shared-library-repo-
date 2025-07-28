

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
                git init
                git add .
                git commit -m "Temp stash before checkout" || echo "No changes"
                git branch -M main


                # 🧲 احصل على آخر نسخة من الريموت
                git pull --rebase origin main

                # ✅ أضف التغييرات الجديدة (من السطر اللي عدّلت فيه بـ sed مثلاً)
                // git add .
                // git commit -m "Update manifests from Jenkins pipeline" || echo "No changes"

                # 🚀 ادفع التحديثات للـ GitHub
                git push origin main
            '''
        }
    }
}




