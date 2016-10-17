@Grapes (
	@Grab(group='joda-time', module='joda-time', version='2.9.3')
)
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class DateParser {
	def String parse(time){
		if(!time)
			throw new IllegalArgumentException()

		// allows all methods on the DateTimeCategory visible within the closure
		use(DateTimeCategory) {
			def printableTime = new DateTime(time)
			// can use implicit return
			// return printableTime.createPrintableTime()
			printableTime.createPrintableTime()
		}
	}
}
