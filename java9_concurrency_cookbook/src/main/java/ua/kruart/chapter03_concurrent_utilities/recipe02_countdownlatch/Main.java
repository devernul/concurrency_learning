package ua.kruart.chapter03_concurrent_utilities.recipe02_countdownlatch;

/**
 * Main class of the example. Create, initialize and execute all the objects
 * necessaries for the example
 *
 */
public class Main {

    /**
     * Main method of the example
     * @param args
     */
    public static void main(String[] args) {

        // Creates a VideoConference with 10 participants.
        VideoConference conference = new VideoConference(10);
        // Creates a thread to run the VideoConference and start it.
        Thread threadConference = new Thread(conference);
        threadConference.start();

        // Creates ten participants, a thread for each one and starts them
        String[] names = {"Arthur", "Derek", "Sam", "Mike", "Carl", "Vanessa", "Jessy", "Anna", "Cristie", "Sandra"};
        for (int i = 0; i < 10; i++){
            Participant p = new Participant(conference, "Participant " + i + " " + names[i]);
            Thread t = new Thread(p);
            t.start();
        }

    }

}
