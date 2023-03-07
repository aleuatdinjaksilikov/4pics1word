package com.example.a4pics1word

import android.content.Context
import android.content.SharedPreferences
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.a4pics1word.databinding.ActivityMainBinding
import com.example.a4pics1word.entity.QuestionList
import kotlin.random.Random

const val PREFERENCE_NAME = "PREFERENCE_NAME"

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences
    lateinit var binding: ActivityMainBinding
    private var currentIndeks = 0
    private var imageId = 0
    private var levelIndex = 0
    private var coins = 0
    private var optionList= mutableListOf<TextView>()
    private var answerList= mutableListOf<TextView>()
    private var userAnswerList = mutableListOf<Pair<String,TextView>>()
    private lateinit var pustoy : Pair<String,TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        pustoy = Pair("",binding.option9)

        fillOptionAndAnswerList()
        QuestionList.getQuestion()
        setQuestion()

        binding.tvLevelNumber.text = "${QuestionList.getQuestion()[currentIndeks].id + levelIndex * QuestionList.getQuestion().size}"

        binding.img1.setOnClickListener {
            imageId = 1
            scaleImageUp(imageId)
        }
        binding.img2.setOnClickListener {
            imageId = 2
            scaleImageUp(imageId)
        }
        binding.img3.setOnClickListener {
            imageId = 3
            scaleImageUp(imageId)
        }
        binding.img4.setOnClickListener {
            imageId = 4
            scaleImageUp(imageId)
        }



        binding.bigImage.setOnClickListener {
            scaleImageDown(imageId)

            Handler(Looper.getMainLooper()).postDelayed({
                binding.bigImage.visibility = View.GONE
            },180)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }


        binding.option1.setOnClickListener { setLetter(binding.option1) }
        binding.option2.setOnClickListener { setLetter(binding.option2) }
        binding.option3.setOnClickListener { setLetter(binding.option3) }
        binding.option4.setOnClickListener { setLetter(binding.option4) }
        binding.option5.setOnClickListener { setLetter(binding.option5) }
        binding.option6.setOnClickListener { setLetter(binding.option6) }
        binding.option7.setOnClickListener { setLetter(binding.option7) }
        binding.option8.setOnClickListener { setLetter(binding.option8) }
        binding.option9.setOnClickListener { setLetter(binding.option9) }
        binding.option10.setOnClickListener { setLetter(binding.option10) }
        binding.option11.setOnClickListener { setLetter(binding.option11) }
        binding.option12.setOnClickListener { setLetter(binding.option12) }



        binding.ans1.setOnClickListener { removeLetter(binding.ans1) }
        binding.ans2.setOnClickListener { removeLetter(binding.ans2) }
        binding.ans3.setOnClickListener { removeLetter(binding.ans3) }
        binding.ans4.setOnClickListener { removeLetter(binding.ans4) }
        binding.ans5.setOnClickListener { removeLetter(binding.ans5) }
        binding.ans6.setOnClickListener { removeLetter(binding.ans6) }
        binding.ans7.setOnClickListener { removeLetter(binding.ans7) }
        binding.ans8.setOnClickListener { removeLetter(binding.ans8) }
    }



    private fun setQuestion() {

        val question = QuestionList.getQuestion()[currentIndeks]
        binding.img1.setImageResource(question.images[0])
        binding.img2.setImageResource(question.images[1])
        binding.img3.setImageResource(question.images[2])
        binding.img4.setImageResource(question.images[3])

        answerList.forEach {
            it.text = ""
            it.visibility = View.GONE
        }

        repeat(question.answer.length){
            answerList[it].visibility = View.VISIBLE
        }

        val options = question.answer.toMutableList()
        repeat(12-options.size){
            options.add(Random.nextInt(1040,1072).toChar())
        }

        options.shuffle()

        options.forEachIndexed { index, c ->
            optionList[index].text = c.toString()
        }


        binding.tvCoins.text = coins.toString()
        binding.tvLevelNumber.text = "${QuestionList.getQuestion()[currentIndeks].id + levelIndex * QuestionList.getQuestion().size}"

    }

    private fun fillOptionAndAnswerList(){
        optionList.add(binding.option1)
        optionList.add(binding.option2)
        optionList.add(binding.option3)
        optionList.add(binding.option4)
        optionList.add(binding.option5)
        optionList.add(binding.option6)
        optionList.add(binding.option7)
        optionList.add(binding.option8)
        optionList.add(binding.option9)
        optionList.add(binding.option10)
        optionList.add(binding.option11)
        optionList.add(binding.option12)

        answerList.add(binding.ans1)
        answerList.add(binding.ans2)
        answerList.add(binding.ans3)
        answerList.add(binding.ans4)
        answerList.add(binding.ans5)
        answerList.add(binding.ans6)
        answerList.add(binding.ans7)
        answerList.add(binding.ans8)

    }

    private fun scaleImageUp(id:Int){
        val question = QuestionList.getQuestion()[currentIndeks]
        when(id){
            1 -> {
                binding.bigImage.setImageResource(question.images[0])
                binding.bigImage.visibility = View.VISIBLE
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_up_1)
                )
            }
            2 -> {
                binding.bigImage.setImageResource(question.images[1])
                binding.bigImage.visibility = View.VISIBLE
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_up_2)
                )
            }
            3 -> {
                binding.bigImage.setImageResource(question.images[2])
                binding.bigImage.visibility = View.VISIBLE
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_up_3)
                )
            }
            4 -> {
                binding.bigImage.setImageResource(question.images[3])
                binding.bigImage.visibility = View.VISIBLE
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_up_4)
                )
            }
        }
    }
    private fun scaleImageDown(id: Int) {

        when(id){
            1 -> {
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_down_1)
                )
            }
            2 -> {
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_down_2)
                )
            }
            3 -> {
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_down_3)
                )
            }
            4 -> {
                binding.bigImage.startAnimation(
                    AnimationUtils.loadAnimation(this,R.anim.scale_down_4)
                )
            }
        }


    }

    private fun setLetter(textView: TextView){
        val letter = textView.text.toString()

        if (letter.isNotEmpty() && userAnswerList.filter { it.first != "" }.size != QuestionList.getQuestion()[currentIndeks].answer.length){
            val pair = Pair(letter,textView)
            val oldIndex = userAnswerList.indexOf(pustoy)
            if (oldIndex == -1){
                userAnswerList.add(pair)
            }else{
                userAnswerList[oldIndex] = pair
            }

            textView.text = ""
            val indexPair = userAnswerList.indexOf(pair)
            answerList[indexPair].text = letter
        }

        if (userAnswerList.filter { it.first != "" }.size == QuestionList.getQuestion()[currentIndeks].answer.length){
            var answer = ""
            userAnswerList.forEach {
                answer += it.first
            }
            if (answer == QuestionList.getQuestion()[currentIndeks].answer){
                answerList.forEach {
                    it.isClickable = false
                }

                binding.screenNext.visibility = View.VISIBLE
                binding.lottieAnimationAnswers.visibility = View.VISIBLE
                binding.btnNextQuestion.setOnClickListener {
                    it.isClickable = false
                    AnimationScreen(binding.screenNext)
                }


            }else{
                vibratePhone(200)
            }

        }

    }

    private fun AnimationScreen(layout : View) {
        var animation = AlphaAnimation(1.0f,0f)
        animation.duration  = 1000
        layout.startAnimation(animation)
        logika()

        Handler(Looper.getMainLooper()).postDelayed({
            binding.btnNextQuestion.isClickable = true
        },3000)

    }

    private fun logika() {
        binding.screenNext.visibility = View.GONE
        binding.lottieAnimationAnswers.visibility = View.GONE

        if (currentIndeks < QuestionList.getQuestion().size-1){
            currentIndeks++
        }else{
            currentIndeks = 0
            levelIndex++
        }

        coins+=4

        answerList.forEach {
            it.isClickable = true
        }

        val editor = preferences.edit()
        editor.putInt("LevelIndex",levelIndex)
        editor.putInt("Coins",coins).apply()
        editor.putInt("currentIndex",currentIndeks).apply()

        userAnswerList.clear()
        setQuestion()
        fillOptionAndAnswerList()

    }



    private fun removeLetter(textView: TextView){

        val letter = textView.text.toString()
        if (letter.isNotEmpty()){
            val index = answerList.indexOf(textView)

            val pair  = userAnswerList[index]
            textView.text = ""
            pair.second.text = pair.first

            userAnswerList[index] = pustoy
        }


    }

    private fun vibratePhone(time:Long){
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        time,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            }else{
                vibrator.vibrate(time)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        preferences = getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

         currentIndeks = preferences.getInt("currentIndex",0)
         coins = preferences.getInt("Coins",0)
         levelIndex = preferences.getInt("LevelIndex",0)
        setQuestion()
    }
}