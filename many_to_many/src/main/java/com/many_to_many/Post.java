package com.many_to_many;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Post implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="post_tag",joinColumns=@JoinColumn(name="post_id"),inverseJoinColumns=@JoinColumn(name="tag_id"))
	private List<Tag> tagList= new ArrayList<Tag>();
	
	public Post() {
		
	}

	

	public Post(String name, List<Tag> tagList) {
		super();
		this.name = name;
		this.tagList = tagList;
	}



	public Post(int id, String name, List<Tag> tagList) {
		super();
		this.id = id;
		this.name = name;
		this.tagList = tagList;
	}



	public void addTag(Tag tag) {
		tagList.add(tag);
		tag.getPostList().add(this);
	}
	public void removeTag(Tag tag) {
		tagList.remove(tag);
		tag.getPostList().remove(this);
	}


	public Post(String name) {
		super();
		this.name = name;
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

	
	
}
