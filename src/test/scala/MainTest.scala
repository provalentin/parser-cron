import org.scalatest.FunSuite

class MainTest extends FunSuite{

  test("parseMin single value test") {
    assert(Parser.parseMin("12") === "12")
  }

  test("parseMin sequence test") {
    assert(Parser.parseMin("1,17,37") === "1 17 37")
  }

  test("parseMin interval test") {
    assert(Parser.parseMin("1-3") === "1 2 3")
  }

  test("parseMin periodical test") {
    assert(Parser.parseMin("*/20") === "0 20 40")
  }

  //TODO: test other methods
}
