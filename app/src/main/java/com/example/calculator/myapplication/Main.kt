package com.example.myapplication

import java.math.BigDecimal
import java.util.*

fun main() {
    var str: String = readLine()!!.toString()
    var ans = BigDecimal("0")
    while (str != "stop"){
        if (!str[0].isDigit()){
            str = "${ans}$str"
        }
        val prn = Parser().ExpressionToRPN(str)
        ans = Parser().RPNToAnswer(prn)
        println(ans)
        str = readLine()!!.toString()
    }
}