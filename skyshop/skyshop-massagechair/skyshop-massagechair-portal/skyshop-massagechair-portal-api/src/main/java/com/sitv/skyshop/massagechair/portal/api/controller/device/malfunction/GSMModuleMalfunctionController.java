/**
 *
 */
package com.sitv.skyshop.massagechair.portal.api.controller.device.malfunction;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitv.skyshop.controller.BaseController;
import com.sitv.skyshop.massagechair.dto.device.malfunction.GSMModuleMalfunctionInfo;
import com.sitv.skyshop.massagechair.service.device.malfunction.IGSMModuleMalfunctionService;

import io.swagger.annotations.Api;

/**
 * @author zfj20 @ 2017年11月20日
 */
@Api("gsm模块故障信息接口")
@Validated
@RestController
@RequestMapping("/gsmmalfunction")
public class GSMModuleMalfunctionController extends BaseController<IGSMModuleMalfunctionService, GSMModuleMalfunctionInfo> {

}
