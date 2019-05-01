package com.xiaoyaotu.shoopingdemo1.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Linqi on 2019-04-30.
 */
@Api(description = "信息导导入-管理")
@RestController
@RequestMapping(value = "/import",method = {RequestMethod.GET, RequestMethod.POST})
public class ExcelImportController {


}
