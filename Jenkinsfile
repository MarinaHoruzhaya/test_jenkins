pipeline {
    agent any

environment {
    ALLURE_RESULTS = "build/allure-results"
    ALLURE_REPORT = "build/allure-report"
}

triggers {
    // Запуск каждый день в 9:00
    cron('H 9 * * *')
}

stages {
    stage('Checkout') {
        steps {
            git branch: 'main', url: 'https://github.com/MarinaHoruzhaya/test_jenkins.git'
        }
    }

    stage('Build & Test') {
        steps {
            sh './gradlew test'
        }
    }

    stage('Allure Report') {
        steps {
            echo "Генерация Allure отчета"
            sh './gradlew allureReport'

            // Публикация отчета в Jenkins
            allure([
                reportDir: "${ALLURE_REPORT}",
                results: [[path: "${ALLURE_RESULTS}"]]
            ])
        }
    }
}

post {
    always {
        echo "Отправка email с результатами"
        emailext(
            to: 'marinakh192@gmail.com',
            subject: "Jenkins Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) - ${currentBuild.currentResult}",
            body: """
                Job: ${env.JOB_NAME}
                Build: ${env.BUILD_NUMBER}
                Result: ${currentBuild.currentResult}
                Подробнее в Allure: ${env.BUILD_URL}allure/
            """
        )
    }
}
}