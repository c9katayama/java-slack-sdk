package test_locally.api.methods;

import com.slack.api.Slack;
import com.slack.api.SlackConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.MockSlackApiServer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.MockSlackApi.ValidToken;

public class ImTest {

    MockSlackApiServer server = new MockSlackApiServer();
    SlackConfig config = new SlackConfig();
    Slack slack = Slack.getInstance(config);

    @Before
    public void setup() throws Exception {
        server.start();
        config.setMethodsEndpointUrlPrefix(server.getMethodsEndpointPrefix());
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void test() throws Exception {
        assertThat(slack.methods(ValidToken).imClose(r -> r.channel("C123"))
                .isOk(), is(true));
        assertThat(slack.methods(ValidToken).imHistory(r -> r.channel("C123"))
                .isOk(), is(true));
        assertThat(slack.methods(ValidToken).imList(r -> r)
                .isOk(), is(true));
        assertThat(slack.methods(ValidToken).imMark(r -> r.channel("C123").ts("123.123"))
                .isOk(), is(true));
        assertThat(slack.methods(ValidToken).imOpen(r -> r.user("U123"))
                .isOk(), is(true));
        assertThat(slack.methods(ValidToken).imReplies(r -> r.channel("C123"))
                .isOk(), is(true));
    }

}
