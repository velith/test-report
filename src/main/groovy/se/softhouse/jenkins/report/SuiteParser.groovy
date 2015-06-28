package se.softhouse.jenkins.report

class SuiteParser {
    private int failures
    private int errors
    private int tests

    def parse(String xml) {
        def testSuite = new XmlSlurper().parseText(xml)

        failures = testSuite.@failures.toInteger()
        errors = testSuite.@errors.toInteger()
        tests = testSuite.@tests.toInteger()
    }

    def getFailures() {
        return failures
    }

    def getErrors() {
        return errors
    }

    def getTests() {
        return tests
    }
}