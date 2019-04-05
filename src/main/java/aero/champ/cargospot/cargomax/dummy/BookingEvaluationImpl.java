package aero.champ.cargospot.cargomax.dummy;

import javax.jws.WebService;

import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRS;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRS;


/**
 * Default implementation for BookingEvaluation.
 *
 * @version  $Revision$, $Date$
 * @see BookingEvaluation
 */
@WebService(
	portName = "BookingEvaluationPort",
	serviceName = "BookingEvaluationService",
	targetNamespace = "http://webservices.sabre.com/cargo/BookingTypes/v1",
	endpointInterface = "aero.champ.cargospot.cargomax.dummy.BookingEvaluation"
)
public class BookingEvaluationImpl implements BookingEvaluation
{
	//~ Methods ----------------------------------

	/**
	 * @see  aero.champ.cargospot.cargomax.dummy.BookingEvaluation#evaluate(aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ)
	 */
	public BookingEvaluationRS evaluate(BookingEvaluationRQ bookingEvaluationRQ)
	{
		BookingEvaluationRS rs = new BookingEvaluationRQProcessor(bookingEvaluationRQ).process();
		
		return rs;
	}
	

	/**
	 * @see  aero.champ.cargospot.cargomax.dummy.BookingEvaluation#review(aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRQ)
	 */
	public BookingReviewRS review(BookingReviewRQ bookingReviewRQ)
	{
		BookingReviewRS rs = new BookingReviewRQProcessor(bookingReviewRQ).process();
		return rs;
	}
}
