/**
 * hibernatedemo:hibernatedemo Created on Dec 27, 2015
 *
 * 
 */
package hibernatedemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learning.hibernate.dto.UserDetails;

/**
 * @author mandheer
 *         
 */
public class UserDetailsTest {
	
	private UserDetails userDetails;
	
	/**
	 * @throws java.lang.Exception
	 *             
	 *             setUp UserDetailsTest void
	 */
	@Before
	public void setUp() throws Exception {
		userDetails = new UserDetails(2, "");
	}
	
	/**
	 * @throws java.lang.Exception
	 *             
	 *             tearDown UserDetailsTest void
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * 
	 *
	 * test UserDetailsTest void
	 */
	@Test
	public final void test() {
		userDetails.setUserId(1);
		userDetails.setUserName("First User");
	}
	
}
