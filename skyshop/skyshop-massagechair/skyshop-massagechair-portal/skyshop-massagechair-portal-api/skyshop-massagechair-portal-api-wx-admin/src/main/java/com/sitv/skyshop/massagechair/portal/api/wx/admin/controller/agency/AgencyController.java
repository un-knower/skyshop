/**
 *
 */
package com.sitv.skyshop.massagechair.portal.api.wx.admin.controller.agency;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitv.skyshop.common.utils.Constants;
import com.sitv.skyshop.controller.BaseRestController;
import com.sitv.skyshop.dto.ResponseInfo;
import com.sitv.skyshop.massagechair.dto.agency.AgencyInfo;
import com.sitv.skyshop.massagechair.dto.agency.AgencyOverviewInfo;
import com.sitv.skyshop.massagechair.dto.agency.AgencyUserInfo;
import com.sitv.skyshop.massagechair.dto.user.LoginUserInfo;
import com.sitv.skyshop.massagechair.service.agency.IAgencyService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zfj20 @ 2017年12月5日
 */
@Slf4j
@Api("代理商接口")
@Validated
@RestController
@RequestMapping("/agency")
public class AgencyController extends BaseRestController<IAgencyService, AgencyInfo> {

	@GetMapping("/overview")
	public ResponseInfo<AgencyOverviewInfo> overview(@Min(0) @PathVariable Long agencyId) {
		log.debug("代理商信息总览>>>");
		log.debug("userId=" + agencyId);

		HttpSession session = request.getSession();

		LoginUserInfo loginUserInfo = (LoginUserInfo) session.getAttribute(Constants.USER_KEY);
		AgencyUserInfo agencyUserInfo = (AgencyUserInfo) loginUserInfo.getUserInfo();
		if (agencyUserInfo.getAgency().getId() != agencyId) {
			return ResponseInfo.ARGS_ERROR("错误的代理商id");
		}

		AgencyOverviewInfo overviewInfo = (AgencyOverviewInfo) session.getAttribute(IAgencyService.OVERVIEW_KEY);
		long lastGetTime = (long) session.getAttribute(IAgencyService.OVERVIEW_LAST_GET_TIME_KEY);
		if (overviewInfo == null || System.currentTimeMillis() - lastGetTime > 10000) {
			overviewInfo = service.getOverview(agencyId);
			session.setAttribute(IAgencyService.OVERVIEW_KEY, overviewInfo);
			session.setAttribute(IAgencyService.OVERVIEW_LAST_GET_TIME_KEY, System.currentTimeMillis());
		}

		log.debug("overviewInfo=" + overviewInfo);
		return ResponseInfo.SUCCESS(overviewInfo);
	}

}