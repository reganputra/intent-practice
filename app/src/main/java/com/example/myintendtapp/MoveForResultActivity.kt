package com.example.myintendtapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Latihan Mendapatkan Nilai Balik dari Intent
class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_choose){
            if (rgNumber.checkedRadioButtonId > 0){
                var value = 0

                when(rgNumber.checkedRadioButtonId){
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultInten = Intent()
                resultInten.putExtra(EXTRA_SELECTED_VALUE,value)
                setResult(RESULT_CODE, resultInten)
                finish() // menuntup activity saat ini dan kembali ke Activity sebelumnya.
                        // saat terturup callback ActivityResultLauncher pada MainActivity akan dijalankan
            }
        }
    }
}