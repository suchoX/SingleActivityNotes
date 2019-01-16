package com.sucho.notesapp.injection.component

import com.sucho.notesapp.BaseApplication
import com.sucho.notesapp.injection.module.ActivityBindingModule
import com.sucho.notesapp.injection.module.AppModule
import com.sucho.notesapp.injection.module.ViewModelFactoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (ViewModelFactoryModule::class), (AndroidSupportInjectionModule::class), (ActivityBindingModule::class)])
interface AppComponent : AndroidInjector<BaseApplication> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}