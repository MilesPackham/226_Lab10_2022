package ca.camosun.ICS226;

/**
 * Main entry point
 *
 */
public class App {
    public static void main( String[] args ) {
        String[] clientArgs = Prompt.getClientArgs();
        Client client = new Client(clientArgs[0], clientArgs[1]);
        client.connect();
    }
}
