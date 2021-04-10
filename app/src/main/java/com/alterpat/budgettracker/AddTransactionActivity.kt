package com.alterpat.budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_add_transaction.*

class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        labelInput.addTextChangedListener {
            if(it!!.count() > 0)
                labelLayout.error = null
        }

        amountInput.addTextChangedListener {
            if(it!!.count() > 0)
                amountLayout.error = null
        }

        addTransactionBtn.setOnClickListener {
            val label = labelInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                labelLayout.error = "Please neter a valid label"

            if(amount == null)
                amountLayout.error = "Please enter a valid amount"
        }

        closeBtn.setOnClickListener {
            finish()
        }
    }

}