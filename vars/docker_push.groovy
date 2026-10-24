def call(String credId, String imgname){
                withCredentials([usernamePassword(
                    credentialsId: "${credId}",
                    passwordVariable: "dockerPass",
                    usernameVariable: "dockerUser"
                    )]){
                    sh "docker login -u ${env.dockerUser} -p ${env.dockerPass}"
                    sh "docker image tag ${imgname} ${env.dockerUser}/${imgname}"
                    sh "docker push ${env.dockerUser}/${imgname}:latest"
                }
}
