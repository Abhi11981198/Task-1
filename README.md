# Task-1

### Assumption
  - Each data point containing timestamp and price ratio is space separated.

### Requirement
  - Java 8+
  - sbt 13.8

### Installation

Install java and sbt, and run the programme.

```sh
$ sbt clean compile
$ sbt "run <input file path>"
```
OR

```sh
$ sbt clean compile
$ sbt assembly
```
After assembly you will find FyberTask-1-assembly-1.0.jar in target/scala-2.11

```sh
$ java -jar <path to assembly jar> <input file path>
```

For example :
```sh
$ sbt clean compile
$ sbt assembly
$ java -jar target/scala-2.11/FyberTask-1-assembly-1.0.jar input.txt
```