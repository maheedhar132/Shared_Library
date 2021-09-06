def call(body){
    def config = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body()
    print(1.**)
    print(config.dockerImageName)
    print(2.****)
    print(config.dockerImage)
    def dockerImageName = config.dockerImageName
    def dockerImage = """$dockerImageName"""
    print(dockerImageName)
    print(dockerImage)
    sh """echo $dockerImageName"""
    sh """docker run $dockerImageName"""
}
