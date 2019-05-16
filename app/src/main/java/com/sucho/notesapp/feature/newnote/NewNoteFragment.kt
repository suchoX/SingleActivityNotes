package com.sucho.notesapp.feature.newnote

import com.sucho.notesapp.R
import com.sucho.notesapp.databinding.FragmentHighlightedNotesBinding
import com.sucho.notesapp.databinding.FragmentNewNoteBinding
import com.sucho.notesapp.feature.base.BaseFragment
import com.sucho.notesapp.feature.highlightednotes.HighlightedNotesListViewModel

class NewNoteFragment : BaseFragment<FragmentNewNoteBinding, NewNoteViewModel>() {
  override fun getViewModelClass(): Class<NewNoteViewModel> = NewNoteViewModel::class.java

  override fun layoutId(): Int = R.layout.fragment_new_note
}