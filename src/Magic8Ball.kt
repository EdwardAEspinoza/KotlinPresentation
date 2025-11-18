import kotlin.random.Random   // Import Kotlin's Random class for generating random answers

fun main() {
    println("🎱 Welcome to the Kotlin Magic 8-Ball!")

    // Boolean variable that controls whether the game keeps running
    var keepPlaying = true

    // Loop continues until the user chooses to stop
    while (keepPlaying) {

        // Prompt user to ask a question
        println("\nAsk any yes-or-no question in your mind, then press ENTER.")
        readln()   // We don't need to store their question, it's for fun

        // ----------------------------
        // ANIMATION SECTION
        // ----------------------------

        // List of "frames" that simulate an animation in the terminal
        val frames = listOf(
            "🔮 Consulting the spirits.",
            "🔮 Consulting the spirits..",
            "🔮 Consulting the spirits..."
        )

        // Loop through each animation frame
        for (frame in frames) {
            print("\r$frame")    // \r moves cursor back to the beginning of the line
            Thread.sleep(600)    // Pause for 0.6 seconds, creates animation effect
        }

        // ----------------------------
        // POSSIBLE ANSWERS
        // ----------------------------

        // List of all possible responses the Magic 8-Ball can give.
        // This includes: Affirmative, Negative, and Non-Committal answers.
        val responses = listOf(
            // --- Affirmative (10) ---
            "✨ Yes — the universe just high-fived you.",
            "🔥 Absolutely yes. Destiny approves.",
            "🦄 Yes — even the unicorn agrees.",
            "🍀 Lucky you! The answer is yes.",
            "🌞 Yes — brighter than your future after finals.",
            "🎉 YES. Confetti has been summoned.",
            "💫 Indeed — the stars aligned for this one.",
            "🪄 Yes — magic says so.",
            "📈 The answer is yes. Success is uploading…",
            "💍 Yes — commit to it like a long-term relationship with Kotlin.",

            // --- Negative (10) ---
            "☁️ No — the clouds whispered against it.",
            "🔮 No — even the spirits face-palmed.",
            "🕳️ Nope. Not happening in this timeline.",
            "🍂 No — the wind said ‘nah.’",
            "💀 Absolutely not. Abort mission.",
            "🛑 Nope. The answer is basically a red light.",
            "🤡 No — clown behavior detected.",
            "⚠️ No — your question crashed like your code.",
            "🚫 Hard no. Don’t even try it.",
            "🌪️ No — and things might get messy if you push it.",

            // --- Non-Committal (10) ---
            "🌙 Ask again when the moon feels cooperative.",
            "🫠 Hmm… future buffering… try again.",
            "🔮 The future is unclear.",
            "🎭 Hard to say — the universe is being dramatic today.",
            "🫧 Reply hazy — like your study schedule.",
            "🧩 Maybe… the puzzle pieces are missing.",
            "🌫️ Foggy vibes. Ask again later.",
            "🪞 The mirror refused to answer. Suspicious.",
            "🎲 Ask again. The spirits want a re-roll.",
            "🔄 Ask again after a snack break."
        )

        // Randomly pick one of the responses by generating a random index
        val answer = responses[Random.nextInt(responses.size)]

        // Clear the animation line before printing the final answer
        print("\r                                     \r")

        // Display the randomly chosen fortune
        println("🎱 Your answer: $answer")

        // ----------------------------
        // ASK USER IF THEY WANT TO PLAY AGAIN
        // ----------------------------

        print("\nWould you like to ask another question? (yes/no): ")
        val choice = readln().lowercase()

        // Game continues if user types "yes" or "y"
        keepPlaying = (choice == "yes" || choice == "y")
    }

    // Game ends when user says no
    println("\n✨ Thank you for using the Kotlin Magic 8-Ball. Farewell!")
}
