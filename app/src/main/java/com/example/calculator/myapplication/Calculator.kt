package com.example.myapplication
import com.example.myapplication.Command.Command
import java.math.BigDecimal

class Calculator(){
    val arithmeticUnit: ArithmeticUnit = ArithmeticUnit()
    val controlUnit: ControlUnit = ControlUnit()

    private fun Run(command: Command):BigDecimal{
        controlUnit.StoreCommand(command)
        controlUnit.ExecuteCommand()
        return arithmeticUnit.register
    }

    fun Add(operand: BigDecimal): BigDecimal{
        return Run(Add(arithmeticUnit, operand))
    }
    fun Sub(operand: BigDecimal): BigDecimal{
        return Run(Sub(arithmeticUnit, operand))
    }
    fun Mul(operand: BigDecimal): BigDecimal{
        return Run(Mul(arithmeticUnit, operand))
    }
    fun Div(operand: BigDecimal): BigDecimal{
        return Run(Div(arithmeticUnit, operand))
    }
    fun Undo(levels: Int):BigDecimal{
        controlUnit.Undo(levels);
        return arithmeticUnit.register
    }
    fun Redo(levels: Int):BigDecimal{
        controlUnit.Redo(levels);
        return arithmeticUnit.register
    }
}