def call(body){
	def config = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = config
	body()
        def dockerImageName = config.dockerImageName
	print(dockerImageName)
	def dockerImage = "$dockerImageName"
        node{
            stage('docker build'){
                dockerRun{
			sh "echo $dockerImageName"
			dockerImageName = dockerImage
			}
            }
            stage('docker scan'){
                dockerScan{
			dockerImageName = "${dockerImageName}"
                }
            }
        }
}
