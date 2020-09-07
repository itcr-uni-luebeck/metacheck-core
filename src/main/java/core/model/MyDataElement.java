package core.model;

import java.util.List;

import de.samply.common.mdrclient.domain.Designation;
import de.samply.common.mdrclient.domain.Slot;
import de.samply.common.mdrclient.domain.Validations;

/**
 * class to model dataelements from samply.mdr
 * 
 * @author Alexandra Banach
 *
 */
public class MyDataElement {
	/** id of a dataelement */
	private String myId;
	/** list of a datalement`s designations */
	private List<Designation> myDesignations;
	/** validations of a dataelement */
	private Validations myValidations;
	/** list of slots of a dataelement */
	private List<Slot> mySlots;
	/**
	 * namespace to which a dataelement belongs * private MyDataElementGroup
	 * myDataElementGroup; /** indicates if dataelement belongs to a group
	 */
	private boolean hasDataElementGroup = false;
	/** computed score for dataelement */
	private float score;

	/**
	 * constructor for a dataelement from samply.mdr
	 * 
	 * @param myId
	 * @param myDesignations
	 * @param validations
	 * @param mySlots
	 */
	public MyDataElement(String myId, List<Designation> myDesignations, Validations myValidations, List<Slot> mySlots,
			boolean hasDataElementGroup) {
		this.myId = myId;
		this.myDesignations = myDesignations;
		this.myValidations = myValidations;
		this.mySlots = mySlots;
		this.hasDataElementGroup = hasDataElementGroup;
	}

	/**
	 * getter for the id of a dataelement
	 * 
	 * @return myId
	 */
	public String getMyId() {
		return myId;
	}

	/**
	 * setter for the id of a dataelement
	 * 
	 * @param myId
	 */
	public void setMyId(String myId) {
		this.myId = myId;
	}

	/**
	 * getter for a dataelement`s list of designations
	 * 
	 * @return myDesignations
	 */
	public List<Designation> getMyDesignations() {
		return myDesignations;
	}

	/**
	 * setter for a datalement`s list of designations
	 * 
	 * @param myDesignations
	 */
	public void setMyDesignations(List<Designation> myDesignations) {
		this.myDesignations = myDesignations;
	}

	/**
	 * getter for the validations of a dataelement
	 * 
	 * @return myValidations
	 */
	public Validations getMyValidation() {
		return myValidations;
	}

	/**
	 * setter for the validations of a datalement
	 * 
	 * @param myValidations
	 */
	public void setMyValidation(Validations myValidations) {
		this.myValidations = myValidations;
	}

	/**
	 * getter for the slots of a dataelement
	 * 
	 * @return mySlots
	 */
	public List<Slot> getMySlots() {
		return mySlots;
	}

	/**
	 * setter for the slots of a dataelement
	 * 
	 * @param mySlots
	 */
	public void setMySlots(List<Slot> mySlots) {
		this.mySlots = mySlots;
	}

	/**
	 * return if dataelement belongs to a group
	 * 
	 * @return hasDataElementGroup
	 */
	public boolean hasDataElementGroup() {
		return hasDataElementGroup;
	}

	/**
	 * setter if dataelement has a group
	 * 
	 * @param hasDataElementGroup
	 */
	public void setHasDataElementGroup(boolean hasDataElementGroup) {
		this.hasDataElementGroup = hasDataElementGroup;
	}

	/**
	 * getter for computed score of a dataelement
	 * 
	 * @return
	 */
	public float getScore() {
		return score;
	}

	/**
	 * setter for computed score of a dataelement
	 * 
	 * @param score computed for dataelement
	 */
	public void setScore(float score) {
		this.score = score;
	}

}
