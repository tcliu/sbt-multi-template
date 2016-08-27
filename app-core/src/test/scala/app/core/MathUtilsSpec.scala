package app.core

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Liu on 8/28/2016.
  */
class MathUtilsSpec extends FlatSpec with Matchers {

  "sum" should "sum up 2 numbers" in {
    MathUtils.sum(2, 3) should be (5)
  }

}
