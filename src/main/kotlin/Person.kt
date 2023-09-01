package contacts

import java.time.LocalDate

class Person(
    firstName: String,
    secondName: String,
    birthDate: String = "[no data]",
    gender: String = "[no data]",
    number: String = "[no data]"
) : Contact(number, LocalDate.now(), LocalDate.now()) {  // Calling superclass constructor

    var firstName: String = firstName
    var secondName: String = secondName
    var birthDate: String = birthDate
    var gender: String = gender
    var number: String = number

    companion object {
        fun createPerson(): Person {
            val firstName: String = askForFirstName()
            val secondName: String = askForSecondName()
            val birthDate: String = askForBirthDate()
            val gender:String = askForGender()
            val phoneNumber: String = askForNumber()

            return Person(firstName, secondName, birthDate, gender, phoneNumber)
        }

        private fun askForFirstName(): String {
            println("Enter the name of the person:")
            return readln()
        }

        private fun askForSecondName(): String {
            println("Enter the surname of the person:")
            return readln()
        }

        private fun askForBirthDate(): String {
            println("Enter the birth date:")
            var birthDate = readln()
            if(!isValidDate(birthDate)) {
                println("Bad birth date!")
                birthDate = "[no data]"
            }
            return birthDate
        }

        private fun askForNumber(): String {
            println("Enter the number:")
            var phoneNumber = readln()
            if(!isValidNumber(phoneNumber)) {
                println("Wrong number format!")
                phoneNumber = "[no data]"
            }
            return phoneNumber
        }

        private fun askForGender(): String {
            println("Enter the gender (M, F):")
            var gender = readln()
            if(!isValidGender(gender)) {
                println("Bad gender!")
                gender = "[no data]"
            }
            return gender
        }

        private fun isValidGender(gender: String): Boolean {
            return gender == "M" || gender == "F"
        }

        fun updatePerson(recordToEdit: Person) {
            println("Select a field (name, surname, birth, gender, number):")
            val chosenAttribute = readln()

            when(chosenAttribute) {
                "name" -> recordToEdit.firstName = askForFirstName()
                "surname" -> recordToEdit.secondName = askForSecondName()
                "birth" -> recordToEdit.birthDate = askForBirthDate()
                "gender" -> recordToEdit.gender = askForGender()
                "number" -> recordToEdit.number = askForNumber()
            }

            recordToEdit.timeModified = LocalDate.now()
        }
    }

    override fun toString(): String {
        return "Name: $firstName\n" +
                "Surname: $secondName\n" +
                "Birth date: $birthDate\n" +
                "Gender: $gender\n" +
                "Number: $number\n" +
                "Time created: $timeCreated\n" +
                "Time last edit: $timeModified"
    }

    override fun printInfo(): String{
        return "$firstName $secondName"
    }
}