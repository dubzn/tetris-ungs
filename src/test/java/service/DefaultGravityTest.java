package service;

import org.junit.Before;
import org.mockito.Mock;

public class DefaultGravityTest {

	private GravedadService gravedad;

	@Mock
	private ColisionService colision;
	
	@Before
	public void setUp() {
		this.gravedad = new DefaultGravityService(colision);
	}

}
