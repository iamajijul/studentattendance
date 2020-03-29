package com.nilesh.tdd.studentattendance

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var presentar: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializePresenter()
        initializeView()
    }

    private fun initializeView() {

        btnLogin.setOnClickListener {
            presentar.isLoginSuccess(et_user_name!!.text.toString().trim { it <= ' ' },
                et_password!!.text.toString().trim { it <= ' ' })
        }
    }

    private fun initializePresenter() {

        presentar = LoginPresenter(this)
    }

    override fun showErrorMessageForUsernameAndPassword() {
        Snackbar.make(et_user_name, "Please check Username or Password.", Snackbar.LENGTH_LONG).show()

    }

    override fun showErrorMessageForMaxLoginAttempt() {
        Snackbar.make(et_password, "You have exceed maximum attempt.", Snackbar.LENGTH_LONG).show()

    }

    override fun showLoginSuccessMessage() {
        Snackbar.make(btnLogin, "Login Successful.", Snackbar.LENGTH_LONG).show()

    }
}
