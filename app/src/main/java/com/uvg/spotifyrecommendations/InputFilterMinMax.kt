package com.uvg.spotifyrecommendations

import android.text.InputFilter
import android.text.Spanned

// Obtained from: https://www.geeksforgeeks.org/how-to-set-minimum-and-maximum-input-value-in-edittext-in-android/
class InputFilterMinMax(intMin : Int, intMax : Int) : InputFilter {
    private var intMin: Int = intMin
    private var intMax: Int = intMax

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dStart: Int,
        dEnd: Int
    ): CharSequence? {
        try {
            val input = Integer.parseInt(dest.toString() + source.toString())
            if (isInRange(intMin, intMax, input)) {
                return null
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }
        return ""
    }

    // Check if input c is in between min a and max b and
    // returns corresponding boolean
    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}