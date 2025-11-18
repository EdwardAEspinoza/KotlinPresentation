class Course(val name: String) {
    private var grades: MutableList<Double> = mutableListOf()
    private var finalGrade: Double? = null
    private var letterGrade: String? = null
    private var yourFuture: String? = null

    fun displayGrade(){
        if(grades.isEmpty()) {
            println("Take an exam to see something here!")
            return
        }

        finalGrade = grades.average()

            letterGrade = when{
                finalGrade!! < 70 ->{
                    yourFuture = "Fry Cook"
                    "F"
                }
                finalGrade!! <= 79 ->{
                    yourFuture = "Proud dirt hut owner"
                    "C"
                }
                finalGrade!! <= 89 ->{
                    yourFuture = "Maybe you'll own a Pontiac"
                    "B"
                }
                finalGrade!! <= 99 ->{
                    yourFuture = "You'll have 2 Pontiacs"
                    "A"
                }
                finalGrade!! == 100.0 ->{
                    yourFuture = "Steve Jobs 2.0"
                    "A+"
                }else -> "unknown"
            }

            println("Your grade: $letterGrade")
            println("What to look forward to: $yourFuture")
        }

    fun takeExam(){
        var correctCounter = 0
        println("Welcome to exam 1!")
        println("Question 1. What is the result of 2 + 2?")
        println("A. 2")
        println("B. Two")
        println("C. Fish")
        println("D. Dos")
        when(readLine()){
            "A" -> {
                println("No dice, moving on")
            }
            "B" -> {
                println("Not this time")
            }
            "C" -> {
                correctCounter++
                println("You got it buddy!")
            }
            "D" -> {
                println("Nope")
            } else -> {
                println("Errrrrrr not an answer")
            }
        }

        println("Your correct answers: $correctCounter")
        println("\nMoving on to the next question")
        println("Question 2. Biggest fraud on Earth")
        println("A. Dr. Victor Von Doom")
        println("B. Reed Richards")
        println("C. Johnathan Spencer Storm")
        println("D. Bentley Whittman")
        when(readLine()){
            "A" -> {
                println("Doom is no fraud!")
            }
            "B" -> {
                correctCounter++
                println("Of course!")
            }
            "C" -> {
                println("Not Quite")
            }
            "D" -> {
                println("No")
            } else -> {
            println("It should be A or B or C or D!!")
        }
        }

        println("Your correct answers: $correctCounter")
        println("\nMoving on to the last question")
        println("Question 3. When are Dr. Figueroa's office hours?")
        println("A. 9:30 am")
        println("B. 8:00 am")
        println("C. 4:15 am")
        println("D. 11:00 am")
        when(readLine()){
            "A" -> {
                println("That's when class starts!")
            }
            "B" -> {
                println("Uh uh")
            }
            "C" -> {
                println("Heavens no!")
            }
            "D" -> {
                correctCounter++
                println("Looks like somebody paid attention")
            } else -> {
            println("Stumbled right before the finish line")
        }
        }
        println("\nThe results are: $correctCounter out of 3 questions answered correctly")
        if(correctCounter == 3){
            grades.add(100.0)
        }else
        grades.add((100.0/3) * correctCounter)
    }

    fun cheat(){
        println("\nPsst don't tell anyone")
        println("The answers are Gamma, Beta, and Delta")
    }

}

fun courseOptions(Course : Course) {
    var incourse = true
    while(incourse) {
        println("\nOptions for ${Course.name}: ")
        println("1. Look at your grade")
        println("2. Take the exam")
        println("3. Cheat")
        println("4. Go back to your other options")
        when (readLine()) {
            "1" -> {
                Course.displayGrade()
            }

            "2" -> {
                Course.takeExam()
            }
            "3" -> {
                Course.cheat()
            }
            "4" -> {
                incourse = false
            }
            else -> {
                println("I'll assume you want to go back")
                incourse = false
            }
        }
    }
}

fun main() {
    val cool = Course("Cool Course")
    val meh = Course("Meh Course")
    println("\nWelcome to the easiest set of Courses there ever were!")

    var present = true
    while(present) {
        println("\nChoose a course or bail on academia")
        println("1. Cool Course")
        println("2. Meh Course")
        println("3. Splitsville")
        when(readLine()){
            "1" -> {
                courseOptions(cool)
            }
            "2" -> {
                courseOptions(meh)
            }
            "3" -> {
                println("Buh bye")
                present = false
            }
            else -> {
                println("It has to be a 1, 2, or 3")
            }
        }
    }
}