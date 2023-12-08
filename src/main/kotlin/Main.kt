


/**
 * Homework 2
 * */
fun table() {
    for (i in 1..9) {
        for (j in 1..9) {
            println("$i * $j = ${i * j}")
        }
        println()
    }
}


/**
 * Homework 3
 * */
fun sumOfNumbersInText() {
    val text = readln()
    val words = text.split(" ")
    var sum = 0.0

    words.forEach {
        val number = it.toDoubleOrNull()
        if (number != null)
            sum += number
    }

    println("Sum: $sum")
}

/**
 * Homework 4
 * */
fun calculator() {
    var command = ""

    while (command.uppercase() != "Q") {
        print("Number1: ")

        val number1 = readln().toDouble()

        print("Number2: ")

        val number2 = readln().toDouble()

        print("Operation: ")

        val operation = readln()[0]

        val result = when (operation) {
            '+' -> number1 + number2
            '-' -> number1 - number2
            '*' -> number1 * number2
            '/' -> number1 / number2
            else -> {
                println("Wrong operation")
                null
            }
        }

        if (result != null)
            println("$number1 $operation $number2 = $result \n")

        print("Command(enter Q for quit, any other character to continue): ")

        command = readln()
    }
}


fun main(args: Array<String>) {

}