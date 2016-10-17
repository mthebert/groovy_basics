def file = new File('fells_loop.gpx')
// println file.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

println gpx.name
println ''
println gpx.desc
println ''
println gpx.@version
println gpx.@creator
println ''
/*
for (point in gpx.rte.rtept){
	println ''
	println point.@lat
	println point.@lon
	println point.time
}

gpx.rte.rtept.each {
	println ''
	println it.@lat
	println it.@lon
	println it.time
}
*/
gpx.rte.rtept.each {
	println ''
	println it.@lat
	println it.@lon
	
	def parser = new DateParser()
	println parser.parse(it.time.toString())
}