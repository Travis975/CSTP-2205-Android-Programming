package entities_tsc_71

class Team_tsc_71 (
    val name: String = "",
    val city: String = "" ,
    private var numberOfPlayers: Int = 0,
    val country: String= ""

) {
    val players = mutableListOf<HockeyPlayer_tsc_71>()
    val coaches = mutableListOf<Coach_tsc_71>()

    fun add(person: Person_tsc_71) {
        when (person) {
            is HockeyPlayer_tsc_71 -> {
                players.add(person)
                numberOfPlayers++
            }
            is Coach_tsc_71 -> {
                coaches.add(person)
            }
            else -> {
                throw IllegalArgumentException("Only HockeyPlayer_tsc_71 or Coach_tsc_71 can be added.")
            }
        }
    }

    fun printRoster() {
        println("Team Roster for $name ($city, $country):\n")
        println("Coaches:")
        coaches.forEach { println(it) }

        println("---")
        println("Players      Position    #    G/A/P")
        players.forEach { println(it) }

        println("---")
        println("Number of Players: ${players.size}")
        println("Number of Coaches: ${coaches.size}")
    }
}