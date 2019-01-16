package com.sucho.notesapp.injection.module

import com.sucho.notesapp.MainActivity
import com.sucho.notesapp.injection.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
  internal abstract fun bindMainActivity(): MainActivity

  @Module(includes = [(BaseActivityModule::class)])
  abstract class ActivityModule<in T : DaggerAppCompatActivity> {
    @Binds
    @ActivityScope
    internal abstract fun bindActivity(activity: T): DaggerAppCompatActivity
  }

  @Module
  open class BaseActivityModule {
/*
    @Provides
    @ActivityScope
    internal fun provideNavigator(activity: DaggerAppCompatActivity): Navigator {
      return ActivityNavigator(activity)
    }*/
  }
}