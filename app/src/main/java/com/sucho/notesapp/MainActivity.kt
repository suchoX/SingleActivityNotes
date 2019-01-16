package com.sucho.notesapp

import android.os.Bundle
import com.sucho.notesapp.feature.base.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel>() {
  override fun getViewModelClass(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}
