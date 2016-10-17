def numbers = 1..10
for (num in numbers) {
	println num
}

def letters = 'a'..'l'
for (ltr in letters) {
	println ltr
}

def enum DAYS {
	SUN,
	MON,
	TUE,
	WED,
	THR,
	FRI,
	SAT
}

def weekdays = DAYS.MON..DAYS.FRI
for (day in weekdays) {
	println day
}

println "Extents: "
println weekdays.from
println weekdays.to