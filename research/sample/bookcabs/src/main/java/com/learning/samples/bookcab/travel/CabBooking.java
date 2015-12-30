package com.learning.samples.bookcab.travel;

import com.learning.samples.bookcab.domain.BookingRequest;
import com.learning.samples.bookcab.domain.BookingResponse;
import com.learning.samples.bookcab.exception.CabBusinessException;

/**
 * It would be responsible for having all checks before allocating cab Id to the requests. 
 * 
 * 
 * @author mandheer
 *
 */
public interface CabBooking{
	/**
	 * Method called for cabBoooking.
	 * 
	 * @param request
	 * @return
	 * @throws CabBusinessException 
	 */
	BookingResponse cabBook(BookingRequest request) throws CabBusinessException;
}
