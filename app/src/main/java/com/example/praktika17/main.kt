package com.example.praktika17

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class main : AppCompatActivity() {

    private lateinit var login:EditText
    private  lateinit var pass:EditText
    private lateinit var pref:SharedPreferences


    private lateinit var  builder:AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login=findViewById(R.id.login)
        pass=findViewById(R.id.pass)


    }

    fun handler(v: View ) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Важный выбор")
            .setMessage("Выбери что делаем")
            .setCancelable(true)
            .setPositiveButton("Сохранить") { _, _ ->

                Toast.makeText(
                    this,
                    "Сохранено",
                    Toast.LENGTH_LONG
                ).show()
                findViewById<TextView>(R.id.sxlog).text=pref.getString("login", "")
                findViewById<TextView>(R.id.sxpas).text=pref.getString("login", "")
                pref=getPreferences(MODE_PRIVATE)
                val ed = pref.edit()
                ed.putString("login", login.text.toString())
                ed.putString("password", pass.text.toString())
                ed.apply()
            }
            .setNegativeButton(
                "Загрузить"
            ) { _, _ ->

                Toast.makeText(
                    this, "загружено",
                    Toast.LENGTH_LONG
                ).show()
                pref=getPreferences(MODE_PRIVATE)
                login.setText(pref.getString("login", ""));
                pass.setText(pref.getString("password", ""));
            }
        builder.create()
        builder.show()

    }

    fun enter(view: View) {
        if(login.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty()){
            val intent= Intent(this,Color2::class.java)
            startActivity(intent)
        }
        else{
            val toast = Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT )
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }
    }


}


/*

СLass spinner : AppCompatActivity () (
lateinit var spin: Spinner
lateinit var adapter: ArrayAdapter<String>
@Override
override fun onCreate (savedInstanceState: Bundle?) {
super. onCreate (savedInstanceState)
setContentView (com.example.sharedpreferenc.R.layout.activity_spinner)
var spin - findViewById<Spinner> (R.id.sp)
ArrayAdapter. createFromResource (
this,
R.array.catNames,
android. R. layout.simple_spinner_item
).also { adapter ->
adapter.setDropDownViewResource (android.R. layout. simple_spinner_dropdown,
item
spin. adapter = adapter
}*/
