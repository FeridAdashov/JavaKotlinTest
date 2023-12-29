import kotlinx.coroutines.runBlocking


enum class RoomType {
    ONE, TWO, THREE
}

fun RoomType.getPrice(): Double = when (this) {
    RoomType.ONE -> 45.0
    RoomType.TWO -> 65.0
    RoomType.THREE -> 90.0
}

fun RoomType.getCount(): Int = when (this) {
    RoomType.ONE -> 50
    RoomType.TWO -> 40
    RoomType.THREE -> 30
}

fun RoomType.info(): String {
    return when (this) {
        RoomType.ONE -> "One room"
        RoomType.TWO -> "Two room"
        RoomType.THREE -> "Three room"
    } + "(${this.getPrice()} Azn)"
}

data class Room(val type: RoomType, val person: Person, var reservedDayCount: Int)
data class Person(val name: String, val surname: String)

interface HotelOperations {
    fun orderRoom(room: Room): Boolean
    fun emptyRoom(person: Person): Boolean
    fun personAccountToPay(person: Person): Double
    fun printMenu()
    fun printAllReservedRooms()
    fun printEmptyRooms()

    fun createPersonByUserInput(): Person

    fun createRoomByUserInputs(): Room
}

class Hotel : HotelOperations {

    private val reservedRooms = mutableListOf<Room>()
    override fun orderRoom(room: Room): Boolean {
        if (reservedRooms.count { it.type == room.type } == room.type.getCount()) {
            println("There is no available room")
            return false
        }

        reservedRooms.add(room)

        return true
    }

    override fun emptyRoom(person: Person): Boolean = reservedRooms.removeIf { it.person == person }

    override fun personAccountToPay(person: Person): Double {
        val r = reservedRooms.find { it.person == person }
        if (r == null) return 0.0
        return r.reservedDayCount * r.type.getPrice()
    }

    override fun printMenu() {
        println(
            "\n1. Order\n" +
                    "2. Empty\n" +
                    "3. All reserved rooms data\n" +
                    "4. All empty rooms\n" +
                    "5. Menu\n" +
                    "q/Q. Quit"
        )
    }

    override fun printAllReservedRooms() {
        reservedRooms.forEach {
            println(
                "Room: ${it.type.info()}\n" +
                        "Reserved day count: ${it.reservedDayCount}\n" +
                        "Person: ${it.person.surname} ${it.person.name}\n" +
                        "Account to pay: ${personAccountToPay(it.person)}"
            )
        }
    }

    override fun printEmptyRooms() {
        RoomType.entries.forEach { type ->
            println("Room type: ${type.info()}  --- Available: ${type.getCount() - reservedRooms.count { it.type == type }}")
        }
    }

    override fun createPersonByUserInput(): Person {
        print("Name: ")
        val name = readln()

        print("Surname: ")
        val surname = readln()

        return Person(name, surname)
    }

    override fun createRoomByUserInputs(): Room {
        RoomType.entries.mapIndexed { index, roomType -> println("${index + 1} : ${roomType.info()}") }

        val type = readln().toInt()
        val roomType = RoomType.entries[type - 1]

        println("Enter person")

        val person = createPersonByUserInput()

        print("Reserved days count: ")
        val days = readln().toInt()

        return Room(roomType, person, days)
    }
}


fun main() = runBlocking {

//    val retrofitHttpClient = RetrofitClient.makeRetrofitService()
//    val mainMapper = MainMapper()
//    val repositoryImpl = MainRepositoryImpl(retrofitHttpClient, mainMapper)
//    val interactor = MainInteractor(repositoryImpl)
//    val viewModel = MainViewModel(interactor)
//
//    var f = true
//
////    CoroutineScope(Dispatchers.IO).launch {
////        val data = viewModel.f()
////
////        println(data)
////
////        f = false
////    }
//
//
//    val result = async {
//        delay(1000L)
//        return@async "Hello, Jack!"
//    }
//
//    // Wait for the result to be available
//    val message = result.await()
//
//    println(message)
//    println("Ok")


    val hotel = Hotel()
    var choice = ' '

    while (!choice.equals('q', ignoreCase = true)) {
        println("\n")

        when (choice.digitToIntOrNull()) {
            1 -> hotel.orderRoom(hotel.createRoomByUserInputs())
            2 -> hotel.emptyRoom(hotel.createPersonByUserInput())
            3 -> hotel.printAllReservedRooms()
            4 -> hotel.printEmptyRooms()
            5 -> hotel.printMenu()
        }

        hotel.printMenu()

        print("\nChoice: ")
        choice = readln()[0]
    }
}

