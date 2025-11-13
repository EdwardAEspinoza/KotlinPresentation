// 🎯 Kotlin Adventure Game
// This program shows Kotlin’s syntax, input handling, functions, and branching logic.
// I’ll walk through how Kotlin makes building an interactive story simple and readable.


// --- ANSI color codes for console text styling (for fun + readability) ---
const val RESET = "\u001B[0m"
const val GREEN = "\u001B[32m"
const val RED = "\u001B[31m"
const val CYAN = "\u001B[36m"
const val YELLOW = "\u001B[33m"
const val PURPLE = "\u001B[35m"


// --- Program starts here ---
fun main() {
    startGame()  // Kotlin’s main function calls startGame() to begin
}

fun startGame() {
    // Kotlin uses println for output and readln() for user input
    println("${CYAN}🌄 Welcome to the Kotlin Adventure Game!$RESET")
    println("You awaken at the entrance of a dark cave hidden deep within a forest.")
    println("Rumor says a lost treasure lies within, guarded by an ancient creature.")
    println("Do you want to ENTER the cave or EXPLORE the forest first?")
    print("${YELLOW}Type 'enter' or 'explore': $RESET")

    // Kotlin's "when" is like switch statements in other languages
    when (readln().lowercase()) {
        "enter" -> enterCave(hasTorch = false)
        "explore" -> exploreForest()
        else -> {
            println("\nYou hesitate too long, and the sun sets.")
            println("You decide to return home, wondering what could’ve been hidden in that cave...")
            ending("🏡 Ending: The Curious Wanderer", "You survived, but never discovered the truth.")
        }
    }
}


// --- Player explores the forest to optionally get a torch ---
fun exploreForest() {
    println("\nYou walk into the forest, hearing birds and the rustling of leaves.")
    println("You find an OLD TORCH lying near a broken wagon.")
    print("Do you PICK up the torch or LEAVE it? ")

    val torchChoice = readln().lowercase() // user input stored in a variable

    if (torchChoice == "pick up") {
        println("${GREEN}You take the torch. It might come in handy inside the cave.$RESET")
        enterCave(hasTorch = true)
    } else {
        println("You leave the torch behind and return to the cave entrance empty-handed.")
        enterCave(hasTorch = false)
    }
}


// --- Entering the cave, player path branches left or right ---
fun enterCave(hasTorch: Boolean) {
    println("\nYou step inside the cave. It’s pitch dark, and the air is damp.")

    // Example of Kotlin’s if/else expression and string interpolation
    if (hasTorch) println("${YELLOW}You light your torch, revealing ancient carvings on the walls.$RESET")
    else println("${RED}You can barely see, tripping over rocks as you move forward.$RESET")

    println("You reach a fork in the path: LEFT seems warm and glowing, RIGHT feels cold and quiet.")
    print("Do you go LEFT or RIGHT? ")

    when (readln().lowercase()) {
        "left" -> warmPath(hasTorch)
        "right" -> coldPath(hasTorch)
        else -> ending("🪨 Ending: The Trapped Explorer", "You hesitated too long, and the cave collapsed around you.")
    }
}


// --- Warm glowing path: chance to drink magical water ---
fun warmPath(hasTorch: Boolean) {
    println("\nYou follow the warm glow and find a pool of shimmering golden water.")
    println("It looks magical, and your reflection seems to move on its own.")
    print("Do you DRINK from the pool or IGNORE it? ")

    val choice = readln().lowercase()

    if (choice == "drink") {
        println("${PURPLE}The water tastes sweet, and you feel powerful!$RESET")
        println("A glowing mark appears on your arm — you’ve been blessed by ancient magic.")
        treasureRoom(blessed = true, hasTorch)
    } else {
        println("You resist temptation and continue deeper into the cave.")
        treasureRoom(blessed = false, hasTorch)
    }
}


// --- Cold path: mysterious noises and moral choices ---
fun coldPath(hasTorch: Boolean) {
    println("\nYou walk down the cold, narrow tunnel.")
    println("You hear scratching sounds. A shadow moves quickly in front of you!")
    print("Do you RUN away or INVESTIGATE the noise? ")

    val choice = readln().lowercase()

    when (choice) {
        "run" -> ending(
            "😨 Ending: The Fearful Survivor",
            "You escape to daylight unharmed, but the mystery of the cave will haunt you forever."
        )

        "investigate" -> {
            println("You approach carefully. A small wolf cub stares at you, trembling.")
            print("Do you HELP the cub or LEAVE it? ")

            when (readln().lowercase()) {
                "help" -> {
                    println("${GREEN}You share food with the cub. It follows you loyally.$RESET")
                    warmPath(hasTorch) // shows function reuse (go back to warm path)
                }

                "leave" -> ending(
                    "🐺 Ending: The Unforgiven",
                    "You turn away, but the cub’s mother lunges from the shadows. The forest claims you."
                )

                else -> ending(
                    "🌑 Ending: The Frozen Wanderer",
                    "You freeze in fear as glowing eyes surround you in the dark."
                )
            }
        }

        else -> ending("🌑 Ending: The Lost Soul", "You wander aimlessly until your torch fades away.")
    }
}


// --- Final chamber: battle or escape ---
fun treasureRoom(blessed: Boolean, hasTorch: Boolean) {
    println("\nYou enter a vast chamber. A golden chest rests on a pedestal.")
    println("Suddenly, a giant serpent rises from behind it! ${RED}🐍${RESET}")
    print("Do you FIGHT or RUN? ")

    val fightChoice = readln().lowercase()

    // Nested conditions: checks both player state and decision
    if (fightChoice == "fight") {
        if (blessed) {
            println("${GREEN}The mark on your arm glows! The serpent disintegrates into dust.$RESET")
            ending("🏆 Ending: The Chosen Hero", "You claim the Heartstone of Aleron and fulfill your destiny.")
        } else {
            println("${RED}You fight bravely, but the serpent is too strong.$RESET")
            ending("⚔️ Ending: The Brave but Fallen", "Your story ends here, remembered as a fearless warrior.")
        }
    } else {
        if (hasTorch) {
            println("${YELLOW}You escape the serpent’s lair, clutching a single gold coin.$RESET")
            ending("💰 Ending: The Lucky Escape", "You survived and left with a token of your courage.")
        } else {
            println("${RED}You flee into the dark, unable to see. You never find your way out.$RESET")
            ending("🌑 Ending: The Lost Explorer", "Your tale becomes a whisper told by travelers at campfires.")
        }
    }
}


// --- Handles endings + replay option ---
fun ending(title: String, description: String) {
    println("\n$title")
    println(description)
    println("\n${CYAN}Would you like to play again? (yes/no): $RESET")
    restartGame()
}


// --- Restart feature using recursion (calls startGame() again) ---
fun restartGame() {
    when (readln().lowercase()) {
        "yes" -> {
            println("\n${PURPLE}Restarting your adventure...$RESET\n")
            startGame()
        }

        else -> {
            println("${GREEN}Thanks for playing! Until next time, brave explorer! 🌟$RESET")
        }
    }
}
