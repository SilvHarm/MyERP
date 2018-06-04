pipeline	{
	agent any

	tools {
        maven 'maven-main'
    }

	stages	{
		stage("Checkout")	{
			steps {
				git url: "https://github.com/SilvHarm/MyERP",
					branch: "${if (env.GIT_BRANCH == "origin/master") {return "master"} else {return env.GIT_BRANCH}}"
			}
		}

		stage("Need Build ?")	{
			steps {
				script {
					if (env.GIT_COMMIT == env.GIT_PREVIOUS_SUCCESSFUL_COMMIT) {
						currentBuild.result = "ABORTED"
						error("Stopping early…")
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

		stage("Integration Testing")	{
			steps	{
				echo "Starting Test Database..."
				sh "cd docker/dev \
					&& docker-compose up &"

				// sleep to let database finish to startup before testing
				// need to be replaced with a "database is start" test
				sleep 10

				echo "Testing consumer module..."
				sh "mvn -f ./src verify -P test-consumer -Dskip.surefire.tests"

				echo "Resetting Test Database..."
				sh "cd docker/dev \
					&& docker-compose stop \
					&& docker-compose rm -v \
					&& docker-compose up &"

				// same as previous sleep
				sleep 10

				echo "Testing business module..."
				sh "mvn -f ./src verify -P test-business -Dskip.surefire.tests"
			}

			post {
				always {
					echo "Post Stage: Stopping Test Database..."
					sh "cd docker/dev \
						&& docker-compose stop \
						&& docker-compose rm -v"
				}
			}
		}
	}
}
