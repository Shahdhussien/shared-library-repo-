

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
                git pull --rebase origin main
                git add .
                git commit -m "Temp stash before checkout" || echo "No changes"
            


                # 🧲 احصل على آخر نسخة من الريموت

                # ✅ أضف التغييرات الجديدة (من السطر اللي عدّلت فيه بـ sed مثلاً)
               

                # 🚀 ادفع التحديثات للـ GitHub
                git push origin main
            '''
        }
    }
}




