package entities_tsc_71

class NormalOrder_tsc_71 : Order_tsc_71() {
    fun dispatch() {
        this.status = "dispatched"
    }

    fun received() {
        this.status = "received"
    }
}