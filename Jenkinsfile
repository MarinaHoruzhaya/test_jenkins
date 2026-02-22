pipeline {
    agent any

stages {
    stage('Run Tests') {
        steps {
            // Запуск тестов через Gradle
            sh './gradlew clean test'
        }
    }

    stage('Allure Report') {
        steps {
            // Генерация Allure отчёта
            sh 'allure generate build/allure-results --clean -o build/allure-report'
        }
    }

    stage('Send Email') {
        steps {
            // Отправка email с ссылкой на отчёт
            emailext (
                subject: "Allure Report - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Отчёт доступен в Jenkins: ${env.BUILD_URL}",
                to: "your.email@example.com"
            )
        }
    }
}