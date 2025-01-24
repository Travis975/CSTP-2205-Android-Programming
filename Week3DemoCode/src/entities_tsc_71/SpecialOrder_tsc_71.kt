package entities_tsc_71

class SpecialOrder_tsc_71 : Order_tsc_71() {
    fun dispatch() {
        this.status = "dispatched"
    }
}