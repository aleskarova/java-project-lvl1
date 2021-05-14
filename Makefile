install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

run: run-dist

check-updates:
	./gradlew dependencyUpdates
