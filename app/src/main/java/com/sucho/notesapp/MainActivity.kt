package com.sucho.notesapp

import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sucho.notesapp.feature.base.BaseActivity
import androidx.navigation.ui.setupWithNavController

class MainActivity : BaseActivity<MainActivityViewModel>() {
  override fun getViewModelClass(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val navController = findNavController(R.id.my_nav_host_fragment)
    findViewById<BottomNavigationView>(R.id.bottom_nav)
        .setupWithNavController(navController)
  }
}
