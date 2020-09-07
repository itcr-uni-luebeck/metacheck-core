package core.model;

import java.util.List;

import de.samply.common.mdrclient.domain.Designation;

/**
 * class to model dataelementgroups from samply.mdr
 * 
 * @author Alexandra Banach
 *
 */
public class MyDataElementGroup {
	/** type of a dataelementgroup */
	private String myType;
	/** id of a dataelementgroup */
	private String myId;
	/** list of designations of a dataelementgroup */
	private List<Designation> myDesignations;
	/** list of subgroups of a dataelementgroup */
	private List<MyDataElementGroup> subgroups;
	/** list of direct subdataelements of a dataelementgroup */
	private List<MyDataElement> subelements;

	/**
	 * constructor for a dataelementgroup from samply.mdr
	 * 
	 * @param myType
	 * @param myId
	 * @param myDesignations
	 */
	public MyDataElementGroup(String myType, String myId, List<Designation> myDesignations) {
		this.myType = myType;
		this.myDesignations = myDesignations;
		this.myId = myId;
	}

	/**
	 * getter for the type of a dataelementgroup
	 * 
	 * @return myType
	 */
	public String getMyType() {
		return myType;
	}

	/**
	 * setter for the type of a dataelementgroup
	 * 
	 * @param myType
	 */
	public void setMyType(String myType) {
		this.myType = myType;
	}

	/**
	 * getter for the id of a dataelementgroup
	 * 
	 * @return myId
	 */
	public String getMyId() {
		return myId;
	}

	/**
	 * setter for the id of a dataelementgroup
	 * 
	 * @param myId
	 */
	public void setMyId(String myId) {
		this.myId = myId;
	}

	/**
	 * getter for the list of designations of a dataelementgroup
	 * 
	 * @return myDesignations
	 */
	public List<Designation> getMyDesignations() {
		return myDesignations;
	}

	/**
	 * setter for the list of designations of a dataelementgroup
	 * 
	 * @param myDesignations
	 */
	public void setMyDesignations(List<Designation> myDesignations) {
		this.myDesignations = myDesignations;
	}

	/**
	 * getter for the list of subgroups of a dataelementgroup
	 * 
	 * @return
	 */
	public List<MyDataElementGroup> getSubgroups() {
		return subgroups;
	}

	/**
	 * setter for the list of subgroups of a dataelementgroup
	 * 
	 * @param subgroups
	 */
	public void setSubgroups(List<MyDataElementGroup> subgroups) {
		this.subgroups = subgroups;
	}

	/**
	 * getter for the list of direct subelements of a dataelementgroup
	 * 
	 * @return
	 */
	public List<MyDataElement> getSubelements() {
		return subelements;
	}

	/**
	 * setter for the list of direct subelements of a dataelementgroup
	 * 
	 * @param subelements
	 */
	public void setSubelements(List<MyDataElement> subelements) {
		this.subelements = subelements;
	}

}
