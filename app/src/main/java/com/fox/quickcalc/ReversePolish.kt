package com.fox.quickcalc

import java.lang.Math.pow
import java.util.*

/**
 * Because doing it in Java < 8 is just too clunky
 * Created by stefox2 on 7/7/16.
 */
private val operationMap = mapOf(
        "+" to { a: Int, b: Int -> a + b },
        "-" to { a, b -> a - b },
        "*" to { a, b -> a * b },
        "/" to { a, b -> a / b },
        "^" to { a, b -> pow(a.toDouble(), b.toDouble()).toInt() }
)

fun evaluate(expression: String) : Int {
    val stack = Stack<Int>();
    for (string in expression.split(" ")) {
        val op = operationMap[string]
        if (op == null) {
            stack.push(string.toInt())
        }
        else {
            val right = stack.pop()
            val left = stack.pop()
            stack.push(op(left, right))
        }
    }
    return stack.pop();
}