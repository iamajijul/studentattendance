package com.nilesh.tdd.studentattendance

interface LoginView {

    fun showErrorMessageForUsernameAndPassword()
    fun showErrorMessageForMaxLoginAttempt()
    fun showLoginSuccessMessage()
}