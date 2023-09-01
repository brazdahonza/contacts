package contacts

import java.time.LocalDate

open class Contact(
    var phoneNumber: String = "[no number]",
    var timeModified: LocalDate = LocalDate.now(), // Default to current date
    val timeCreated: LocalDate = LocalDate.now()  // Default to current date
) {
    companion object {
        fun isValidNumber(phoneNumber: String): Boolean {
            val phoneNumberRegex = Regex(pattern = "[+]?\\w?[\\s-]?(\\([\\w]{2,}\\)|[\\w]{2,}[\\s-]\\([\\w]{2,}\\)|[\\w]{1,})([\\s-][\\w]{2,})*")
            return phoneNumber.matches(phoneNumberRegex)
        }

        fun isValidDate(date: String): Boolean {
            val dateRegex = Regex("^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")
            return date.matches(dateRegex)
        }
    }

    open fun printInfo(): String {
        return this.toString()
    }
}