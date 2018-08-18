package com.mj.common.contllor;

import com.mj.common.util.time.ReadExcelUtils;
import com.mj.common.util.time.ResultVM;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by：mingwang
 * Company：MJ
 * Date：2018/4/13
 * Annotation:
 */
@RestController
@RequestMapping("/assets")
public class ExcelContller {
    @RequestMapping(value = "/excelReader", method = RequestMethod.GET)
    public ResultVM excelReader(String path) {
        try {
            List<List<String>> lists = new ArrayList<>();
            ReadExcelUtils excelUtils = new ReadExcelUtils(path);//加载地址文件
            Map<Integer, Map<Integer, Object>> map = excelUtils.readExcelContent();//读取出数据
            for (int i = 1; i < map.size(); i++) { //循环取出数据
                List<String> list = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVM.ok();
    }

}
