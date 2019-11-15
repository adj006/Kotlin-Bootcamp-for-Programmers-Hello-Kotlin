fun main(args: Array<String>) {
    var fortune: String = ""
    while (fortune.contains("Take it easy")) {
        fortune = getFortuneV3(getBirthdayV3())
        println("\nYour fortune is: $fortune")
    }
}

fun getFortuneV3(birthday : Int) : String {
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

fun getBirthdayV3(): Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}