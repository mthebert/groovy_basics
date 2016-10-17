def file = new File('data/fells_loop.gpx')
// println file.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

println 'beginning dump...'
// good for debugging - the dump provides a wealth of info
println gpx.name.value.dump()

println 'beginning inspect...'
println gpx.name.inspect()

gpx.with {
	println name
	println ''
	println desc
	println ''
	println attributes()['version']
	println attributes()['creator']
}

/*
// each of these were previous versions of the function
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
gpx.rte.rtept.each {
	println ''
	println it.@lat
	println it.@lon

	def parser = new DateParser()
	println parser.parse(it.time.toString())
*/
