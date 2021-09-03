def call(body){
		def config = [:]
		body.resolveStrategy = Closure.DELEGATE_FIRST
		body.delegate = config
		body()
        def dockerImageName = config.dockerImageName
        node{
            stage('docker build'){
                dockerRun{
                    dockerImageName=dockerImageName
                }
            }
            stage('docker scan'){
                dockerScan{
                    dockerImageName=dockerImageName
                }
            }
        }
}