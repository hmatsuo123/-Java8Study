package ch09.ex03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThrows {
	private static final Logger logger = Logger.getLogger(MultiThrows.class.getName());

	public static void process() throws IOException {
	    try {
	    	if (new Random().nextInt() % 2 == 0) {
	    		throw new FileNotFoundException();
	    	}
	    	throw new UnknownHostException();
	    } catch (FileNotFoundException | UnknownHostException e) {
	        logger.log(Level.SEVERE, "...", e);
	        throw e;
	    }
	}

	public static void main(String[] args) throws Throwable{
		process();
    }
}
