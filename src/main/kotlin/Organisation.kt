package contacts

import java.time.LocalDate

class Organisation(
    orgName: String,
    adress: String,
    number: String = "[no data]"
) : Contact(number, LocalDate.now(), LocalDate.now()) {

    val orgName: String = orgName
    var adress: String = adress
    var number: String = number

    override fun toString(): String {
        return "Organization name: $orgName\n" +
                "Address: $adress\n" +
                "Number: $number\n" +
                "Time created: $timeCreated\n" +
                "Time last edit: $timeModified"
    }

    companion object {
        fun createOrganisation(): Contact {
            val orgName = askForName()
            val adress = askForAdress()
            val phoneNumber = askForNumber()
            return Organisation(orgName, adress, phoneNumber)
        }

        fun askForNumber(): String {
            println("Enter the number:")
            var phoneNumber = readln()
            if(!isValidNumber(phoneNumber)) {
                println("Wrong number format!")
                phoneNumber = "[no data]"
            }
            return phoneNumber
        }

        fun askForName(): String {
            println("Enter the organization name:")
            return readln()
        }

        fun askForAdress(): String{
            println("Enter the address:")
            return readln()
        }

        fun updateOrganisation(recordToEdit: Organisation) {
            println("Select a field (address, number):")
            val chosenAttribute = readln()

            when(chosenAttribute) {
                "address" -> recordToEdit.adress = askForAdress()
                "number" -> recordToEdit.number = askForNumber()
            }

            recordToEdit.timeModified = LocalDate.now()
        }
    }

    override fun printInfo(): String{
        return orgName
    }
}