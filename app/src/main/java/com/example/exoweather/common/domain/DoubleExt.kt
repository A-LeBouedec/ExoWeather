package com.example.exoweather.common.domain

//https://discuss.kotlinlang.org/t/how-do-you-round-a-number-to-n-decimal-places/8843
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}
