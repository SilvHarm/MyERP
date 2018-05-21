pipeline	{
	agent any
	stages {
		stage("Checkout")	{
			steps {
				git url: 'https://github.com/SilvHarm/MyERP'
			}
		}
		
		stage("Compile")	{
			steps	{
				withMaven(maven: 'maven-main')	{
					sh "mvn -f ./src clean compile"
				}
			}
		}
		
		stage("Tests Unitaires")	{
			steps	{
				withMaven(maven: 'maven-main')	{
					sh "mvn -f ./src test"
				}
			}
		}
	}
}
