package com.mj.common.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by qzy on 2017/5/14.
 */
@Entity
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 详细步骤
     */
    private String details;
    /**
     * 关键要素
     */
    private String element;
    /**
     * 步骤顺序
     */
    private int sequence;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", element='" + element + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
