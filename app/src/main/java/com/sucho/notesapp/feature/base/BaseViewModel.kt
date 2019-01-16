package com.sucho.notesapp.feature.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

  var compositeDisposable = CompositeDisposable()

  override fun onCleared() {
    super.onCleared()
    Timber.d("unsubscribeFromDataStore(): ")
    compositeDisposable.dispose()
    compositeDisposable.clear()
  }

  protected fun addDisposable(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }
}