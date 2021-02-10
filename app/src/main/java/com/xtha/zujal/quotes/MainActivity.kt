package com.xtha.zujal.quotes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val decorView: View = window.decorView
        val uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.setSystemUiVisibility(uiOptions)

        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            var mainFragment: MainFragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.rootid, mainFragment)
                .commitAllowingStateLoss()
        }



    }
}