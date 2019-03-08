#!/bin/groovy

package main.com.service.docker

def createDockerImage(String APP_IMAGE_NAME , String DOCKERFILE_PATH){
try {
    wrap([$class: 'AnsiColorBuildWrapper']) {
	print "\u001B[51mINFO => triggering docker build for $APP_IMAGE_NAME please wait..."
        sh "cd ${WORKSPACE}"
	sh "docker build -t ${APP_IMAGE_NAME} --file=${DOCKERFILE_PATH} ${WORKSPACE}"
	}
	}
    catch (error) {
     wrap([$class: 'AnsiColorBuildWrapper']) {
        print "\u001B[41m[ERROR]: Failed to create Image.. please check the console logs"
        throw error
     }
   }

}
