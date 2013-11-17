package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CameraSearchUsingCameraAcceptor {
	
	List<Camera> privateListOfCameras = CameraUtils.getList();
	
	/** An Acceptor accepts some elements from a Collection */
	public interface CameraAcceptor {
	        boolean choose(Camera c);
	}
	
	public List<Camera> search(CameraAcceptor acceptor) {
	    List<Camera> results = new ArrayList<>();
	    for (Camera c : privateListOfCameras) {
	        if (acceptor.choose(c)) {
	            results.add(c);
	        }
	    }
	    return results;
	}
	
	public static void main(String[] args) {
		CameraSearchUsingCameraAcceptor searchApp = new CameraSearchUsingCameraAcceptor();
		// Writing it using the anonymous inner class
		List<Camera> results = searchApp.search(new CameraAcceptor() {
	        public boolean choose(Camera c) {
	            return c.isIlc() && c.getPrice() < 500;
	        }
	    });
		// Writing it as a Lambda expression:
		results = searchApp.search(c -> c.isIlc() && c.getPrice() < 500);
		System.out.println(results);
	}
}
