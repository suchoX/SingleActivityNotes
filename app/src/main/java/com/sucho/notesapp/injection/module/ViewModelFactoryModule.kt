package com.sucho.notesapp.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sucho.notesapp.feature.noteslist.NotesListViewModel
import com.sucho.notesapp.injection.scope.ViewModelScope
import com.sucho.notesapp.MainActivityViewModel
import com.sucho.notesapp.feature.highlightednotes.HighlightedNotesListFragment
import com.sucho.notesapp.feature.highlightednotes.HighlightedNotesListViewModel
import com.sucho.notesapp.feature.newnote.NewNoteViewModel
import com.sucho.notesapp.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  @IntoMap
  @ViewModelScope(MainActivityViewModel::class)
  abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelScope(NotesListViewModel::class)
  abstract fun bindNotesListViewModel(notesListViewModel: NotesListViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelScope(HighlightedNotesListViewModel::class)
  abstract fun bindHighlightedNotesListViewModel(highlightedNotesListViewModel: HighlightedNotesListViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelScope(NewNoteViewModel::class)
  abstract fun bindNewNoteViewModel(newNoteViewModel: NewNoteViewModel): ViewModel

  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}