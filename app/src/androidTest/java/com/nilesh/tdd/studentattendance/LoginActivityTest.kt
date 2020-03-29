package com.nilesh.tdd.studentattendance

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {

    @get:Rule
    var loginActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun userNameEditTextIsDisplayed() {
        loginActivityTestRule.launchActivity(Intent())
        onView(withId(R.id.et_user_name)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPasswordEditTextIsDisplayed() {
        loginActivityTestRule.launchActivity(Intent())
        onView(withId(R.id.et_password))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkErrorMessageIsDisplayedForEmptyData() {
        loginActivityTestRule.launchActivity(Intent())
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed())).perform(click())
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()))

    }

    @Test
    fun checkLoginSuccess() {
        loginActivityTestRule.launchActivity(Intent())
        onView(withId(R.id.et_user_name)).perform(typeText("Ajijul"), closeSoftKeyboard())
        onView(withId(R.id.et_password)).perform(typeText("12345"), closeSoftKeyboard())
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed())).perform(click())
        onView(withText("Login Successful.")).check(matches(isDisplayed()))

    }

}