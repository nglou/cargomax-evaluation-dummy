package aero.champ.cargospot.cargomax.dummy;

import aero.champ.cargospot.cargomax.dummy.db.InMemoryDB;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRQ;
import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRS;
import aero.champ.cargospot.cargomax.dummy.generated.SuccessMsg;


/**
 * Processor for BookingReviewRQ.
 *
 * @version  $Revision$, $Date$
 */
public class BookingReviewRQProcessor
{
	//~ Instance fields --------------------------
	/**  */
	private BookingReviewRQ rq;
	//~ Constructors -----------------------------
	/**
	 * Creates a new BookingReviewRQProcessor object.
	 *
	 * @param  rq
	 */
	public BookingReviewRQProcessor(BookingReviewRQ rq)
	{
		this.rq = rq;
	}
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public BookingReviewRS process()
	{
		InMemoryDB inMemoryDB = InMemoryDB.fromContext();
		inMemoryDB.addReviewRequest(rq);

		BookingReviewRS rs = new BookingReviewRS();
		// might need to change default response status
		rs.setSuccess(SuccessMsg.OK);
		
		inMemoryDB.addReviewResponse(rs);

		return rs;
	}
}
