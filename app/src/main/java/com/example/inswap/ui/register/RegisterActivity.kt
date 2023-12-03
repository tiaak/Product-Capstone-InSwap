package com.example.inswap.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import com.example.inswap.R
import com.example.inswap.databinding.ActivityRegisterBinding
import com.example.inswap.ui.customView.MyButton
import com.example.inswap.ui.customView.MyMinPass
import com.example.inswap.ui.login.LoginActivity
import com.example.inswap.ui.main.MainActivity

class RegisterActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var myMinPass: MyMinPass
    private lateinit var myButton : MyButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideActionBar()

        myMinPass = binding.passwordInputText
        myButton = binding.registerButton

        binding.registerButton.setOnClickListener(this)

        myMinPass.addTextChangedListener(object: TextWatcher {
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
        if(isEnable){
            if(pass != null){
                myButton.isEnabled = pass.length >= 8
            }
        }else myButton.isEnabled = false
    }

    private fun hideActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

    override fun onClick(view: View?) {
        when(view){
            binding.registerButton -> {
                val moveToLogin = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(moveToLogin)
                finish()
            }
        }
    }
}