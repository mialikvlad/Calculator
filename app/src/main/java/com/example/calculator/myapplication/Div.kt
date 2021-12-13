package com.example.myapplication
import com.example.myapplication.Command.Command
import java.math.BigDecimal

class Div(override val unit: ArithmeticUnit, override val operand: BigDecimal) : Command() {
    override fun Execute() {
        unit.Run('/', operand)
    }

    override fun UnExecute() {
        unit.Run('*', operand)
    }

}