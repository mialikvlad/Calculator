package com.example.myapplication

import java.math.BigDecimal
import java.util.*
import kotlin.math.exp

class Parser {

    fun ExpressionToRPN(expr: String): String {
        var current: String = ""
        val stack = Stack<Char>()

        var priority: Int
        for (i in expr.indices) {
            priority = GetP(expr[i])

            if (priority == 0) current += expr[i]
            if (priority == 1) stack.push(expr[i])
            if (priority > 1){
                current+=' '

                while (!stack.empty()){
                    if (GetP(stack.peek()) >= priority) current+=stack.pop()
                    else break
                }
                stack.push(expr[i])
            }
            if (priority == -1){
                current+=' '
                while (GetP(stack.peek()) != 1) current+=stack.pop()
                stack.pop()
            }
        }
        while (!stack.empty()) current+=stack.pop()

        return current
    }

    fun RPNToAnswer(rpn: String): BigDecimal {
        var operand: String = ""
        val stack = Stack<BigDecimal>()


        for (i in rpn.indices){
            if (GetP(rpn[i]) == 0 ){
                //while (rpn[i] != ' ' && GetP(rpn[i]) == 0)
                operand+=rpn[i]
            }
            if (GetP(rpn[i]) != 0 && operand.isNotEmpty()) {
                stack.push(operand.toBigDecimal())
                operand = ""
            }else if (rpn[i] == ' ') continue
            if (GetP(rpn[i]) > 1){
                val a = stack.pop()
                val b = stack.pop()
                val calculator = Calculator()
                if (rpn[i] == '+') {
                    var result  = calculator.Add(b)
                    result = calculator.Add(a)
                    stack.push(result)
                }
                if (rpn[i] == '-') {
                    var result  = calculator.Add(b)
                    result = calculator.Sub(a)
                    stack.push(result)
                }
                if (rpn[i] == '*') {
                    var result  = calculator.Add(b)
                    result = calculator.Mul(a)
                    stack.push(result)
                }
                if (rpn[i] == '/') {
                    var result  = calculator.Add(b)
                    result = calculator.Div(a)
                    stack.push(result)
                }
            }

        }

        return stack.pop()
    }

    private fun GetP(token: Char): Int {
        return when (token) {
            '*', '/' -> 3
            '+', '-' -> 2
            '(' -> 1
            ')' -> -1
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'-> 0
            else -> -100
        }
    }
}