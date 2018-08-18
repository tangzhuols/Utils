package com.mj.common.config;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.locator.BaseLocator;

/**
 * Created by：mingwang
 * Company：MJ
 * Date：2018/2/5
 * 连接modbus协议的时间
 */
public class ModbusConfig {
    /**
     * 获取master
     *
     * @return
     * @throws com.serotonin.modbus4j.exception.ModbusInitException
     */
    public ModbusMaster getMaster() throws ModbusInitException {
        IpParameters parameters = new IpParameters();
        parameters.setHost("127.0.0.1");
        parameters.setPort(502);
        ModbusMaster master = new ModbusFactory().createTcpMaster(parameters, false);
        master.init();
        return master;
    }

    /**
     * 读取[01 Coil status 0x]类型 开关数据
     *
     * @param slaveId slaveID
     * @param offset  位置
     * @return 读取值
     * @throws com.serotonin.modbus4j.exception.ModbusTransportException 异常
     * @throws ModbusInitException
     * @throws com.serotonin.modbus4j.exception.ErrorResponseException
     */
    public boolean readCoilStatus(int slaveId, int offset) throws ModbusInitException, ModbusTransportException, ErrorResponseException {
        BaseLocator<Boolean> loc = BaseLocator.coilStatus(slaveId, offset);
        Boolean value = getMaster().getValue(loc);
        return value;
    }

    /**
     * 读取[02 Input status 1x]类型 开关数据
     *
     * @param slaveId slaveId
     * @param offset  位置
     * @return
     * @throws com.serotonin.modbus4j.exception.ModbusTransportException 异常
     * @throws ModbusInitException
     * @throws com.serotonin.modbus4j.exception.ErrorResponseException
     */
    public Boolean readInputStatus(int slaveId, int offset) throws ModbusInitException, ModbusTransportException, ErrorResponseException {
        BaseLocator<Boolean> loc = BaseLocator.inputStatus(slaveId, offset);
        Boolean value = getMaster().getValue(loc);
        return value;
    }

    /**
     * 读取[03 Holding status 2x]模拟量数据
     *
     * @param slaveId  slaveId
     * @param offset   位置
     * @param dataType 数据类型
     * @return
     * @throws com.serotonin.modbus4j.exception.ModbusTransportException 异常
     * @throws ModbusInitException
     * @throws com.serotonin.modbus4j.exception.ErrorResponseException
     */
    public Number readHoldingRegister(int slaveId, int offset, int dataType) throws ModbusInitException, ModbusTransportException, ErrorResponseException {
        BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
        Number value = getMaster().getValue(loc);
        return value;
    }
    /**
     * 读取[04 Input Registers 3x]类型 模拟量数据
     *
     * @param slaveId  slaveId
     * @param offset   位置
     * @param dataType 数据类型
     * @return
     * @throws com.serotonin.modbus4j.exception.ModbusTransportException 异常
     * @throws ModbusInitException
     * @throws com.serotonin.modbus4j.exception.ErrorResponseException
     */
    public Number readInputRegister(int slaveId, int offset, int dataType) throws ModbusInitException, ModbusTransportException, ErrorResponseException {
        BaseLocator<Number> loc = BaseLocator.inputRegister(slaveId, offset, dataType);
        Number value = getMaster().getValue(loc);
        return value;
    }
    /**
     * 批量读取使用方法
     *
     *  @throws com.serotonin.modbus4j.exception.ModbusTransportException 异常
     * @throws ModbusInitException
     * @throws com.serotonin.modbus4j.exception.ErrorResponseException
     */
    public void batchRead()throws ModbusInitException, ModbusTransportException, ErrorResponseException {
        BatchRead<Integer> read = new BatchRead<Integer>();
        read.addLocator(0, BaseLocator.holdingRegister(1,1, DataType.FOUR_BYTE_FLOAT));
        read.addLocator(1, BaseLocator.inputStatus(1,0));

        ModbusMaster master = getMaster();
        read.setContiguousRequests(false);
        BatchResults<Integer> results = master.send(read);
        System.out.println(results.getValue(0));
        System.out.println(results.getValue(1));
    }

    /**
     * 写入数据
     *
     * @param slaveId
     * @param offset
     * @param value
     * @param dataType
     * @throws ModbusTransportException
     * @throws ModbusInitException
     * @throws ErrorResponseException
     */
    public void writeHoldingRegister(int slaveId,int offset,Number value,int dataType) throws ModbusTransportException,ModbusInitException,ErrorResponseException {
        ModbusMaster master = getMaster();
        BaseLocator<Number> locator = BaseLocator.holdingRegister(slaveId,offset,dataType);
        master.setValue(locator,value);
    }

}
