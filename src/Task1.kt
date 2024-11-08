import kotlin.math.abs
class Point(val x: Int, val y: Int)//класс точка с координатами x, y

class Triangle(val a: Point, val b: Point, val c: Point) {//класс треугольник, с координатами 3-х вершин
    fun isPointInside(point: Point): Boolean {
        // Формула площади треугольника (в 2 раза больше, чем стандартная)
        val area = abs((b.x * c.y - c.x * b.y) - (a.x * c.y - c.x * a.y) + (a.x * b.y - b.x * a.y))
        // Вычисляет площади трёх треугольников, образованных точкой и каждой парой вершин исходного треугольника.
        val area1 = abs((point.x * b.y - b.x * point.y) - (a.x * b.y - b.x * a.y) + (a.x * point.y - point.x * a.y))
        val area2 = abs((point.x * c.y - c.x * point.y) - (b.x * c.y - c.x * b.y) + (b.x * point.y - point.x * b.y))
        val area3 = abs((point.x * a.y - a.x * point.y) - (c.x * a.y - a.x * c.y) + (c.x * point.y - point.x * c.y))
        // Сравнивает сумму площадей малых треугольников с площадью исходного треугольника.
        // Если они равны, то точка находится внутри треугольника.
        return area == area1 + area2 + area3
    }
}

fun main() {
    // Создание объектов класса `Point` для вершин треугольника и для точки.
    println("Введите координаты точки A (x y):")
    val inputA = readLine() ?: ""
    val coordinatesA = inputA.split(" ").map { it.toIntOrNull() ?: 0 }//при пропуске ввода будет присвоен 0
    val a = Point(coordinatesA[0], coordinatesA[0])

    println("Введите координаты точки B (x y):")
    val inputB = readLine() ?: ""
    val coordinatesB = inputB.split(" ").map { it.toIntOrNull() ?: 0 }//при пропуске ввода будет присвоен 0
    val b = Point(coordinatesB[0], coordinatesB[0])

    println("Введите координаты точки C (x y):")
    val inputC = readLine() ?: ""
    val coordinatesC = inputC.split(" ").map { it.toIntOrNull() ?: 0 }//при пропуске ввода будет присвоен 0
    val c = Point(coordinatesC[0], coordinatesC[0])

    println("Введите координаты точки (x y):")
    val inputPoint = readLine() ?: ""
    val coordinatesPoint = inputPoint.split(" ").map { it.toIntOrNull() ?: 0 }//при пропуске ввода будет присвоен 0
    val point = Point(coordinatesPoint[0], coordinatesPoint[0])

    val triangle = Triangle(a, b, c)

    println("Точка ${point.x}, ${point.y} ${if (triangle.isPointInside(point)) "внутри" else "вне"} треугольника.")
}