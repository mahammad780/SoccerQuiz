package com.example.soccerquiz

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.soccerquiz.databinding.FragmentQuizBinding
import com.example.soccerquiz.databinding.FragmentWelcomeScreenBinding


class QuizFragment : Fragment() {
    lateinit var bindingQuizFragment: FragmentQuizBinding

    private val quizItem: MutableList<QuizItem> = mutableListOf(
        QuizItem("How many players does each team have on the pitch when a soccer match starts?",
            listOf("11","8","12")),
        QuizItem("What should be the circumference of a Size 5 (adult) football?",
            listOf("27\" to 28\"", "24\" to 25\"", "23\" to 24\"")),
        QuizItem("What is given to a player for a very serious personal foul on an opponent?,",
            listOf("Red Card", "Green Card", "Yellow Card")),
        QuizItem("To most places in the world, soccer is known as what?",
            listOf("Football", "Footgame", "Legball")),
        QuizItem("Offside. If a player is offside, what action does the referee take?",
            listOf("Awards an indirect free kick to the opposing team", "Awards a penalty to the opposing team",
            "Awards a yellow card  to the player")),
        QuizItem("How many laws of Association Football are there?",
            listOf("17", "11", "23")),
        QuizItem("Excluding the goalkeeper, what part of the body cannot touch the ball?",
            listOf("Arm", "Head", "Shoulder")),
        QuizItem("What is it called when a player, without the ball on the offensive team is behind the last defender, or fullback?",
            listOf("Offside", "Outside", "Field-side")),
        QuizItem("The Ball. The circumference of the ball should not be greater than what?",
            listOf("70", "80", "90")),
        QuizItem("How many minutes are played in a regular game (without injury time or extra time)?",
        listOf("90", "95", "100"))

    )

    lateinit var currentQuiz: QuizItem
    lateinit var answers: MutableList<String>
    private var quizItemIndex = 0
    private val numberOfQuestions = 3


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingQuizFragment = FragmentQuizBinding.inflate(inflater)

        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"

        setHasOptionsMenu(true)



        getRandomQuestion()


        bindingQuizFragment.buttonPass.setOnClickListener { view: View ->
            val checkedBoxId = bindingQuizFragment.quizRadioGroup.checkedRadioButtonId

            if(checkedBoxId != -1){
                var answerIndex = 0
                when(checkedBoxId){
                    R.id.firtstRadioButton -> answerIndex = 0
                    R.id.secondRadioButton -> answerIndex = 1
                    R.id.thirdRadioButton -> answerIndex = 2
                }

                if(answers[answerIndex] == currentQuiz.answerList[0]){

                    quizItemIndex ++
                    if(quizItemIndex< numberOfQuestions){
                        setQuizItem()
                    }
                    else{
                        //go to goal fragment
                        view.findNavController().navigate(R.id.action_quizFragment_to_goalFragment)
                    }

                }
                else{
                    // go to miss fragment
                    view.findNavController().navigate(R.id.action_quizFragment_to_missFragment)

                }
            }
        }

        return bindingQuizFragment.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun getRandomQuestion(){
        quizItem.shuffle()
        quizItemIndex = 0
       setQuizItem()
    }

    private fun setQuizItem(){
        currentQuiz = quizItem[quizItemIndex]
        answers = currentQuiz.answerList.toMutableList()
        answers.shuffle()
    }

    companion object {

        fun newInstance() = QuizFragment()
    }
}