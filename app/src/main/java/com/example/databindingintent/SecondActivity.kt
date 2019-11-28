package com.example.databindingintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)
        textViewReceiveName.text = name
        textViewReceivePhone.text = phone

        buttonDone.setOnClickListener {
            if(editTextReply.text.isNotEmpty()){
                val reply = editTextReply.text.toString()
                intent.putExtra(MainActivity.EXTRA_REPLY,reply)
                setResult(Activity.RESULT_OK,intent)
            }else{
                setResult(Activity.RESULT_CANCELED,intent)
            }
            finish()
        }

        buttonCall.setOnClickListener {
            val phone = Uri.parse("tel:" + textViewReceivePhone.text.toString())

            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(phone)

            if(intent.resolveActivity(packageManager)!= null){
                startActivity(intent)
            }

        }
    }


}
