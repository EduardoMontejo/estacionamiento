package co.com.ceiba.estacionamiento.domain.base;

import static org.junit.Assert.fail;

import java.util.function.Supplier;

import org.junit.Assert;

public class BaseTest {
	private static final String BUT_WAS_THROWN = "Pero fue lanzada ";
	private static final String WAS_EXPECTED = "Se esperaba la excepcion ";

	public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
		try {
			supplier.get();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(WAS_EXPECTED + exception.getCanonicalName() + BUT_WAS_THROWN
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	public static void assertThrows(Thunk thunk, Class<? extends Exception> exception, String message) {
		try {
			thunk.execute();
			fail();
		} catch (Exception e) {
			Assert.assertTrue(WAS_EXPECTED + exception.getCanonicalName() + BUT_WAS_THROWN
					+ e.getClass().getCanonicalName(), exception.isInstance(e));
			Assert.assertTrue(e.getMessage().contains(message));
		}
	}

	@FunctionalInterface
	public interface Thunk {
		void execute();
	}
}
