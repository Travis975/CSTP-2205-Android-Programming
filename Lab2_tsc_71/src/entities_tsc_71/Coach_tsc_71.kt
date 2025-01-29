package entities_tsc_71

class Coach_tsc_71(
    name: String,
    phoneNumber: String,
    emailAddress: String,
    private val _title: String
) : Person_tsc_71(name, phoneNumber, emailAddress) {
    override fun toString(): String {
        return "$name       $_title"
    }
}
