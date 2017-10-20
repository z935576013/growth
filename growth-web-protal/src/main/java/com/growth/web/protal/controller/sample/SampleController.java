package com.growth.web.protal.controller.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.growth.common.utils.MobilePageParam;
import com.growth.service.intf.sample.SampleService;
import com.growth.service.intf.sample.dto.Sample;
import com.growth.web.protal.controller.ResultBean;

@RestController
@RequestMapping(value = "sample", produces = "application/json; charset=UTF-8")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	/**
	 * 列表
	 */
	@RequestMapping("/getList")
	public String getList(MobilePageParam mobilePageParam, boolean isEN) {
		// Long userId = SessionUtil.getUserId();
		ResultBean resultBean = new ResultBean();
		List<Sample> list = sampleService.getList(
				mobilePageParam.getStartIndex(), mobilePageParam.getNum());
		resultBean.addAttribute("list", list);
		resultBean.addAttribute("isEN", isEN);
		return resultBean.toString();
	}

	/**
	 * 保存
	 */
	@RequestMapping("/saveFile")
	public String saveFile(MultipartFile file) {
		ResultBean resultBean = new ResultBean();
		String url = sampleService.saveFile(file);
		resultBean.addAttribute("url", url);
		return resultBean.toString();
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public String save(String name) {
		ResultBean resultBean = new ResultBean();
		Sample sample = new Sample();
		sample.setName(name);
		sampleService.save(sample);
		return resultBean.toString();
	}

}
