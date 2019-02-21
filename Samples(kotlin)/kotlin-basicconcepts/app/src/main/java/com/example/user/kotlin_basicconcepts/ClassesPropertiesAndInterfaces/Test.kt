package com.example.user.kotlin_basicconcepts.ClassesPropertiesAndInterfaces


/*
In kotlin, a function or a field can be declared in a kotlin file, without extracting
it to a separate class. In the below example, we can see that the function test exists
outside a class
* */
fun test() {
    val person = Person("John", 30)

}

/*
In kotlin we don't need to make the getters and setters functions to access the members
if the members need to have different access modifiers, they can be mentioned in the constructor

Using the primary constructor is most common in kotlin
*/
class Person(name: String, age: Int)


/*
Other ways of defining a class (Check Person1, Person2, Person3)
*/

//with the init block
class Person1(name: String, age: Int) {
    val name: String
    val age: Int

    /*
   In kotlin, this init block is used to add some constructor code to the class
   */
    init {
        this.name = name
        this.age = age
    }
}

//assigning the values in class
class Person2(name: String, age: Int) {
    val name: String = name
    val age: Int = age
}

//declaring the values inline
class Person3(val name: String, val age: Int)

/*
For assigning a default value to the constructor in kotlin, you can assign the value
while we init the constructor of the class inline. In the below example we are also making
a custom getter and setter to change and verify the value of the property
*/
open class Person4(val name: String = "John", age: Int = 10) {
    var age: Int = age
        get() = field + 10
        set(value) {
            if (value != field)
                field = value
        }

    override fun toString(): String {
        return "Person4(name='$name', Age:'$age')"
    }


}

/*
For inheritance, we need to make the Person class "open" since all classes in kotlin
by default are final
*/
open class OpenPerson(val name: String = "Default name", val age: Int = 10)

/*
In the following example, the Developer class is extending the OpenPerson class
and have different names but default age of all objects

If the class does not have any code (constructor or methods), we can remove the "{}"
*/
class Developer(name: String, age: Int) : OpenPerson(name, 20)

/*
For making multiple custom constructors you can use the keyword "constructor"
*/
class AndroidDeveloper : OpenPerson {

    constructor(name: String) : super("Android Dev: $name")
    constructor(age: Int) : super(age = age)
}
