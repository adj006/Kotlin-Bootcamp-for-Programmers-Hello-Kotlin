fun main(args: Array<String>) {
    var fortune: String
    for (i in 1..10) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break;
    }
}

fun getFortune(birthday : Int) : String {
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    val index = when (birthday) {
        28 , 31 -> 6
        in 1..7 -> 0
        else -> birthday.rem(fortunes.size)
    }
    return fortunes[index]
}

fun getBirthday(): Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}