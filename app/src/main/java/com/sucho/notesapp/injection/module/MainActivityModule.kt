package com.sucho.notesapp.injection.module

import androidx.appcompat.app.AppCompatActivity
import com.sucho.notesapp.MainActivity
import com.sucho.notesapp.feature.highlightednotes.HighlightedNotesListFragment
import com.sucho.notesapp.feature.newnote.NewNoteFragment
import com.sucho.notesapp.feature.noteslist.NotesListFragment
import com.sucho.notesapp.injection.module.ActivityBindingModule.BaseActivityModule
import com.sucho.notesapp.injection.scope.ActivityScope
import com.sucho.notesapp.injection.scope.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {
  @FragmentScope
  @ContributesAndroidInjector
  internal abstract fun showNotesListFragment(): NotesListFragment

  @FragmentScope
  @ContributesAndroidInjector
  internal abstract fun showHighlightedNotesListFragment(): HighlightedNotesListFragment

  @FragmentScope
  @ContributesAndroidInjector
  internal abstract fun showNewNoteFragment(): NewNoteFragment

  @Binds
  @ActivityScope
  abstract fun provideActivity(mainActivity: MainActivity): AppCompatActivity
}