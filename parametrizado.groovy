job('ejemplo-job-DSL'){
  description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/alexmfz/Jenkins.git', 'main') { node -> 
      node / gitConfigName('alexmfz')
      node / gitConfigEmail('nataelmf@gmail.com')    
    }
  }
  parameters {
    stringParam('nombre', defaultValue='Alex', description='Name parameter') 
    stringParam('curso', defaultValue='Jenkins', description='Course parameter') 
	}
  triggers {
    cron('H/7 * * * *')
    }
  steps {
    shell("apt-get install dos2unix")
	shell("dos2unix /var/jenkins_home/workspace/ejemplo-job-DSL/jobParametrized.sh")   
    shell("bash /var/jenkins_home/workspace/ejemplo-job-DSL/jobParametrized.sh")   
    }
 publishers {
   	mailer('nataelmf@gmail.com', dontNotifyEveryUnstableBuild = true, sendToIndividuals = true)
   	slackNotifier {
       notifyAborted(true)	
       notifyEveryFailure(true)
       notifyNotBuilt(false)
       notifyBackToNormal(true)
       notifySuccess(false)
       notifyRepeatedFailure(false)
       startNotification(false)
       includeTestSummary(false)
       includeCustomMessage(false)
       sendAs(null)
       commitInfoChoice('NONE')
       teamDomain(null)
       authToken(null)
   }
    }
}
