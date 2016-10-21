package com.fyber

/**
 * Created by Abhi on 10/20/2016.
 */
object Main {
  def main(args: Array[String]) {
    val path = args(0)
    filePath(path)
  }

  def filePath(path: String) = {
    val tSpace = 10
    val nSpace = 1
    val rsSpace = 6
    val minVSpace = 4
    val maxVSpace = 3
    val vSpace = 7
    val printChar = (n: Int, char: String) => char * n

    println(s"T${printChar(tSpace, " ")}V${printChar(vSpace, " ")}N${printChar(nSpace, " ")}RS${printChar(rsSpace, " ")}MinV${printChar(minVSpace, " ")}MaxV${printChar(maxVSpace, " ")}")
    println(s"${printChar(tSpace + nSpace + vSpace + rsSpace + minVSpace + maxVSpace + 13, "-")}")

    def output(lines: Iterator[String], list: List[String] = Nil): Unit = {
      if (lines.hasNext) {
        val line = lines.next()
        val arr = line.split(" ")
        val time = arr(0).trim.toInt
        val window = time - 60
        val price = arr(1).trim.toFloat
        val l = line +: list.collect { case str if str.split(" ")(0).toInt >= window => str }
        if (l.nonEmpty) {
          val result = inner(list.toIterator, min = price, max = price)
          println(s"$time $price ${result._1} ${result._2} ${result._3} ${result._4}")
        }
        output(lines, l)
      }
    }

    def inner(iterator: Iterator[String],
              n: Int = 0,
              rs: Float = 0,
              min: Float,
              max: Float): (Int, String, String, String) = {
      if (iterator.hasNext) {
        val nextArr = iterator.next.split(" ")
        val time = nextArr(0).trim.toInt
        val priceRatio = nextArr(1).trim.toFloat
        if (priceRatio < min) {
          inner(iterator, n + 1, rs + priceRatio, priceRatio, max)
        }
        else if (priceRatio > max) {
          inner(iterator, n + 1, rs + priceRatio, min, priceRatio)
        }
        else
          inner(iterator, n + 1, rs + priceRatio, min, max)
      } else {
        (n, f"$rs%1.5f", f"$min%1.5f", f"$max%1.5f")
      }
    }
    output(scala.io.Source.fromFile(path).getLines)

  }
}
