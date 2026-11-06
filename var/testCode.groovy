def call() {
    dir('app') {
        sh 'npm ci'
        sh 'npm test'
        }
}