package com.example.myportfolio


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), onCLickCallBackListener {
    private lateinit var list: ArrayList<DataModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Main Activity", "onCreate Called")

        list = ArrayList()
        addSocialMedia()

        recycler_view.layoutManager = GridLayoutManager(this, 4)
        recycler_view.adapter = MediaAdapter(list, this)

    }

    private fun addSocialMedia() {

        list.add(
            DataModel(R.drawable.google, "Google","https://www.google.com")
        )
        list.add(
            DataModel(R.drawable.fb, "Facebook", "https://m.facebook.com/femjuri")
        )
        list.add(
            DataModel(R.drawable.whatsapp, "Whatsapp", "https://api.whatsapp.com/send?phone=2348168036131")
        )
        list.add(
            DataModel(R.drawable.email, "E-mail", "https://mail.google.com/mail/mu/mp/788/#co")
        )
        list.add(
            DataModel(R.drawable.git, "Github", "https://www.github.com/dev-juri")
        )
        list.add(
            DataModel(R.drawable.youtube, "Youtube", "https://www.youtube.com/learnwithhng")
        )
        list.add(
            DataModel(R.drawable.ig, "Instagram", "https://www.instagram.com")
        )
        list.add(
            DataModel(R.drawable.www, "Website", "https://www.mywebsite.com")
        )
    }

    override fun callBack(icon: DataModel, position: Int) {
        val intent = Intent()
        intent.data = Uri.parse(icon.mediaUrl)
        intent.action = Intent.ACTION_VIEW
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Main Activity", "onStart Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Main Activity", "onStop Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Main Activity", "onPause Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Main Activity", "onResume Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main Activity", "onDestroy Called")
    }
}


