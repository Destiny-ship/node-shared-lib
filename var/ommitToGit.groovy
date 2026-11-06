def call(String credsId, String repoPath, String branch = 'main') {
    withCredentials([usernamePassword(credentialsId: credsId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'git config user.email "jenkins@jenkins.com"'
        sh 'git config user.name "jenkins"'
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh "git remote set-url origin https://\$USER:\$PASS@${repoPath}"
        sh "git push origin HEAD:${branch}"
    }
}