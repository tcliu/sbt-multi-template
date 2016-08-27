package app.module

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Liu on 8/28/2016.
  */
class ModuleUtilsSpec extends FlatSpec with Matchers {

  "sum" should "sum up 2 numbers" in {
    ModuleUtils.sum(2, 3) should be (5)
  }
}
