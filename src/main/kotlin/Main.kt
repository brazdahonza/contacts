package contacts

fun main() {
    start()
}

fun start() {
    val contactList = mutableListOf<Contact>()
    while(true) {
        println("Enter action (add, remove, edit, count, info, exit):")
        val input = readln()

        when(input) {
            "add" -> add(contactList)
            "remove" -> remove(contactList)
            "edit" -> edit(contactList)
            "count" -> {
                println("The Phone Book has ${count(contactList)} records.")
            }
            "info" -> info(contactList)
            "exit" -> break
        }
        println()
    }
}
fun edit(contactList: MutableList<Contact>) {
    if(count(contactList) == 0) {
        println("No records to edit!")
        return
    }

    list(contactList)
    println("Select a record:")
    val selectedRecord = readln().toInt()

    if(selectedRecord !in 1..contactList.size) {
        println("Invalid record!")
        return
    }

    val recordToEdit = contactList[selectedRecord-1]
    if(recordToEdit is Person) {
        Person.updatePerson(recordToEdit)
    }
    if(recordToEdit is Organisation) {
        Organisation.updateOrganisation(recordToEdit)
    }
    println("The record updated!")
}

fun add(contactList: MutableList<Contact>) {
    println("Enter the type (person, organization):")
    val choice = readln()
    if(choice == "person") {
        contactList.add(Person.createPerson())
    } else if(choice == "organization") {
        contactList.add(Organisation.createOrganisation())
    }

    println("The record added.")
}

fun remove(contactList: MutableList<Contact>) {
    if(count(contactList) == 0) {
        println("No records to remove!")
        return
    }

    println("Select a record:")
    val selectedRecord = readln().toInt()

    if(selectedRecord !in 1..contactList.size) {
        println("Invalid record!")
        return
    }

    contactList.removeAt(selectedRecord - 1)
    println("The record removed!")
}

fun count(contactList: MutableList<Contact>): Int {
    return contactList.size
}

fun info(contactList: MutableList<Contact>) {

    list(contactList)
    println("Select a record:")
    val selectedRecord = readln().toInt()
    println(contactList[selectedRecord-1].toString())
}

fun list(contactList: MutableList<Contact>) {
    for(i in 0..contactList.lastIndex) {
        if(contactList[i] is Person) {
            println("${i + 1}. ${contactList[i].printInfo()}")
        }
    }
}











