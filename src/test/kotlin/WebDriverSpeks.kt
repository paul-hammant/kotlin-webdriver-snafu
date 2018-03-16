import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.seleniumhq.selenium.fluent.FluentWebDriver

class WebDriverSpeks : Spek({
    ChromeDriverManager.getInstance().setup()
    val co = ChromeOptions()
    val chromeDriver = ChromeDriver(co) as WebDriver
    val fluentWebDriver = FluentWebDriver(chromeDriver)

    beforeGroup {
        chromeDriver.get("https://yahoo.com/")
    }

    describe("yahoo") {
        it("should have index.html") {
            fluentWebDriver.title().shouldBe("OK")
        }
    }

    afterGroup {
        chromeDriver.close()
    }
})
