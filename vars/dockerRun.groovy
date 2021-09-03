def call(body){
    def config = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body()
    def dockerImageName = config.dockerImageName
    echo ${dockerImageName}
    sh "docker run ${dockerImageName}"
}
