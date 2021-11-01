package com.example.testproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testproject.databinding.FragmentExpandableCardBinding

class ExpandableCardFragment : Fragment() {

    private var _binding: FragmentExpandableCardBinding? = null
    private val mBinding get() = _binding!!

    companion object {

        @JvmStatic
        fun newInstance() = ExpandableCardFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpandableCardBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}