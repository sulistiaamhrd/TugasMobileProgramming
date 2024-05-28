package com.example.tugasmobileprogramming

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityKonversi : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konversi)

        val EdtSuhu = findViewById<EditText>(R.id.EdtSuhu) as EditText
        val buttonKonversi = findViewById<Button>(R.id.buttonKonversi) as Button
        val SpinnerSuhu = findViewById<Spinner>(R.id.SpinerSuhu) as Spinner
        val TextHasil = findViewById<TextView>(R.id.TextHasil) as TextView

        //list spinner
        val listitem = listOf("Celcius ke Reamur", "Celcius ke Kelvin", "Celcius ke Fahreinhat");

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, listitem
        )
        SpinnerSuhu.setAdapter(adapter)

        //klik spinner
        SpinnerSuhu.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long
            ){
               val getSpiner = SpinnerSuhu.selectedItem.toString();
                Toast.makeText(this@ActivityKonversi, "kamu pilih $getSpiner", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        //proses konversi suhu
        buttonKonversi.setOnClickListener(View.OnClickListener {
            val resultText: String
            var inputVal = EdtSuhu.text.toString()
            if (EdtSuhu.text.toString().equals("")) {
                Toast.makeText(this@ActivityKonversi, "Isi Kolom Input Suhu", Toast.LENGTH_LONG).show()
            } else if (SpinnerSuhu.selectedItem.toString() == "Celcius ke Reamur") {
                resultText = (inputVal.toInt() * 4 / 5).toString();
                TextHasil.setText(resultText)
            } else if (SpinnerSuhu.selectedItem.toString() == "Celcius ke Kelvin") {
                resultText = (inputVal.toInt() + 273).toString();
                TextHasil.setText(resultText)
            }else if (SpinnerSuhu.selectedItem.toString() == "Celcius ke Fahreinhat") {
                resultText = ((inputVal.toInt() * 9 / 5)+ 32).toString();
                TextHasil.setText(resultText)
            }
        })
    }
}