package aero.champ.cargospot.cargomax.dummy;

import org.junit.Test;

import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ;

public class BookingEvaluationRQProcessorTest
{
	@Test
	public void rqStoredToDB()
	{
		BookingEvaluationRQ rq = new BookingEvaluationRQ();
		// TODO: do something
		BookingEvaluationRQProcessor proc = new BookingEvaluationRQProcessor(rq);
	}
	
}
