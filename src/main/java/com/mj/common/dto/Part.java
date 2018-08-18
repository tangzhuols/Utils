package com.mj.common.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 工位
 * Created by qzy on 2017/5/9.
 */
@Entity
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partName;
    private String partNum;
    @Column(columnDefinition="int default 0")
    private Integer count = 0;
    /**
     * 扭矩
     */
    private String torque;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }


    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partNum='" + partNum + '\'' +
                ", count=" + count +
                ", torque='" + torque + '\'' +
                '}';
    }
}
