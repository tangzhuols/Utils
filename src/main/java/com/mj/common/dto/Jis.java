package com.mj.common.dto;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by qzy on 2017/5/9.
 */
@Entity
public class Jis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jisName;
    private String jisNum;
    /**
     * 主要步骤
     */
    private String mainStep;
    private String jisLimit;
    private String version;
    /**
     * 图片URL
     */
    private String jisUrl;
    /**
     * 步骤顺序
     */
    private int sequence;


    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "jis_id")
    @OrderBy("sequence")
    private Set<Step> steps = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJisName() {
        return jisName;
    }

    public void setJisName(String jisName) {
        this.jisName = jisName;
    }

    public String getJisNum() {
        return jisNum;
    }

    public void setJisNum(String jisNum) {
        this.jisNum = jisNum;
    }


    public String getJisLimit() {
        return jisLimit;
    }

    public void setJisLimit(String jisLimit) {
        this.jisLimit = jisLimit;
    }

    public String getMainStep() {
        return mainStep;
    }

    public void setMainStep(String mainStep) {
        this.mainStep = mainStep;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getJisUrl() {
        return jisUrl;
    }

    public void setJisUrl(String jisUrl) {
        this.jisUrl = jisUrl;
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }


    @Override
    public String toString() {
        return "Jis{" +
                "id=" + id +
                ", jisName='" + jisName + '\'' +
                ", jisNum='" + jisNum + '\'' +
                ", mainStep='" + mainStep + '\'' +
                ", jisLimit='" + jisLimit + '\'' +
                ", version='" + version + '\'' +
                ", jisUrl='" + jisUrl + '\'' +
                ", sequence=" + sequence +
                ", steps=" + steps +
                '}';
    }
}
