package com.jinyeob.eqt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jinyeob.domain.model.CheckItem
import com.jinyeob.eqt.databinding.FragmentMccheyneSingleBinding

class MccheyneSingleFragment(checkItem:CheckItem) : Fragment() {
    private var binding by autoCleared<FragmentMccheyneSingleBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMccheyneSingleBinding.inflate(inflater, container, false)
        return binding.root
    }
}
