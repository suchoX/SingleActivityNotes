package com.sucho.notesapp.injection.module

import android.content.Context
import com.sucho.notesapp.BaseApplication
import com.sucho.notesapp.injection.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class AppModule {

  @Provides
  @ApplicationContext
  internal fun provideApplicationContext(app: BaseApplication): Context = app.applicationContext

}