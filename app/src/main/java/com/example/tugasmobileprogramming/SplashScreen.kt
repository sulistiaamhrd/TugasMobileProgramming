package com.example.tugasmobileprogramming

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //deklarasi variabel ID
        val imgSplash = findViewById<ImageView>(R.id.imgSplash)
        val imgKoneksi = findViewById<ImageView>(R.id.imgKoneksi)

        val splashTime: Long = 3000 // lama splashscreen berjalan


        Handler().postDelayed({
            if(adaInternet()){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent) // Pindah ke Login Activity setelah 3 detik
                finish()
            } else {
                imgSplash.visibility = View.GONE
                imgKoneksi.visibility = View.VISIBLE
                Toast.makeText(this@SplashScreen, "Tidak ada internet Coba lagi", Toast.LENGTH_LONG).show();
            }

        }, splashTime)
    }

    //cek koneksi internet
    private fun adaInternet(): Boolean {
        val koneksi = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return koneksi.activeNetworkInfo != null
    }
}