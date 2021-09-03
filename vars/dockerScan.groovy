def call(body){
    def config = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body()
    def dockerImage = config.dockerImageName
    def var = sh "docker scan ${dockerImageName}"
    print(var)
}
