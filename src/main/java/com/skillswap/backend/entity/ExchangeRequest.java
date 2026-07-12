package com.skillswap.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExchangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String status;

    // Empty Constructor (Required by Spring Boot)
    public ExchangeRequest() {
    }

    // Parameterized Constructor
    public ExchangeRequest(Long id, User sender, User receiver, Skill skill, String status) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.skill = skill;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

//package com.skillswap.backend.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//
//@Entity
//public class ExchangeRequest {
//
//	public ExchangeRequest(Long id, User sender, User receiver, Skill skill, String status) {
//		super();
//		this.id = id;
//		this.sender = sender;
//		this.receiver = receiver;
//		this.skill = skill;
//		this.status = status;
//	}
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@ManyToOne
//	@JoinColumn(name = "sender_id")
//	private User sender;
//	
//	@ManyToOne
//	@JoinColumn(name = "receiver_id")
//	private User receiver;
//	
//	@ManyToOne
//    @JoinColumn(name = "skill_id")
//    private Skill skill;
//	
//	 private String status;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public User getSender() {
//		return sender;
//	}
//
//	public void setSender(User sender) {
//		this.sender = sender;
//	}
//
//	public User getReceiver() {
//		return receiver;
//	}
//
//	public void setReceiver(User receiver) {
//		this.receiver = receiver;
//	}
//
//	public Skill getSkill() {
//		return skill;
//	}
//
//	public void setSkill(Skill skill) {
//		this.skill = skill;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//}


//package com.skillswap.backend.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class ExchangeRequest {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "sender_id")
//    private User sender;
//
//    @ManyToOne
//    @JoinColumn(name = "receiver_id")
//    private User receiver;
//
//    @ManyToOne
//    @JoinColumn(name = "skill_id")
//    private Skill skill;
//
//    private String status;
//
//    // Empty Constructor (Required by Spring Boot/JPA)
//    public ExchangeRequest() {
//    }
//
//    // Constructor with Fields
//    public ExchangeRequest(Long id, User sender, User receiver, Skill skill, String status) {
//        this.id = id;
//        this.sender = sender;
//        this.receiver = receiver;
//        this.skill = skill;
//        this.status = status;
//    }
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getSender() {
//        return sender;
//    }
//
//    public void setSender(User sender) {
//        this.sender = sender;
//    }
//
//    public User getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(User receiver) {
//        this.receiver = receiver;
//    }
//
//    public Skill getSkill() {
//        return skill;
//    }
//
//    public void setSkill(Skill skill) {
//        this.skill = skill;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}
