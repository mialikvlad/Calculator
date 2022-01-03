package com.example.myapplication

import java.math.BigDecimal
import java.math.RoundingMode

class ArithmeticUnit {
    var register: BigDecimal = BigDecimal(0)

    fun Run(operationCode: Char, operand: BigDecimal){
        when (operationCode) {
            '+' -> register = register.add(operand)
            '-' -> register = register.subtract(operand)
            '*' -> register = register.multiply(operand)
            '/' -> register = register.divide(operand, 10, RoundingMode.CEILING)
            else -> (0).toBigDecimal()
        }
    }
}