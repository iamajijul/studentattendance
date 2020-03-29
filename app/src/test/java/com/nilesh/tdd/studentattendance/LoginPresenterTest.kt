package com.nilesh.tdd.studentattendance

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LoginPresenterTest{

    var loginView = mock(LoginView::class.java)
    var presenter = LoginPresenter(loginView)
    @Test
    fun checkIfLoginAttemptExceeded(){

        Assert.assertEquals(1,presenter.incrementLoginAttempt())
        Assert.assertEquals(2,presenter.incrementLoginAttempt())
        Assert.assertEquals(3,presenter.incrementLoginAttempt())

        Assert.assertTrue(presenter.isLoginAttemptExceeded())

    }

    @Test
    fun checkIfLoginAttemptIsNotExceeded(){
        Assert.assertFalse(presenter.isLoginAttemptExceeded())
    }

    @Test
    fun checkUserNameAndPasswordIsCurrect(){

        Assert.assertTrue(presenter.isLoginSuccess("Ajijul","12345"))
        verify(loginView).showLoginSuccessMessage()
    }
    @Test
    fun checkUserNameAndPasswordIsInCurrect(){

        Assert.assertFalse(presenter.isLoginSuccess("xyz","12345"))
        verify(loginView).showErrorMessageForUsernameAndPassword()
    }

    @Test
    fun checkIfLoginAttemptIsExceedAndViewMethodIsCalled(){

        Assert.assertFalse(presenter.isLoginSuccess("xyz","12345"))
        Assert.assertFalse(presenter.isLoginSuccess("xyz","12345"))
        Assert.assertFalse(presenter.isLoginSuccess("xyz","12345"))
        Assert.assertFalse(presenter.isLoginSuccess("xyz","12345"))
        verify(loginView).showErrorMessageForMaxLoginAttempt()
    }
}