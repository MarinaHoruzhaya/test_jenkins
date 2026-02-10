pipeline {
    agent any

triggers {
    cron('H 9 * * *')   // каждый день в 9 утра
}

stages {

    stage('Checkout') {
        steps {
            git branch: 'main', url: 'https://github.com/MarinaHoruzhaya/test_jenkins.git'
        }
    }

    stage('Build') {
        steps {
            sh './gradlew clean build -x test'
        }
    }

    stage('Tests') {
        steps {
            sh './gradlew test'
        }
    }

    stage('Report') {
        steps {
            echo 'Tests finished'
        }
    }
}

post {
    always {
        echo 'Pipeline finished'

        emailext(
            subject: "QA Tests: ${currentBuild.currentResult}",
            body: """
            Build: ${env.BUILD_NUMBER}
            Status: ${currentBuild.currentResult}
            Job: ${env.JOB_NAME}
            Link: ${env.BUILD_URL}
            """,
            to: "marinakh192@gmail.com"
        )
    }
}
}