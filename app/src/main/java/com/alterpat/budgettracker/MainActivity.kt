package com.alterpat.budgettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add_transaction.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var transactions : ArrayList<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transactions = arrayListOf(
            Transaction("Weekend budget", 400.00),
            Transaction("Bananas", -4.00),
            Transaction("Gasoline", -40.90),
            Transaction("Breakfast", -9.99),
            Transaction("Water bottles", -4.00),
            Transaction("Suncream", -8.00),
            Transaction("Car Park", -15.00)
        )

        transactionAdapter = TransactionAdapter(transactions)
        linearLayoutManager = LinearLayoutManager(this)

        recyclerview.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }

        updateDashboard()

        addBtn.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateDashboard(){
        val totalAmount = transactions.map { it.amount }.sum()
        val budgetAmount = transactions.filter { it.amount>0 }.map{it.amount}.sum()
        val expenseAmount = totalAmount - budgetAmount

        balance.text = "$ %.2f".format(totalAmount)
        budget.text = "$ %.2f".format(budgetAmount)
        expense.text = "$ %.2f".format(expenseAmount)
    }
}