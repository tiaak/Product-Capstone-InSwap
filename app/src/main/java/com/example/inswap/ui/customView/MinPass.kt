package com.example.inswap.ui.customView

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class MinPass: AppCompatEditText, View.OnTouchListener {
    //TEMPA MENENTUKAN BEHAVIOR CUSTOM VIEW
    private fun init(){
        addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing.
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(s.toString().length < 8){
                    setError("At least 8 character", null)
                }else{
                    error = null
                }
            }
            override fun afterTextChanged(s: Editable) {
                // Do nothing.
            }
        })
    }

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return false
    }
}