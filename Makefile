lint:
	./gradlew checkstyleMain

build: lint
	./gradlew clean build

install: lint
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

run: run-dist

check-updates:
	./gradlew dependencyUpdates
