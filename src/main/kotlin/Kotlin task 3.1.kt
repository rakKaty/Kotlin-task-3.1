
fun main() {
    val time : UInt = 1350u
    var text  = "0_o"

    when (time) {
        in 0u..60u -> text = "только что"
        in 61u..60u * 60u ->  text = "${calculateMinutes(time)} минут${determinateEndings(time)} назад"
        in 60u * 60u..24u * 60u * 60u -> text = "${calculateHours(time)} час${determinateEndings(time)} назад"
        in 24u * 60u * 60u..2u * 24u * 60u * 60u -> text = "сегодня"
        in 2u * 24u * 60u * 60u..3u * 24u * 60u * 60u -> text = "вчера"
        in 2u * 24u * 60u * 60u..3u * 24u * 60u * 60u -> text = "давно"
        else -> println("Неправильный формат ввода")
    }
    println("был(а) в сети $text")
}


//расчёт сколько минут
fun calculateMinutes(time: UInt): UInt {
    return time / 60u
}

//расчёт сколько часов
fun calculateHours(time: UInt): UInt {
    return time / (60u * 60u)
}


fun determinateEndings(time: UInt): String {
    return if(time < 60u * 60u) {
        when (calculateMinutes(time) % 20u) {
            1u -> "у"
            in 2u..4u -> "ы"
            else -> ""
        }
    } else {
        when (calculateHours(time) % 20u) {
            1u -> ""
            in 2u..4u -> "а"
            else -> "ов"
        }
    }
}
