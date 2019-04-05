package aero.champ.cargospot.cargomax.dummy;

import aero.champ.cargospot.cargomax.dummy.db.InMemoryDB;
import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingEvaluationRS;

import java.math.BigDecimal;


/**
 * Processor for BookingEvaluationRQ.
 *
 * @version  $Revision$, $Date$
 */
public class BookingEvaluationRQProcessor
{
	//~ Instance fields --------------------------
	/**  */
	private BookingEvaluationRQ rq;
	//~ Constructors -----------------------------
	/**
	 * Creates a new BookingEvaluationRQProcessor object.
	 *
	 * @param  rq
	 */
	public BookingEvaluationRQProcessor(BookingEvaluationRQ rq)
	{
		this.rq = rq;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public BookingEvaluationRS process()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();
		inMemoryDB.addEvaluationRequest(rq);

		BookingEvaluationRS rs = new BookingEvaluationRS();
		// might need to change default response status
		rs.setStatus(inMemoryDB.currentEvaluationDefaultStatus());

		// set back same ref values from rq, below might need to change based on whats needed in csp
		rs.setSeqNo(rq.getSeqNo());
		rs.setAwbNum(rq.getAwbNum());
		rs.setBookingId(rq.getBookingId());
		rs.setAwbCurrency(rq.getAwbCurrency());
		rs.setMinRate(BigDecimal.ZERO);
		rs.setErrorCode(0);
		rs.setErrorMsg("");
		rs.setUserId("SYSTEM");

		inMemoryDB.addEvaluationResponse(rs);

		return rs;
	}
}
