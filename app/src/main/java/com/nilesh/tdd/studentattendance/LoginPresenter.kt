package com.nilesh.tdd.studentattendance

class LoginPresenter(var loginView: LoginView) {

    private val MAX_ATTEMPT = 3
    private var loginAttempt = 0L
    fun incrementLoginAttempt(): Long {
        loginAttempt += 1
        return loginAttempt
    }

    fun isLoginAttemptExceeded(): Boolean {

        return loginAttempt >= MAX_ATTEMPT
    }

    fun isLoginSuccess(userName: String, password: String): Boolean {

        if (isLoginAttemptExceeded())
        {
            loginView.showErrorMessageForMaxLoginAttempt()
            return false
        }
        if (userName == "Ajijul" && password == "12345") {
            loginView.showLoginSuccessMessage()
            resetLoginAttempt()
            return true
        }
        incrementLoginAttempt()
        loginView.showErrorMessageForUsernameAndPassword()
        return false
    }

    private fun resetLoginAttempt() {
        loginAttempt = 0
    }
}