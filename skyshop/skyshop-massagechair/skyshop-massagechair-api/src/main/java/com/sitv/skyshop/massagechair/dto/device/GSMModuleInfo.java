/**
 *
 */
package com.sitv.skyshop.massagechair.dto.device;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sitv.skyshop.massagechair.domain.device.GSMModule;

/**
 * @author zfj20 @ 2017年11月15日
 */
public class GSMModuleInfo extends DeviceInfo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1510842333944062983L;

	@NotBlank
	private String imei;

	@NotNull
	private SIMCardInfo simCard;

	// 型号
	private String module;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param module
	 * @param imei
	 * @param sim
	 * @param createTime
	 * @param updateTime
	 */
	public GSMModuleInfo(Long id, String name, String description, String module, String imei, SIMCardInfo sim, Calendar createTime, Calendar updateTime) {
		super(id, name, description, null, createTime, updateTime);
		this.imei = imei;
		this.module = module;
		this.simCard = sim;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei
	 *            the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the simCard
	 */
	public SIMCardInfo getSimCard() {
		return simCard;
	}

	/**
	 * @param simCard
	 *            the simCard to set
	 */
	public void setSimCard(SIMCardInfo simCard) {
		this.simCard = simCard;
	}

	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @param gsmModule
	 * @return
	 */
	public static GSMModuleInfo create(GSMModule gsmModule) {
		if (gsmModule == null) {
			return null;
		}
		SIMCardInfo sim = SIMCardInfo.create(gsmModule.getSimCard());
		return new GSMModuleInfo(gsmModule.getId(), gsmModule.getName(), gsmModule.getDescription(), gsmModule.getModule(), gsmModule.getImei(), sim, gsmModule.getCreateTime(),
		                gsmModule.getUpdateTime());
	}

	public static List<GSMModuleInfo> creates(List<GSMModule> list) {
		List<GSMModuleInfo> gsmModuleInfos = new ArrayList<>();
		if (list != null) {
			for (GSMModule gsmModule : list) {
				gsmModuleInfos.add(create(gsmModule));
			}
		}
		return gsmModuleInfos;
	}
}
