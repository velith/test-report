package se.softhouse.jenkins.report

import org.junit.Before
import org.junit.Test

class SuiteParserTest {

    final String xmlString1 = getClass().getResource( 'testResult.xml' ).text

    final String xmlString2 = getClass().getResource( 'failedTestResult.xml' ).text

    private SuiteParser parser

    @Before
    void setUp() {
       parser = new SuiteParser()
    }

    @Test
    void testNoFailuresOrErrors() {
        parser.parse(xmlString1)

        assert parser.getErrors() == 0
        assert parser.getFailures() == 0
    }

    @Test
    void testExtractedFailure() {
        parser.parse(xmlString2)

        assert parser.getFailures() == 1
    }

    @Test
    void testGetTestCases() {
        parser.parse(xmlString1)

        assert parser.getTests() == 31
    }

}