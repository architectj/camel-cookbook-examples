package org.camelcookbook.splitjoin.split;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Shows how multi-line Strings may be split using a token.
 */
public class SplitMultiLineTest extends CamelTestSupport {
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new SplitMultiLineRouteBuilder();
    }

    @Test
    public void testSplitMultiLineString() throws InterruptedException {
        MockEndpoint mockOut = getMockEndpoint("mock:out");
        mockOut.expectedBodiesReceived("this is a", "multi-line", "piece of text");

        String multiLineSting = "this is a\nmulti-line\npiece of text";
        template.sendBody("direct:in", multiLineSting);

        assertMockEndpointsSatisfied();
    }

}