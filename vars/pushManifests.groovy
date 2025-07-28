

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

    # ✅ كومت أي تغييرات موجودة بالفعل
    git add -A
    git commit -m "Temp commit before rebase" || echo "No staged changes"

    # ✅ سحب آخر نسخة من الريموت
    git pull --rebase origin main

    # ✅ بعد الـ rebase، كومت أي تغييرات جديدة حصلت في البايبلاين
    git add -A
    git commit -m "Update manifests from Jenkins pipeline" || echo "No new changes"

    # 🚀 بوش نهائي
    git push origin main
'''

        }
    }
}




