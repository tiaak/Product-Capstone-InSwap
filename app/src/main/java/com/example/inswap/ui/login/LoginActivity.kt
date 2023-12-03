package com.example.inswap.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import com.example.inswap.ViewModelFactory
import com.example.inswap.databinding.ActivityLoginBinding
import com.example.inswap.ui.customView.MyButton
import com.example.inswap.ui.customView.MyMinPass
import com.example.inswap.ui.home.HomeFragment
import com.example.inswap.ui.main.MainActivity
import com.example.inswap.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity(), OnClickListener {

    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivityLoginBinding
    private lateinit var myMinPass: MyMinPass
    private lateinit var myButton: MyButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideActionBar()

        myMinPass = binding.passwordInputText
        myButton = binding.loginButton

        binding.loginButton.setOnClickListener(this)
        binding.textToRegister.setOnClickListener(this)


        myMinPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do Nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButton(true)
            }

            override fun afterTextChanged(s: Editable?) {
                //Do Nothing
            }
        })

    }

    private fun setMyButton(isEnable: Boolean) {
        val pass = myMinPass.text
        if (isEnable) {
            if (pass != null) {
                myButton.isEnabled = pass.length >= 8
            }
        } else myButton.isEnabled = false
    }

    protected fun hideActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

//    fun onTextClick(view: View) {
//        when (view) {
//
//        }
//    }

    override fun onClick(view: View?) {
        when(view){
            binding.loginButton ->{
                val moveToMain = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(moveToMain)
                finish()
            }
            binding.textToRegister -> {
                val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

}