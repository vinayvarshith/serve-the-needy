package com.project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NgoMember implements Serializable {
	@Id
	@GeneratedValue
	private int memberId;
	private String memberName;
	private long memberPhone;
	private String memberAddress;
	private int memberAge;
	private long aadhar;
	private String gender;
}
