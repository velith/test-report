package se.softhouse.jenkins.report

import org.junit.Before
import org.junit.Test

class SuiteParserTest {

    final String xmlString1 = getClass().getResource( 'testResult.xml' ).text

    final String xmlString2 = '''
        <testsuite failures="4" time="0.095" errors="1" skipped="0" tests="9" name="triangle.TriangleTest">
            <properties>
            </properties>
            <testcase time="0.005" classname="triangle.TriangleTest" name="testIsIsoTrue"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testClassifyImpossibleLB"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testSetSideLengths"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testIsScaleneFalse"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testIsScaleneTrue"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testClassifyEqiLB"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testClassifyEqiUB"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testClassifyIsoLB"/>
            <testcase time="0" classname="triangle.TriangleTest" name="testClassifyIsoUB"/>
        </testsuite>
    '''

    private SuiteParser parser

    @Before
    void setUp() {
       parser = new SuiteParser()
    }

    @Test
    void testFailErrorCounter() {
        parser.parse(xmlString1)

        assert parser.getErrors() == 0
        assert parser.getFailures() == 0
    }

    @Test
    void testGetTestCases() {
        parser.parse(xmlString1)

        assert parser.getTests() == 31
    }
}