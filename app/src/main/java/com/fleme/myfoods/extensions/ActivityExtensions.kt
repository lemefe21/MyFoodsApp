package com.fleme.myfoods.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.createFragmentTransaction(execute: FragmentTransaction.() -> Unit) {
    val transaction = supportFragmentManager.beginTransaction()
    execute(transaction)
    transaction.commit()
}