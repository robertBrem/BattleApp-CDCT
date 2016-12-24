package ninja.disruptor.battleapp;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import static com.airhacks.rulz.jaxrsclient.JAXRSClientProvider.buildWithURI;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BattleAppIT {

    @Rule
    public JAXRSClientProvider provider = buildWithURI("http://" + System.getenv("HOST") + ":" + System.getenv("PORT") + "/battleapp/resources/users");

    @Test
    public void shouldReturnDan() {
        String expectedToContain = "dan";
        String response = provider
                .target()
                .request()
                .get(String.class);
        assertThat(response, containsString(expectedToContain));
    }

}
