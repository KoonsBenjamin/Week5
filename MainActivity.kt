package com.example.ben.week5

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEMail)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        txtName.requestFocus()
        btnSubmit.setOnClickListener{
            if (rbFemale.isChecked) txtShow.text = "Hello ${txtName.text}, the women's lounge is on the first floor. " +
                    "We will send an email of the meeting agenda to: ${txtEmail.text}"
            if (rbMale.isChecked) txtShow.text = "Hello ${txtName.text}, the men's lounge is on the second floor. " +
                    "We will send an email of the meeting agenda to: ${txtEmail.text}"
            hideKeyboard()
            txtName.setText("")
            txtEmail.setText("")
            txtName.requestFocus()
        }

    }

    fun hideKeyboard(){
        try{
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken,0)
        } catch (e: Exception) {

        }

    }
}
