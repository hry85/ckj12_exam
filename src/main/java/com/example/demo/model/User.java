package com.example.demo.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private String role;
	
	private String name;
	private int age;
	private String gender;
	private String email;
	
	
	@OneToMany(mappedBy="user")
	private List<Note>notes;
	
	@OneToMany(mappedBy="user")
	private List<Folder>folders;
	
	public void addNote(Note note) {
		note.setUser(this);
		notes.add(note);
		
	}
	public void createFolder(Folder folder) {
		folder.setUser(this);
		folders.add(folder);
	}
}
