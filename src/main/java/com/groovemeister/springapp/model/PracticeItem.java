package com.groovemeister.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PracticeItem {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String frequency;
	private String description;
	private String source_link;
	private String topic;
	private String type;
	private Integer duration;

	// for JPA only, no use
	public PracticeItem() {
	}

	public PracticeItem(String frequency, String description, String source_link, String topic, String type, Integer duration){
		this.frequency = frequency;
		this.description = description;
		this.source_link = source_link;
		this.topic = topic;
		this.type = type;
		this.duration = duration;
	}

    @Override
    public String toString() {
        return "PracticeItem{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", description=" + description +
                ", source_link=" + source_link +
				", topic=" + topic +
				", type=" + type +
				", duration=" + duration+
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getSource_link() {
        return source_link;
    }

    public void setSource_link(String source_link) {
        this.source_link = source_link;
    }

	public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
