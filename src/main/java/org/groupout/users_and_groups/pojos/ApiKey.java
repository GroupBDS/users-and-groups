package org.groupout.users_and_groups.pojos;

public class ApiKey {

	private String apiName;
	public ApiKey(String apiName) {
		this.apiName = apiName;
	}
	
	public ApiKey() {}
	
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	
	/**
	 * 
	 * @return Name of the api
	 */
	public String getSecret() {
		return this.apiName;	
	}
}
