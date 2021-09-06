def call(body){
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def dockerImageName = config.dockerImageName
    def dockerImage = """$dockerImageName"""
    print(dockerImageName)
    print(dockerImage)
    sh """echo $dockerImageName"""
    sh """docker run $dockerImageName"""
}
