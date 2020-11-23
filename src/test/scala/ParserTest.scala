import org.scalatest.FunSuite

class ParserTest extends FunSuite{

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

  test("parseDOW asterix test") {
    assert(Parser.parseDOW("*") === "1 2 3 4 5 6 7")
  }

  test("parseDOW negative test") {
    assert(Parser.parseDOW("0") === "wrong string")
  }

  //TODO: test other methods
}
