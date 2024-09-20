package com.example.myintendtapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    //membuat sebuah Activity yang dapat mengembalikan nilai
    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult( // mendaftarkan jenis kembalian
        ActivityResultContracts.StartActivityForResult() // mendapatkan nilai kembalian setelah memanggil Activity baru
    ) {result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) { // merespon nilai balik dari MoveForResultActivity
            val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil: $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // intialized component

        //Intent Explicit
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        //Mengirim Data pada Intent
        val btnMoveWithData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithData.setOnClickListener(this)

        //Latihan Inten Parcelable
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        //Latihan Intent Implicit
        val btnDialPone: Button = findViewById(R.id.btn_dial_number)
        btnDialPone.setOnClickListener(this)

        // Latihan Mendapatkan Nilai Balik dari Intent
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)  // berpindah ke activity lain
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Anjay Mabar")// menambahkan data pada intent
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person("Regan", 5, "batukahn@gmail","Surabaya") // objek person
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "082629847"
                val dialPhoneInten = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")) //melakukan proses dial sebuah nomor telepon
                startActivity(dialPhoneInten)
            }
            R.id.btn_move_for_result -> {
                val  moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent) // launch unutk mendapaktan nilai balik dari intent
            }
        }
    }
}
