package aero.champ.cargospot.cargomax.dummy.beans;

import aero.champ.cargospot.cargomax.dummy.generated.BookingReviewRQ;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * Dummied representation of BookingReviewRQ; so that we don't need to change the real thing.
 *
 * @version  $Revision$, $Date$
 */
public class ReviewRequest
{
	//~ Instance fields --------------------------
	/**  */
	public final String awbNum;

	/**  */
	public final long bookingId;

	/**  */
	public final String comment;

	/**  */
	public final int id;

	/**  */
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "dd-MM-yyyy hh:mm:ss"
	)
	public final Date requestTime;

	/**  */
	public final long seqNo;
	//~ Constructors -----------------------------
	/**
	 * Creates a new ReviewRequest object.
	 *
	 * @param  id
	 * @param  rq
	 */
	public ReviewRequest(int id, BookingReviewRQ rq)
	{
		this.id = id;
		this.bookingId = rq.getBookingId();
		this.seqNo = rq.getSeqNo();
		this.awbNum = rq.getAwbNum();
		this.comment = rq.getComment();
		this.requestTime = new Date();
	}

	/**
	 * Creates a new ReviewRequest object.
	 *
	 * @param  id
	 * @param  seqNo
	 * @param  bookingId
	 * @param  awbNum
	 * @param  comment
	 * @param  requestTime
	 */
	@JsonCreator
	public ReviewRequest(@JsonProperty("id") int id,
		@JsonProperty("seqNo") long seqNo,
		@JsonProperty("bookingId") long bookingId,
		@JsonProperty("awbNum") String awbNum,
		@JsonProperty("comment") String comment,
		@JsonProperty("requestTime") Date requestTime)
	{
		this.id = id;
		this.seqNo = seqNo;
		this.bookingId = bookingId;
		this.awbNum = awbNum;
		this.comment = comment;
		this.requestTime = requestTime;
	}
}
