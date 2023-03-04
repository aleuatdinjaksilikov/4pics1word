package com.example.a4pics1word.entity

import com.example.a4pics1word.R

object QuestionList {

    fun getQuestion(): MutableList<Question> {
        val sorawlar = mutableListOf<Question>()
        sorawlar.add(
            Question(
            id = 1,
            images = listOf(
                R.drawable.photo1_1,
                R.drawable.photo1_2,
                R.drawable.photo1_3,
                R.drawable.photo1_4
            ),
                "МОРОЗ"
        ))

        sorawlar.add(
            Question(
            id = 2,
            images = listOf(
                R.drawable.photo2_1,
                R.drawable.photo2_2,
                R.drawable.photo2_3,
                R.drawable.photo2_4
            ),
                "ШУМ"
        ))

        sorawlar.add(
            Question(
                id = 3,
                images = listOf(
                    R.drawable.photo3_1,
                    R.drawable.photo3_2,
                    R.drawable.photo3_3,
                    R.drawable.photo3_4
                ),
                "ТЕПЛО"
            ))

        sorawlar.add(
            Question(
                id = 4,
                images = listOf(
                    R.drawable.photo4_1,
                    R.drawable.photo4_2,
                    R.drawable.photo4_3,
                    R.drawable.photo4_4
                ),
                "МУЗЫКА"
            ))

        sorawlar.add(
            Question(
                id = 5,
                images = listOf(
                    R.drawable.photo5_1,
                    R.drawable.photo5_2,
                    R.drawable.photo5_3,
                    R.drawable.photo5_4
                ),
                "ТОЧКА"
            ))
        return sorawlar
    }
}