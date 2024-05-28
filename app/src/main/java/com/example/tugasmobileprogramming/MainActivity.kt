package com.example.tugasmobileprogramming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi variabel ID
        val ImgSuhu = findViewById<ImageView>(R.id.ImgSuhu) as ImageView
        val ImgJarak = findViewById<ImageView>(R.id.ImgJarak) as ImageView
        val Imgmasa = findViewById<ImageView>(R.id.ImgMasa) as ImageView
        val ImgWaktu = findViewById<ImageView>(R.id.ImgWaktu) as ImageView

        //coding klik untuk pindah activity
        ImgSuhu.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivityKonversi::class.java)
            startActivity(intent) // Pindah ke MainActivity
            finish()
        })

        //coding clik untuk informasi
        ImgJarak.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Jarak masih dalam tahap pengembangan", Toast.LENGTH_LONG).show();
        })

        Imgmasa.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Masa masih dalam tahap pengembangan", Toast.LENGTH_LONG).show();
        })

        ImgWaktu.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Waktu masih dalam tahap pengembangan", Toast.LENGTH_LONG).show();
        })
    }

}