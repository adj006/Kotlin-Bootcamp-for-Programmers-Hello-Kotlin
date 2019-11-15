import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20
) : Boolean {
    /*return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }*/
    val isTooHot =  temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)
    shouldChangeWater(day = "Monday")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun fitMoreFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true) : Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun randomDay() : String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}


