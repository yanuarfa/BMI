package b1.uts0703040054.achmadfauzan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var beratBadan: EditText
    private lateinit var tinggiBadan: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        beratBadan = findViewById(R.id.beratBadan)
        tinggiBadan = findViewById(R.id.tinggiBadan)
        btnHitung = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)

        val jeniskelamin = resources.getStringArray(R.array.jenis_kelamin)
        val spinner = findViewById<Spinner>(R.id.jeniskelamin)

        ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        btnHitung.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnHitung) {
            val inputBeratBadan = beratBadan.text.toString().trim()
            val inputTinggiBadan = tinggiBadan.text.toString().trim()
            val tinggiMeter = inputTinggiBadan.toDouble() / 100

            val bmi = inputBeratBadan.toDouble() / (tinggiMeter.toDouble() * tinggiMeter.toDouble())
            tvHasil.text = bmi.toString()
        }
    }
}
