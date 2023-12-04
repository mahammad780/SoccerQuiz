package com.example.soccerquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.soccerquiz.databinding.FragmentMissBinding

class MissFragment : Fragment() {

    lateinit var bindingMissFragment: FragmentMissBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingMissFragment = FragmentMissBinding.inflate(inflater)

        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"
        return bindingMissFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingMissFragment.buttonTryAgain.setOnClickListener { view: View->
            view.findNavController().navigate(R.id.action_missFragment_to_quizFragment)
        }
    }

    companion object {
        fun newInstance() =  MissFragment()

    }
}