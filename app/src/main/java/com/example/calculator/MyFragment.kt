package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.FragmentMainBinding
import com.example.myapplication.Parser
import java.math.BigDecimal

class MyFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = requireNotNull(_binding)


    private lateinit var display: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        display.id = R.id.input
        display.showSoftInputOnFocus = false
        /*display.setOnClickListener(View.OnClickListener {
            if (getString(R.string.display).equals(display.text)) {
                display.setText("")
            }
        })*/

        var bracketsDifferance = 0
        var bracketsCorrectness: Boolean = true

        with(binding) {
            val clickListener = View.OnClickListener { p0 ->
                when (p0?.id) {
                    R.id.zeroBTN -> {
                        updateText("0")
                    }
                    R.id.oneBTN -> {
                        updateText("1")
                    }
                    R.id.twoBTN -> {
                        updateText("2")
                    }
                    R.id.threeBTN -> {
                        updateText("3")
                    }
                    R.id.fourBTN -> {
                        updateText("4")
                    }
                    R.id.fiveBTN -> {
                        updateText("5")
                    }
                    R.id.sixBTN -> {
                        updateText("6")
                    }
                    R.id.sevenBTN -> {
                        updateText("7")
                    }
                    R.id.eightBTN -> {
                        updateText("8")
                    }
                    R.id.nineBTN -> {
                        updateText("9")
                    }
                    R.id.addBTN -> {
                        updateText("+")
                    }
                    R.id.subtractBTN -> {
                        updateText("-")
                    }
                    R.id.multiplyBTN -> {
                        updateText("*")
                    }
                    R.id.divideBTN -> {
                        updateText("/")
                    }
                    R.id.startBracketBTN -> {
                        if (bracketsDifferance < 0) bracketsCorrectness = false
                        bracketsDifferance++
                        updateText("(")
                    }
                    R.id.endBracketBTN -> {
                        if (bracketsDifferance <= 0) bracketsCorrectness = false
                        bracketsDifferance--
                        updateText(")")
                    }
                    R.id.pointBTN -> {
                        updateText(".")
                    }
                    R.id.clearBTN -> {
                        display.setText("")
                    }
                    R.id.equalsBTN -> {
                        if(bracketsDifferance != 0 && !bracketsCorrectness){
                            Toast.makeText(context,"incorrect brackets order",Toast.LENGTH_LONG)
                                .show()
                        }
                        val str: String = display.text.toString()
                        val prn = Parser().ExpressionToRPN(str)
                        val ans = Parser().RPNToAnswer(prn)
                        display.setText(ans.toString())
                    }
                    R.id.plusMinusBTN -> {
                        val equation = BigDecimal(display.text.toString())
                        display.setText(equation.multiply(BigDecimal(-1)).toString())
                    }
                    R.id.backspaceBTN -> {
                        val length: Int = display.text.length
                        if (length != 0) {
                            val selection: SpannableStringBuilder =
                                (SpannableStringBuilder(display.text))
                            selection.replace(length - 2, length - 1, "")
                            display.text = selection
                        }
                    }
                }
            }
            zeroBTN.setOnClickListener(clickListener)
            oneBTN.setOnClickListener(clickListener)
            twoBTN.setOnClickListener(clickListener)
            threeBTN.setOnClickListener(clickListener)
            fourBTN.setOnClickListener(clickListener)
            fiveBTN.setOnClickListener(clickListener)
            sixBTN.setOnClickListener(clickListener)
            sevenBTN.setOnClickListener(clickListener)
            eightBTN.setOnClickListener(clickListener)
            nineBTN.setOnClickListener(clickListener)
            startBracketBTN.setOnClickListener(clickListener)
            endBracketBTN.setOnClickListener(clickListener)
            backspaceBTN.setOnClickListener(clickListener)
            clearBTN.setOnClickListener(clickListener)
            plusMinusBTN.setOnClickListener(clickListener)
            pointBTN.setOnClickListener(clickListener)
            addBTN.setOnClickListener(clickListener)
            subtractBTN.setOnClickListener(clickListener)
            multiplyBTN.setOnClickListener(clickListener)
            divideBTN.setOnClickListener(clickListener)

        }
    }

    @SuppressLint("SetTextI18n")
    fun updateText(strToAdd: String) {
        val oldStr: String = display.text.toString()
        display.setText(oldStr + strToAdd)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}