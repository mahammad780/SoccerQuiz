package com.example.soccerquiz

import android.app.ActionBar
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.soccerquiz.databinding.FragmentWelcomeScreenBinding


class WelcomeScreenFragment : Fragment() {
    lateinit var bindingWelcomeScreenBinding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingWelcomeScreenBinding = FragmentWelcomeScreenBinding.inflate(inflater)

        bindingWelcomeScreenBinding.startButton.setOnClickListener {
                view: View -> Navigation.findNavController(view).navigate(R.id.action_welcomeScreenFragment_to_quizFragment)
        }


        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"

        return bindingWelcomeScreenBinding.root
    }

}
