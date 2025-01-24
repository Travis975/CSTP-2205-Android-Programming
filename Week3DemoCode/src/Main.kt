import entities_tsc_71.NormalOrder_tsc_71
import entities_tsc_71.Order_tsc_71
fun main() {

    var someOrder : Order_tsc_71 = Order_tsc_71()
    var normalOrder : NormalOrder_tsc_71 = NormalOrder_tsc_71()

    println(someOrder);

    normalOrder.dispatch()

    println(normalOrder)

    someOrder compareStatus normalOrder;
}