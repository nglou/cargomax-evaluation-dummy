/**
 *
 */
package aero.champ.cargospot.cargomax.dummy;

import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRS;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * The main webservice dummy endpoint implementation that imitates sabre BPE evaluate and review functions.
 *
 * @version  $Revision$, $Date$
 */
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(targetNamespace = "http://webservices.sabre.com/cargo/BookingTypes/v1")
public interface BookingEvaluation
{
	//~ Methods ----------------------------------
	/**
	 * Receive and process Booking Evaluation Requests from CSP.
	 *
	 * @param   bookingevaluationrq
	 * @return
	 */
	@WebMethod
	@WebResult(
		name = "BookingEvaluationRS",
		partName = "bookingEvaluationRS"
	)
	BookingEvaluationRS evaluate(
		@WebParam(
			name = "BookingEvaluationRQ",
			partName = "bookingEvaluationRQ"
		) BookingEvaluationRQ bookingEvaluationRQ);
	
	/**
	 * Receive and process Booking Review Requests from CSP.
	 *
	 * @param   bookingreviewrq
	 * @return
	 */
	@WebMethod
	@WebResult(
		name = "BookingReviewRS",
		partName = "bookingReviewRS"
	)
	BookingReviewRS review(
		@WebParam(
			name = "BookingReviewRQ",
			partName = "bookingReviewRQ"
		) BookingReviewRQ bookingReviewRQ);
}
