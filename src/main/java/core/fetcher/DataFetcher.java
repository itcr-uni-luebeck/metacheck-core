package core.fetcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import core.metric.exceptions.AmbiguousNamespaceException;
import core.metric.exceptions.InvalidNamespaceException;
import core.model.MyDataElement;
import core.model.MyDataElementGroup;
import core.model.MyNamespace;
import de.samply.common.mdrclient.MdrClient;
import de.samply.common.mdrclient.MdrConnectionException;
import de.samply.common.mdrclient.MdrInvalidResponseException;
import de.samply.common.mdrclient.domain.DataElement;
import de.samply.common.mdrclient.domain.Namespace;
import de.samply.common.mdrclient.domain.Result;

/**
 * class to get data from samply.mdr
 * 
 * @author Alexandra Banach
 *
 */
public class DataFetcher {

	/** url of your Samply.MDR */
	private String url;

	/** name of Samply.MDR namespace */
	private String namespace;

	/** language shorthand symbol for Samply.MDR */
	private String languageShorthandSymbol;

	private String subjectID;

	private String accessToken;

	/**
	 * Constructor to create a data object belonging to your Samply.MDR
	 * 
	 * @param url                     of Samply.MDR
	 * @param namespace
	 * @param languageShorthandSymbol
	 */
	public DataFetcher(String url, String namespace, String languageShorthandSymbol, String subjectID, String accessToken) {
		this.url = url;
		this.namespace = namespace;
		this.languageShorthandSymbol = languageShorthandSymbol;
		this.subjectID = subjectID;
		this.accessToken = accessToken;

	}

	/**
	 * getter for your samply.mdr url
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * setter for your samply.mdr url
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * getter to get the namespace of data
	 * 
	 * @return namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * setter to set namespace of data
	 * 
	 * @param namespace
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * getter for languageShorthandSymbol for samply.mdr
	 * 
	 * @return languageShorthandSymbol
	 */
	public String getLanguageShorthandSymbol() {
		return languageShorthandSymbol;
	}

	/**
	 * setter for languageShorthandSymbol for samply.mdr
	 * 
	 * @param languageShorthandSymbol
	 */
	public void setLanguageShorthandSymbol(String languageShorthandSymbol) {
		this.languageShorthandSymbol = languageShorthandSymbol;
	}

	/**
	 * method to get data (dataelements and groups) from your samply.mdr
	 * 
	 * @param url of your samply.mdr
	 * @return lists of dataelements and groups as an object of the type MyResult
	 * @throws AmbiguousNamespaceException is throw if there are at least two
	 *                                     namespaces with the same name
	 * @throws InvalidNamespaceException   is thrown if there is no namespace with
	 *                                     the requested name
	 * @throws ExecutionException          might be thrown while getting members of
	 *                                     namespace
	 * @throws MdrInvalidResponseException might be thrown while getting members of
	 *                                     namespace
	 * @throws MdrConnectionException      is thrown while contacting Samply.MDR
	 */
	public MyNamespace getMyData(DataFetcher data) throws InvalidNamespaceException, AmbiguousNamespaceException,
			ExecutionException, MdrConnectionException, MdrInvalidResponseException {

		MdrClient client = new MdrClient(data.getUrl());

		// get object data for namespace
		MyNamespace myNamespace = data.getMyNamespace(data, client);

		// get direct submembers (dataelements and groups) from namespace
		myNamespace = data.getMyMembersFromNamespace(myNamespace, data, client);

		// get other members for namespace (dataelements and groups)
		myNamespace = data.getOtherMembers(myNamespace, data, client);

		// return complete namespace object with all data
		return myNamespace;

	}

	/**
	 * method to get namespace data for a namespace from samply.mdr
	 * 
	 * @param data:   object of type Data with url and name of namespace
	 * @param client: samply.mdr client object
	 * @return object of type MyNamespace
	 * @throws InvalidNamespaceException is thrown when your namespace cannot be
	 *                                   found in Samply.MDR
	 * @throws ExecutionException        might be thrown while getting all
	 *                                   namespaces from Samply.MDR
	 */
	private MyNamespace getMyNamespace(DataFetcher data, MdrClient client)
			throws InvalidNamespaceException, ExecutionException {

		String myNamespace = data.getNamespace();

		// get all namespaces from Samply.MDR
		List<Namespace> namespaces = client.getNamespaces(data.getLanguageShorthandSymbol(), data.getAccessToken(),
				data.getSubjectID());

		// search my namespace and return it as object
		for (Namespace ns : namespaces) {
			if (ns.getName().equals(myNamespace)) {
				return new MyNamespace(ns.getName(), ns.isWriteable(), ns.getDesignations());
			} else {

			}
		}

		// if namespace was not found throw exception
		throw new InvalidNamespaceException("Namespace cannot be found. Please check your name!");
	}

	/**
	 * method to get data for direct subgroups and subelements of a namespace in
	 * samply.mdr
	 * 
	 * @param myNamespace: object of type MyNamespace
	 * @param data:        object of type Data
	 * @param client:      object of type MdrClient
	 * @return object of type MyNamespace
	 * @throws ExecutionException
	 * @throws MdrInvalidResponseException
	 * @throws MdrConnectionException      is thrown while contacting Samply.MDR
	 */
	private MyNamespace getMyMembersFromNamespace(MyNamespace myNamespace, DataFetcher data, MdrClient client)
			throws ExecutionException, MdrConnectionException, MdrInvalidResponseException {

		// get members
		System.out.println(data.getSubjectID());
		List<Result> result = client.getNamespaceMembers(data.getLanguageShorthandSymbol(), data.getAccessToken(),
				data.getSubjectID(), myNamespace.getMyName());

		// check each member and create object dataelementgroup or dataelement and add
		// it to namespace
		// initialize empty objects and sublists for setting
		DataElement resDataElement;
		MyDataElementGroup myGroup;
		MyDataElement myElement;
		myNamespace.setMyDataElementGroup(new ArrayList<MyDataElementGroup>());
		myNamespace.setSubgroups(new ArrayList<MyDataElementGroup>());
		myNamespace.setMyDataElements(new ArrayList<MyDataElement>());
		myNamespace.setSubelements(new ArrayList<MyDataElement>());
		for (Result res : result) {
			if (res.getType().equals("DATAELEMENTGROUP")) {
				myGroup = new MyDataElementGroup(res.getType(), res.getId(), res.getDesignations());
				myNamespace.getMyDataElementGroup().add(myGroup);
				myNamespace.getSubgroups().add(myGroup);
			} else if (res.getType().equals("DATAELEMENT")) {
				resDataElement = client.getDataElement(res.getId(), data.getLanguageShorthandSymbol(), null,
						data.getSubjectID());
				myElement = new MyDataElement(resDataElement.getIdentification().getUrn(),
						resDataElement.getDesignations(), resDataElement.getValidation(), resDataElement.getSlots(),
						false);
				myNamespace.getMyDataElements().add(myElement);
				myNamespace.getSubelements().add(myElement);

			} else {

			}
		}

		return myNamespace;
	}

	/**
	 * method to get data for nested dataelements and groups of a namespace from
	 * samply.mdr
	 * 
	 * @param myNamespace: object of type MyNamespace
	 * @param data:        object of type Data
	 * @param client:      object of type MdrClient
	 * @return object of type MyNamespace
	 * @throws ExecutionException          might be thrown while getting submembers
	 *                                     of groups from Samply.MDR
	 * @throws MdrConnectionException      is thrown while contacting Samply.MDR
	 * @throws MdrInvalidResponseException might be thrown while getting submembers
	 *                                     of groups from Samply.MDR
	 */
	private MyNamespace getOtherMembers(MyNamespace myNamespace, DataFetcher data, MdrClient client)
			throws MdrConnectionException, ExecutionException, MdrInvalidResponseException {
		// get other members (dataelements and groups) from group
		// need some more lists for iteration
		List<MyDataElementGroup> iteratorList2 = new ArrayList<MyDataElementGroup>();
		List<Result> iteratorList3 = new ArrayList<Result>();
		MyDataElementGroup dataelementgroup;
		MyDataElement dataelement;

		// as long as there are some new groups (start with groups of namespaces)
		// check if there are some members
		List<MyDataElementGroup> iteratorList = new ArrayList<MyDataElementGroup>();
		List<MyDataElementGroup> deg = myNamespace.getSubgroups();
		DataElement resDataElement = null;
		for (MyDataElementGroup group : deg) {
			iteratorList.add(group);
		}

		while (iteratorList.size() != 0) {
			// for each group
			for (MyDataElementGroup res : iteratorList) {
				// initialize empty sublists and set it to group
				res.setSubgroups(new ArrayList<MyDataElementGroup>());
				res.setSubelements(new ArrayList<MyDataElement>());
				// get members
				// TODO: anpassen
				iteratorList3 = client.getMembers(res.getMyId(), data.getLanguageShorthandSymbol(), null,
						data.getSubjectID());

				// for each member
				for (Result res3 : iteratorList3) {
					// check type, create object and put it into lists
					if (res3.getType().equals("DATAELEMENTGROUP")) {
						// create object dataelementgroup
						dataelementgroup = new MyDataElementGroup(res3.getType(), res3.getId(), res3.getDesignations());
						// add it to collection of all dataelementgroups
						myNamespace.getMyDataElementGroup().add(dataelementgroup);
						// add object to subgroup list
						res.getSubgroups().add(dataelementgroup);
						// collect groups for further iteration
						iteratorList2.add(dataelementgroup);
					} else if (res3.getType().equals("DATAELEMENT")) {
						// get all data for the element
						// TODO: anpassen
						resDataElement = client.getDataElement(res3.getId(), data.getLanguageShorthandSymbol(), null,
								data.getSubjectID());
						// create object dataelement
						dataelement = new MyDataElement(resDataElement.getIdentification().getUrn(),
								resDataElement.getDesignations(), resDataElement.getValidation(),
								resDataElement.getSlots(), true);
						// add it to collection of all dataelements
						myNamespace.getMyDataElements().add(dataelement);
						// add object to subgroup list
						res.getSubelements().add(dataelement);

					} else {

					}
				}
			}
			// put collected groups into the right list for further iterations
			iteratorList.clear();
			for (MyDataElementGroup res2 : iteratorList2) {
				iteratorList.add(res2);
			}
			// let us tidy up for further iterations
			iteratorList2.clear();
			iteratorList3.clear();
		}
		return myNamespace;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
