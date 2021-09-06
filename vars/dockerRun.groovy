def call(body){
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def dockerImageName = config.dockerImageName
    def dockerImageName = """$dockerImageName"""
    print(dockerImageName)
    sh """echo $dockerImageName"""
    sh """docker run $dockerImageName"""
}
