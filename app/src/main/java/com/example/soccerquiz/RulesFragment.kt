package com.example.soccerquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.soccerquiz.databinding.FragmentRulesBinding


class RulesFragment : Fragment() {

    lateinit var bindingRulesFragment: FragmentRulesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingRulesFragment = FragmentRulesBinding.inflate(inflater)

        (activity as AppCompatActivity).supportActionBar?.title = "Game Rules"
        return bindingRulesFragment.root
    }

    companion object {

        fun newInstance() = RulesFragment()
    }

}