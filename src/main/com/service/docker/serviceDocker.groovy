#!/bin/groovy

package main.com.service.docker

def createDockerImage(DOCKER_IMAGE_NAME, DOCKERFILE_PATH){
try {
    wrap([$class: 'AnsiColorBuildWrapper']) {
	sh "docker build -t ${DOCKER_IMAGE_NAME} -f ${DOCKERFILE_PATH} "
    print "\u001B[32m[INFO]: Docker Image Successfully Created..."
	}
	}
    catch (error) {
     wrap([$class: 'AnsiColorBuildWrapper']) {
        print "\u001B[41m[ERROR]: Failed to create Image.. please check the console logs"
        throw error
     }
   }

}