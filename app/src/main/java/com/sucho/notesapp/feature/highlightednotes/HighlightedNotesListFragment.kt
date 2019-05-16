package com.sucho.notesapp.feature.highlightednotes

import com.sucho.notesapp.R
import com.sucho.notesapp.databinding.FragmentHighlightedNotesBinding
import com.sucho.notesapp.feature.base.BaseFragment

class HighlightedNotesListFragment : BaseFragment<FragmentHighlightedNotesBinding, HighlightedNotesListViewModel>() {
  override fun getViewModelClass(): Class<HighlightedNotesListViewModel> = HighlightedNotesListViewModel::class.java

  override fun layoutId(): Int = R.layout.fragment_highlighted_notes
}