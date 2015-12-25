/**
 * 
 */
package com.sapient.test.nitrocabs.travel.impl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sapient.test.nitrocabs.domain.BookingRequest;
import com.sapient.test.nitrocabs.domain.BookingResponse;
import com.sapient.test.nitrocabs.domain.SectorsInfoData;
import com.sapient.test.nitrocabs.exception.CabBusinessException;
import com.sapient.test.nitrocabs.log.LogMessage;
import com.sapient.test.nitrocabs.travel.CabBooking;
import com.sapient.test.nitrocabs.util.CabConstants;
import com.sapient.test.nitrocabs.util.CabUtility;

/**
 * This is Impl for {@link CabBooking}.
 * 
 * @author mandheer
 */
public class CabBookingImpl implements CabBooking {

	private static final Logger LOG = LoggerFactory.getLogger(CabBookingImpl.class);
	
	/** 
	 * {@inheritDoc}
	 * @throws CabBusinessException 
	 */
	public BookingResponse cabBook(BookingRequest request) throws CabBusinessException {
		BookingResponse bookingResponse = null;
		SectorsInfoData data = SectorsInfoData.getInstance();
		double maxProfit = 0d;
		String cabId = null;
		CabUtility.validateRequest(request);
		for(String cab:data.getCabData().keySet()){
			int initialPin = data.getCabData().get(cab);
			if(CabUtility.isBookingTimeAllowed(initialPin, request.getPickupPin(),request.getPickupTime())){
				double profitPercent = CabUtility.cabProfit(initialPin, request.getPickupPin(), request.getDropPin());
				LOG.debug(LogMessage.CAB00001D, request.getBookingId(), profitPercent, cab);
				if(profitPercent > CabConstants.MIN_PROFIT_MARGIN && profitPercent > maxProfit){
					maxProfit = profitPercent;
					cabId = cab;
				}
			}
		}
		if(cabId != null){
			bookingResponse= new BookingResponse(request.getBookingId(), cabId);
		}
		return bookingResponse;
	}

}
