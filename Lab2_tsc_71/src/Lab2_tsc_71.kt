// ============================================= Lab 2 Hockey Team Builder =============================================
// 1. All entities must be in a package called entities_abc_## . The Person_abc_## class must not be instantiable
// 2. You may not hardcode the order of adding any of the Persons to the team
// 3. Your main.kt file must add a coach in the middle, you must still print the coaches first,
//      you must instantiate at least 5 players and 1 coach
// 4. You must use user-defined objects to store all the data in the program according to the objects and Class Diagram.
// =====================================================================================================================
package entities_tsc_71

fun main() {
    println("============================ Hockey Team Roster ============================")

    // Set variables for the team info
    val teamName : String = "Canucks"
    val teamCity : String = "Vancouver"
    val teamCountry : String = "Canada"
    var teamSize : Int = 12

    val team = Team_tsc_71(teamName, teamCity, teamSize, teamCountry)

    println("\nWelcome to the Team Builder for ${team.name}!")

    // Set the variables for the team members
    val player1 = HockeyPlayer_tsc_71(
        name = "John Deere",
        phoneNumber = "123-345-6789",
        emailAddress = "player1@hotmail.com",
        firstName = "John",
        lastName = "Deere",
        _pos = HockeyPlayer_tsc_71.Position.LEFT_WING,
        _goals = 5,
        _assists = 4,
        _penalties = 2,
        _number = "20",
        team = team
    )
    val player2 = HockeyPlayer_tsc_71(
        name = "Travis Kelce",
        phoneNumber = "123-345-6799",
        emailAddress = "player2@hotmail.com",
        firstName = "Travis",
        lastName = "Kelce",
        _pos = HockeyPlayer_tsc_71.Position.RIGHT_WING,
        _goals = 7,
        _assists = 6,
        _penalties = 2,
        _number = "97",
        team = team
    )
    val player3 = HockeyPlayer_tsc_71(
        name = "Wayne Gretsky",
        phoneNumber = "123-345-6788",
        emailAddress = "player3@hotmail.com",
        firstName = "Wayne",
        lastName = "Gretsky",
        _pos = HockeyPlayer_tsc_71.Position.CENTER,
        _goals = 99,
        _assists = 98,
        _penalties = 1,
        _number = "99",
        team = team
    )
    val player4 = HockeyPlayer_tsc_71(
        name = "Bubba Johnson",
        phoneNumber = "123-345-8989",
        emailAddress = "player4@hotmail.com",
        firstName = "Bubba",
        lastName = "Johnson",
        _pos = HockeyPlayer_tsc_71.Position.DEFENSE,
        _goals = 1,
        _assists = 3,
        _penalties = 72,
        _number = "6",
        team = team
    )
    val player5 = HockeyPlayer_tsc_71(
        name = "Conor McDavid",
        phoneNumber = "123-375-6789",
        emailAddress = "playr5@hotmail.com",
        firstName = "Conor",
        lastName = "McDavid",
        _pos = HockeyPlayer_tsc_71.Position.DEFENSE,
        _goals = 13,
        _assists = 22,
        _penalties = 4,
        _number = "22",
        team = team
    )
    val player6 = HockeyPlayer_tsc_71(
        name = "Roberto Luongo",
        phoneNumber = "123-346-6789",
        emailAddress = "player6@hotmail.com",
        firstName = "Roberto",
        lastName = "Luongo",
        _pos = HockeyPlayer_tsc_71.Position.GOALIE,
        _goals = 1,
        _assists = 2,
        _penalties = 2,
        _number = "67",
        team = team
    )
    val player7 = HockeyPlayer_tsc_71(
        name = "Sidney Crosby",
        phoneNumber = "123-345-5589",
        emailAddress = "player7@hotmail.com",
        firstName = "Sidney",
        lastName = "Crosby",
        _pos = HockeyPlayer_tsc_71.Position.CENTER,
        _goals = 7,
        _assists = 3,
        _penalties = 2,
        _number = "18",
        team = team
    )
    val coach1 = Coach_tsc_71(
        name = "Don Cherry",
        phoneNumber = "123-567-3214",
        emailAddress = "coach1@hotmail.com",
        _title = "Head Coach"
    )
    val coach2 = Coach_tsc_71(
        name = "Mike Ditka",
        phoneNumber = "123-333-2222",
        emailAddress = "coach2@hotmail.com",
        _title = "Assistant Coach"
    )
    // Add members to the team (show order of adding does not matter)
    team.add(player1)
    team.add(player2)
    team.add(player3)
    team.add(coach1)
    team.add(coach2)
    team.add(player4)
    team.add(player5)
    team.add(player6)
    team.add(player7)


    // Print the team roster to console
    team.printRoster()
}

// Used the scanner for getting user input
//import java.util.Scanner

//fun main() {
//    println("============================================= Lab 2 Hockey Team Builder with UI =============================================\n")
//    // Create a Scanner object to read from console
//    val scanner = Scanner(System.`in`)
//
//    // Get the user details for team details
//    print("Enter the team name: ")
//    val teamName = scanner.nextLine().trim()
//
//    print("Enter the team's city: ")
//    val teamCity = scanner.nextLine().trim()
//
//    println("Enter the number of players: ")
//    val teamSize = scanner.nextInt()
//
//    scanner.nextLine() // Call this to not skip over country
//    print("Enter the team's country: ")
//    val teamCountry = scanner.nextLine().trim()
//
//    val team = Team_tsc_71(teamName, teamCity, teamSize , teamCountry)
//
//    println("\nWelcome to the Team Builder for ${team.name}!")
//
//
//    while (true) {
//        println("\nOptions: ")
//        println("1: Add Player")
//        println("2: Add Coach")
//        println("3: Print Roster")
//        println("4: Quit")
//        print("\nEnter your choice: ")
//
//        val choice = scanner.nextLine().trim()
//
//        when (choice) {
//            "1" -> {
//                try {
//                    print("Enter player's first name: ")
//                    val firstName = scanner.nextLine().trim()
//                    print("Enter player's last name: ")
//                    val lastName = scanner.nextLine().trim()
//                    print("Enter player's position (CENTER, LW, RW, DEFENSE, GOALIE): ")
//                    val position = scanner.nextLine().trim().uppercase()
//                    print("Enter player's goals: ")
//                    val goals = scanner.nextLine().toInt()
//                    print("Enter player's assists: ")
//                    val assists = scanner.nextLine().toInt()
//                    print("Enter player's penalties: ")
//                    val penalties = scanner.nextLine().toInt()
//                    print("Enter player's number: ")
//                    val number = scanner.nextLine().trim()
//
//                    val positionEnum = HockeyPlayer_tsc_71.Position.valueOf(position)
//
//                    val player = HockeyPlayer_tsc_71(
//                        name = "$firstName $lastName",
//                        phoneNumber = "",
//                        emailAddress = "",
//                        firstName = firstName,
//                        lastName = lastName,
//                        _pos = positionEnum,
//                        _goals = goals,
//                        _assists = assists,
//                        _penalties = penalties,
//                        _number = number,
//                        team = team
//                    )
//
//                    team.add(player)
//                    println("Player $firstName $lastName added successfully!")
//                } catch (e: Exception) {
//                    println("Error adding player: ${e.message}")
//                }
//            }
//
//            "2" -> {
//                try {
//                    print("Enter coach's name: ")
//                    val name = scanner.nextLine().trim()
//                    print("Enter coach's title: ")
//                    val title = scanner.nextLine().trim()
//
//                    val coach = Coach_tsc_71(
//                        name = name,
//                        phoneNumber = "",
//                        emailAddress = "",
//                        _title = title
//                    )
//
//                    team.add(coach)
//                    println("Coach $name added successfully!")
//                } catch (e: Exception) {
//                    println("Error adding coach: ${e.message}")
//                }
//            }
//
//            "3" -> {
//                println("\nTeam Roster:")
//                team.printRoster()
//            }
//
//            "4" -> {
//                println("Exiting program. Goodbye!")
//                break
//            }
//
//            else -> println("Invalid choice. Please try again.")
//        }
//    }
//
//}