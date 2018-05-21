pipeline	{
	agent any
	
	tools {
        maven 'maven-main' 
    }
	
	stages	{
		stage("Checkout")	{
			steps {
				git url: "https://github.com/SilvHarm/MyERP",
					branch: "${env.GIT_BRANCH}"
			}
		}
		
		stage("Need Build ?")	{
			steps {
				script {
					if (env.GIT_COMMIT == env.GIT_PREVIOUS_SUCCESSFUL_COMMIT) {
						currentBuild.result = 'ABORTED'
						error('Stopping early…')
					}
				}
			}
		}
			
		stage("Compile")	{
			steps	{
				sh "mvn -f ./src clean compile"
			}
		}
				
		stage("Unit Testing")	{
			steps	{
				sh "mvn -f ./src test"
			}
		}
	}
}
