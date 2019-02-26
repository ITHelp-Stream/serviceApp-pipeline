#!/bin/groovy

package main.com.service.config

def setupJenkinsConfig(){

try {
     wrap([$class: 'AnsiColorBuildWrapper']) {
	 properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '2', artifactNumToKeepStr: '2', daysToKeepStr: '2', numToKeepStr: '2')), gitLabConnection(''), [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false], [$class: 'ThrottleJobProperty', categories: [], limitOneJobWithMatchingParams: false, maxConcurrentPerNode: 0, maxConcurrentTotal: 0, paramsToUseForLimit: '', throttleEnabled: false, throttleOption: 'project']])
	 }
	 }
	 catch (error) {
     wrap([$class: 'AnsiColorBuildWrapper']) {
         print "\u001B[41m[ERROR]: failed to setup the Jenkins Configuration.."
        throw error
     }
   }

}