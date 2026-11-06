def call(String imageName, String credsIs) {
    withCredentials([usernamePassword(credentialsId: credsId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push ${imageName}"
    }
}