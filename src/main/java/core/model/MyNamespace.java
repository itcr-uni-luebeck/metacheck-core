package core.model;

import java.util.List;

import de.samply.common.mdrclient.domain.Designation;

/**
 * class to model a namespace from samply.mdr
 * 
 * @author Alexandra Banach
 */
public class MyNamespace {
	/** name of a namespace */
	private String myName;
	/** indicates if namespace is writable */
	private boolean myIsWritable;
	/** list of designations for a namespace */
	private List<Designation> myDesignations;
	/** list with all dataelementgroups of a namespace */
	private List<MyDataElementGroup> myDataElementGroups;
	/** list with all dataelements of a namespace */
	private List<MyDataElement> myDataElements;
	/** list with subgroups of a namespace */
	private List<MyDataElementGroup> subgroups;
	/** list with dataelements which are direct subelements of a namespace */
	private List<MyDataElement> subelements;

	/**
	 * constructor to create a namespace from samply.mdr
	 * 
	 * @param name
	 * @param writable
	 * @param designations
	 */
	public MyNamespace(String myName, boolean myIsWritable, List<Designation> myDesignations) {
		this.myName = myName;
		this.myIsWritable = myIsWritable;
		this.myDesignations = myDesignations;

	}

	/**
	 * getter for the name of a namespace
	 * 
	 * @return name
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * setter for the name of a namespace
	 * 
	 * @param name
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * getter if namespace is writable
	 * 
	 * @return writable
	 */
	public boolean myIsWritable() {
		return myIsWritable;
	}

	/**
	 * setter if namespace is writable
	 * 
	 * @param writable
	 */
	public void setMyWritable(boolean myIsWritable) {
		this.myIsWritable = myIsWritable;
	}

	/**
	 * getter for list of designations of namespace
	 * 
	 * @return designations
	 */
	public List<Designation> getMyDesignations() {
		return myDesignations;
	}

	/**
	 * setter for list of designations of namespace
	 * 
	 * @param list
	 */
	public void setMyDesignations(List<Designation> myDesignations) {
		this.myDesignations = myDesignations;
	}

	/**
	 * getter for list of all dataelement groups of a namespace
	 * 
	 * @return
	 */
	public List<MyDataElementGroup> getMyDataElementGroup() {
		return myDataElementGroups;
	}

	/**
	 * setter for list of all dataelement groups of a namespace
	 * 
	 * @param myDataElementGroup
	 */
	public void setMyDataElementGroup(List<MyDataElementGroup> myDataElementGroups) {
		this.myDataElementGroups = myDataElementGroups;
	}

	/**
	 * getter for list of all dataelements of a namespace
	 * 
	 * @return
	 */
	public List<MyDataElement> getMyDataElements() {
		return myDataElements;
	}

	/**
	 * setter for list of all dataelements of a namespace
	 * 
	 * @param myDataElements
	 */
	public void setMyDataElements(List<MyDataElement> myDataElements) {
		this.myDataElements = myDataElements;
	}

	/**
	 * getter for list of subgroups of a namespace
	 * 
	 * @return
	 */
	public List<MyDataElementGroup> getSubgroups() {
		return subgroups;
	}

	/**
	 * setter for list of subgroups of a namespace
	 * 
	 * @param subgroups
	 */
	public void setSubgroups(List<MyDataElementGroup> subgroups) {
		this.subgroups = subgroups;
	}

	/**
	 * getter for list of direct subelements of a namespace
	 * 
	 * @return
	 */
	public List<MyDataElement> getSubelements() {
		return subelements;
	}

	/**
	 * setter for list of direct subelements of a namespace
	 * 
	 * @param subelements
	 */
	public void setSubelements(List<MyDataElement> subelements) {
		this.subelements = subelements;
	}
}
