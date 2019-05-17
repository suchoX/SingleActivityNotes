package com.sucho.notesapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sucho.notesapp.feature.base.BaseActivity
import androidx.navigation.ui.setupWithNavController

class MainActivity : BaseActivity<MainActivityViewModel>() {
  override fun getViewModelClass(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val navController = findNavController(R.id.my_nav_host_fragment)
    val appBarConfiguration = AppBarConfiguration
        .Builder(R.id.notesListFragment, R.id.highlightedNotesListFragment, R.id.newNoteFragment)
        .build()  //Had to manually give fragments to make them top level destinations and not show the back button
    findViewById<BottomNavigationView>(R.id.bottom_nav)
        .setupWithNavController(navController)
    findViewById<Toolbar>(R.id.toolbar)
        .setupWithNavController(navController, appBarConfiguration)
  }
}
