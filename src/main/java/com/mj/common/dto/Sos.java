package com.mj.common.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qzy on 2017/5/9.
 */
@Entity
public class Sos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sosNum;
    /**
     * 工作内容
     */
    private String duty;
    /**
     * 标示，是否关键工位
     * 0，关键
     * 1，非关键
     */
    @Column(columnDefinition="int default 0",nullable = false)
    private Integer marking = 0;
    /**
     * sos的顺序
     */
    private int sequence;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "sos_id")
    @OrderBy("sequence")
    private Set<Jis> jisSet = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "sos_id")
    private Set<Part> parts = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getSosNum() {
        return sosNum;
    }

    public void setSosNum(String sosNum) {
        this.sosNum = sosNum;
    }

    public Integer getMarking() {
        return marking;
    }

    public void setMarking(Integer marking) {
        this.marking = marking;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Set<Jis> getJisSet() {
        return jisSet;
    }

    public void setJisSet(Set<Jis> jisSet) {
        this.jisSet = jisSet;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Sos{" +
                "id=" + id +
                ", sosNum='" + sosNum + '\'' +
                ", duty='" + duty + '\'' +
                ", marking=" + marking +
                ", sequence=" + sequence +
                ", jisSet=" + jisSet +
                ", parts=" + parts +
                '}';
    }
}
