/**
 *
 */
package com.sitv.skyshop.massagechair.portal.api.controller.device;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitv.skyshop.controller.BaseController;
import com.sitv.skyshop.massagechair.dto.device.GSMModuleInfo;
import com.sitv.skyshop.massagechair.service.device.IGSMModuleService;

import io.swagger.annotations.Api;

/**
 * @author zfj20 @ 2017年11月18日
 */
@Api("gsm模块接口")
@Validated
@RestController
@RequestMapping("/gsmmodule")
public class GSMModuleController extends BaseController<IGSMModuleService, GSMModuleInfo> {

}
