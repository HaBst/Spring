package org.kh.bean.model.vo;

import java.util.Map;

public class CollectionBean3 {
	private Map<String,String> addressMap;

	public CollectionBean3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionBean3(Map<String, String> addressMap) {
		super();
		this.addressMap = addressMap;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
}
