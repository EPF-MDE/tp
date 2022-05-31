import com.github.polomarcus.utils.ClimateService
import com.github.polomarcus.model.CO2Record
import org.scalatest.funsuite.AnyFunSuite

//@See https://www.scalatest.org/scaladoc/3.1.2/org/scalatest/funsuite/AnyFunSuite.html
class ClimateServiceTest extends AnyFunSuite {
  test("containsWordGlobalWarming - non climate related words should return false") {
    assert(ClimateService.isClimateRelated("pizza") == false)

    assert(ClimateService.isClimateRelated("la crypto c'est bo") == false)
  }

  test("isClimateRelated - climate related words should return true") {
    assert(ClimateService.isClimateRelated("climate change"))
    assert(ClimateService.isClimateRelated("IPCC"))
  }

  //@TODO
  test("parseRawData") {
    val list1 = List((2003, 1, 355.2), (2004, 1, 375.2))
    val output = List(Some(CO2Record(2003, 1, 355.2)), Some(CO2Record(2004, 1, 375.2)))
    assert(ClimateService.parseRawData(list1) == output)
  }
  test("getMinMax"){
    val list1 = List(Some(CO2Record(2003, 1, 355.2)), Some(CO2Record(2004, 1, 375.2)))
    val output = (355.2,375.2)
    assert(ClimateService.getMinMax(list1) == output)
  }
test("getMinMaxByYear"){
  val Year = 2003
  val list1 = List(Some(CO2Record(2003, 1, 355.2)), Some(CO2Record(2003, 1, 375.2)),Some(CO2Record(2003, 1, 365.2)),Some(CO2Record(2004, 1, 375.2)))
  val output = (355.2,375.2)
  assert(ClimateService.getMinMaxByYear(Year,list1) == output)
}
  //@TODO
  test("filterDecemberData") {
    assert(true == false)
  }
}
