package com.sucho.notesapp.feature.noteslist

import com.sucho.notesapp.R
import com.sucho.notesapp.databinding.FragmentNotesListBinding
import com.sucho.notesapp.feature.base.BaseFragment

class NotesListFragment : BaseFragment<FragmentNotesListBinding, NotesListViewModel>() {
  override fun getViewModelClass(): Class<NotesListViewModel> = NotesListViewModel::class.java

  override fun layoutId(): Int = R.layout.fragment_notes_list
}