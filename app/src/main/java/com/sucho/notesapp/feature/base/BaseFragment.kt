package com.sucho.notesapp.feature.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sucho.notesapp.BR
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel> : Fragment(), HasSupportFragmentInjector {
  protected lateinit var binding: B
  lateinit var viewModel: VM

  private var compositeDisposable: CompositeDisposable? = null

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
    bindContentView()
    return binding.root
  }

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun onDestroy() {
    if (compositeDisposable != null) {
      compositeDisposable!!.dispose()
      compositeDisposable!!.clear()
      compositeDisposable = null
    }
    super.onDestroy()
  }

  fun addDisposable(disposable: Disposable) {
    if (compositeDisposable == null) {
      compositeDisposable = CompositeDisposable()
    }
    compositeDisposable!!.add(disposable)
  }

  private fun bindContentView() {
    viewModel = ViewModelProviders.of(this, viewModelFactory)
        .get(getViewModelClass())
    binding.setVariable(BR.viewModel, viewModel)
  }

  @Inject
  protected lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
    return childFragmentInjector
  }

  abstract fun getViewModelClass(): Class<VM>

  @LayoutRes protected abstract fun layoutId(): Int

}