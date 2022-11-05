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

    var spinJenisKelamin = ""
//    var hasilBMI = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnHitung = findViewById(R.id.btnHitung)
        tvHasil = findViewById(R.id.tvHasil)

        val jeniskelamin = resources.getStringArray(R.array.jenis_kelamin)
        val spinner = findViewById<Spinner>(R.id.jeniskelamin)

        ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinJenisKelamin = p0?.getItemAtPosition(p2).toString()
            }
        }

        btnHitung.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        beratBadan = findViewById(R.id.beratBadan)
        tinggiBadan = findViewById(R.id.tinggiBadan)
        if(p0?.id == R.id.btnHitung) {
            if(beratBadan.text.toString() === "") {
                tvHasil.text = spinJenisKelamin
            }
        }
//        if(beratBadan.getText().toString().trim() === "") {
//            Toast.makeText(applicationContext, "Form wajib diisi!",Toast.LENGTH_LONG).show()
//        } else {
//            if(p0?.id == R.id.btnHitung) {
//                val inputBeratBadan = beratBadan.text.toString().trim()
//                val inputTinggiBadan = tinggiBadan.text.toString().trim()
//                val tinggiMeter = inputTinggiBadan.toDouble() / 100
//
//                val bmi = inputBeratBadan.toDouble() / (tinggiMeter.toDouble() * tinggiMeter.toDouble())
//                tvHasil.text = spinJenisKelamin
//            }
//        }
    }
}
