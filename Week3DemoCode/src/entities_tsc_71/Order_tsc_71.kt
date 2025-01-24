package entities_tsc_71

import java.util.Date;

public open class Order_tsc_71 {

    val date = Date();
    var number : String = "";
    var status : String = "open"

    // Companion Object
    companion object {

        var currentOrderNumber : Int = 1;

        fun getNewOderNumber() : Int {
            return currentOrderNumber++;
        }

    }
    // init block for when a new instance is created
    init {
        this.number = Order_tsc_71.getNewOderNumber().toString();
    }

    fun confirm() {
        this.status = "confirmed"
    }

    fun close() {
        this.status = "close"
    }

    infix fun compareStatus(o: Order_tsc_71) {
        if (o.status.equals(this.status)) {
            println("Order: ${o.number} and ${this.number} have the same status")
        } else {
            println("Order: ${o.number} and ${this.number} do not have the same status")
        }
    }

    override fun toString() : String {
        val sb = StringBuilder()
        sb.append("Order Number: " + this.number + "\n")
        sb.append("Order date: " + this.date + "\n")
        sb.append("Order status: " + this.status + "\n")

        return sb.toString();
    }
}