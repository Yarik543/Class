import kotlin.math.sqrt

class Point3(val x: Double, val y: Double) {
    fun distanceTo(other: Point3): Double {
        val dx = other.x - x
        val dy = other.y - y
        return sqrt(dx * dx + dy * dy)
    }
}

fun main() {
    println("Введите координаты первой точки (x y), разделенные пробелом:")
    val input1 = readLine() ?: ""
    //Используется `split(" ")` для разделения строки на части по пробелам.
    //Используется `map { it.toDoubleOrNull() ?: 0.0 }` для преобразования каждой части в число с плавающей точкой.
    // Если преобразование не удалось (например, ввод был не числом), то в результат записывается значение 0.0 по умолчанию.
    val coordinates1 = input1.split(" ").map { it.toDoubleOrNull() ?: 0.0 }//при пропуске ввода будет присвоен 0
    val point1 = Point3(coordinates1[0], coordinates1[0])

    println("Введите координаты второй точки (x y), разделенные пробелом:")
    val input2 = readLine() ?: ""
    //Используется `split(" ")` для разделения строки на части по пробелам.
    //Используется `map { it.toDoubleOrNull() ?: 0.0 }` для преобразования каждой части в число с плавающей точкой.
    // Если преобразование не удалось (например, ввод был не числом), то в результат записывается значение 0.0 по умолчанию.
    val coordinates2 = input2.split(" ").map { it.toDoubleOrNull() ?: 0.0 }//при пропуске ввода будет присвоен 0
    val point2 = Point3(coordinates2[0], coordinates2[0])

    val distance = point1.distanceTo(point2)
    println("Расстояние между точками: $distance")
}