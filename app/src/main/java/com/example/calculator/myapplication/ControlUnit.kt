package com.example.myapplication
import com.example.myapplication.Command.Command

class ControlUnit {
    private val commands = mutableListOf<Command>()
    private var current: Int = 0
    fun StoreCommand(command: Command){
        commands.add(command)
    }
    fun ExecuteCommand(){
        commands[current].Execute()
        current++
    }
    fun Undo(levels: Int){
        for (i in 0 until levels){
            if(current > 0) commands[--current].UnExecute()
        }
    }
    fun Redo(levels: Int){
        for(i in 0 until levels){
            if(current < commands.size - 1)
                commands[current++].Execute()
        }
    }
}