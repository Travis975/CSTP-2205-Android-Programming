package entities_tsc_71

class HockeyPlayer_tsc_71(
    name: String,
    phoneNumber: String,
    emailAddress: String,
    private val firstName: String,
    private val lastName: String,
    private val _pos: Position,
    private var _goals: Int,
    private var _assists: Int,
    private var _penalties: Int,
    _number: String,
    team: Team_tsc_71
) : Person_tsc_71(name, phoneNumber, emailAddress) {

    val _number: String

    init {
        if (team.players.any { it._number == _number }) {
            throw IllegalArgumentException("Number $_number is already taken by another player.")
        }
        this._number = _number
    }

    enum class Position {
        CENTER, LEFT_WING, RIGHT_WING, DEFENSE, GOALIE
    }

    var goals: Int
        get() = _goals
        set(value) {
            if (value >= 0) _goals = value
        }

    var assists: Int
        get() = _assists
        set(value) {
            if (value >= 0) _assists = value
        }

    var penalties: Int
        get() = _penalties
        set(value) {
            if (value >= 0) _penalties = value
        }

    override fun toString(): String {
        return "$firstName $lastName  $_pos    $_number   $_goals $_assists $_penalties "
    }

}