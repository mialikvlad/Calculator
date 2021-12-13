package com.example.myapplication

import java.math.BigDecimal

class Command {
    abstract class Command {
        protected abstract val unit: ArithmeticUnit
        protected abstract val operand: BigDecimal


        abstract fun Execute()
        abstract fun UnExecute()
    }
}

