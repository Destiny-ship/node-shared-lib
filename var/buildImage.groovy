def call(String imageName) {
    dir('app') {
        sh "docker build --platform linux/amd64 -t ${imageName} ."
        }
}