// 🏦 Advanced Banking System in Kotlin
// This program demonstrates Object-Oriented Programming (OOP) in Kotlin.
// It includes: classes, lists, functions, encapsulation, loops, and user input.
// Users can create multiple accounts, deposit, withdraw, and calculate interest.

// Define a class to represent a single bank account
class BankAccount(val owner: String, private var balance: Double) {

    // Function to deposit money into the account
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("✅ $owner deposited $$amount successfully.")
        } else {
            println("❌ Invalid deposit amount.")
        }
    }

    // Function to withdraw money from the account
    fun withdraw(amount: Double) {
        if (amount <= 0) {
            println("❌ Invalid withdrawal amount.")
        } else if (amount > balance) {
            // Kotlin allows clean conditional checks
            println("⚠️ Insufficient funds! $owner’s balance is $$balance.")
        } else {
            balance -= amount
            println("💸 $owner withdrew $$amount successfully.")
        }
    }

    // Function to display current balance
    fun checkBalance() {
        println("💰 $owner’s current balance: $$balance")
    }

    // Function to calculate and apply simple interest to the account
    fun addInterest(rate: Double) {
        if (rate <= 0) {
            println("❌ Invalid interest rate. Must be greater than 0.")
            return
        }

        // Calculate interest and add it to the balance
        val interest = balance * (rate / 100)
        balance += interest
        println("📈 Interest of $${"%.2f".format(interest)} added to $owner’s account.")
    }
}

fun main() {
    println("🏦 Welcome to Kotlin Bank!")
    println("This version supports multiple users and interest calculation.\n")

    // List to store all user accounts (OOP + collections)
    val accounts = mutableListOf<BankAccount>()

    var running = true
    while (running) {
        // Display the main menu with options
        println("==== Main Menu ====")
        println("1. Create a new account")
        println("2. Access existing account")
        println("3. View all accounts")
        println("4. Exit")
        print("Enter choice (1–4): ")

        when (readln()) {
            // Option 1: Create a new account
            "1" -> {
                print("Enter owner’s name: ")
                val name = readln()
                print("Enter initial deposit amount: ")
                val amount = readln().toDoubleOrNull()

                if (amount != null && amount >= 0) {
                    // Create a new BankAccount object and add to list
                    accounts.add(BankAccount(name, amount))
                    println("✅ Account for $name created successfully with $$amount.\n")
                } else {
                    println("❌ Invalid deposit amount.\n")
                }
            }

            // Option 2: Access an existing account
            "2" -> {
                print("Enter the owner’s name to access account: ")
                val name = readln()

                // Find the account by owner’s name (case-insensitive)
                val account = accounts.find { it.owner.equals(name, ignoreCase = true) }

                if (account != null) {
                    println("Welcome back, ${account.owner}!")
                    accountMenu(account)
                } else {
                    println("⚠️ No account found for '$name'.\n")
                }
            }

            // Option 3: Show list of all account owners
            "3" -> {
                if (accounts.isEmpty()) {
                    println("No accounts created yet.\n")
                } else {
                    println("📋 List of all accounts:")
                    accounts.forEach { println("- ${it.owner}") }
                    println()
                }
            }

            // Option 4: Exit the banking system
            "4" -> {
                println("👋 Thank you for using Kotlin Bank Plus! Have a great day!")
                running = false
            }

            // Handle invalid menu inputs
            else -> println("❌ Invalid choice. Please enter a number from 1 to 4.\n")
        }
    }
}

fun accountMenu(account: BankAccount) {
    var inAccount = true

    while (inAccount) {
        // Show user actions inside their account
        println("\n---- Account Menu for ${account.owner} ----")
        println("1. Deposit Money")
        println("2. Withdraw Money")
        println("3. Check Balance")
        println("4. Add Interest")
        println("5. Return to Main Menu")
        print("Enter choice (1–5): ")

        when (readln()) {
            "1" -> {
                print("Enter amount to deposit: ")
                val amount = readln().toDoubleOrNull()
                if (amount != null) account.deposit(amount)
                else println("❌ Invalid input, must be a number.")
            }

            "2" -> {
                print("Enter amount to withdraw: ")
                val amount = readln().toDoubleOrNull()
                if (amount != null) account.withdraw(amount)
                else println("❌ Invalid input, must be a number.")
            }

            "3" -> account.checkBalance()

            "4" -> {
                print("Enter annual interest rate (e.g., 5 for 5%): ")
                val rate = readln().toDoubleOrNull()
                if (rate != null) account.addInterest(rate)
                else println("❌ Invalid input, must be a number.")
            }

            "5" -> {
                println("Returning to main menu...\n")
                inAccount = false
            }

            else -> println("❌ Invalid option, try again.\n")
        }
    }
}
