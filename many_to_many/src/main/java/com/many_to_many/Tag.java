package com.many_to_many;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	
	@ManyToMany(mappedBy="tagList")
	private List<Post> postList =new ArrayList<Post>();


	public Tag(String name) {
		super();
		this.name = name;
	}

	public Tag(String name, List<Post> postList) {
		super();
		this.name = name;
		this.postList = postList;
	}





	public Tag(int id, String name, List<Post> postList) {
		super();
		this.id = id;
		this.name = name;
		this.postList = postList;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	
	
}
