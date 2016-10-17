def myClosure = { 
	println "In a closure"
	println new Date()
}

myClosure()

for(i in 1..3) {
	myClosure()
	sleep(1000)
}

(1..3).each {
	println "In a closure--> $it"
}

(1..3).each ({ i->
	println "In a closure: $i"
})

(1..10).findAll({return it%2==0}).each ({ i->
	println "Again In a closure: $i"
})

(1..10).findAll({return it%2==0}).each ({println "one line In a closure: $it"})