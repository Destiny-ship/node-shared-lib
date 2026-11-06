def call(String bumpType) {
    dir('app') {
        sh "npm version ${params.VERSION_BUMP} --no-git-tag-version"
        def matcher = readFile('package.json') =~ '"version": "(.+)"'
        def version = matcher[0][1]
        env.IMAGE_NAME = "${version}-${env.BUILD_NUMBER}"
    }
}

