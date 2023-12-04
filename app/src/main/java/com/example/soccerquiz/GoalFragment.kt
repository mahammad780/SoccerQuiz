package com.example.soccerquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.soccerquiz.databinding.FragmentGoalBinding


class GoalFragment : Fragment() {

    lateinit var bindigGoalFragment: FragmentGoalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindigGoalFragment = FragmentGoalBinding.inflate(inflater)

        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"
        return bindigGoalFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindigGoalFragment.buttonTry.setOnClickListener { view: View->
            view.findNavController().navigate(R.id.action_goalFragment_to_quizFragment)
        }
    }

    companion object {

        fun newInstance() = GoalFragment()
    }
}