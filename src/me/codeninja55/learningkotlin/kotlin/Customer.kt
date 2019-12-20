package me.codeninja55.learningkotlin.kotlin

// Default constructor
// data gives use some other pre-compiled code like toString(), hashCode() and equals()
// hashCode() uses variables in the primary constructor
data class Customer(val firstName: String, val lastName: String, val age: Int) {
    var address: Address
        private set

    private val id: Int

    // Overriding setters
    var approved: Boolean = false
    set(value) {  // Important to put mutator for class var right underneath
        // Override approved accessor/mutator method
        if (age >= 18)
            // Need to refer to class variable by `field`
            field = value
        else
            println("You can't approve an underage customer.")
    }

    val nextAge  // Important to put accessor for class var right underneath
    get() = age + 1

    // Will run whenever primary constructor is run
    init {
        this.id = getNewId()
        this.address = Address()
    }

    // Secondary constructor
    constructor(
        firstName: String,
        lastName: String,
        age: Int,
        street: String,
        suburb: String,
        postCode: Int,
        state: String,
        country: String
    ) : this(firstName, lastName, age) {  // Call the primary constructor
        this.address = Address(street, suburb, postCode, state, country)
    }

    fun fullName() : String = "$firstName $lastName"
    private fun upperCaseName() : String = fullName().toUpperCase()

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String {
        return """Customer ($id): ${upperCaseName()}
            |Age: $age
            |$address
        """.trimMargin("|")
    }

    // Static functions and variables
    companion object {
        private var idCounter: Int = 0
        fun getNewId() = ++idCounter
    }
}

class Address(
    val street: String = "",
    val suburb: String = "",
    val postCode: Int = -1,
    val state: String = "",
    val country: String = ""
) {

    // Overriding destructuring in standard class
    operator fun component1() = street
    operator fun component2() = suburb
    operator fun component3() = postCode
    operator fun component4() = state
    operator fun component5() = country

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String {
        return if (this.street.isNotBlank()) """Address:
        | $street
        | $suburb $postCode $state
        | $country
        """.trimMargin("|") else "Address: None"
    }
}

fun main(args: Array<String>) {
    val cust = Customer("Genina", "Manuel", 28)

    println(cust)

    val cust2 = Customer(
        firstName = "Andrew",
        lastName = "Che",
        age = 30,
        street = "4 Pinnacle Street",
        suburb = "Sadleir",
        postCode = 2168,
        state = "NSW",
        country = "Australia"
    )
    println(cust2)

    val underageCust = Customer(
        firstName = "Annie",
        lastName = "Nguyen",
        age = 17
    )
    underageCust.approved = true
    println(underageCust)

    println("Next year, ${underageCust.fullName()} will be ${underageCust.nextAge}")

    // Call Static method of class
    println(Customer.getNewId())

    // Default copy function from using a `data` class
    val annieOlder = underageCust.copy(firstName = "Annie", lastName = "Nguyen", age = 21)
    annieOlder.approved = true
    println(annieOlder)

    // Destructuring from `data` class
    val (firstName, lastName, age) = annieOlder
    println("$firstName $lastName is $age years old.")

    // Destructuring overridden from non `data` class
    val (street, suburb, postcode, state, country) = cust2.address
    println("${cust2.fullName()} lives at $street, $suburb $postcode $state $country")

}