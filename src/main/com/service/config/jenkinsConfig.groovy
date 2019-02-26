#!/bin/groovy

package com.main.service.config

def setupJenkinsConfig(){

try {
     wrap([$class: 'AnsiColorBuildWrapper']) {
	 properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '10', artifactNumToKeepStr: '10', daysToKeepStr: '10', numToKeepStr: '10')), gitLabConnection(''), [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false], [$class: 'ThrottleJobProperty', categories: [], limitOneJobWithMatchingParams: false, maxConcurrentPerNode: 0, maxConcurrentTotal: 0, paramsToUseForLimit: '', throttleEnabled: false, throttleOption: 'project']])
	 }
	 }
	 catch (error) {
     wrap([$class: 'AnsiColorBuildWrapper']) {
         print "\u001B[41m[ERROR]: failed to setup the Jenkins Configuration.."
        throw error
     }
   }

}