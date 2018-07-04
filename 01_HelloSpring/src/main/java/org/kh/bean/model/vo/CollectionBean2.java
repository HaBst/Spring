package org.kh.bean.model.vo;

import java.util.Set;

public class CollectionBean2 {
	private Set<String> nameList;

	public CollectionBean2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionBean2(Set<String> nameList) {
		super();
		this.nameList = nameList;
	}

	public Set<String> getNameList() {
		return nameList;
	}

	public void setNameList(Set<String> nameList) {
		this.nameList = nameList;
	}
	
}
