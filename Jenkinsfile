pipeline {
	 //Donde se va a ejecutar el Pipeline
	 agent {
		 label 'Slave_Induccion'
	 }
	
	 //Opciones especÃƒÂ­ficas de Pipeline dentro del Pipeline
	 options {
		//Mantener artefactos y salida de consola para el # especÃƒÂ­fico de ejecuciones recientes del Pipeline.
		buildDiscarder(logRotator(numToKeepStr: '3'))
	
		//No permitir ejecuciones concurrentes de Pipeline
		disableConcurrentBuilds()
	 }
	 
	 //Una secciÃƒÂ³n que define las herramientas para Ã¢â‚¬Å“autoinstalarÃ¢â‚¬ï¿½ y poner en la PATH
	 tools {
		 jdk 'JDK8_Centos' //Preinstalada en la ConfiguraciÃƒÂ³n del Master
		 gradle 'Gradle4.5_Centos' //Preinstalada en la ConfiguraciÃƒÂ³n del Master
	 }
	
	 //AquÃƒÂ­ comienzan los Ã¢â‚¬Å“itemsÃ¢â‚¬ï¿½ del Pipeline
	 stages{
		stage('Checkout') {
	 		steps{
	 			echo "------------>Checkout<------------"
	 			
	 			checkout([$class: 'GitSCM', branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false, extensions: [], gitTool:
			'Git_Centos', submoduleCfg: [], userRemoteConfigs: [[credentialsId:
			'GitHub_EduardoMontejo', url:
			'https://github.com/EduardoMontejo/estacionamiento']]]) 			
	 		}
	 	}
	 	
	 	stage('Unit Tests') {
	 		steps{
	 			echo "------------>Unit Tests<------------"
	 		}
	 	}
	 	
	 	stage('Integration Tests') {
	 		steps {
	 			echo "------------>Integration Tests<------------"
	 		}
	 	}
	 
	    stage('Static Code Analysis') {
		  	steps {
		        echo '------------>Análisis de código estático<------------'
		   		withSonarQubeEnv('Sonar') {
		     		sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"    
		   		}
		  	}
		}
	 	
	 	stage('Build') {
	 		steps {
	 			echo "------------>Build<------------"
	 			sh 'gradle --b ./build.gradle compileJava'
	 		}
	 	}
	 }
	 
	 post {
		 always {
		 	echo 'This will always run'
		 }
	 
	 	success {
	 		echo 'This will run only if successful' 
//	 		junit ​'**/build/test-results/test/*.xml'  
	 	}
	 
	 	failure {
	 		echo 'This will run only if failed' 
	 		mail (to: '​eduardo.montejo@ceiba.com.co​',
	 				subject: "​Failed Pipeline:${currentBuild.fullDisplayName}​",
	 				body: "​Something is wrong with ${env.BUILD_URL}​") 
	 	}
	 
	 	unstable {
	 		echo 'This will run only if the run was marked as unstable'
	 	}
	 
	 	changed {
	 		echo 'This will run only if the state of the Pipeline has changed'
	 		echo 'For example, if the Pipeline was previously failing but is now successful'
	 	}
	 }
}
